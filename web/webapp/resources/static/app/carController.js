app.controller('carCtrl', function ($scope, $http, $location, $localStorage, ngDialog) {
    //Creating variables.
    $scope.car = {brand: {},
        model: {}
    };

    $scope.brands = [];
    $scope.models = [{
            brand: {}
        }];

    $scope.modelsToPost = [{
            brand: {}
        }];

    $scope.listCars = [];
    $scope.showModels = true;


    //Make selection of models depending on which brand was chosen.
    $scope.change = function () {
        $scope.modelsToPost = [];
        angular.forEach($scope.models, function (item) {
            console.log(item);
            if ($scope.car.brand.idBrand == item.brand.idBrand) {
                $scope.modelsToPost.push(item);
            }
        });
        $scope.showModels = false;
    };

    //Get brands to post.
    $http({
        method: 'GET',
        url: 'car',
        data: $scope.brands,
        headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
        $scope.brands = data;
    });

    //Get models to post
    $http({
        method: 'GET',
        url: 'models',
        data: $scope.models,
        headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
        $scope.models = data;
    });

    //Create a new car.
    $scope.createCar = function () {

        $http({
            method: 'POST',
            url: 'car',
            data: $scope.car,
            headers: {'Content-Type': 'application/json'}
        }).success(function (data) {
            $location.path('/listcars');
        });
    };

    //Show cars created.
    $scope.show = "true";
    $scope.hide = "true";

    $http({
        method: 'GET',
        url: 'listcars',
        data: $scope.listCars,
        headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
        $scope.listCars = data;
    });

    //Ediit car
    $scope.editCar = function (idCar) {
        $scope.show = "false";
        $scope.hide = "false";
        $scope.hideObj = "true";
        $scope.showObj = "true";

        $scope.idCar = idCar;
    };

    //Back to normal.
    $scope.undoEdit = function () {
        $scope.show = "true";
        $scope.hide = "true";
        $scope.hideObj = "false";
        $scope.showObj = "false";

        $scope.idCar = 0;
    };

    //Save changes made in the selected field.
    $scope.saveCar = function (car) {
        $http({
            method: 'PUT',
            url: 'updateCar',
            data: car,
            headers: {'Content-Type': 'application/json'}
        }).success(function (data) {
            ngDialog.open({
                scope: $scope,
                template: 'webapp/resources/static/img/modalSuccess.html',
                className: 'ngdialog-theme-default',
                width: 650,
                lain: true
            });
            $scope.show = "true";
            $scope.hide = "true";
            $scope.hideObj = "false";
            $scope.showObj = "false";

            $scope.idCar = 0;
            $location.path('/listcars');
        });
    };

    //Delete car.
    $scope.deleteCar = function (car) {
        ngDialog.openConfirm({
            template: 'webapp/resources/static/img/sure.html',
            className: 'ngdialog-theme-default'
        }).then(function () {
            $http({
                method: 'DELETE',
                url: 'deleteCar',
                data: car,
                headers: {'Content-Type': 'application/json'}
            }).success(function (car) {
                //Update list. Again again it's not really what I wanted to do.
                $http({
                    method: 'GET',
                    url: 'listcars',
                    data: $scope.listCars,
                    headers: {'Content-Type': 'application/json'}
                }).success(function (data) {
                    $scope.listCars = data;
                });

            });
        }, function (reason) {

        });
    };
});