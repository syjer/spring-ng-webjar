(function() {

    var app = angular.module('app', ['ngSanitize', 'ui.router']);

    app.config(['$urlRouterProvider', '$stateProvider', function($urlRouterProvider, $stateProvider) {
        var homeState = {
            url: '/',
            name: 'home',
            component: 'myComponent',
            resolve: {
                value: ['$q', function($q) { return $q(function(resolve) {resolve('blabla')});}]
            }
        };

        var secondState = {
            url: '/second',
            name: 'second',
            component: 'secondComponent'
        }

        $stateProvider.state(homeState);
        $stateProvider.state(secondState);

        $urlRouterProvider.otherwise('/');

    }]);

})();