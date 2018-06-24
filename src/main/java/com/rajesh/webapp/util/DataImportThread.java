/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.webapp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class DataImportThread extends Thread {

    String uploadPath = "C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaServletMVCProject\\src\\main\\webapp\\WEB-INF\\upload\\";
    String fileName;

    public DataImportThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            BufferedReader reader = new BufferedReader(new FileReader(uploadPath + "/" + fileName));
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmj18003_project", "root", "");
            String sql = "insert into customers(first_name,"
                    + "last_name,email,contact_no,status)"
                    + "values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println("importing......" + line);
                String[] tokens = line.split(",");
                stmt.setString(1, tokens[1]);
                stmt.setString(2, tokens[2]);
                stmt.setString(3, tokens[3]);
                stmt.setString(4, tokens[4].substring(0, 10));
                stmt.setBoolean(5, Boolean.parseBoolean(tokens[5]));
                stmt.executeUpdate();

            }
            conn.close();
        } catch (SQLException | ClassNotFoundException | IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
