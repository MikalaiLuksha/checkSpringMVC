package by.pelar.DAO.rowMapper;

import by.pelar.entity.Role;
import by.pelar.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setRole(Role.valueOf(rs.getString("role")));
        user.setAddDate(getDate(rs.getLong("add_date")));
        return user;
    }

    private Calendar getDate(long l){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(l);
        return calendar;
    }
}
