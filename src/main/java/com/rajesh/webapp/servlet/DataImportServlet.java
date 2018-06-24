/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.webapp.servlet;

import com.rajesh.webapp.util.DataImportThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "import", urlPatterns = "/import")

public class DataImportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = "C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaServletMVCProject\\src\\main\\webapp\\WEB-INF\\upload\\";

        if (request.getParameter("file") == null || request.getParameter("file").isEmpty()) {
            request.setAttribute("files", new File(uploadPath).listFiles());
            request.getRequestDispatcher("/WEB-INF/views/importer.jsp")
                    .forward(request, response);
        } else {
            DataImportThread thread=new DataImportThread(request.getParameter("file"));
            thread.start();
            response.sendRedirect(request.getContextPath());

        }
    }

}
