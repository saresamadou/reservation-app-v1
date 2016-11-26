app.controller("carController", function($scope, $http) {
	$scope.title="Car";
	$http.get("http://localhost:8080/cars/getCars").then(function (response) {
		$scope.cars = response.data;
	});
}); 