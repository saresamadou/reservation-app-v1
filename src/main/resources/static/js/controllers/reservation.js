app.controller("reservationController", ["$scope", "$http","$location", "$rootScope" , 
	function($scope, $http, $location, $rootScope) {

	
	var Reservation = function() {
		var car, client;
	};
	
	
	console.log($rootScope.car);
	
	$scope.searchUser = function() {
		
		$http.post("/clients/login", $scope.user.email).
        success(function(data) {
        	$scope.client = data;
        	console.log(data);
        })
        .error(function() 
        {
        	console.log("KO");
        	$scope.message="No client with this email !";
        }); 
	};
	
	
$scope.reserve = function() {
		
		var reservation = new Reservation();
		reservation.car = $rootScope.car;
		reservation.client = $scope.client;
		
		console.log(reservation);
		
		//Make a reservation
		$http.post("/rsv/addReservation", reservation).
        success(function(data) {
        	console.log("OK");
        	console.log(data);
       	//Reload the page to actualise the car status
        	$location.path('/home');
       
       })
        .error(function() 
        {console.log("KO");
        }); 
	};
}]); 