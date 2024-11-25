/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xprod.xproddesktop.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 *
 * @author William
 */
public class Connexion {

    private Connection con;

    public Connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/xproddb", "root", "");

        } catch (Exception e) {
        }
    }

    public Connection getCon() {
        return con;
    }

}
