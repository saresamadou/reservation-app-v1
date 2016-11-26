var app = angular.module('carReservationApp', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/login', {
			templateUrl: 'views/login.html',
			controller: 'RegistrationController'
		}).
		when('/register', {
			templateUrl: 'views/register.html',
			controller: 'RegistrationController'
		}).
		when('/success', {
			templateUrl: 'views/home.html',
			controller: 'homeController'
		}).
		when('/car', {
			templateUrl: 'views/car.html',
			controller: 'carController'
		}).
		otherwise( {
			redirectTo: '/login'
		});
	//$locationProvider.html5Mode(true);
}]);

