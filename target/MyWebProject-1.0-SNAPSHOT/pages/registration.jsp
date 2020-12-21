
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.*" %>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setBundle basename="message"/>
<fmt:setLocale value="${cookie['lang'].value}" scope="application"/>
<html>
<head>
    <title><fmt:message key="site_title"/></title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">

    <style>
        @import "../styles/dropbox.css";
        @import "../bootstrap/css/bootstrap.css";
        @import "../bootstrap/css/bootstrap.min.css";
    </style>
</head>
<body>
<div style="padding: 20px">

    <h1><fmt:message key="reg.form"/></h1>
    <div class="row">
        <div class="col-sm-4">
            <form method="post" action="/users/save">
                </br>
                 <div align="left">
                     <label for="login" class="form-label"><fmt:message key="user.login"/></label>
                     <input type="text" class="form-control" placeholder=<fmt:message key="user.login"/>  name="login" id="login"
                            required>
                 </div>

                <div align="left">
                    <label for="password" class="form-label"><fmt:message key="user.password"/></label>
                    <input type="password" class="form-control" placeholder=<fmt:message key="user.password"/>  name="password" id="password"
                           required>
                </div>

                <div align="left">
                    <label for="email" class="form-label"><fmt:message key="reg.email"/></label>
                    <input type="text" class="form-control" placeholder=<fmt:message key="reg.email"/>  name="email" id="email"
                           required>
                </div>

                </br>
                <div align="rigth">
                    <input type="submit" id="submit" value=
                    <fmt:message key="button.submit"/> name="submit" class="btn btn-info">
                    <input type="reset" id="reset" value=
                    <fmt:message key="button.cancel"/> name="reset" class="btn btn-warning">
                    <h4 align="center"><a href="../index.html"><fmt:message key="header.exit"/></a></h4>
                </div>

            </form>
        </div>


    </div>
</div>
</body>

</html>
