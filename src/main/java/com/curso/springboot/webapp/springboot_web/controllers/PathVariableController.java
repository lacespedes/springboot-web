package com.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.webapp.springboot_web.models.Users;
import com.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    @Value("${config.username}")
    private String username;

    @Value("${config.password}")
    private String password;

    @Value("${config.message}")
    private String message;

    @Value("${config.listofvalues}")
    private List<String> listofvalues;
    
    @Value("${config.listofvalues}")
    private String[] listofvaluesArray;

    @Value("#{'${config.listofvalues}'.split(',')}")
    private String[] valueslist;

    @Value("#{'${config.listofvalues}'.toUpperCase()}")
    private String valueString;

    @Value("${config.caracterespeciales}")
    private String caracterespeciales;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;
    
    @Value("#{${config.valuesMap}.price}")
    private String price;

    @Autowired
    private Environment environment;

    @GetMapping(path = "/baz/{message}", produces = "application/json;charset=UTF-8")
    public ParamDto baz(@PathVariable() String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message );
        return paramDto;
    }

    @GetMapping(path = "/mix/{product}/{id}", produces = "application/json;charset=UTF-8")
    public Map<String, Object> mix(@PathVariable() String product, @PathVariable() Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping(path = "/create", produces = "application/json;charset=UTF-8")
    public Users create(@RequestBody Users user) {        
        return user;
    }

    @GetMapping(path = "/config", produces = "application/json;charset=UTF-8")
    public Map<String, Object> getConfig(@Value("${config.code}") int code) {
        Map<String, Object> json = new HashMap<>(); 
        json.put("username", username);
        json.put("password", password);
        json.put("message", message);
        json.put("listofvalues", listofvalues);
        json.put("code", code);
        json.put("listofvaluesArray", listofvaluesArray);
        json.put("caracterespeciales", caracterespeciales);
        json.put("valueslist", valueslist);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
    }
    
    @GetMapping("/env")
    public Map<String, Object> env() {
         Map<String, Object> json = new HashMap<>();
         json.put("CodeParseInt", Integer.parseInt(environment.getProperty("config.code")));
         json.put("Code", environment.getProperty("config.code", Long.class));
         json.put("Message", environment.getProperty("config.message"));
         return json;
    }
    
    
}
