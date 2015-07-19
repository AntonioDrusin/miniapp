(function() {
    'option strict';

    angular.module('frontend.services').factory('restInvoices',
        ["Restangular", function(restangular){
            return restangular.withConfig(
                    function(RestangularConfigurer){
                        RestangularConfigurer.setBaseUrl("http://localhost:8080/");
                    });
        }]);
})();