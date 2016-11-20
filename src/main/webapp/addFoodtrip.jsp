<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Misa
  Date: 10/10/2016
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chewzy</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <spring:url value="http://fonts.googleapis.com/css?family=Lato:300,400" var="fontLato"/>
    <link href='${fontLato}' rel='stylesheet' type='text/css'>
    <spring:url value="http://fonts.googleapis.com/css?family=Abel" var="fontAbel"/>
    <link href='${fontAbel}' rel='stylesheet' type='text/css'>
    <spring:url value="chewzy-bootstrap/css/bootstrap.min.css" var="bsMincss"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${bsMincss}" />
    <spring:url value="chewzy-bootstrap/css/prettify-1.0.css" var="prettifyCss"/>
    <link href="${prettifyCss}" rel="stylesheet">
    <spring:url value="chewzy-bootstrap/css/base.css" var="baseCss"/>
    <link href="${baseCss}" rel="stylesheet">
    <spring:url value="chewzy-bootstrap/css/bootstrap-datetimepicker.css" var="bsdatetimeCss"/>
    <link href="${bsdatetimeCss}" rel="stylesheet">
    <spring:url value="chewzy-bootstrap/css/bootstrap-modal-bs3patch.css" var="modalbs3patchCss"/>
    <link href="${modalbs3patchCss}" rel="stylesheet" />
    <spring:url value="chewzy-bootstrap/css/bootstrap-modal.css" var="bsmodalCss"/>
    <link href="${bsmodalCss}" rel="stylesheet" />


    <style>
        .text-center {
            text-align: center;
        }

        .marketing h1 {
            font-size: 50px;
            font-weight: lighter;
            line-height: 1;
        }

        .marketing p {
            font-size: 18px;
        }
    </style>
    <!-- My Custom CSS -->
    <spring:url value="chewzy-bootstrap/css/style.css" var="styleCss"/>
    <link href="${styleCss}" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="chewzy-bootstrap/js/html5shiv.js"></script>
    <script src="chewzy-bootstrap/js/respond.min.js"></script>
    <![endif]-->

    <spring:url value="chewzy-bootstrap/js/jquery-2.1.1.min.js" var="jqueryJS"/>
    <script type="text/javascript" src="${jqueryJS}"></script>
    <spring:url value="chewzy-bootstrap/js/bootstrap.min.js" var="bsminJs"/>
    <script type="text/javascript" src="${bsminJs}"></script>
    <spring:url value="chewzy-bootstrap/js/moment-with-locales.js" var="localJs"/>
    <script src="${localsJs}"></script>
    <spring:url value="chewzy-bootstrap/js/bootstrap-datetimepicker.js" var="bsdatetimeJs"/>
    <script src="${bsdatetimeJs}"></script>

    <spring:url value="/chewzy-bootstrap/images/cat.jpg" var="userpp"/>
</head>

<body>
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
            <img id="profilePicture" src="${userpp}">
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

<form class="form-signin" action="calculate" method="post">
    <h2 class="form-signin-heading">ADD FOODTRIP</h2><br>
    <h4>Transaction ID: 123456</h4>
    <div class="panel panel-danger">
        <div class="panel-heading">Dishes bought</div>
        <table class="table"> <thead> <tr> <th>Meal</th> <th>Price</th>  </tr> </thead>
            <tbody>
            <tr>  <td>Sausage mcmuffin <br> </td> <td>$ 10.00</td>  </tr>
            <tr>  <td>Egg mcmuffin <br> </td> <td>$ 5.00</td>  </tr>
            <tr>  <td>Filet o fish <br> </td> <td>$ 3.00</td>  </tr>
            <thead> <tr>  <th>Total amount: <br> </th> <th>$ 18.00</th>  </tr>  </thead>
            </tbody>
        </table>
    </div>
    <h4>Date: 10/10/2016</h4>
    <h4>Foodtrip: </h4>
    <textarea class="form-control" rows="6" id="message" name="foodtripContent" placeholder="Write your foodtrip experience here..."></textarea>

    <br>
    <button class="btn btn-lg btn-danger btn-block" type="submit" >Add Foodtrip</button>
</form>






<!-- End Page Content -->


<!-- JAVASCRIPT -->

<script src="./js/prettify-1.0.min.js"></script>
<script src="./js/base.js"></script>
<script src="js/bootstrap-modalmanager.js"></script>
<script src="js/bootstrap-modal.js"></script>

</body>
</html>



