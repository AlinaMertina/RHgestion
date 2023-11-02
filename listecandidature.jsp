<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Candidat"%>
<%
  Vector liste= (Vector) request.getAttribute("liste");
  String iddemande =(String) request.getAttribute("iddemande");
  
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
<style>
  .service{
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
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->

    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_settings-panel.html -->
      <!-- partial -->
      <!-- partial:partials/_sidebar.html -->
      
      <!-- partial -->
      <div class="main-panel" style="margin: auto;">   
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                      <div class="card-body">
                        <h2 class="card-title">Liste Candidature</h2>
                        <!-- <button class="btn btn-success btn-rounded btn-icon" onclick="addService()">
                          <i class="fas fa-plus"></i>
                        </button> -->
                        <div class="content-wrapper"  class="pagination">
                          <div class="btn-group" role="group" aria-label="Basic example" class="pagination2"></div>
                           <a href="#" >  <button type="button" class="btn btn-outline-secondary"  >1</button> </a>
                            <a href="/RHgestion/sudo.do"> <button type="button" class="btn btn-outline-secondary" href="#" >X</button></a>
                          
                            <a  href="#"> <button type="button" class="btn btn-outline-secondary">3</button> </a>
                          </div>
                        <div class="table-responsive">
                          <table class="table table-striped">
                            <!-- champ existant -->
                            <thead>
                              <tr>
                                <th>idcandidat</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Age</th>
                                <th>Email</th>
                                <th>tel</th>
                                <th>note generale</th>
                              </tr>
                                <% for(int i=0; i<liste.size();i++) { Candidat service =  (Candidat) liste.get(i); service.setagecandidat(); %>
                                    <tr>
                                      <td class="py-1"><% out.println( service.getidcandidat() ); %> </td>
                                      <td class="py-1"><% out.println( service.getnom() ); %> </td>
                                      <td class="py-1"><% out.println( service.getprenom() ); %> </td>
                                      <td class="py-1"><% out.println( service.getagecandidat() ); %> </td>
                                      <td class="py-1"><% out.println( service.getmail() ); %> </td>
                                      <td class="py-1"><% out.println( service.gettel() ); %> </td>
                                      <td class="py-1"><% out.println( service.getnotegenerale() ); %> </td>

                                      
                                    <td>
                                        <!-- <a href="/RHgestion/deletecvcandidadetaille.do?idcvcandidadetaille=<% out.println( service.getidcandidat() ); %>"> -->
                                        <a href="/RHgestion/voirdetaillecvcandidat.do?idcandidat=<% out.println( service.getidcandidat() ); %>&&iddemande=<%= iddemande %>">

                                            <button class="btn btn-info btn-rounded btn-icon" >
                                                <i class="fas fa-align-justify"></i>
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
        

<!-- partial:../../partials/_footer.html -->

        <!-- partial -->
      </div>
    </div>
      <!-- main-panel ends -->
    </div> 
    <!-- page-body-wrapper ends -->
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
        fetch("http://localhost:8080/RHgestion/insertcvcandidadetaille.do", {
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
      fetch("http://localhost:8080/RHgestion/modificationcvcandidadetaille.do", {
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
