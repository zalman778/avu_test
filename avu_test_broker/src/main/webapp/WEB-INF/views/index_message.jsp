<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Creating new message</title>

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
</head>

<body>

<div class="container-fluid">
    <div class="well lead">new message</div>
    <form:form method="POST" modelAttribute="message" class="form-horizontal" action="${pageContext.request.contextPath}/add">
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="intValue">Int value</label>
                <div class="col-md-7">
                    <form:input type="text" path="intValue" id="intValue" class="form-control input-sm" required="required"/>
                    <div class="has-error">
                        <form:errors path="intValue" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="pickValue">Pick value:</label>
                <div class="col-md-7">

                    <form:select path="pickValue" id="pickValue" required="required" class="form-control">
                        <form:options items="${pickVariantMap}" />
                    </form:select>

                    <div class="has-error">
                        <form:errors path="pickValue" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="dateValue">Date value (dd-MM-YYYY):</label>
                <div class="col-md-7">
                    <form:input readonly="readonly" path="dateValue" id="dateValue" class="form-control input-sm" required="required"/>
                    <div class="has-error">
                        <form:errors path="dateValue" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <input type="submit" value="SEND message" class="btn btn-primary btn-sm"/>
                or <a href="<c:url value='/' />">Cancel</a>
            </div>
        </div>
    </form:form>
</div>
</body>

    <script type="text/javascript">
        $( function() {
            $( "#dateValue" ).datepicker();
        } );
    //allow only digits
    $("#intValue").on("keyup", function(e)
    {
        if (/\D/g.test(this.value))
        {
            this.value = this.value.replace(/\D/g, '');
        }
    });
    //readonly for date
    $("#dateValue").prop("readonly", true);
</script>

</html>