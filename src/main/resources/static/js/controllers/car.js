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
						function() {
							console.log("OK");
							$location.path('/home');
						}).error(function() {
					console.log("KO");
				});

			};

		} ]);