var app = angular.module('app', ['ngRoute', 'ngResource', 'ngStorage', 'ngDialog']);
app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
            .when('/', {
                templateUrl: 'webapp/resources/static/views/info.html',
                controller: 'homeCtrl'
            })
            .when('/signin', {
                templateUrl: 'webapp/resources/static/views/signin.html',
                controller: 'loginCtrl'
            })
            .when('/signup', {
                templateUrl: 'webapp/resources/static/views/signup.html',
                controller: 'createUserCtrl'
            })

            .when('/home', {
                templateUrl: 'webapp/resources/static/views/home.html',
                controller: 'homeCtrl'
            })

            .when('/brand', {
                templateUrl: 'webapp/resources/static/views/brand.html',
                controller: 'brandCtrl'
            })

            .when('/listbrands', {
                templateUrl: 'webapp/resources/static/views/listbrands.html',
                controller: 'brandCtrl'
            })
            .when('/model', {
                templateUrl: 'webapp/resources/static/views/model.html',
                controller: 'modelCtrl'
            })

            .when('/listmodels', {
                templateUrl: 'webapp/resources/static/views/listmodels.html',
                controller: 'modelCtrl'
            })
            .when('/car', {
                templateUrl: 'webapp/resources/static/views/car.html',
                controller: 'carCtrl'
            })

            .when('/listcars', {
                templateUrl: 'webapp/resources/static/views/listcars.html',
                controller: 'carCtrl'
            })
            .otherwise(
                    {redirectTo: '/'}
            );
});


