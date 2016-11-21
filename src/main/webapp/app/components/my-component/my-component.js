(function() {


    angular.module('app').component('myComponent', {
        bindings: {
            value: '<'
        },
        templateUrl: 'app/components/my-component/my-component.html',
        controller: myComponentCtrl
    })


    function myComponentCtrl($http) {
        var ctrl = this;

        ctrl.$onInit = onInit;
        ctrl.helloWorld = helloWorld;

        function onInit() {
            ctrl.bla = 'bla';
        }

        function helloWorld() {
            console.log(ctrl.bla);
        }
    }

    myComponentCtrl.$inject = ['$http'];

})();