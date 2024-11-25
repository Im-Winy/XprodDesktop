/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xprod.xproddesktop.dao;

import com.xprod.xproddesktop.model.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author william NYACKA
 */
public class UserDao {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public UserDao() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Register de MySQL Driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xproddb", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La connexion à la base de données a échouée, une erreur s'est produite!" + e);
        }
    }

    public List rechercheLogin(String username, String password) {
        List logLogin = new ArrayList();
        int result;

        sql = "SELECT username, password, authorization FROM user WHERE username='" + username + "' and password= '" + password + "'";

        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Users user = new Users();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAuthorization(rs.getString("authorization"));
                logLogin.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "une erreur s'est produite lors du login: \n" + e);
        }
        return logLogin;
    }

}
