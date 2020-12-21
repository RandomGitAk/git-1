<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="message"/>
<fmt:setLocale value="${cookie['lang'].value}" scope="application"/>
<!DOCTYPE html>

<%@include file="../WEB-INF/jspf/header.jspf" %>
<%@include file="../WEB-INF/jspf/left_menu.jspf" %>
<%@include file="../WEB-INF/jspf/letters.jspf" %>

<div style="float:left; margin-top: 20px;">
    <h3><fmt:message key="main.content"/></h3>
</div>

      