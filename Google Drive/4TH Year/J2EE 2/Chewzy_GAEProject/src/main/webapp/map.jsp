<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Misa
  Date: 10/5/2016
  Time: 3:58 AM
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
    <spring:url value="http://fonts.googleapis.com/css?family=Lato:300,400" var="fontscss"/>
    <link href='${fontscss}' rel='stylesheet' type='text/css'>
    <spring:url value="http://fonts.googleapis.com/css?family=Abel" var="fontsAbel"/>
    <link href='${fontsAbel}' rel='stylesheet' type='text/css'>
    <spring:url value="/chewzy-bootstrap/css/bootstrap.min.css"  var="bsmincss"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${bsmincss}" />
    <spring:url value="/chewzy-bootstrap/css/prettify-1.0.css" var="prettifycss"/>
    <link href="${prettifycss}" rel="stylesheet">
    <spring:url value="/chewzy-bootstrap/css/base.css" var="basecss"/>
    <link href="${basecss}" rel="stylesheet">
    <spring:url value="/chewzy-bootstrap/css/bootstrap-datetimepicker.css" var="dtpicker"/>
    <link href="${dtpicker}" rel="stylesheet">

    <!-- My Custom CSS -->
    <spring:url value="/chewzy-bootstrap/css/style.css" var="styleCss"/>
    <link href="${styleCss}" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <spring:url value="/chewzy-bootstrap/js/html5shiv.js" var="html5shivJs"/>
    <script src="${html5shivJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/respond.min.js" var="respondJs"/>
    <script src="${respondJs}"></script>
    <![endif]-->


    <spring:url value="/chewzy-bootstrap/js/jquery-2.1.1.min.js" var="jqueryjs"/>
    <script type="text/javascript" src="${jqueryjs}"></script>
    <spring:url value="/chewzy-bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>
    <script type="text/javascript" src="${bootstrapJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/moment-with-locales.js" var="momentJs"/>
    <script src="${momentJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/bootstrap-datetimepicker.js" var="bsdtpickerJs"/>
    <script src="${bsdtpickerJs}"></script>

    <spring:url value="/chewzy-bootstrap/js/prettify-1.0.min.js" var="prettifyJs"/>
    <spring:url value="/chewzy-bootstrap/js/base.js" var="baseJs"/>

    <spring:url value="/chewzy-bootstrap/images/star-on.png" var="star"/>
    <spring:url value="/chewzy-bootstrap/images/star-half.png" var="halfstar"/>
    <spring:url value="/chewzy-bootstrap/images/serine.jpg" var="userpp"/>
    <spring:url value="/chewzy-bootstrap/images/kuya-j.png" var="resimage"/>
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
<!-- end of navbar -->

<div class="intro-block">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="input-group">
                    <input type="text" class="form-control input-lg" placeholder="Search restaurant or dish">
            <span class="input-group-btn">
              <button class="btn btn-danger btn-lg" type="button"><span class="glyphicon glyphicon-cutlery"></span></button>
            </span>
                </div><!-- /input-group -->
            </div>
            <%--<div class="col-md-4">--%>
                <%--<div class="media">--%>
                    <%--<div class="media-left">--%>
                        <%--<img class="media-object" src="${userpp}" alt="avatar" height="50" width="50" style="border-radius: 25px; margin-left: 10px;">--%>
                    <%--</div>--%>
                    <%--<div class="media-body" style="padding-top: 10px;">--%>
                        <%--<h5>${user.firstname} ${user.lastname}</h5>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
    </div>
</div>
<!-- end of sub-header -->

<div class="container-fluid">
    <div class="placeholder">
        <div class="row">
            <div class="col-md-3">
                <div class="kuya">
                    <img class="img-rounded" src="${resimage}" alt="avatar" height:"300px" width="300">
                </div>
            </div>
            <div class="col-md-9">
                <div class="textme">
                    <h1>Kuya J Restaurant &nbsp; 4/5 &nbsp; <img alt="1" src="${star}" title="5">
                        <img alt="1" src="${star}" title="5">
                        <img alt="1" src="${star}" title="5">
                        <img alt="1" src="${star}" title="5">
                        <img alt="1" src="${halfstar}" title="4.5"></h1>
                    <h6>Escario Street, Kamputhaw, Cebu</h6>
                    <button class="btn btn-danger" type="button"> <span class="glyphicon glyphicon-pencil"></span> Write a Review</button>
                    <button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-star"></span> Rate</button>
                </div>


            </div>
        </div>
    </div>
</div>
<!-- End of Kuya J -->

<div class="container padded">
    <div class="row">
        <div class="col-sm-3 sidebar">

            <section>
                <div class="list-group tpad">
                    <a href="map.html" class="list-group-item list-group-item-danger active"><span class="glyphicon glyphicon-map-marker"></span> Map</a>
                    <a href="index.html" class="list-group-item "><span class="glyphicon glyphicon-list-alt"></span> Menu</a>
                    <a href="reviews.html" class="list-group-item"><span class="glyphicon glyphicon-star"></span> Reviews</a>
                </div>
            </section>
        </div>


        <div class="col-sm-9">
            <section>
                <h1><a href="#" class="menu">Map</a></h1>
                <div class="panel panel-danger">
                    <div class="panel-heading">Directions</div>
                    <div class="panel-body">
                        <div class="row ">
                            <div class="col-sm-9 pbody">
                                <div class="map">
                                    <iframe width="100%" height="100%" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3925.283445051634!2d123.89926631422145!3d10.319185992632764!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x33a999393c9e62cd%3A0x841d5ad5aa0c101b!2sKuya+J&#39;s+Restaurant!5e0!3m2!1sen!2sca!4v1475608725477"></iframe><br />


                                </div>

                                <small><a href="https://maps.google.ca/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=200+Trafalgar+Rd,+Oakville,+ON&amp;aq=0&amp;oq=200+trafalgar&amp;sll=43.447946,-79.624382&amp;sspn=0.321037,0.617294&amp;ie=UTF8&amp;hq=&amp;hnear=200+Trafalgar+Rd,+Oakville,+Ontario+L6J+3G7&amp;t=m&amp;z=14&amp;ll=43.449604,-79.670214" style="color:#0000FF;text-align:left">View Larger Map</a></small>
                            </div>


                        </div>
                    </div>
                </div>



            </section>
        </div>

    </div>
</div>
<!-- End Page Content -->


<!-- JAVASCRIPT -->
<script src="${prettifyJs}"></script>
<script src="${baseJs}"></script>


</body>
</html>



