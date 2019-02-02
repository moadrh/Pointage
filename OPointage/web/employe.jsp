<%-- 
    Document   : employe
    Created on : 12 janv. 2019, 13:44:16
    Author     : dell
--%>


<%@page import="beans.Fonction"%>
<%@page import="services.FonctionService"%>
<%@page import="beans.Role"%>
<%@page import="services.RoleService"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon.ico" type="image/ico" />

        <title>EMPLOYES </title>

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
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <%@include file="/includes/menu.jsp" %>

                <!-- top navigation -->
                <%@include file="/includes/header.jsp" %>
                <!-- /top navigation -->

                <!-- page content -->
                <div class="right_col" role="main">
                    <!-- top tiles -->
                    <div class="x_panel" >
                        <div class="x_title">
                            <h2>Nouveau employé </h2>
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
                        <div class="x_content" style=" padding-left: 0px; float: left;" >
                            <br>
                            <div id="demo-form2" data-parsley-validate=""  class="form-horizontal form-label-left" novalidate="">

                                <div class="form-group" >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Nom </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="number" name="update" id="update" hidden="" />
                                        <input type="text" id="nom" required="required" class="form-control col-md-11 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Prenom </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="prenom" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">sexe </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" id="sexe">
                                            <option value="hidden">Choisit un sexe</option>
                                            <option value="femme" >Femme</option>
                                            <option value="homme" >Homme</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Date de naissance </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="date" id="dateNaissance" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Telephone </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="telephone" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Adresse </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="adresse" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Date d'embauche </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="date" id="dateEmbauche" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Email </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="email" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Mot de passe </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="password" id="password" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Role </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" id="role">
                                            <option value="hidden">Choisit un role</option>
                                            <% RoleService rs = new RoleService();
                                                for (Role r : rs.findAll()) {%>
                                            <option value="<%= r.getId()%>" ><%= r.getLibelle()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Fonction </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" id="fonction">
                                            <option value="hidden">Choisit une fonction</option>
                                            <% FonctionService fs = new FonctionService();
                                                for (Fonction f : fs.findAll()) {%>
                                            <option value="<%= f.getId()%>" ><%= f.getLibelle()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>        
                                <div class="ln_solid" ></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <button type="submit" id="save" class="btn btn-round btn-success" style="width: 150px;">Ajouter</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Liste des employés </h2>
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
                                            <th class="column-title">
                                                ID
                                            </th>
                                            <th class="column-title">
                                                NOM
                                            </th>
                                            <th class="column-title">
                                                PRENOM
                                            </th>
                                            <th class="column-title">
                                                SEXE
                                            </th>
                                            <th class="column-title">
                                                DATE NAISSANCE
                                            </th>
                                            <th class="column-title">
                                                TEL
                                            </th>
                                            <th class="column-title">
                                                ADRESSE
                                            </th>
                                            <th class="column-title"> 
                                                DATE EMBAUCHE
                                            </th>
                                            <th class="column-title">
                                                EMAIL
                                            </th>
                                            <th class="column-title">
                                                ROLE
                                            </th>
                                            <th class="column-title">
                                                FONCTION
                                            </th>
                                            <th class="column-title">
                                                SUPPRIMER
                                            </th>
                                            <th class="column-title">
                                                MODIFIER
                                            </th>
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
                <footer>
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
        <script src="script/moment.js" type="text/javascript"></script>
        <script src="script/employe.js" type="text/javascript"></script>
        <script src="script/menu.js" type="text/javascript"></script>
    </body>
</html>


