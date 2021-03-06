<%-- 
    Document   : votreHistorique
    Created on : 19 janv. 2019, 15:45:40
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Employe"%>
<%@page import="services.EmployeService"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon.ico" type="image/ico" />

        <title>HISTORIQUE </title>

        <!-- Bootstrap -->
        <link href="gentelella//vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="gentelella//vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="gentelella//vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="gentelella//vendors/iCheck/skins/flat/green.css" rel="stylesheet">

        <!-- bootstrap-progressbar -->
        <link href="gentelella//vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- JQVMap -->
        <link href="gentelella//vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
        <!-- bootstrap-daterangepicker -->
        <link href="gentelella//vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <script src="script/jquery-3.2.1.min.js" type="text/javascript"></script>
        <!-- Custom Theme Style -->
        <link href="gentelella//build/css/custom.min.css" rel="stylesheet">
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>

    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <!-- top navigation -->
                <div class="top_nav" style="margin-left: 0px" >
                    <div class="nav_menu" >
                        <nav >
                            

                            <ul class="nav navbar-nav navbar-right">
                                <li class="">
                                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <span id="mot"> </span>
                                        <span class=" fa fa-angle-down"></span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                                        <li><a href="javascript:;"> Profile</a></li>
                                        <li>
                                            <a href="javascript:;">
                                                <span class="badge bg-red pull-right">50%</span>
                                                <span>Settings</span>
                                            </a>
                                        </li>
                                        <li><a href="javascript:;">Help</a></li>
                                        <li><a href="authentification.jsp"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                                    </ul>
                                </li>

                                <li role="presentation" class="dropdown">
                                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                        <i class="fa fa-envelope-o"></i>
                                        <span class="badge bg-green">6</span>
                                    </a>
                                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                        <li>
                                            <a>
                                                <span class="image"><img src="gentelella/production/images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="gentelella/production/images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="gentelella/production/images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="gentelella/production/images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <div class="text-center">
                                                <a>
                                                    <strong>See All Alerts</strong>
                                                    <i class="fa fa-angle-right"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->

                <!-- page content -->
                <div class="right_col" role="main" style="margin-left: 0px ;">
                    <!-- top tiles -->
                    <div class="x_panel" >
                        <div class="x_title">
                            <h1 style="text-align: center;">Votre historique </h1>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Settings 1</a>
                                        </li>
                                        <li><a href="#">Settings 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content" >
                            <br>
                            <div id="demo-form2" data-parsley-validate=""  class="form-horizontal form-label-left" novalidate="">

                                <div class="form-group">
                                    <input type="checkbox" class="checkbox" id="box" onclick="show()" /><b>Entre deux dates</b>
                                </div>
                                <span id="dates" hidden="true" >
                                    <div class="form-group"  >
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Date 1 </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="date" id="date1" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group"  >
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Date 2 </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="date" id="date2" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                </span>       
                            </div>
                        </div>
                    </div>

                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Liste des pointages</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Settings 1</a>
                                        </li>
                                        <li><a href="#">Settings 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                            <div class="table-responsive">
                                <table class="table table-striped jambo_table bulk_action">
                                    <thead>
                                        <tr class="headings">
                                            <th class="column-title">DATE </th>
                                            <th class="column-title">EMPLOYE </th>
                                            <th class="column-title">HEURE ENTREE </th>
                                            <th class="column-title">HEURE SORTIE </th>
                                        </tr>
                                    </thead>
                                    <tbody id="mTable">

                                    </tbody>
                                </table>
                            </div>


                        </div>
                    </div>



                </div>
                <!-- /page content -->

                <!-- footer content -->
                <footer style="margin-left: 0px">
                    <div class="pull-right">
                        Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
            </div>
        </div>

        <!-- jQuery -->
        <script src="gentelella//vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="gentelella//vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="gentelella//vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="gentelella//vendors/nprogress/nprogress.js"></script>
        <!-- Chart.js -->
        <script src="gentelella//vendors/Chart.js/dist/Chart.min.js"></script>
        <!-- gauge.js -->
        <script src="gentelella//vendors/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="gentelella//vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- iCheck -->
        <script src="gentelella//vendors/iCheck/icheck.min.js"></script>
        <!-- Skycons -->
        <script src="gentelella//vendors/skycons/skycons.js"></script>
        <!-- Flot -->
        <script src="gentelella//vendors/Flot/jquery.flot.js"></script>
        <script src="gentelella//vendors/Flot/jquery.flot.pie.js"></script>
        <script src="gentelella//vendors/Flot/jquery.flot.time.js"></script>
        <script src="gentelella//vendors/Flot/jquery.flot.stack.js"></script>
        <script src="gentelella//vendors/Flot/jquery.flot.resize.js"></script>
        <!-- Flot plugins -->
        <script src="gentelella//vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
        <script src="gentelella//vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
        <script src="gentelella//vendors/flot.curvedlines/curvedLines.js"></script>
        <!-- DateJS -->
        <script src="gentelella//vendors/DateJS/build/date.js"></script>
        <!-- JQVMap -->
        <script src="gentelella//vendors/jqvmap/dist/jquery.vmap.js"></script>
        <script src="gentelella//vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
        <script src="gentelella//vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
        <!-- bootstrap-daterangepicker -->
        <script src="gentelella//vendors/moment/min/moment.min.js"></script>
        <script src="gentelella//vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="gentelella//build/js/custom.min.js"></script>
        <script src="script/votreHistorique.js" type="text/javascript"></script>
        <script src="script/menu.js" type="text/javascript"></script>

    </body>
</html>