app.controller("clientController", [
		"$scope",
		"$http",
		"$location",
		function($scope, $http, $location) {

			var Client = function() {
				var name, email, addresse, phone;
			};

			$scope.addclient = function() {
				var client = new Client();
				client.name = $scope.client.name;
				client.email = $scope.client.email;
				client.addresse = $scope.client.addresse;
				client.phone = $scope.client.phone;

				// Send POST request to add a new client
				$http.post("/clients/addClient", client)
						.success(function() {
							console.log("OK");
							$location.path('/home');
						}).error(function() {
							console.log("KO");
						});
			};

		} ]);