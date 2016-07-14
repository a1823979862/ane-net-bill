(function() {
    'use strict';

    angular
        .module('app.smartadmin')
        .controller('SmartadminController', SmartadminController);


    SmartadminController.$inject = ['$scope'];

    function SmartadminController($scope) {
        var vm = this;

        init();

        function init() {
            initSidebar();
        }

        function initSidebar() {
            $('nav ul').jarvismenu({
                accordion: menu_accordion || true,
                speed: menu_speed || true,
                closedSign: '<em class="fa fa-plus-square-o"></em>',
                openedSign: '<em class="fa fa-minus-square-o"></em>'
            });
        }
    }

})();
