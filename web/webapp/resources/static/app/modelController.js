app.controller('modelCtrl', function ($scope, $http, $location, $localStorage, ngDialog) {
    $scope.model = {brand: {}};
    $scope.listBrand = [];
    $scope.listModel = [{
            brand: {}
        }];

    $scope.show = "true";
    $scope.hide = "true";

    //Get list of brands to post
    $http({
        method: 'GET',
        url: 'model',
        data: $scope.listBrand,
        headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
        $scope.listBrand = data;

    });

    //Show lists of models
    $http({
        method: 'GET',
        url: 'listmodels',
        data: $scope.listModel,
        headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
        $scope.listModel = data;

    });

    //Post model.
    $scope.createModel = function () {
        if ($scope.model.nameModel == '' || $scope.model.nameModel == null || $scope.model.brand.idBrand == '' || $scope.model.brand.idBrand == null) {
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
                url: 'model',
                data: $scope.model,
                headers: {'Content-Type': 'application/json'}
            }).success(function (data) {
                $location.path('/listmodels');
            });
        }
    };

    //Open options to edit.
    $scope.editModel = function (idModel) {
        $scope.show = "false";
        $scope.hide = "false";
        $scope.hideObj = "true";
        $scope.showObj = "true";

        $scope.idModel = idModel;
    };

    //Back to normal.
    $scope.undoEdit = function () {
        $scope.show = "true";
        $scope.hide = "true";
        $scope.hideObj = "false";
        $scope.showObj = "false";

        $scope.idModel = 0;
    };

    //Save changes made in the selected field.
    $scope.saveModel = function (model) {
        $http({
            method: 'PUT',
            url: 'updateModel',
            data: model,
            headers: {'Content-Type': 'application/json'}
        }).success(function (model) {
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

            $scope.idModel = 0;
        });
    };

    $scope.deleteModel = function (model) {
        ngDialog.openConfirm({
            template: 'webapp/resources/static/img/sure.html',
            className: 'ngdialog-theme-default'
        }).then(function () {
            $http({
                method: 'DELETE',
                url: 'deleteModel',
                data: model,
                headers: {'Content-Type': 'application/json'}
            }).success(function (model) {
                //Update list. Again iIt's not really what I wanted to do.
                $http({
                    method: 'GET',
                    url: 'listmodels',
                    data: $scope.model,
                    headers: {'Content-Type': 'application/json'}
                }).success(function (data) {
                    
                    $scope.listModel = data;
                });

            });
        }, function (reason) {

        });

    };

});