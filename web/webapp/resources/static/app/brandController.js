app.controller('brandCtrl', function ($scope, $http, $location, $localStorage, ngDialog) {
    $scope.brand = {};
    $scope.listBrand = [];
    $scope.show = "true";
    $scope.hide = "true";

    //Create a new brand.
    $scope.createBrand = function () {
        if ($scope.brand.nameBrand == '' || $scope.brand.nameBrand == null) {
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
                url: 'brand',
                data: $scope.brand,
                headers: {'Content-Type': 'application/json'}
            }).success(function (data) {
                $location.path('/listbrands');
            });

        }
        ;

    };

    //Show a list of brands already created.
    $http({
        method: 'GET',
        url: 'listbrands',
        data: $scope.brand,
        headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
        $scope.listBrand = data;
    });

    //Open options to edit.
    $scope.editBrand = function (idBrand) {
        $scope.show = "false";
        $scope.hide = "false";
        $scope.hideObj = "true";
        $scope.showObj = "true";
        $scope.idBrand = idBrand;
    };

    //Back to normal. Show the list.
    $scope.undoEdit = function () {
        $scope.show = "true";
        $scope.hide = "true";
        $scope.hideObj = "false";
        $scope.showObj = "false";

        $scope.idBrand = 0;
    };

    //Save changes made in the selected field.
    $scope.saveBrand = function (brand) {
        $http({
            method: 'PUT',
            url: 'updateBrand',
            data: brand,
            headers: {'Content-Type': 'application/json'}
        }).success(function (brand) {
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
            $scope.idBrand = 0;
            $location.path('/listbrands');
        });
    };

    //Delete a brand passing a brand object.
    $scope.deleteBrand = function (brand) {
        ngDialog.openConfirm({
            template: 'webapp/resources/static/img/sure.html',
            className: 'ngdialog-theme-default'
        }).then(function () {
            $http({
                method: 'DELETE',
                url: 'deleteBrand',
                data: brand,
                headers: {'Content-Type': 'application/json'}
            }).success(function (brand) {
                //Update list. It's not really what I wanted to do.
                $http({
                    method: 'GET',
                    url: 'listbrands',
                    data: $scope.brand,
                    headers: {'Content-Type': 'application/json'}
                }).success(function (data) {
                    $scope.listBrand = data;
                });

            });
        }, function (reason) {

        });
    };
});
