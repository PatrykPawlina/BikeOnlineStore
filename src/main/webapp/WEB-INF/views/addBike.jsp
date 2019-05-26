<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Canyon Bikes</title>
</head>
<body>
<section>
    <div class="pull-right" style="padding-right: 50px">
        <a href="?language=en">English</a> | <a href="?language=polish">Polish</a>
        <a href="<c:url value="/logout"/>">Logout</a>
    </div>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Canyon Bikes</h1>
            <p>Add Bike</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form method="POST" modelAttribute="newBike" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Add new Bike</legend>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="bikeId">
                    <spring:message code="addBike.form.bikeId.label"/></label>
                <div class="col-lg-10">
                    <form:input id="bikeId" path="bikeId" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">
                    <spring:message code="addBike.form.name.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                    <spring:message code="addBike.form.unitPrice.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="manufacturer">
                    <spring:message code="addBike.form.manufacturer.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                </div>
            </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="category">
                    <spring:message code="addBike.form.category.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="category" path="category" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                    <spring:message code="addBike.form.unitsInStock.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="description">
                    <spring:message code="addBike.form.description.label"/> </label>
                <div class="col-lg-10">
                    <form:input id="description" path="description" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" id="condition">
                    <spring:message code="addBike.form.condition.label"/> </label>
                <div class="col-lg-10">
                    <form:radiobutton path="condition" value="New"/>New
                    <form:radiobutton path="condition" value="Old"/>Old
                    <form:radiobutton path="condition" value="Refurbished"/>Refurbished
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="bikeImage">
                    <spring:message code="addBike.form.bikeImage.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="bikeImage" path="bikeImage" type="file" class="form:input-large"/>
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