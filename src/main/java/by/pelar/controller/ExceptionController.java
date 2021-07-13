package by.pelar.controller;

import by.pelar.exception.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    public String ex (UserNotFoundException ex, HttpSession httpSession){
        String message = ex.getMessage();
        httpSession.setAttribute("userNotFound", message);
        return "redirect:/";
    }
}
