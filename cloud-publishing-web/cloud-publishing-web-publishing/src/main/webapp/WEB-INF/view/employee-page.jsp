<%-- 
    Document   : main
    Created on : 07.11.2019, 16:44:25
    Author     : Igor Kuzmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/employee-page.css'/>"/>
        <title>Employees</title>
    </head>
    <body>
        <header>
            <jsp:include page="cloud-publishing-nav-menu.jsp"/>
        </header>
        
        <main class="container-fluid">   
            
            <div class="row justify-content-center">
                
                <div class="col-sm-6">
                    
                    <table class="table table-hover">
                        <thead class="thead-inverse">
                            <tr>
                                <th>#</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Sex</th>
                                <th>Birth year</th>
                                <th>Employee type</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${employees}" var="employee" varStatus="status">
                                <tr>
                                    <th>${status.index}</th>
                                    <td>${employee.firstName}</td>
                                    <td>${employee.lastName}</td>
                                    <td>${employee.sex}</td>
                                    <td>${employee.birthYear}</td>
                                    <td>${employee.type}</td>
                                </tr>
                            </c:forEach>
                        </tbody>        
                    </table>
                    
                </div>  
                
            </div>
            
        </main>
             
        
        <script src="<c:url value='/resources/js/jquery/jquery-3.4.1.min.js'/>"></script>
        <script src="<c:url value='/resources/js/popper/popper.min.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap/bootstrap.min.js'/>"></script>
    </body>
</html>
