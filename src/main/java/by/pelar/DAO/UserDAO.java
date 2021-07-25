package by.pelar.DAO;

import by.pelar.DAO.rowMapper.UserRowMapper;
import by.pelar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String SAVE_USER = "insert into userdata (name, login, password, role, add_date) values (?, ?, ?, ?, ?)";
    private final static String GET_USER_BY_LOGIN = "select * from userdata WHERE login = ?";
    private final static String GET_USER_BY_ID = "select * from userdata WHERE id = ?";
    private final static String GET_ALL = "select * from userdata";

    public void saveUser(User user){
        jdbcTemplate.update(SAVE_USER, user.getName(), user.getLogin(), user.getPassword(), user.getRole().toString(), user.getAddDate().getTimeInMillis());
    }

    public User getUserByLogin(String login){
        try {
            return jdbcTemplate.queryForObject(GET_USER_BY_LOGIN, new Object[]{login}, new UserRowMapper());
        }
        catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public User getUserById(long id){
        try {
            return jdbcTemplate.queryForObject(GET_USER_BY_ID, new Object[]{id}, new UserRowMapper());
        }
        catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAll(){
        List<User>userList = jdbcTemplate.query(GET_ALL, new UserRowMapper());
        return userList;
    }
}
