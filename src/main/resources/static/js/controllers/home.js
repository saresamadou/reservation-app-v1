app.controller('homeController', [ '$scope', '$http','$location','$route','$rootScope', 
	function($scope, $http, $location, $route, $rootScope) {

	console.log($rootScope.connectedUser);
	
	
	

	$scope.title = "Home";
	$http.get("/cars/getCars").then(function(response) {
		$scope.cars = response.data;
	});

	// Reservation function
	$scope.reserve = function(carReserved) {
		$rootScope.car = carReserved;
		$location.path('/reservation');
	};
	
	//Return the disponiblity
	$scope.getDispo = function(isDispo) {
		
		if(isDispo) {
			return "Available";
		} else {
			return "Unavailable";
		}
	};
	
} ]);