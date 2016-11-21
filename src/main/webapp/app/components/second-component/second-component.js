(function() {


    angular.module('app').component('secondComponent', {
        bindings: {
            value: '<'
        },
        templateUrl: 'app/components/second-component/second-component.html',
        controller: secondComponentCtrl
    })


    function secondComponentCtrl() {
        var ctrl = this;

    }

    secondComponentCtrl.$inject = ['$http'];

})();