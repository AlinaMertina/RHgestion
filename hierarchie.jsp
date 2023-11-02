<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Hierarchie"%>
<%@page import="etu002087.superutilisateur.Service"%>

<%
  Vector liste= (Vector) request.getAttribute("liste");
  Vector serviceliste = (Vector)  request.getAttribute("service");


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
                        <h2 class="card-title">Liste hierarchie</h2>
                        <button class="btn btn-success btn-rounded btn-icon" onclick="addService()">
                          <i class="fas fa-plus"></i>
                        </button>

                        <div class="content-wrapper"  class="pagination">
                          <div class="btn-group" role="group" aria-label="Basic example" class="pagination2"></div>
                           <a href="http://localhost:8080/RHgestion/paginationhierarchie.do?nbr=<%  out.println(precedent); %>" >  <button type="button" class="btn btn-outline-secondary"  >1</button> </a>
                      
                           <a href="/RHgestion/sudo.do"> <button type="button" class="btn btn-outline-secondary" href="#" >X</button> </a>
                            
                          
                            <a  href="http://localhost:8080/RHgestion/paginationhierarchie.do?nbr=<%  out.println(suivant); %>"> <button type="button" class="btn btn-outline-secondary">3</button> </a>
                          </div>
                        <div class="table-responsive">
                          <table class="table table-striped">
                            <!-- champ existant -->
                            <thead>
                              <tr>
 <th>idhierarchie</th>
 <th>idfservice</th>
 <th>nomhierarchie</th>
                                    </tr>
<% for(int i=0; i<liste.size();i++) { Hierarchie service =  (Hierarchie) liste.get(i); %>
                                    <tr>
                                      <td class="py-1"><% out.println( service.getidhierarchie() ); %> </td>
                                      <td class="py-1"><% out.println( service.getidfservice() ); %> </td>
                                      <td class="py-1"><% out.println( service.getnomhierarchie() ); %> </td>
<td>
<button class="btn btn-info btn-rounded btn-icon" onclick="updateService(<%out.println(i);%>)">
<i class="fas fa-edit"></i>
</button>
</td>
<td>
<a href="http://localhost:8080/RHgestion/deletehierarchie.do?idhierarchie=<% out.println( service.getidhierarchie() ); %>">
<button class="btn btn-danger btn-rounded btn-icon">
<i class="fas fa-trash-alt"></i>
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
        <div id="addService">
          <div class="content-popup">
            <span id="closePopup" class="close-popup"><button onclick="closepopup()"><i class="fas fa-times"></i></button></span>
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Ajouter Hierarchie</h4>
                  <form class="forms-sample" id="creation">
                    <div class="form-group">
                      
                      <input type="hidden" class="form-control" id="exampleInputUsername1"  name="idhierarchie">

                      <label for="exampleInputUsername1">service</label>
                      <select class="form-control"  name="idfservice">
                        <% for(int i=0; i< serviceliste.size() ;i++) {  Service value =(Service) serviceliste.get(i); %>
                        <option value="<%= value.getidservice() %>"><%=  value.getnomservice() %></option>
                        <% } %>
                      </select>

                      <label for="exampleInputUsername1">nom hierarchie</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="nomhierarchie">
                    </div>
                    <button type="submit" class="btn btn-primary mr-2" >Submit</button>
                  </form>
                </div>
              </div>
          </div>
        </div>
        </div>
<% for(int i=0; i<liste.size();i++) {  Hierarchie service =  (Hierarchie) liste.get(i); %>
            <div  class="service" >
              <div class="content-popup">
                <span id="closePopup" class="close-popup"><button onclick="closepopuppdate(<%out.println(i);%>)"><i class="fas fa-plus"></i></button></span>
                <div class="col-md-6 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Modif</h4>
                      <form class="forms-sample formulaiupdate">
                        <div class="form-group">
                      <label for="exampleInputUsername1">idhierarchie</label>
                      <input type="hidden" class="form-control" id="exampleInputUsername1"  name="idhierarchie" value="<% out.print( service.getidhierarchie() ); %>" >
                      <label for="exampleInputUsername1">idfservice</label>
                          <label for="exampleInputUsername1">idfservice</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="idfservice" value="<% out.print( service.getidfservice() ); %>" >
                      <label for="exampleInputUsername1">nomhierarchie</label>
                          <label for="exampleInputUsername1">nomhierarchie</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="nomhierarchie" value="<% out.print( service.getnomhierarchie() ); %>" >
                        </div>
                        <button type="submit" class="btn btn-primary mr-2" onclick="updateforme(<%out.println(i);%>)">Submit</button>
                      </form>
                    </div>
                  </div>
              </div>
              </div>
            </div>
        <% } %>
<!-- partial:../../partials/_footer.html -->
<footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2021.  Premium <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> from BootstrapDash. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="ti-heart text-danger ml-1"></i></span>
          </div>
        </footer>
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
        fetch("http://localhost:8080/RHgestion/inserthierarchie.do", {
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
      fetch("http://localhost:8080/RHgestion/modificationhierarchie.do", {
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
