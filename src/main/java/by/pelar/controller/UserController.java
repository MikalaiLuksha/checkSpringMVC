package by.pelar.controller;

import by.pelar.DTO.UserDTO;
import by.pelar.entity.User;
import by.pelar.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

    @Controller
    @RequestMapping(path = "/user")
    public class UserController {


        private final UserService userService;


        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping(path = "/reg")
        public String reg(Model model) {
            model.addAttribute("user", new User());
            return "reg";
        }


        @PostMapping(path = "/reg")
        public String reg(@Valid User user, BindingResult bindingResult, Model model) {
            if (!bindingResult.hasErrors()){
                if (userService.saveUser(user)) {
                    model.addAttribute("message", "Registration successful");
                    return "redirect:/";
                }
                else {
                    model.addAttribute("messageA", "Login is already in use");
                    model.addAttribute("keyReg", true);
                    return "reg";
                }
            } else {
                return "reg";
            }
        }

        @PostMapping(path = "/auth")
        public String auth(@Valid UserDTO userDTO, BindingResult bindingResult, Model model, HttpSession httpSession) {
            if (!bindingResult.hasErrors()) {
                User currentUser = userService.checkAuth(userDTO);
                httpSession.setAttribute("currentUser", currentUser);
                httpSession.setAttribute("key1", true);
                return "index";
            }
            else {
                return "index";
            }
        }

        @GetMapping(path = "/profiles/{id}")
        public String prof(@PathVariable(name = "id")long id, Model model ) {
            User userById = userService.getUserById(id);
            model.addAttribute("userProfile", userById);
            return "userProfile";

        }

        @GetMapping(path = "/logout")
        public String logout(HttpSession httpSession){
            httpSession.removeAttribute("currentUser");
            httpSession.setAttribute("key1", false);
            return "redirect:/";
        }


    }

