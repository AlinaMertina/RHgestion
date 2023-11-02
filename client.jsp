<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Demande_besoin"%>
<%@page import="etu002087.demandebesoin.Notecritere"%>
<%@page import="etu002087.superutilisateur.Service"%>

<%
Vector liste= (Vector) request.getAttribute("liste");

%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Skydash Admin</title>
<!-- plugins:css -->
<link rel="stylesheet" href="assets/vendors/feather/feather.css">
<link rel="stylesheet" href="assets/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" href="assets/fontawesome-5/css/all.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet" href="assets/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
<link rel="stylesheet" href="assets/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" type="text/css" href="assets/js/select.dataTables.min.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="assets/css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="images/favicon.png" />
<link rel="stylesheet" href="assets/ownCSS/client.css">
</head>
<style>
    body{
            background-image: url('assets/images/job.jpg'); /* Remplacez 'votre-image.jpg' par l'URL de votre image */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
    }
</style>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <nav >
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                  <i class="icon-layout menu-icon"></i>
                  <span class="menu-title">Service</span>
                  <i class="menu-arrow"></i>
                </a>
                <div class="collapse" id="ui-basic">
                  <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="#">Buttons</a></li>
                    <li class="nav-item"> <a class="nav-link" href="#">Dropdowns</a></li>
                    <li class="nav-item"> <a class="nav-link" href="#">Typography</a></li>
                  </ul>
                </div>
            </li>
        </ul>
        </nav>
      <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item dropdown">
            <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown"></a>
              <i class="icon-bell mx-0"></i>
              <span class="count"></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
              <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-success">
                    <i class="ti-info-alt mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-normal">Application Error</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    Just now
                  </p>
                </div>
              </a>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-warning">
                    <i class="ti-settings mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-normal">Settings</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    Private message
                  </p>
                </div>
              </a>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-info">
                    <i class="ti-user mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-normal">New user registration</h6>
                  <p class="font-weight-light small-text mb-0 text-muted"></p>
                    2 days ago
                  </p>
                </div>
              </a>
            </div>
          </li>
          
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="icon-menu"></span>
        </button>
      </div>
    </nav>
    <!-- partial -->
    
    <% for(int i=0;i<liste.size();i++ ){ Demande_besoin demande = (Demande_besoin) liste.get(i);  demande.sethierarchie();  %>
      <% if(i!=0){ %>
        <div class="col-lg-12 grid-margin stretch-card demande"  style="width:50%;margin: auto;background-color: none;margin-top:10% ;display:none;">
      <% } else { %>
        <div class="col-lg-12 grid-margin stretch-card demande"  style="width:50%;margin: auto;background-color: none;margin-top:10% ;">
      <% }%>

        
            <div class="card">
              <div class="card-body">
                <h4 class="card-title"><%= demande.gethierarchie().getnomhierarchie() %></h4>
                <p class="card-description">
                  <%= demande.getdatedemande() %> <code><%= demande.getdatefin()%></code>
                </p>
                <div class="table-responsive">
                  <table class="table">
                    <thead>
                      
                      <tr>
                        <th>
                          <button class="btn btn-success btn-rounded btn-icon badge badge-warning" onclick="submita(event,<% out.print(i-1); %>)">
                              <i class="fas fa-angle-left"></i>
                          </button>
                        </th>
                        <th>
                            <button class="btn btn-success btn-rounded btn-icon badge badge-warning" onclick="submita(event,<% out.print(i); %>)">
                               X
                            </button>
                        </th>
                        <th>
                          #
                        </th>
                        <th>
                          Demande
                        </th>
                        <th>
                            <button class="btn btn-success btn-rounded btn-icon badge badge-warning" onclick="submita(event,<% out.print(i+1); %>)">
                                <i class="fas fa-angle-right"></i>
                            </button>
                        </th>
                        
                      
                      </tr>
                    </thead>
                    <tbody>
                      <% for(int a=0;a<demande.getNotecritere().size() ; a++) {  Notecritere note = (Notecritere) demande.getNotecritere().get(a); note.setdetaille_critere();  %>
                        <tr>
                          <td></td>
                          <td><%= a %></td>
                          <td> <%=  note.getDetaille_critere().getnomdetaillecritere()%></td>
                          <td></td>
                        </tr>
                      <% 
                     } %>
                     <tr>
                      <td></td>
                      <td></td>
                      <td></td>
                     

                      <td> <a href="http://localhost:8080/RHgestion/cvinsert.do?idmande=<%= demande.getiddemande() %>&&idservice=<%= demande.getidfservice() %>"> <button  class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" >Mettre cv</button>  </a> </td>
                     </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
      <% } %>

      
    
    <!-- page-body-wrapper ends -->
  
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="assets/vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page -->
  <script src="assets/vendors/chart.js/Chart.min.js"></script>
  <script src="assets/vendors/datatables.net/jquery.dataTables.js"></script>
  <script src="assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  <script src="assets/js/dataTables.select.min.js"></script>
  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="assets/js/off-canvas.js"></script>
  <script src="assets/js/hoverable-collapse.js"></script>
  <script src="assets/js/template.js"></script>
  <script src="assets/js/settings.js"></script>
  <script src="assets/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="assets/js/dashboard.js"></script>
  <script src="assets/js/Chart.roundedBarCharts.js"></script>
  <!-- End custom js for this page-->
</body>
</html>
<script type="text/javascript">      
  
  function submita(event,id){
     
        event.preventDefault();
        var bilan = document.getElementsByClassName('demande');
        if(id >=bilan.length  ){
            return ;
        }
        for(let i=0;i<bilan.length;i++){
            bilan[i].style.display="none";
        }
        bilan[id].style.display="block";
    }
</script>
