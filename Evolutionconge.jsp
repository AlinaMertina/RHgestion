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
                        <div class="carousel-item active">
                            <div class="row">
                              <h4>Nombre de conge restant :<%= nombrecongepermi %></h4>
                              <div class="col-md-12 col-xl-9">
                                <div class="row">
                                  <div class="col-md-11 border-right">
                                    <div class="table-responsive ">
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
                                  <!-- <div class="col-md-3 mt-3">
                                    <canvas id="north-america-chart"></canvas>
                                    <div id="north-america-legend"></div>

                                  </div> -->
                                </div>
                              </div>
                              
                            </div>
                            <a href="http://localhost:8080/RHgestion/listeemployerconger.do">
                              <button type="button" class="btn btn-link">Retour</button>
                            </a>
                            
                          </div>

                          <!-- fin contra -->
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
            fetch("<?php  echo base_url('index.php/Welcome/modifvent')?>", {
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
