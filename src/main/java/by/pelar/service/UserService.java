package by.pelar.service;

import by.pelar.DAO.UserDAO;
import by.pelar.DTO.UserDTO;
import by.pelar.entity.Role;
import by.pelar.entity.User;
import by.pelar.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean saveUser(User user){
        if (checkLogin(user.getLogin())){
        user.setRole(Role.user);
        user.setAddDate(addDate());
        userDAO.saveUser(user);
        return true;
        }
        else {
            return false;
        }
    }

    public User checkAuth (UserDTO userDTO){
        User userByLogin = getUserByLogin(userDTO.getLogin());
        if (userByLogin.getPassword().equals(userDTO.getPassword())){
                return userByLogin;
            }
        else throw new UserNotFoundException("Password incorrect");
        }

        private boolean checkLogin(String login){
            List<User> all = userDAO.getAll();
            for (User userA : all) {
                if (userA.getLogin().equals(login)){
                    return false;
                  }
            }
            return true;
        }



    private User getUserByLogin(String login){
        User user1 = userDAO.getUserByLogin(login);
        if (user1 != null) {
            return user1;
        }
         else throw new UserNotFoundException("User not found");
    }

     public User getUserById(long id){
        User user1 = userDAO.getUserById(id);
        if (user1 != null) {
            return user1;
        }
        else throw new UserNotFoundException("User not found");
    }

    private Calendar addDate(){
        Date date= new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }
}
