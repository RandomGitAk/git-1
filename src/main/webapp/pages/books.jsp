<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="message"/>
<fmt:setLocale value="${cookie['lang'].value}" scope="application"/>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<jsp:useBean id="bookList" class="dao.BookList" scope="page"/>

<%@include file="../WEB-INF/jspf/letters.jspf" %>

<div class="book_list">



    <%
        ArrayList<Book> list = null;

        if (request.getParameter("genre_id") != null) {
            long genreId = Long.parseLong(request.getParameter("genre_id"));
            list = bookList.getBooksByGenre(genreId);
        } else if (request.getParameter("letter") != null) {
            String letter = request.getParameter("letter");
            session.setAttribute("letter", letter);
            list = bookList.getBooksByLetter(letter);
        } else if (request.getParameter("search_string") != null) {
            String searchStr = request.getParameter("search_string");
            list = bookList.getBooksBySearch(searchStr);
        }
    %>
    <h5 style="text-align: left; margin-top:20px;"><fmt:message key="site_title"/>: <%=list.size() %> </h5>
    <%  session.setAttribute("currentBookList", list);
        for (Book book : list) {

    %>

    <div class="book_info">
        <div class="book_title">
            <p> <%=book.getName()%></p>
        </div>
        <div class="book_image">
            <a href="#"><img src="<%=book.getImage()%>" height="250" width="190" alt=""/></a>
        </div>
        <div class="book_details">
            <br><strong>ISBN:</strong> <%=book.getIsbn()%>
            <br><strong><fmt:message key="book.publisher"/>:</strong> <%=book.getPublisher()%>

            <br><strong><fmt:message key="book.page"/>:</strong> <%=book.getPageCount()%>
            <br><strong><fmt:message key="book.year"/>:</strong> <%=book.getPublishDate()%>
            <br><strong><fmt:message key="book.author"/>:</strong> <%=book.getAuthor()%>
            <p style="margin:10px;"> <a href="<%=book.getContent()%>"><fmt:message key="book.read"/></a></p>
        </div>
    </div>


    <%}%>



</div>
