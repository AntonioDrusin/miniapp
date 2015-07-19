(function(){
	'use strict';

	angular.module('frontend', [ 'ngRoute','frontend-main','templates' ])
	  .config(function ($routeProvider) {
	    $routeProvider
	      .otherwise({
	        redirectTo: '/'
	      });
	  });
	  
})();