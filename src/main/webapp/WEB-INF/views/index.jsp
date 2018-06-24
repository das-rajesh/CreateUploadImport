<%-- 
    Document   : index
    Created on : Jun 24, 2018, 4:59:18 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Upload File</h1>
        <form method="post" action="${pageContext.request.contextPath}/upload"
              enctype="multipart/form-data">
            <input type="file"  name="file"/>
            <button type="submit">Upload</button>
            
        </form>
    </body>
</html>
