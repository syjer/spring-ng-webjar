describe('myComponent test suite', function() {

    beforeEach(module('app'));

    var scope;
    var controller;

    beforeEach(inject(function($rootScope, $componentController){
        scope = $rootScope.$new();
        controller = $componentController('myComponent', {$scope: scope}, {value: '1.5'});
    }));

    it('should expose value', function() {
        expect(controller.value).toBeDefined();
        expect(controller.value).toBe('1.5');
    });

    // .... ecc
});