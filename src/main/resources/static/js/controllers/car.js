app.controller("carController", [
		"$scope",
		"$http",
		"$location",
		function($scope, $http, $location) {
			// Car object declaration
			var Car = function() {
				var matricule, marque, place, disponibilite;
			};

			$scope.title = "Car";
			$http.get("http://localhost:8080/cars/getCars").then(
					function(response) {
						$scope.cars = response.data;
					});

			$scope.addcar = function() {

				var car = new Car();
				car.marque = $scope.car.marque;
				car.matricule = $scope.car.matricule;
				car.place = $scope.car.place;
				car.disponibilite = $scope.car.disponibilite;

				// Send POST request to add a new car
				$http.post("http://127.0.0.1:8080/cars/addCar", car).success(
						function(data) {
							if(data==300){
								$scope.error_message="The car with matricule " + car.matricule +" you're adding already exists!";
							} else if(data==200){
								$location.path('/home');
							}
							
						}).error(function(data) {
							console.log(data);
				});

			};

		} ]);