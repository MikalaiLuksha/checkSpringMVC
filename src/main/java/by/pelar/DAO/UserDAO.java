package by.pelar.DAO;

import by.pelar.DAO.rowMapper.UserRowMapper;
import by.pelar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String SAVE_USER = "insert into userdata (name, login, password) values (?, ?, ?)";
    private final static String GET_USER_BY_ID = "select * from userdata WHERE login = ?";

    public void saveUser(User user){
        jdbcTemplate.update(SAVE_USER, user.getName(), user.getLogin(), user.getPassword());
    }

    public User getUserByLogin(String login){
        try {
            return jdbcTemplate.queryForObject(GET_USER_BY_ID, new Object[]{login}, new UserRowMapper());
        }
        catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
            }
    }
}
