<%-- 
    Document   : main
    Created on : 07.11.2019, 16:44:25
    Author     : 21Vek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
        <title>Employees</title>
    </head>
    <body>
        <header>
            <jsp:include page="cloud-publishing-nav-menu.jsp"/>
        </header>
        
        <script src="<c:url value='/resources/js/jquery/jquery-3.4.1.min.js'/>"></script>
        <script src="<c:url value='/resources/js/popper/popper.min.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap/bootstrap.min.js'/>"></script>
    </body>
</html>
