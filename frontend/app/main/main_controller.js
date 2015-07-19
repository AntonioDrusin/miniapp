(function(){
  'use strict';

  angular.module('frontend',['templates','ui.router'])
    .config(["$stateProvider", function ($stateProvider) {
      $stateProvider
          .state('main', {
            url: "/",
            templateUrl: "main/main.html",
            controller: ["$scope", function ($scope) {
              $scope.awesomeThings = [
                'HTML5 Boilerplate',
                'AngularJS',
                'Karma'
              ];
            }]
      });
    }]);
})();