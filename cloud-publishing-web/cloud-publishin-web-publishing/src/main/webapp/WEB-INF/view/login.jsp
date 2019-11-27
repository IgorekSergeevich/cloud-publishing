<%-- 
    Document   : login
    Created on : 26.10.2019, 14:17:42
    Author     : Igor Kuzmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form method="post" action="${pageContext.request.contextPath}/login/processing">
            <div class="form-group">
                <label for="login" for="userLogin">Login</label>
                <input type="text" placeholder="Login" name="login" class="form-control" id="userLogin"/>
            </div>
            <div class="form-group">
                <label for="password" for="userPassword">Password</label>
                <input type="password" placeholder="Password" name="password" class="form-control" id="userPassword"/>
            </div>
            <div class="form-group">
                <input type="submit" value="submit" class="btn btn-primary"/>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        
        <script src="<c:url value='/resources/js/jquery/jquery-3.4.1.min.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap/bootstrap.min.js'/>"></script>
    </body>
</html>
