/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xprod.xproddesktop.model;

/**
 *
 * @author william NYACKA
 */
public class Users {
    private int idUser;
    private String username;
    private String password;
    private String authorization;

    public Users() {
    }

    public Users(int idUser, String username, String password, String authorization) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.authorization = authorization;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
    
    
}
