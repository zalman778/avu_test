<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Message status</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"></link>
</head>
<body>
<div class="container-fluid">
    <div class="alert alert-success lead">
        ${info_block}
    </div>

    <span class="well floatRight">
		<a href="${pageContext.request.contextPath}/add">New message</a>
	</span>


</div>
</body>

</html>