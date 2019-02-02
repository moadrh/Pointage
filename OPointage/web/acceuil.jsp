<%-- 
    Document   : acceuil
    Created on : 17 janv. 2019, 13:33:22
    Author     : dell
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.Employe"%>
<%@page import="services.FonctionService"%>
<%@page import="services.EmployeService"%>
<%@page import="services.PointageService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon.ico" type="image/ico" />

        <title>Acceuil </title>

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
                <%@include file="/includes/menu.jsp" %>

                <!-- top navigation -->
                <%@include file="/includes/header.jsp" %>
                <!-- /top navigation -->

                <!-- page content -->
                <div class="right_col" role="main">
                    <!-- top tiles -->
                    <div class="x_panel">
                        <div class="row">
                            <% EmployeService es = new EmployeService();%>
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <div class="icon"><i class="fa fa-users"></i>
                                    </div>
                                    <div class="count"><%= es.count()%></div>

                                    <h3>Employés</h3>
                                </div>
                            </div>
                            <% FonctionService fs = new FonctionService();%>
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <div class="icon"><i class="fa fa-gears"></i>
                                    </div>
                                    <div class="count"><%= fs.count()%></div>

                                    <h3>Fonctions</h3>
                                </div>
                            </div>
                            <% PointageService ps = new PointageService();%>
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <div class="icon"><i class="fa fa-clock-o"></i>
                                    </div>
                                    <div class="count"><%= ps.count()%></div>

                                    <h3>Pointages</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="x_panel">
                        <div class="x_content" >
                            <br>
                            <div id="demo-form2" data-parsley-validate=""  class="form-horizontal form-label-left" novalidate="">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Employé </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select id="employe" name="role" class="form-control form-control-lg" >
                                            <option value="hidden">Choisit un employé</option>
                                            <% for (Employe e : es.findAll()) {%>
                                            <option value="<%= e.getId()%>" ><%= e.getNom() + ' ' + e.getPrenom()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
<!--                                        <div class="form-group" style="display: inline;" >
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Mois </label>
                                            <input type="checkbox" class="checkbox" id="box" onclick="showChart()"  /> Annees
                                        </div>       -->
                                     <div class="form-group"  >
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Par mois ou année :</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" id="choix">
                                            <option value="mois" >Mois</option>
                                            <option value="annee" >Annéé</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div  class="x_panel"   >
                        <div class="row" id ="chart" hidden="true" >
                            <div class="col-md-12 col-sm-8 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2 id="mot1">Nombre d'heures travaillés </h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <canvas id="mChart"></canvas>
                                    </div>
                                </div>
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
            <script src="script/Chart.js" type="text/javascript"></script>
            <script src="script/graph.js" type="text/javascript"></script>
            <script src="script/menu.js" type="text/javascript"></script>
    </body>
    <script>
//        var mChart = document.getElementById('mChart').getContext('2d');
//        
//        // Global Options
//        Chart.defaults.global.defaultFontFamily = 'Lato';
//        Chart.defaults.global.defaultFontSize = 18;
//        Chart.defaults.global.defaultFontColor = '#777';
<%
//           List<String> mList = new ArrayList<String>();
//           mList.add("'Janvier'");
//           mList.add("'Février'");
//           mList.add("'Mars'");
//           mList.add("'Avril'");
//           mList.add("'Mai'");
//           mList.add("'Juin'");
//           mList.add("'Juillet'");
//           mList.add("'Aout'");
//           mList.add("'Septembre'");
//           mList.add("'Octobre'");
//           mList.add("'Novembre'");
//           mList.add("'Décembre'");
//           
//           List<Integer> mList2 = new ArrayList<Integer>();
//           
//           for (int i = 1; i < 13; i++) {
//               mList2.add(ps.totalHeurebyMonth(1, i));
//           }
       
%>
//        let mois =  mList ;
//        let nbrHeures =   mList2 ;
//        
//       let mois =['jjhh','bhbh'];
//       let nbrHeures=[15,30]
//        console.log(mois);
//        console.log(nbrHeures);
//        let massPopChart = new Chart(mChart, {
//            type: 'line', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
//            data: {
//                labels: mois,
//                datasets: [{
//                        label: 'Nombre heures',
//                        data: nbrHeures,
//                        //backgroundColor:'green',
//                        backgroundColor: [
//                            'rgba(255, 99, 132, 0.6)',
//                            'rgba(54, 162, 235, 0.6)',
//                            'rgba(255, 206, 86, 0.6)',
//                            'rgba(75, 192, 192, 0.6)',
//                            'rgba(15, 102, 255, 0.6)',
//                            'rgba(140, 5, 64, 0.6)',
//                            'rgba(255, 99, 132, 0.6)'
//                        ],
//                        borderWidth: 1,
//                        borderColor: '#777',
//                        hoverBorderWidth: 3,
//                        hoverBorderColor: '#000'
//                    }]
//            },
//            options: {
//                title: {
//                    display: true,
//                    text: 'Le nombre d heures par mois',
//                    fontSize: 25
//                },
//                legend: {
//                    display: true,
//                    position: 'right',
//                    labels: {
//                        fontColor: '#000'
//                    }
//                },
//                layout: {
//                    padding: {
//                        left: 50,
//                        right: 0,
//                        bottom: 0,
//                        top: 0
//                    }
//                },
//                tooltips: {
//                    enabled: true
//                },
//                scales: {
//                    yAxes: [{
//                            display: true,
//                            stacked: true,
//                            ticks: {
//                                min: 0, // minimum value
//                            }
//                        }]
//                }
//            }
//        });
    </script>
</html>
