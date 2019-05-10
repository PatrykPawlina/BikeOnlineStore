<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Canyon Bikes</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Canyon Bikes</h1>
            <p>All the available Bikes in our Bike Store</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${bikes}" var="bike">
            <div class="col-sm-8 col-md-4">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${bike.name}</h3>
                        <h4>${bike.category}</h4>
                        <p>${bike.description}</p>
                        <p>Price: ${bike.unitPrice} EUR</p>
                        <p>Available ${bike.unitsInStock} units in stock</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
