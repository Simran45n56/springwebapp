<%-- 
    Document   : login
    Created on : Jan 17, 2019, 1:17:59 PM
    Author     : Siron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="Enter Username">
            <input type="text" name="password" placeholder="Enter Password">
             <input type="submit" value="Login">
        </form>
    </body>
</html>
