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

<%

    request.setAttribute("listAuthors", new AuthorList().listAuthorsNames());
    request.setAttribute("listGenres", new GenreList().listGenre());
    request.setAttribute("listPublishers",new PublisherList().listPublishersNames());
    request.setAttribute("listBooks",new BookList().listBooks());
%>

<div style="padding: 20px">

    <h1><fmt:message key="site_title"/></h1>
    <div class="row">
        <div class="col-sm-4">
            <form method="post" action="/user/save">
                </br>

             <div align="left">
                <label class="form-label"><fmt:message key="adminB.name"/></label>
                <input type="text" class="form-control" placeholder=
                <fmt:message key="adminB.name"/> name="name" id="name"
                       required>
            </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.content"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="adminB.content"/> name="content" id="content"
                           required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.count"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="adminB.count"/> name="pageCount" id="pageCount"
                           required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.isbn"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="adminB.isbn"/> name="isbn" id="isbn"
                           required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.genre"/></label>
                    <select class="form-control" name="genre" id="genre" required>
                        <c:forEach items="${listGenres}" var="genre">
                            <option value="${genre.key}">${genre.value}</option>
                        </c:forEach>
                    </select>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.author"/></label>
                    <select class="form-control" name="author" id="author" required>
                        <c:forEach items="${listAuthors}" var="author">
                            <option value="${author.key}">${author.value}</option>
                        </c:forEach>
                    </select>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.year"/></label>
                    <input type="number" class="form-control" placeholder=
                    <fmt:message key="adminB.year"/> name="publishDate" id="publishDate" required>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.publish"/></label>
                    <select class="form-control" name="publisher" id="publisher" required>
                        <c:forEach items="${listPublishers}" var="publisher">
                            <option value="${publisher.key}">${publisher.value}</option>
                        </c:forEach>
                    </select>
                </div>

                <div align="left">
                    <label class="form-label"><fmt:message key="adminB.image"/></label>
                    <input type="file" name="file" class="btn btn-info">
                </div>


                </br>
                <div align="rigth">
                    <input type="submit" id="submit" value=
                    <fmt:message key="button.submit"/> name="submit" class="btn btn-info">
                    <input type="reset" id="reset" value=
                    <fmt:message key="button.cancel"/> name="reset" class="btn btn-warning">
                </div>

                </br>
                <h4><a href="/author"><fmt:message key="add.author"/></a></h4>
                <h4><a href="/genre"><fmt:message key="add.genre"/></a></h4>
                <h4><a href="/publisher"><fmt:message key="add.publisher"/></a></h4>
            </form>
        </div>

        <div class="col-sm-8">
            <div class="panel-body">
                <table id="tbl-subjects" class="table table-responsive table-bordered" cellpadding="0" width="100%">
                    <thead>
                    <tr>
                        <th><fmt:message key="adminB.name"/></th>
                        <th><fmt:message key="adminB.content"/></th>
                        <th><fmt:message key="adminB.count"/></th>
                        <th><fmt:message key="adminB.isbn"/></th>
                        <th><fmt:message key="adminB.genre"/></th>
                        <th><fmt:message key="adminB.author"/></th>
                        <th><fmt:message key="adminB.year"/></th>
                        <th><fmt:message key="adminB.publish"/></th>
                        <th><fmt:message key="adminB.image"/></th>

                        <th><fmt:message key="data.edit"/></th>
                        <th><fmt:message key="data.delete"/></th>
                    </tr>

                    <c:forEach items="${listBooks}" var="books">
                    <tr>
                        <td>${books.name}</td>
                        <td>${books.content}</td>
                        <td align="center">${books.pageCount}</td>
                        <td align="center">${books.isbn}</td>
                        <td align="center">${books.genre}</td>
                        <td align="center">${books.author}</td>
                        <td align="center">${books.publishDate}</td>
                        <td align="center">${books.publisher}</td>
                        <td align="center">${books.image}</td>

                        <td align="center"><a href="/user/update?id=${books.id}"><img
                                src="../images/edit.png" alt="Edit" width="24"></a></td>
                        <td align="center"><a href="/delete?id=${books.id}"><img
                                src="../images/delete.png" alt="Delete" width="24"></a></td>
                    </tr>

                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</div>

<div>
    <h5>
        <fmt:message key="cookie.ChooseLocale"/>
    </h5>
    <ul>
        <li><a href="confirm?cookieLocale=en_US"><fmt:message key="lang.en"/></a></li>
        <li><a href="confirm?cookieLocale=uk_UA"><fmt:message key="lang.ua"/></a></li>
        <li><a href="confirm?cookieLocale=de_DE"><fmt:message key="lang.de"/></a></li>
    </ul>
</div>

<div id="report_div">
    <p><a href="/getPdfFile" target="_blank">Get report in PDF</a></p>
</div>

<form action="/logout" method="get">
    <input type="submit" value=
    <fmt:message key="user.logout"/> id="frm1_submit"/>
</form>

</body>
</html>
