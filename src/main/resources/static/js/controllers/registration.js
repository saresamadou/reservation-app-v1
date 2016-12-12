app.controller('RegistrationController', ['$scope','$location','$http','$rootScope', 
	function($scope, $location, $http, $rootScope ) {
	
	
	
	$scope.login=function() {
		
		var email = $scope.user.email;
		
		$http.post("/clients/login", email).
        success(function(data) {
        	console.log("OK");
        	$rootScope.connectedUser = data;
        	$location.path('/home');
        })
        .error(function() 
        {console.log("KO");
        }); 
	};
		
		

	
	$scope.register=function() {
		$location.path('/addclient')	}
}]);