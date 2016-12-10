app.controller('homeController', [ '$scope', '$http','$location','$route', function($scope, $http, $location, $route) {

	
	
	$scope.$on('CLIENT_CONNECTED' , function(client) {
		$scope.client = client;
	});
	
	var Reservation = function() {
		var car, client;
	};

	$scope.title = "Home";
	$http.get("http://localhost:8080/cars/getCars").then(function(response) {
		$scope.cars = response.data;
	});

	// Reservation function
	$scope.reserve = function(carReserved, client) {
		console.log(carReserved);
		var reservation = new Reservation();
		reservation.car = carReserved;
		reservation.client = client;
		
		//Make a reservation
		$http.post("http://localhost:8080/rsv/addReservation", reservation).
        success(function(data) {
        	console.log("OK");
        	console.log(data);
        	//Reload the page to actualise the car status
        	$location.path('/home');
        	$route.reload();
        })
        .error(function() 
        {console.log("KO");
        }); 
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