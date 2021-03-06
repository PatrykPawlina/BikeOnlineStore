<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
    <script src="/BikeOnlineStore/resources/js/controllers.js"></script>
    <title>Bikes</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Bikes</h1>
        </div>
    </div>
</section>
<section class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/img/${bike.bikeId}.jpg"></c:url>"
                 alt="image" style="width: 100%"/>
        </div>
        <div class="col-md-5">
            <h3>${bike.name}</h3>
            <p>${bike.description}</p>
            <p>
                <strong>Item Code : </strong><span class="label label-warning">${bike.bikeId}</span>
            </p>
            <p>
                <strong>manufacturer</strong> : ${bike.manufacturer}
            </p>
            <p>
                <strong>category</strong> : ${bike.category}
            </p>
            <p>
                <strong>Available units in stock </strong> : ${bike.unitsInStock}
            </p>
            <h4>${bike.unitPrice}EUR</h4>
            <p ng-controller="cartCtrl">
                <a href="<spring:url value="/market/bikes" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> back
                </a>
                <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${bike.bikeId}')">
                    <span class="glyphicon-shopping-cart glyphicon"></span> Order Now
                </a>
                <a href="<spring:url value="/cart" />" class="btn btn-default">
                    <span class="glyphicon-hand-right glyphicon"></span> View Cart
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>
