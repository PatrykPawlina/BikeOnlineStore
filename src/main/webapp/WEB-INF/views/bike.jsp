<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min/css">
    <title>Canyon Bikes</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Canyon Bikes</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <h3>${bike.name}</h3>
            <p>${bike.description}</p>
            <p>
                <strong>Item Code : </strong>
                <span class="label label warning">${biike.bikeId}</span>
            </p>
            <p>
                <strong>manufacturer</strong> : ${bike.manufacturer}
            </p>
            <p>
                <strong>category</strong> : ${bike.category}
            </p>
            <p>
                <strong>Available units in stock</strong> : ${bike.unitsInStock}
            </p>
            <h4>${bike.unitsInStock} EUR</h4>
            <p>
                <a href="#" class="btn btn-warning btn-large">
                    <span class="glyphiocon-shopping-cart glyphicon"></span> Order Now
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>