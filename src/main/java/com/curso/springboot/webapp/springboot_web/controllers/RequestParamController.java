package com.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "No se ha recibido ningún mensaje") String message){
        ParamDto paramDto = new ParamDto();

       //paramDto.setMessage(message!= null ? message : "No se ha recibido ningún mensaje");
       paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam(required=false) String text, @RequestParam(required = false) Integer code ){
        ParamMixDto paramDto = new ParamMixDto();
        paramDto.setText(text);
        paramDto.setCode(code);
        return paramDto;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        ParamMixDto paramDto = new ParamMixDto();
        String text = request.getParameter("text");
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }
        paramDto.setText(text);
        paramDto.setCode(code);
        return paramDto;
    }

}
