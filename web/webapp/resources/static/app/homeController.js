app.controller('homeCtrl', function ($scope, $http, $location, $localStorage, ngDialog) {
    //Will do some stuff here later.
    $scope.user = $localStorage.userLogged;
    
    $scope.preloader = false;

    //Testing ngDialog
    $scope.testDialog = function () {
        ngDialog.open({
            scope: $scope,
            template: 'webapp/resources/static/img/test.html',
            className: 'ngdialog-theme-default',
            width: 650,
            lain: true
        });
       
    };
    
    

});

