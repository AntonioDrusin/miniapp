(function(){
	'use strict';

	angular.module('frontend.controllers',['restangular']);
	angular.module('frontend', [ 'ui.router','templates', 'frontend.services', 'restangular', 'frontend.controllers' ])
	  .config([ "$urlRouterProvider", function ( $urlRouterProvider) {
            $urlRouterProvider.otherwise("/error");
	  }])
	.run(['$rootScope', function($rootScope) {
	    // We need this to track errors during resolve of ui.router
		$rootScope.$on('$stateChangeError', function (event, toState, toParams, fromState, fromParams, error) {
			throw error;
		});
	}]);
	  
})();