<%-- 
    Document   : cloud-publishing-nav-menu
    Created on : 6 дек. 2019 г., 17:25:22
    Author     : ikuzmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
 
    <a class="navbar-brand" href="#">Cloud-publishing</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/employees"/>">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Articles</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Magazines</a>
            </li>
        </ul>
    </div>
    
    <form method="post" action="<c:url value='/logout'/>">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-outline-success" type="submit">Logout</button>
    </form>
    
</nav>
