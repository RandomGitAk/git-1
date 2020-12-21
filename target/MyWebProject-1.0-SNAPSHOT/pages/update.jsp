<jsp:useBean id="book" scope="request" type="model.Book"/>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setBundle basename="message"/>
<fmt:setLocale value="${cookie['lang'].value}" scope="application"/>

<html>
<head>
    <title>Редагування</title>
    <style>
        @import "../bootstrap/css/bootstrap.css";
        @import "../bootstrap/css/bootstrap.min.css";
    </style>
</head>
<body>

<div style="padding: 20px">

    <h1><fmt:message key="data.update"/></h1>
    <div class="row">
        <div class="col-sm-4">
            <form method="post" action="<c:url value="/user/update"/>">

                <input style="visibility: hidden" type="number" name="id" id="id" value="${book.id}">

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.name"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="adminB.name"/> value="${book.name}" name="name" id="name"
                           required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.content"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="adminB.content"/> value="${book.content}" name="content" id="content"
                           required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.count"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="adminB.count"/> value="${book.pageCount}" name="pageCount" id="pageCount"
                           required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.isbn"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="adminB.isbn"/> value="${book.isbn}" name="isbn" id="isbn"
                           required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.genre"/></label>
                    <select class="form-control" name="genre" id="genre" required>
                        <c:forEach items="${listG}" var="genre">
                            <option

                                    <c:if  test="${book.genreId == genre.key}">
                                        selected
                                    </c:if>

                                    value="${genre.key}">${genre.value}</option>
                        </c:forEach>
                    </select>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.author"/></label>
                    <select class="form-control" name="author" id="author" required>
                        <c:forEach items="${listA}" var="author">
                            <option

                                    <c:if  test="${book.authorId == author.key}">
                                        selected
                                    </c:if>

                                    value="${author.key}">${author.value}</option>
                        </c:forEach>
                    </select>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.year"/></label>
                    <input type="number" class="form-control" placeholder=
                    <fmt:message key="adminB.year"/> value="${book.publishDate}" name="publishDate" id="publishDate" required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.publish"/></label>
                    <select class="form-control" name="publisher" id="publisher" required>
                        <c:forEach items="${listP}" var="publisher">
                            <option

                                    <c:if  test="${book.publisherId == publisher.key}">
                                        selected
                                    </c:if>

                                    value="${publisher.key}">${publisher.value}</option>
                        </c:forEach>
                    </select>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.image"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="adminB.image"/> value="${book.image}" name="image" id="image"
                           required>
                </div>

                </br>
                <div align="rigth">
                    <input type="submit" id="submit" value=
                    <fmt:message key="button.submit"/> name="submit" class="btn btn-info">
                    <input type="reset" id="reset" value=
                    <fmt:message key="button.cancel"/> name="reset" class="btn btn-warning"
                           onclick="location.href='/courses'">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
