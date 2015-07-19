(function(){
	'use strict';

	angular.module('frontend', [ 'ui.router','frontend-main','frontend.templates' ])
	  .config([ "$urlRouterProvider", function ( $urlRouterProvider) {
            $urlRouterProvider.otherwise("main");
	  }]);
	  
})();