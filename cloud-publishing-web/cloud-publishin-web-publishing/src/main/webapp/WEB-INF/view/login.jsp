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
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/fontawesome.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css'/>"/>
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            
            <header class="row justify-content-center">
                <img src="<c:url value='/resources/img/cloud-publish-logo.png'/>">
            </header>	
            
            <section class="row justify-content-center">
		<div class="col col-sm-5">
                    <div class="card login-container">
                        <h5 class="card-header text-white bg-primary text-center">Sign up</h5>
			<div class="card-body"> 
                            <form method="post" action="${pageContext.request.contextPath}/login/processing">
                                <div class="form-group">
                                    <label for="userLogin">Login</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-user"></i>
                                            </span>
                                        </div>
                                        <input id="userLogin" type="text" name="login" class="form-control" placeholder="Login"/>
                                    </div>
                                    	
				</div>
                                <div class="form-group">
                                    <label for="userPassword">Password</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-eye"></i>
                                            </span>
                                        </div>
                                        <input id="userPassword" type="password" name="password" class="form-control" placeholder="Password"/>
                                    </div>	
                                </div>
				<div class="form-row justify-content-center">
                                    <div class="col-sm-6">
                                        <input type="submit" value="Sign in" class="btn btn-success btn-block"/>
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</div>
                            </form>
			</div>
                    </div>	
		</div> 			
            </section>
            
            <footer class="text-right">
                <hr/>
		<span>Version 1.0-SNAPSHOT</span>
            </footer>
            
        </div>
            
        <script src="<c:url value='/resources/js/jquery/jquery-3.4.1.min.js'/>"></script>
        <script src="<c:url value='/resources/js/popper/popper.min.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap/bootstrap.min.js'/>"></script>
    </body>
</html>
