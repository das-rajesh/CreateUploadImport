/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.webapp.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Dell
 */
@WebServlet(name = "upload",urlPatterns = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String uploadPath = "C:\\Users\\Dell\\Documents\\NetBeansProjects\\JavaServletMVCProject\\src\\main\\webapp\\WEB-INF\\upload\\";
        Part part = request.getPart("file");
        InputStream is = part.getInputStream();
        FileOutputStream os = new FileOutputStream(uploadPath + part.getSubmittedFileName());

        byte[] data = new byte[1024 * 5];
        int i = 0;
        while ((i = is.read(data)) != -1) {
            os.write(data, 0, i);
        }
        os.close();
        response.sendRedirect(request.getContextPath());

    }

}
