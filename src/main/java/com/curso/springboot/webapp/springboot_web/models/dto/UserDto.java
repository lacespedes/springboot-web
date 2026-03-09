package com.curso.springboot.webapp.springboot_web.models.dto;

import com.curso.springboot.webapp.springboot_web.models.Users;

public class UserDto {
    private String title;
    private Users user;

    public UserDto() {
    }

    public UserDto(String title, Users user) {
        this.title = title;
        this.user = user;
    }
    public String getTitle() {
        return title;       
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
}
