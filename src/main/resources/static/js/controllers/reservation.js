app.controller("reservationsController", ["$scope", "$http","$location" , function($scope, $http, $location) {

	$http.get("http://localhost:8080/rsv/getReservations").then(function(response) {
		$scope.reservations = response.data;
	});
}]); 