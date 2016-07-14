(function() {
    'use strict';

    angular
        .module('app.user-example')
        .controller('UserExampleListController', UserExampleListController);


    UserExampleListController.$inject = ['$scope' , 'routerHelper' , "UserExampleService"];

    function UserExampleListController($scope , routerHelper , UserExampleService) {
        var vm = this;
        vm.users = [];

        init();

        function init() {
            
            var promise = UserExampleService.getUsers();
            promise.then(function(users){
                console.log(users);
                vm.users = users;

            });

        }


        vm.addUser = function(){
            routerHelper.go("new");
        }


        vm.editUser = function(user){
            routerHelper.go("edit" , { userId : user.id});
        }

        vm.deleteUser = function( user ){
            

        }

    }
})();
