app.controller('RegistrationController', ['$scope','$location','$http', function($scope, $location, $http ) {
	
	
	
	$scope.login=function() {
		
		var email = $scope.user.email;
		
		$http.post("http://127.0.0.1:8080/clients/login", email).
        success(function(data) {
        	console.log("OK");
        	console.log(data);
        	$location.path('/home');
        })
        .error(function() 
        {console.log("KO");
        }); 
	};
		
		

	
	$scope.register=function() {
		$location.path('/addclient')	}
}]);