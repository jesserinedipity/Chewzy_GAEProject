<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Misa
  Date: 9/15/2016
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>Chewzy</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="stylesheet" type="text/css" href="Chewzy.css"> -->

    <spring:url value="/chewzy-bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
    <link rel="stylesheet" type="text/css" media="screen" href="${bootstrapCss}"/>
    <spring:url value="/chewzy-bootstrap/css/chewzy.css" var="chewzycss"/>
    <link rel="stylesheet" type="text/css" href="${chewzycss}"/>

    <spring:url value="/chewzy-bootstrap/css/font-awesome.min.css" var="fontawesome"/>
    <link rel="stylesheet" href="${fontawesome}"/>
    <spring:url value="/chewzy-bootstrap/css/prettify-1.0.css" var="prettifyCss"/>
    <link href="${prettifyCss}" rel="stylesheet"/>
    <spring:url value="/chewzy-bootstrap/css/base.css" var="baseCss"/>
    <link href="${baseCss}" rel="stylesheet"/>
    <spring:url value="/chewzy-bootstrap/css/bootstrap-datetimepicker.css" var="datetimepickerCss"/>
    <link href="${datetimepickerCss}" rel="stylesheet"/>

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

    <spring:url value="/chewzy-bootstrap/js/jquery-2.1.1.min.js" var="jqueryJs"/>
    <script type="text/javascript" src="${jqueryJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>
    <script type="text/javascript" src="${bootstrapJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/moment-with-locales.js" var="momentlocalsJs"/>
    <script src="${momentlocalsJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/bootstrap-datetimepicker.js" var="datetimepickerJs"/>
    <script src="${datetimepickerJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/prettify-1.0.min.js" var="prettifyJs"/>
    <script src="${prettifyJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/base.js" var="baseJs"/>
    <script src="${baseJs}"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <spring:url value="/chewzy-bootstrap/js/html5shiv.js" var="html5shivJs" />
    <script src="${html5shivJs}"></script>
    <spring:url value="/chewzy-bootstrap/js/respond.min.js" var="respondJs" />
    <script src="${respondJs}"></script>
    <![endif]-->

    <!-- MAP -->
    <%--<spring:url value="http://maps.google.com/maps/api/js?sensor=false&libraries=places" var="gmap"/>--%>
    <script type="text/javascript" src='http://maps.google.com/maps/api/js?sensor=false&libraries=places&key=AIzaSyBJhWCKYfH3lfmy35XtSD-4BfPXk6-0Wys'></script>
    <spring:url value="/chewzy-bootstrap/dist/locationpicker.jquery.min.js" var="locationpickerJs"/>
    <script src="${locationpickerJs}"></script>
    <!-- END OF MAP -->

    <style>
        .pac-container {
            z-index: 99999;
        }
    </style>

    <style>
        body {
            padding-top: 40px;
        }
    </style>
    <spring:url value="/chewzy-bootstrap/css/bootstrap-modal-bs3patch.css" var="bs3patchCss"/>
    <link href="${bs3patchCss}" rel="stylesheet" />
    <spring:url value="/chewzy-bootstrap/css/bootstrap-modal.css" var="bootstrapModalCss"/>
    <link href="${bootstrapModalCss}" rel="stylesheet" />
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
</head>
<body>
<div class="page-container">
    <div class="container" style="position: relative">
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
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Home</a></li>
                    <li><a data-toggle="modal" href="#responsive">Log In</a></li>
                    <li><a href="signUp.jsp">Sign Up </a></li>

                </ul>
            </div>
        </nav>
    </div>
    <!-- End Navigation -->

    <div class="jumbotron">
        <div class="container">
            <h1>Chewzy</h1>
            <p>Discover popular dishes and restaurants around you!</p>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" id="focusedInput" placeholder="Search restaurant or dish" maxlength="30" size="50">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
    <!-- End Intro Text -->
</div>



<!-- START OF FORM -->

<form class="form-horizontal" id="signUp" class="col-lg-8" action="/user/signup" method="POST">
    <fieldset>
        <legend>Sign Up</legend>
        <div class="form-group">
            <label for="lastName" class="col-lg-3 control-label">Last Name</label>
            <div class="col-lg-7">
                <input type="text" class="form-control" name="lastname" id="lastName" placeholder="Your last name">
            </div>
        </div>

        <div class="form-group">
            <label for="givenName" class="col-lg-3 control-label">Given Name</label>
            <div class="col-lg-7">
                <input type="text" class="form-control" name="firstname" id="givenName" placeholder="Your given name">
            </div>
        </div>

        <div class="form-group">
            <label for="userName" class="col-lg-3 control-label">User Name</label>
            <div class="col-lg-7">
                <input type="text" class="form-control" name="username" id="userName" placeholder="Your user name">
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="col-lg-3 control-label">Email Address</label>
            <div class="col-lg-7">
                <input type="email" name="email" class="form-control" id="email" placeholder="Your email address">
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-lg-3 control-label">Password</label>
            <div class="col-lg-7">
                <input type="password" name="password" class="form-control" id="password" placeholder="Your password">
            </div>
        </div>

        <div class="form-group">
            <label for="confirmPassword" class="col-lg-3 control-label">Confirm Password</label>
            <div class="col-lg-7">
                <input type="password" name="confirmpass" class="form-control" id="confirmPassword" placeholder="Re-enter Password">
            </div>
        </div>

        <div class="form-group">
            <label for="contactNumber" class="col-lg-3 control-label">Contact Number</label>
            <div class="col-lg-7">
                <input type="text" name="contact_number" class="form-control" id="contactNumber" placeholder="Contact Number">
            </div>
        </div>

        <div class="form-group">
            <label for="birthdate" class="col-lg-3 control-label">Birth Date</label>
            <div class="col-lg-3">
                <div class='input-group date' id='datetimepicker10'>
                    <input type="text" name="birthdate" class="form-control" id="birthdate">
                    <span class="input-group-addon">
                            <span class="glyphicon glyphicon-th"></span>
                    </span>
                </div>
            </div>
            <div class="col-lg-1">
                <label for="gender" class="col-lg-4 control-label">Gender</label>
            </div>
            <div class="col-lg-3">
                <select class="form-control" id="select" name="gender">
                    <option value="male">male</option>
                    <option value="female">female</option>
                </select>
            </div>

            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker10').datetimepicker({
                        viewMode: 'years',
                        format: 'MM/DD/YYYY'
                    });
                });
            </script>
        </div>

        <div class="form-group">
            <label for="address" class="col-lg-3 control-label">Address</label>
            <div class="col-lg-5">
                <input type="text" name="address" class="form-control" id="address" disabled="" />
            </div>
            <div class="col-lg-4">
                <button class="btn btn-primary" data-target="#us6-dialog" data-toggle="modal">Locate Address Here</button>
            </div>
            <div id="us6-dialog" class="modal fade"  tabindex="-1" data-width="600">
                <div class="modal-dialog">
                    <form id="addressModal" method="post">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Address</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-horizontal" style="width: 550px">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Location:</label>
                                <script>
                                    $(document).ready(function() {
                                        $('#location').change(function() {
                                            $('#address').val($('#location').val());
                                        });
                                    });
                                </script>
                                <div class="col-sm-10">
                                    <input type="text" name="location" class="form-control" id="us3-address" />
                                </div>
                            </div>

                            <input type="hidden" name="latitude" id="us3-lat">
                            <input type="hidden" name="longitude" id="us3-lon">
                            <!--  <div class="form-group">
                                 <label class="col-sm-2 control-label">Radius:</label>

                                 <div class="col-sm-5">
                                     <input type="text" class="form-control" id="us3-radius" />
                                 </div> -->

                            <%--G-maps API key: AIzaSyBJhWCKYfH3lfmy35XtSD-4BfPXk6-0Wys--%>
                            <div id="us3" style="width: 100%; height: 400px;"></div>
                            <div class="clearfix">&nbsp;</div>

                            <div class="clearfix"></div>
                            <script>
                                $('#us3').locationpicker({
                                    location: {
                                        latitude: 46.15242437752303,
                                        longitude: 2.7470703125
                                    },
                                    inputBinding: {
                                        latitudeInput: $('#us3-lat'),
                                        longitudeInput: $('#us3-lon'),
                                        radiusInput: $('#us3-radius'),
                                        locationNameInput: $('#us3-address')
                                    },
                                    enableAutocomplete: true,
                                    markerIcon: 'images\\location.png'
                                });
                                $('#us6-dialog').on('shown.bs.modal', function () {
                                    $('#us3').locationpicker('autosize');
                                });
                            </script>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="close" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save Address</button>
                    </div>
                    </form>
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
        </div>
        <div class="col-lg-10">
            <button type="submit" class="btn btn-primary" style="float:right">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="cancel" class="btn btn-default" style="float:right">Cancel</button>
        </div>
    </fieldset>
</form>
<!-- END OF FORM -->



<!-- <script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/prettify.js"></script>
<script src="js/bootstrap.js"></script> -->
<spring:url value="/chewzy-bootstrap/js/bootstrap-modalmanager.js" var="modalManagerJs"/>
<script src="${modalManagerJs}"></script>
<spring:url value="/chewzy-bootstrap/js/bootstrap-modal.js" var="bootstrapModalJs"/>
<script src="${bootstrapModalJs}"></script>

</body>
</html>
