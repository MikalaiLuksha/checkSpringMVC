package by.pelar.controller;

import by.pelar.DTO.UserDTO;
import by.pelar.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping
    public String start(HttpSession httpSession, Model model){
        String userNotFound = (String) httpSession.getAttribute("userNotFound");
        model.addAttribute("userNot", userNotFound);
        httpSession.setAttribute("userNotFound", null);
        model.addAttribute("userDTO", new UserDTO());
        return "index";
    }
}
