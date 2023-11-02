<%@page import="java.lang.Integer"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.conge.Conge"%>

<%

Vector liste = (Vector) request.getAttribute("detailleconge");
Integer nombrecongepermi = (Integer) request.getAttribute("nombredeconge");

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
                      <h2 class="card-title">Conge    <b style="color: white;">XXXXXXX</b>   
                      <!-- <a href="http://localhost:8080/RHgestion/pageinsertcongehand.do">
                          <button class="btn btn-success btn-rounded btn-icon">
                              <i class="fas fa-plus"></i>
                          </button>
                      </a> -->
                      <b style="color: white;">XXXXXXX</b>
                      
                      <a href="http://localhost:8080/RHgestion/listeemployerconger.do">
                          <button class="btn btn-success btn-rounded btn-icon" >
                              <i class="fas fa-angle-left"></i>
                          </button> 
                      </a>
                      <br>
                      
                      </h2>
                     
                     
                      <div class="table-responsive">
                        <table class="table table-bordered">
                          <thead>
                                <tr>
                                  
                                  <th>
                                    Categorie conge
                                  </th>
                                  <th>
                                    Date debut
                                  </th>
                                  <th>
                                    Date fin
                                  </th>
                                  <th>
                                    Nombre de jours
                                  </th>
                                </tr>
                          </thead>
                          <tbody>
                            <% for(int i=0; i < liste.size() ;i++) { Conge conge = (Conge) liste.get(i); %>
                            <tr>
                              <td><%= conge.getCongespecifie().getnomconge() %></td>
                              <td><%= conge.getdatedebut() %></td>
                              <td><%= conge.getdatefin() %></td>
                              <td><%= conge.getjours() %></td>
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
  </div>
          
  
  
          
        <script src="assets/vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <script src="assets/vendors/chart.js/Chart.min.js"></script>
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="assets/js/off-canvas.js"></script>
        <script src="assets/js/hoverable-collapse.js"></script>
        <script src="assets/js/template.js"></script>
        <script src="assets/js/settings.js"></script>
        <script src="assets/js/todolist.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <script src="assets/js/chart.js"></script>
  </body>
  
  
  </html>
  
  <script type="text/javascript">
    var canvas = document.getElementById('areaChart');
        if (canvas.getContext) {
            var ctx = canvas.getContext('2d');
            ctx.fillStyle = 'red';
            ctx.fillRect(10, 10, 50, 50); // dessiner un rectangle rouge à partir du point (10, 10) avec une largeur de 50 et une hauteur de 50
        } else {
            // code de secours ici
        }

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
  