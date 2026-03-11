package com.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.webapp.springboot_web.models.Users;
import com.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @RequestMapping(path = "/details", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public UserDto details() {
        Users user = new Users("Leonardo", "Cespedes");

        UserDto userDto = new UserDto();
        userDto.setTitle("Hola mundo spring Boot");
        userDto.setUser(user);

        return userDto;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Users> list() {
        Users user1 = new Users("Leonardo", "Cespedes");
        Users user2 = new Users("Maria", "Gonzalez");
        Users user3 = new Users("Carlos", "Perez");

        List<Users> users = List.of(user1, user2, user3);

        return users;

    }

    @RequestMapping(path = "/details-map", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Map<String, Object> detailsMap() {
        Users user = new Users("Leonardo", "Cespedes");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo spring Boot");
        body.put("user", user);

        return body;
    }
}
