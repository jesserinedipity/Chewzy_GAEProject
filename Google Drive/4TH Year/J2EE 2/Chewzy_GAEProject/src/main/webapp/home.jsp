<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Misa
  Date: 9/14/2016
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <spring:url value="/chewzy-bootstrap/Chewzy.css" var="chewzyCss" />
    <link rel="stylesheet" type="text/css" href="${chewzyCss}">
    <spring:url value="/chewzy-bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet" />
    <spring:url value="/chewzy-bootstrap/css/prettify.css" var="prettifyCss"/>
    <link href="${prettifyCss}" rel="stylesheet" />
    <spring:url value="/chewzy-bootstrap/css/chewzy.css" var="chewzycss"/>
    <link rel="stylesheet" type="text/css" href="${chewzycss}">

    <!-- Circular -->
    <spring:url value="/chewzy-bootstrap/css/demo.css" var="demo"/>
    <link rel="stylesheet" type="text/css" href="${demo}" />
    <spring:url value="/chewzy-bootstrap/css/common.css" var="common"/>
    <link rel="stylesheet" type="text/css" href="${common}" />
    <spring:url value="/chewzy-bootstrap/css/style2.css" var="style2"/>
    <link rel="stylesheet" type="text/css" href="${style2}" />
    <spring:url value="/chewzy-bootstrap/js/modernizr.custom.79639.js" var="commonJs"/>
    <script type="text/javascript" src="${commonJs}"></script>
    <!-- end of circular -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <spring:url value="/chewzy-bootstrap/js/html5shiv.js" var="html5shiv" />
    <script src="${html5siv}" rel="stylesheet"></script>
    <spring:url value="/chewzy-bootstrap/js/respond.min.js" var="respondJs" />
    <script src="${respondJs}" rel="stylesheet"></script>
    <![endif]-->
    <style>
        body {
            padding-top: 40px;
        }
    </style>
    <spring:url value="/chewzy-bootstrap/css/bootstrap-modal-bs3patch.css" var="modalbs3pathCss"/>
    <link href="${modalbs3pathCss}" rel="stylesheet" />
    <spring:url value="/chewzy-bootstrap/css/bootstrap-modal.css" var="modalCss"/>
    <link href="${modalCss}" rel="stylesheet" />
    <style>
        .text-center {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="page-container">
    <div class="container" style="position: relative">

        <%--THIS PART IS TO CHANGE WITH DROP DOWN MENU FOR THE USER'S FUNCTIONALITY--%>
            <!-- Start of navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.jsp">Logo</a>
    </div>
    <div class="navbar-collapse navbar-right collapse">

        <div class="dropdown">
            <%--<button class="dropbtn">${username}</button>--%>
            <div class="media-left">
                <div class="media-left">
                    <img class="media-object" src="${userpp}" alt="avatar" height="50" width="50" style="border-radius: 25px; margin-left: 10px;">
                </div>
                &nbsp;
                <button class="dropbtn" style="padding-left:20px" >${user.username}</button>
                <div class="dropdown-content">
                    <a href="<c:url value="/user/home"/>">Home</a>
                    <a href="<c:url value="/user/profile"/>">Profile</a>
                    <a href="#">Foodtrip</a>
                    <a href="#">Settings</a>
                    <a href="<c:url value="/user/logout"/>">Log-out</a>
                </div>
            </div>
        </div>
        </div>
    </nav>
        </div>
</div>
    <!-- End Navigation -->


    <div class="jumbotron">
        <div class="container">
            <h1>Chewzy</h1>
            <p>Discover popular dishes and restaurants around you!</p>
            <form class="navbar-form navbar-left" role="search" action="/business/search" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" id="focusedInput" name="searchedKey" placeholder="Search restaurant or dish" maxlength="30" size="50">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
    <!-- End Intro Text -->
</div>



<div id="responsive" class="modal fade" tabindex="-1" data-width="760" style="display: none;">
    <form action="/user/login" method="POST">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">Login your account</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-6">
                    <h4>Username</h4>
                    <p><input class="form-control" type="text" name="username"/></p>

                </div>
                <div class="col-md-6">
                    <h4>Password</h4>
                    <p><input class="form-control" type="password" name="password"/></p>

                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="close" data-dismiss="modal" class="btn btn-default">Close</button>
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
    </form>
</div>

<div id="mostPopularDish" class="withMainMargin">
    <h2>Recommended Dishes</h2>
    <p>Try these recommended dishes that suits your taste.</p>

    <div class="row">
        <center>
            <section>
                <ul class="ch-grid">
                    <a href="restaurant.html" class="anchor">
                        <li>
                            <div id="gridMargin" class="ch-item ch-img-2">
                                <div class="ch-info">
                                    <h4 class="dishHolder">DISH</h4>
                                </div>
                            </div>
                            <h3 class="dishName">DISH</h3>
                        </li>
                    </a>
                    <a href="restaurant.html" class="anchor">
                        <li>

                            <div id="gridMargin" class="ch-item ch-img-2">
                                <div class="ch-info">
                                    <h4 class="dishHolder">DISH</h4>

                                </div>
                            </div>
                            <h3 class="dishName">DISH</h3>

                        </li>
                    </a>
                    <a href="restaurant.html" class="anchor">
                        <li>

                            <div class="ch-item ch-img-2">
                                <div class="ch-info">
                                    <h4 class="dishHolder">DISH</h4>
                                </div>
                            </div>
                            <h3 class="dishName">DISH</h3>

                        </li>
                    </a>
                    <a href="restaurant.html" class="anchor">
                        <li>

                            <div class="ch-item ch-img-2" >
                                <div class="ch-info">
                                    <h4 class="dishHolder">DISH</h4>

                                </div>
                            </div>

                        </li>
                    </a>
                </ul>
            </section>

        </center>
    </div>


</div>

<div id="mostPopularRestaurant" class="withMainMargin">
    <h2>Recommended Restaurants</h2>
    <p>Visit these recommended restaurants based on your restaurant of interest.</p>
    <div class="row">
        <center>
            <section>
                <ul class="ch-grid">
                    <a href="restaurant.html" class="anchor">
                        <li>
                            <div class="ch-item ch-img-2">
                                <div class="ch-info">
                                    <h4>RESTAURANT</h4>

                                </div>
                            </div>
                            <h3 class="restaurantName">Restaurants</h3>
                        </li>
                    </a>
                    <a href="restaurant.html" class="anchor">
                        <li>
                            <div class="ch-item ch-img-2">
                                <div class="ch-info">
                                    <h4>RESTAURANT</h4>

                                </div>
                            </div>
                            <h3 class="restaurantName">Restaurants</h3>
                        </li>
                    </a>
                    <a href="restaurant.html" class="anchor">
                        <li>
                            <div class="ch-item ch-img-2">
                                <div class="ch-info">
                                    <h4>RESTAURANT</h4>

                                </div>
                            </div>
                            <h3 class="restaurantName">Restaurants</h3>
                        </li>
                    </a>
                    <a href="restaurant.html" class="anchor">
                        <li>
                            <div class="ch-item ch-img-2">
                                <div class="ch-info">
                                    <h4>RESTAURANT</h4>

                                </div>
                            </div>
                            <h3 class="restaurantName">Restaurants</h3>
                        </li>
                    </a>
                </ul>
            </section>

        </center>
    </div>
</div>
</div>

<div id="nearBy" class="withMainMargin">
    <h2>Restaurant Near You</h2>
    <p>Visit these restaurants near you.</p>
    <div class="row">
        <center>
            <div class="col-md-6">
                <div id="nearByOne" class="nearByBox">
                    <div id="nearbyOneImage" class="nearByImage"> </div>
                    <div class="description"></div>
                </div>
            </div>

            <div class="col-md-6">
                <div id="nearByTwo" class="nearByBox">
                    <div id="nearbyTwoImage" class="nearByImage"> </div>
                    <div class="description"></div>
                </div>

            </div>
        </center>
    </div>
    <div class="row">
        <center>
            <div class="col-md-6">
                <div id="nearByThree" class="nearByBox">
                    <div id="nearbyThreeImage" class="nearByImage"> </div>
                    <div class="description"></div>
                </div>
            </div>

            <div class="col-md-6">
                <div id="nearByFour" class="nearByBox">
                    <div id="nearbyFourImage" class="nearByImage"> </div>
                    <div class="description"></div>
                </div>

            </div>
        </center>
    </div>
</div>





<script src="chewzy-bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="chewzy-bootstrap/js/prettify.js"></script>
<script src="chewzy-bootstrap/js/bootstrap.js"></script>
<script src="chewzy-bootstrap/js/bootstrap-modalmanager.js"></script>
<script src="chewzy-bootstrap/js/bootstrap-modal.js"></script>

</body>
</html>
