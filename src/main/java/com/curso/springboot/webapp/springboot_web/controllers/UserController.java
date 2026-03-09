package com.curso.springboot.webapp.springboot_web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.curso.springboot.webapp.springboot_web.models.Users;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        Users user = new Users("Leonardo", "Cespedes");
        user.setEmail("leonardo@correo.com");
        model.addAttribute("title", "Hola mundo spring Boot");
        model.addAttribute("user", user);
    
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        /* List<Users> users = getUsers();
        model.addAttribute("users", users); */
        model.addAttribute("title", "Lista de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<Users> getUsers() {
        return List.of(
            new Users("Leonardo", "Cespedes", "leonardo@correo.com"),
            new Users("Maria", "Gomez", "maria@correo.com"),
            new Users("Juan", "Perez", "juan@correo.com"),
            new Users("Ana", "Lopez", "ana@correo.com")
        );
    }
}
