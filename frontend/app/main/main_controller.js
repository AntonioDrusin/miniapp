(function(){
  'use strict';

  angular.module('frontend.controllers',['templates','ui.router','frontend.services'])
      .factory('aa',function(){return {};})
    .config(["$stateProvider",  function ($stateProvider) {
      $stateProvider
          .state('main', {
            url: '/',
            templateUrl: 'main/main.html',
            resolve: {
              // Fix errors in resolvers by looking at promise resolution https://github.com/angular-ui/ui-router/issues/469
              invoice: ['restInvoices', function(restInvoices){
                return restInvoices.one('invoices',32).get();
              }]
            },
            controller: ['$scope', 'invoice', function ($scope, invoice) {
              $scope.invoice = invoice;
              $scope.awesomeThings = [
                'HTML5 Boilerplate',
                'AngularJS',
                'Karma'
              ];
            }]
      });
    }]);
})();