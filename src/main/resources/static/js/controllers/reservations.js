app.controller("reservationsController", ["$scope", "$http","$location" , function($scope, $http, $location) {

	$http.get("/rsv/getReservations").then(function(response) {
		$scope.reservations = response.data;
	});
}]); 