<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>list of messages</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"></link>
</head>

<body>

<div class="container-fluid">
    <div class="well lead">Currently recieved messages from AQ:</div>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>created at</th>
            <th>int value</th>
            <th>pick value</th>
            <th>date value</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${messages}" var="entry">
            <tr>
                <td>${entry.uid}</td>
                <td>${entry.createDate}</td>
                <td>${entry.intValue}</td>
                <td>${entry.pickValue}</td>
                <td>${entry.dateValue}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>