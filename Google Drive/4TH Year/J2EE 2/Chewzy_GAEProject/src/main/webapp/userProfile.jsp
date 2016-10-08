<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>Chewzy</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <spring:url value="/chewzy-bootstrap/Chewzy.css" var="chewzyCss"/>
    <link rel="stylesheet" type="text/css" href="${chewzyCss}">
    <spring:url value="/chewzy-bootstrap/css/bootstrap.min.css" var="bootstrapminCss"/>
    <link href="${bootstrapminCss}" rel="stylesheet" />
    <spring:url value="/chewzy-bootstrap/css/prettify.css" var="prettifyCss"/>
    <link href="${prettifyCss}" rel="stylesheet" />
    <spring:url value="/chewzy-bootstrap/css/chewzy.css" var="ChewzyCss"/>
    <link rel="stylesheet" type="text/css" href="${ChewzyCss}">

    <!-- Circular -->
    <spring:url value="/chewzy-bootstrap/css/demo.css" var="demoCss"/>
    <link rel="stylesheet" type="text/css" href="${demoCss}" />
    <spring:url value="/chewzy-bootstrap/css/common.css" var="commonCss"/>
    <link rel="stylesheet" type="text/css" href="${commonCss}" />
    <spring:url value="/chewzy-bootstrap/css/style2.css" var="style2Css"/>
    <link rel="stylesheet" type="text/css" href="${style2Css}" />
    <spring:url value="/chewzy-bootstrap/js/modernizr.custom.79639.js" var="modenizrJs"/>
    <script type="text/javascript" src="${modenizrJs}"></script>
    <!-- end of circular -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <!--<spring:url value="/chewzy-bootstrap/js/html5shiv.js" var="html5shivJs" />-->
    <!--<script type="text/javascript" src="${html5shivJs}"></script>-->
    <!--<spring:url value="/chewzy-bootstrap/js/respond.min.js" var="respondJs" />-->
    <!--<script type="text/javascript" src="${respondJs}"></script>-->
    <![endif]-->

    <spring:url value="/chewzy-bootstrap/css/bootstrap-modal-bs3patch.css" var="bs3patchCss"/>
    <link href="${bs3patchCss}" rel="stylesheet" />
    <spring:url value="/chewzy-bootstrap/css/bootstrap-modal.css" var="bootstrapModalCss"/>
    <link href="${bootstrapModalCss}" rel="stylesheet" />
    <spring:url value="/chewzy-bootstrap/images/cat.jpg" var="catPp"/>
    <spring:url value="/chewzy-bootstrap/images/cat.jpg" var="profilepic"/>
    <spring:url value="/chewzy-bootstrap/images/ic_place_white_24dp_1x.png" var="locationpntr"/>

    <spring:url value="/chewzy-bootstrap/images/serine.jpg" var="userpp"/>
</head>
<body>
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
                    <img class="media-object" src="${userpp}" alt="avatar" height="50" width="50" style="border-radius: 25px; margin-left: 10px;">
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
    <!-- End Navigation -->



    <div class="jumbotron">
        <div class="container col-centered">
            <div id="ppContainer">
                <img id="profilePicture" src="${profilepic}">
            </div>
            <center>
                <div id="highlight">
                    <h2 id="name">
                        ${user.firstname} ${user.lastname}
                    </h2>
                    <p id="location"><img src="${locationpntr}"> ${user.address}</p>
                </div>
            </center>
        </div>
    </div>
    <!-- End Intro Text -->
    <div class="container">
    <br>
    <center>
        <a data-toggle="modal" href="#addfoodtripModal"><button class="btn btn-danger btn-lg" type="button">Add Foodtrip</button></a>
    </center>

    <div id="addfoodtripModal" class="modal fade" tabindex="9999" data-width="760" style="display:none;">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">Add Food Trip</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="form-group">
                    <label for="foodTripReview" class="col-lg-3 control-label">Transaction ID:</label>
                    <div class="col-lg-9">
                        <input type="text" name="" class="form-control" id="foodTripTransactionID">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group">
                    <label for="foodTripReview" class="col-lg-2 control-label">Review</label>
                    <div class="col-lg-10">
                        <textarea rows="7" cols="35" class="form-control" id="foodTripReview" placeholder="Your review goes here" disabled="disabled"></textarea>
                    </div>
                </div>
            </div>

            <input class="btn btn-danger btn-lg" type="submit" name="addFoodTrip">
        </div>
    </div>

</div>
</div>

<spring:url value="chewzy-bootstrap/js/jquery.min.js" var="jqueryminJs"/>
<script src="${jqueryminJs}"></script>
<spring:url value="chewzy-bootstrap/js/prettify.js" var="prettifyJs"/>
<script type="text/javascript" src="${prettifyJs}"></script>
<spring:url value="chewzy-bootstrap/js/bootstrap.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>
<spring:url value="chewzy-bootstrap/js/bootstrap-modalmanager.js" var="bsModalmanagerJs"/>
<script src="${bsModalmanagerJs}"></script>
<spring:url value="chewzy-bootstrap/js/bootstrap-modal.js" var="bsModalJs"/>
<script src="${bsModalJs}"></script>

</body>
</html>