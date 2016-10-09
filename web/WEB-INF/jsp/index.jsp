<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="app">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link href="webapp/resources/static/css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="webapp/resources/static/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="webapp/resources/static/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="webapp/resources/static/css/ngDialog.css" rel="stylesheet" type="text/css"/>
        <link href="webapp/resources/static/css/ngDialog-theme-default.css" rel="stylesheet" type="text/css"/>
        <link href="webapp/resources/static/css/preloader.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
    <header>
        <nav>
            <div class="nav-wrapper">
                <a href="#!" class="brand-logo">Example</a>
                <ul class="right hide-on-med-and-down">
                    <li><a class="waves-effect waves-button-input btn" id="btnNav" href="#/signin">Sign in</a></li>
                    <li><a class="waves-effect waves-button-input btn" id="btnNav2" href="#/signup">Sign up</a></li>
                </ul>
            </div>
        </nav>
    </header>
    <main class="center">
        <div ng-view></div>
    </main>


    <footer class="page-footer" id="footerPage">
        <div class="footer-copyright" id="footerCopy">
            <div class="container">
                © 2016 Felipe Bento
                <a class="grey-text text-lighten-4 right" href="#!">How you doin'?</a>
            </div>
        </div>
    </footer>


    <script src="webapp/resources/static/lib/angular.js" type="text/javascript"></script>
    <script src="webapp/resources/static/lib/angular-route.js" type="text/javascript"></script>
    <script src="webapp/resources/static/lib/angular-resource.js" type="text/javascript"></script>
    <script src="webapp/resources/static/js/ngDialog.js" type="text/javascript"></script>
    
    <script src="webapp/resources/static/lib/ngStorage.js" type="text/javascript"></script>
   <script src="webapp/resources/static/app/app.js" type="text/javascript"></script>
  

    <script src="webapp/resources/static/lib/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="webapp/resources/static/js/materialize.js" type="text/javascript"></script>
    

    <script src="webapp/resources/static/app/userController.js" type="text/javascript"></script>
    <script src="webapp/resources/static/app/homeController.js" type="text/javascript"></script>
    <script src="webapp/resources/static/app/brandController.js" type="text/javascript"></script>
    <script src="webapp/resources/static/app/modelController.js" type="text/javascript"></script>
    <script src="webapp/resources/static/app/carController.js" type="text/javascript"></script>

  </body>
</html>
