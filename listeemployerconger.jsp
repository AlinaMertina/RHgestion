<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Candidat"%>

<%@page import="etu002087.conge.Congespecifie"%>

<%

Vector conge = (Vector) request.getAttribute("conge");

  Vector liste= (Vector) request.getAttribute("liste");
  Integer nbr = (Integer)  request.getAttribute("nbr");
  Integer precedent = new Integer(0);
  Integer suivant = new Integer(0);
    if(nbr>3){  ;
      precedent=nbr-3;
    }
  suivant=nbr+3;

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
    <link rel="stylesheet" href="assets/ownCSS/Service.css">
</head>

<style>
  .update{
    display: none;
    position: fixed;
    z-index: 1;
    left: 300px;
    top: 0;
    width: 50%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0,0,0,0,5);
    float: right;
}
</style>

<body style="margin: auto;">
    
    <div class="main-panel" style="margin:auto;width:100%;height:100%;">        
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  
                  <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                      <div class="card-body">
                        <h2 class="card-title">Liste Vente    <b style="color: white;">XXXXXXX</b>   
                        
                        <b style="color: white;">XXXXXXX</b>
                        
                        <a href="#">
                            <button class="btn btn-success btn-rounded btn-icon" >
                                <i class="fas fa-angle-left"></i>
                            </button> 
                        </a>
                        <br>
                          <div class="content-wrapper"  class="pagination">
                          
                        </h2>
                        <div class="btn-group" role="group" aria-label="Basic example" class="pagination2"></div>
                          <a href="http://localhost:8080/RHgestion/listeemployercongerpagination.do?nbr=<%  out.println(precedent); %>" >  <button type="button" class="btn btn-outline-secondary"  >1</button> </a>
                          <button type="button" class="btn btn-outline-secondary" href="#" >X</button>
                          <a  href="http://localhost:8080/RHgestion/listeemployercongerpagination.do?nbr=<%  out.println(suivant); %>"> <button type="button" class="btn btn-outline-secondary">3</button> </a>
                        </div>
                       
                        <div class="table-responsive">
                          <table class="table table-striped">
                            <thead>
                              <tr>
                                <th>#</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                               
                                <th>Conge</th>
                                <th>Absence</th>
                                <th>Conge</th>
                                <th>Absence</th>
                               
                                
                                

                              </tr>
                            </thead>
                            <tbody>
                                <% for(int i=0; i < liste.size() ;i++ ) {  Candidat candidat = (Candidat) liste.get(i); %>
                                <tr>
                                    <td></td>
                                    <td><%= candidat.getnom() %></td>
                                    <td><%= candidat.getprenom() %> </td>

                                    <td style="text-align: center;width: 10%;">
                                        <a href="http://localhost:8080/RHgestion/detailleconge.do?idfcandidat=<%= candidat.getidcandidat() %>">
                                            <button class="btn btn-success btn-rounded btn-icon" >
                                                <i class="fas fa-align-justify"></i>
                                            </button> 
                                        </a>                     
                                    </td>
                                    
                                    <td style="text-align: center;width: 10%;">
                                        <a href="http://localhost:8080/RHgestion/listeabsence.do?idfcandidat=<%= candidat.getidcandidat() %>">
                                            <button class="btn btn-success btn-rounded btn-icon" >
                                                <i class="fas fa-bars"></i>
                                            </button> 
                                        </a>
                                    </td>
                                     
                                    <td style="text-align: center;width: 10%;">
                                     
                                      <div class="dropdown">
                                        <button type="button" class="btn btn-outline-info dropdown-toggle" id="dropdownMenuIconButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                          <i class="ti-time"></i>
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuIconButton3">
                                          <h6 class="dropdown-header">Conge</h6>
                                          <% for(int a=0 ; a<conge.size() ;a++) {  Congespecifie con = (Congespecifie) conge.get(a); %>
                                            <a class="dropdown-item" href="demadeconge.do?idpersonne=<%= candidat.getidcandidat() %>&idconge=<%= con.getidcongespecifie() %>"><%= con.getnomconge() %></a>
                                          <% } %>
                                        </div>
                                      </div>
                                        <!-- <a href="http://localhost:8080/RHgestion/pageinsertcongehand.do?idfcandidat=<%= candidat.getidcandidat() %>">
                                            <button class="btn btn-success btn-rounded btn-icon">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </a>  -->
                                    </td>
                                    <td style="text-align: center;width: 10%;" >
                                      
                                        <a href="pagesetabsence.do?idcandidat=<%= candidat.getidcandidat() %>">
                                          <button class="btn btn-success btn-rounded btn-icon" >
                                            <i class="fas fa-clock"></i>
                                          </button> 
                                        </a> 
                                    </td>
                                </tr>
                                <% } %>
                                
                                
                            </tbody>
                          </table>
                        </div>

                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
         
        </div>

        


        
        <!-- partial -->
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
</body>


</html>

<script type="text/javascript">

      document.getElementById("creation").addEventListener("submit", function(event) {
        event.preventDefault(); 
        
        const formData = new FormData(this); 
        fetch("<?php  echo base_url("index.php/Welcome/insertvent")?>", {
            method: "POST", 
            body: formData // Les données du formulaire
        })
        .then(response => response.json()) 
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error(error);
        });
        // window.location.reload();
    });
      function modif($nameforme){
        document.getElementById($nameforme).addEventListener("submit", function(event) {
            event.preventDefault(); 
            
            const formData = new FormData(this); 
            fetch("<?php  echo base_url("index.php/Welcome/modifvent")?>", {
                method: "POST", 
                body: formData // Les données du formulaire
            })
            .then(response => response.json()) 
            .then(data => {
                console.log(data);
            })
            .catch(error => {
                console.error(error);
            });
       // window.location.reload();
        });

      }

      function addService(event) {
        event.preventDefault();
        document.getElementById('addService').style.display='block';
      }

      function closepopup() {
        document.getElementById('addService').style.display='none';
      }

      function updateService(event,nomid) {
        console.log(nomid);
        event.preventDefault(); 
        document.getElementById(nomid).style.display='block';
      }
      function closepopuppdate(event,nomid) {
        event.preventDefault(); 
         document.getElementById(nomid).style.display='none';
      }

</script>
