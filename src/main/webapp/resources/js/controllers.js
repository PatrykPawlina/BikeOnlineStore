var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.refreshCart = function (cartId) {
        $http.get("/BikeOnlineStore/rest/cart/" + $scope.cartId)
            .success(function (data) {
                $scope.cart = data;
            });
    };

    $scope.clearCart = function () {
        $http.delete("/BikeOnlineStore/rest/cart/" + $scope.cartId)
            .success(function (data) {
                $scope.refreshCart($scope.cartId);
            });

    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function (bikeId) {
        $http.put("/BikeOnlineStore/rest/cart/add/" + bikeId)
            .success(function (data) {
                alert("Bike Successfully added to the Cart!");
            });
    };
    $scope.removeFromCart = function (bikeId) {
        $http.put("/BikeOnlineStore/rest/cart/remove/" + bikeId)
            .success(function (data) {
                $scope.refreshCart($scope.cartId);
            });
    };
});
