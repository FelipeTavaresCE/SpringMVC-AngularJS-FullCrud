/*********************************************************____USER CONTROLLER____****************************************************************/
app.controller('createUserCtrl', function ($scope, $http, $location) {
    $scope.user = {};
    //Create a new user.
    $scope.saveUser = function () {
        $http({
            method: 'POST',
            url: 'signup',
            data: $scope.user,
            headers: {
                'Content-Type': 'application/json'
            }
        }).success(function (data) {
            $location.path('/signin');
        });
    };
});


//Login controller
app.controller('loginCtrl', function ($scope, $http, $location, $localStorage, ngDialog) {
    $scope.user = {};
    //Login a user and keep their data in the $localStorage.userLogged = data which will later be used to log out among other things. 
    //Verifies if the inputs are filled in.
    $scope.loginUser = function () {
        if ($scope.user.email == '' || $scope.user.email == null || $scope.user.password == '' || $scope.user.password == null) {
            ngDialog.open({
                scope: $scope,
                template: 'webapp/resources/static/img/modal.html',
                className: 'ngdialog-theme-default',
                width: 650,
                lain: true
            });
        } else {
            $http({
                method: 'POST',
                url: 'signin',
                data: $scope.user,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).success(function (data) {
                $localStorage.userLogged = data;
                if (data.iduser == '' || data.iduser == null) {
                    ngDialog.open({
                        scope: $scope,
                        template: 'webapp/resources/static/img/userNotFound.html',
                        className: 'ngdialog-theme-default',
                        width: 650,
                        lain: true
                    });
                } else {
                    $location.path('/home');
                }
            });

        }
        ;
    };
});
