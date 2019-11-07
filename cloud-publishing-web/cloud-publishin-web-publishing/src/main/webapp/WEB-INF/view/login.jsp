<%-- 
    Document   : login
    Created on : 26.10.2019, 14:17:42
    Author     : Igor Kuzmin
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
        <form method="post" action="${pageContext.request.contextPath}/login/processing">
            <label for="login">Login</label>
            <input type="text" placeholder="Login" name="login"/>
            <label for="password">Password</label>
            <input type="password" placeholder="Password" name="password"/>
            <input type="submit" value="submit"/>
            <input type="hidden"name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </body>
</html>
