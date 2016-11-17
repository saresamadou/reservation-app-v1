app.controller("carCtrl", function($scope, $http) {
	$http.get("http://localhost:8080/cars/getCars").then(function (response) {
		$scope.cars = response.data;
	});
});