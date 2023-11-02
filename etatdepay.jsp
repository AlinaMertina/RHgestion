
<%@page import="java.util.Vector"%>
<%@page import="java.lang.Double"%>


<%@page import="etu002087.demandebesoin.Candidat"%>
<%@page import="java.text.DecimalFormat"%>



<%

Vector liste = (Vector) request.getAttribute("liste");
Double heursp=0.0;
Double prime= 0.0;
Double cnaps=0.0;
Double irsa=0.0;
Double absence=0.0;
Double salaire=0.0;
Double net=0.0;

DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.0");


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
<body>
 
   
      <!-- partial:partials/_settings-panel.html -->
      <!-- partial -->
      <!-- partial:partials/_sidebar.html -->
      
      <!-- partial -->
      <div class="main-panel" style="margin: auto;width: 102%;">   
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                      <div class="card-body">
                        <h2 class="card-title">Etat de pays <b> Date </b></h2>
                        <button class="btn btn-success btn-rounded btn-icon" onclick="addService()">
                          <i class="fas fa-plus"></i>
                        </button>
                        
                          <div class="btn-group" role="group" aria-label="Basic example" class="pagination2"></div>
                           <a href="#" >  <button type="button" class="btn btn-outline-secondary"  >1</button> </a>
                           <a href="/RHgestion/sudo.do" > <button type="button" class="btn btn-outline-secondary" href="#" >X</button>  </a>
                          <a  href="#"> <button type="button" class="btn btn-outline-secondary">3</button> </a>
                          <br style="margin-bottom: 4%;">
                        <div class="table-responsive">
                          <table class="table table-striped">
                            <!-- champ existant -->
                            <thead>
                            <tr>
                                <th>Matricule</th>
                                <th>Nom prenome</th>
                                <th>Heure d'absence</th>
                                <th>Heure supplementaire</th>
                                <th>Prime</th>
                                <th>Cnaps</th>
                                <th>IRSA</th>
                                <th>Salaire de base</th>
                                <th>Salaire nete</th>


                            </tr>
                            <% for(int i=0; i < liste.size() ; i++) { Candidat candidat = (Candidat) liste.get(i); 
                                prime=prime+candidat.getTotalprime();
                                heursp=heursp+candidat.getTotalheursup();
                                cnaps=cnaps+candidat.getTotalcnaps();
                                absence=absence+ candidat.getPrixabsence();
                                irsa=irsa+candidat.getPrixtaux();
                                salaire=salaire+candidat.getSalaire();
                                net=net +((candidat.getTotalheursup()+candidat.getTotalprime()+candidat.getTotalcnaps() +candidat.getPrixtaux()+candidat.getSalaire())-candidat.getPrixabsence());
                               %>
                            <tr>
                                <td><%= candidat.getmatricule() %></td>
                                <td><%= candidat.getnom() %><b style="color:white">XXXXXXX</b><%= candidat.getprenom() %></td>
                                <td><%= decimalFormat.format(candidat.getPrixabsence()) %></td>
                                <td><%= decimalFormat.format(candidat.getTotalheursup()) %></td>
                                <td><%= decimalFormat.format(candidat.getTotalprime()) %></td>
                                <td><%= decimalFormat.format(candidat.getTotalcnaps()) %></td>
                                <td><%= decimalFormat.format(candidat.getPrixtaux()) %></td>
                                <td><%= decimalFormat.format(candidat.getSalaire()) %></td>

                                <td><%= decimalFormat.format(((candidat.getTotalheursup()+candidat.getTotalprime()+candidat.getTotalcnaps() +candidat.getPrixtaux()+candidat.getSalaire())-candidat.getPrixabsence())) %></td>                         
                                <td>
                                    <a href="/RHgestion/monfichedepay.do?idfcandidat=<%= candidat.getidcandidat() %>">
                                        <button class="btn btn-success btn-rounded btn-icon" >
                                            <i class="fas fa-bars"></i>
                                        </button> 
                                    </a>
                                </td>
                            </tr>
                            <% } %>
                            <tr>
                                <td>#</td>
                                <td></td>
                                <td><%=  decimalFormat.format(absence)  %></td>
                                <td><%= decimalFormat.format(heursp)  %></td>
                                <td><%= decimalFormat.format(prime) %></td>
                                <td><%=  decimalFormat.format(cnaps)  %></td>
                                <td><%= decimalFormat.format(irsa)  %></td>
                                <td><%=  decimalFormat.format(salaire) %></td>
                                <td><%=  decimalFormat.format(net) %></td>

                               
                            </tr>

                            <tr>
                              <td>#</td>
                              <td></td>
                              <td><%=  decimalFormat.format(absence) %></td>
                              <td><%= decimalFormat.format(heursp)  %></td>
                              <td><%= decimalFormat.format(prime) %></td>
                              <td><%=  decimalFormat.format(cnaps)  %></td>
                              <td><%= decimalFormat.format(irsa)  %></td>
                              <td><%=  decimalFormat.format(salaire)  %></td>
                              <td><%= decimalFormat.format(net) %></td>
                            </tr>

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


        <!-- partial -->
      </div>

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
<script type="text/javascript">      function addService() {        document.getElementById('addService').style.display='block';
      }
      function closepopup() {
        document.getElementById('addService').style.display='none';
      }
      function updateService(id) {
        console.log(document.getElementsByClassName("service")[parseInt(id)]);
        document.getElementsByClassName("service")[parseInt(id)].style.display='block';
      }
      function closepopuppdate(id) {
        document.getElementsByClassName("service")[parseInt(id)].style.display='none';
      }
      document.getElementById("creation").addEventListener("submit", function(event) {
        event.preventDefault(); 
        const formData = new FormData(this); 
        fetch("http://localhost:8080/RHgestion/insertservice.do", {
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
        window.location.reload();
    });
    function updateforme(id){
      event.preventDefault();
      const formData = new FormData(document.getElementsByClassName("formulaiupdate")[parseInt(id)]);
      fetch("http://localhost:8080/RHgestion/modificationservice.do", {
            method: "POST",
            body: formData // Les données du formulaire
        })
        .then(response => response.json()) 
        .then(data => {
            console.log(data);
        });
        window.location.reload();
    }
</script>
