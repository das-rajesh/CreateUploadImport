<%-- 
    Document   : importer
    Created on : Jun 24, 2018, 5:31:24 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Files</h1>
        <table>
            <tr>
                <th>file</th>
                <th>Action</th>
            </tr>
            <c:forEach var="file" items="${files}">
                <tr>
                    <td>${file.getName()}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/import?file=${file.getName()}">
                        Import</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
