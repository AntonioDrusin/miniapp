(function(){
	'use strict';

	angular.module('frontend', [ 'ui.router','frontend-main','templates' ])
	  .config([ "$urlRouterProvider", function ( $urlRouterProvider) {
            $urlRouterProvider.otherwise("main");
	  }]);
	  
})();