<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Canyon Bikes</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Canyon Bikes</h1>
            <p>All the available bikes in our store</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${bikes}" var="bike">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="<c:url value="/img/${bike.bikeId}.jpg">
                    </c:url>" alt="image" style="width: 100%"/>
                    <div class="caption">
                        <h3>${bike.name}</h3>
                        <p>${bike.description}</p>
                        <p>${bike.unitPrice} EUR</p>
                        <p>Available ${bike.unitsInStock} units in stock</p>
                        <p>
                            <a href=" <spring:url value="/market/bike?id=${bike.bikeId}"/>"
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Details
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
