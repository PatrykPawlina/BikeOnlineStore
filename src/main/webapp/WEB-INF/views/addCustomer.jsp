<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Canyon Bikes</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Canyon Bikes</h1>
            <p>Add new Customer</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form method="POST" modelAttribute="newCustomer" class="form-horizontal">
        <fieldset>
            <legend>Add new Customer</legend>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="firstName">
                    <spring:message code="addCustomer.form.firstName.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="lastName">
                    <spring:message code="addCustomer.form.lastNme.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="emailAddress">
                    <spring:message code="addCustomer.form.emailAddress.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="emailAddress" path="emailAddress" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" id="customerGender">
                    <spring:message code="addCustomer.form.customerGender.label"/> </label>
                <div class="col-lg-10">
                    <form:radiobutton path="customerGender" value="Male"/>Male
                    <form:radiobutton path="customerGender" value="Female"/>Female
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Add"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>