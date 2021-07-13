package by.pelar.service;

import by.pelar.DAO.UserDAO;
import by.pelar.DTO.UserDTO;
import by.pelar.entity.User;
import by.pelar.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void saveUser(User user){
        userDAO.saveUser(user);
    }

    public User checkAuth (UserDTO userDTO){
        User userByLogin = getUserByLogin(userDTO.getLogin());
        if (userByLogin.getPassword().equals(userDTO.getPassword())){
                return userByLogin;
            }
        else throw new UserNotFoundException("Password incorrect");
        }



    private User getUserByLogin(String login){
        User user1 = userDAO.getUserByLogin(login);
        if (user1 != null) {
            return user1;
        }
         else throw new UserNotFoundException("User not found");
    }
}
