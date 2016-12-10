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
		when('/home', {
			templateUrl: 'views/home.html',
			controller: 'homeController'
		}).
		when('/car', {
			templateUrl: 'views/car.html',
			controller: 'carController'
		}).
		when('/addcar', {
			templateUrl: 'views/addcar.html',
			controller: 'carController'
		}).
		when('/addclient', {
			templateUrl: 'views/addclient.html',
			controller: 'clientController'
		}).
		when('/reservations', {
			templateUrl: 'views/reservations.html',
			controller: 'reservationsController'
		}).
		when('/contact', {
			templateUrl: 'views/contact.html',
			controller: 'contactController'
		}).
		otherwise( {
			redirectTo: '/login'
		});
	//$locationProvider.html5Mode(true);
}]);

