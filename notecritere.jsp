<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Notecritere"%>
<%@page import="etu002087.demandebesoin.Detaille_critere"%>
<%@page import="etu002087.demandebesoin.Demande_besoin"%>


<%
  Vector liste= (Vector) request.getAttribute("liste");
  Vector listenote =(Vector) request.getAttribute("listenotevalide");
  Integer nbr = (Integer)  request.getAttribute("nbr");
  Integer precedent = new Integer(0);
  Integer suivant = new Integer(0);
    if(nbr>3){  ;
      precedent=nbr-3;
    }
  suivant=nbr+3;
    Demande_besoin demande_besoin = new Demande_besoin();
    demande_besoin.setiddemande((String) request.getSession().getAttribute("iddemande") );
    demande_besoin.findOne();
    
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
      <div class="main-panel" style="margin: auto;width: 100%;">   
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                      <div class="card-body">
                        <h2 class="card-title">Liste notecritere</h2>
                        <%  if ( demande_besoin.getfait()!=null) { if(demande_besoin.getfait().compareTo("true")!=0){  %>
                          <button class="btn btn-success btn-rounded btn-icon" onclick="addService()">
                            <i class="fas fa-plus"></i>
                          </button>
                        <%  } 
                         } %>
                        <!-- <a href="/RHgestion/superieur.do">
                          <button class="btn btn-success btn-rounded btn-icon">
                            <i class="fas fa-angle-left"></i>
                          </button>
                        </a> -->
                        <div class="content-wrapper"  class="pagination">
                          <div class="btn-group" role="group" aria-label="Basic example" class="pagination2"></div>
                           <a href="http://localhost:8080/RHgestion/paginationnotecritere.do?nbr=<%  out.println(precedent); %>" >  <button type="button" class="btn btn-outline-secondary"  >1</button> </a>
                           <a href="/RHgestion/superieur.do"> <button type="button" class="btn btn-outline-secondary" href="#" >X</button> </a>
                            <a  href="http://localhost:8080/RHgestion/paginationnotecritere.do?nbr=<%  out.println(suivant); %>"> <button type="button" class="btn btn-outline-secondary">3</button> </a>
                          </div>
                        <div class="table-responsive">
                          <table class="table table-striped">
                            <!-- champ existant -->
                            <thead>
                              <tr>
 <th>idnote</th>
 <th>idfdetaille_cr</th>
 <th>note</th>
 <th>idfdemande</th>
                                    </tr>
<% for(int i=0; i<liste.size();i++) { Notecritere service =  (Notecritere) liste.get(i); service.setdetaille_critere(); %>
                                    <tr>
                                      <td class="py-1"><% out.println( service.getidnote() ); %> </td>
                                      <td class="py-1"><% out.println( service.getDetaille_critere().getnomdetaillecritere() ); %> </td>
                                      <td class="py-1"><% out.println( service.getnote() ); %> </td>
                                      <td class="py-1"><% out.println( service.getidfdemande() ); %> </td>
<td>
<button class="btn btn-info btn-rounded btn-icon" onclick="updateService(<%out.println(i);%>)">
<i class="fas fa-edit"></i>
</button>
</td>
<td>
<a href="http://localhost:8080/RHgestion/deletenotecritere.do?idnote=<% out.println( service.getidnote() ); %>">
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
                  <h4 class="card-title">Ajouter Notecritere</h4>
                  <form class="forms-sample" id="creation">
                    <div class="form-group">
                      <input type="hidden" class="form-control" id="exampleInputUsername1"  name="idnote">
                      
                      <label for="exampleInputUsername1"> Detaille critere</label>
                        <select class="form-select" aria-label="Default select example" name="idfdetaille_cr">
                          <% for(int i=0;i<listenote.size();i++){ Detaille_critere critere = (Detaille_critere) listenote.get(i);  %>
                            <option value="<% out.print( critere.getiddetaille_cr() ); %>"> <% out.println( critere.getnomdetaillecritere()  ); %> </option>
                          <% } %>
                        </select>
                    <br/>
                      <label for="exampleInputUsername1">note</label>
                        <input type="texte" class="form-control" id="exampleInputUsername1"  name="note">
                          
                      <input type="hidden" class="form-control" id="exampleInputUsername1"  name="idfdemande">
                    </div>
                    <button type="submit" class="btn btn-primary mr-2" >Submit</button>
                  </form>
                </div>
              </div>
          </div>
        </div>
        </div>
<% for(int i=0; i<liste.size();i++) {  Notecritere service =  (Notecritere) liste.get(i); %>
            <div  class="service" >
              <div class="content-popup">
                <span id="closePopup" class="close-popup"><button onclick="closepopuppdate(<%out.println(i);%>)"><i class="fas fa-plus"></i></button></span>
                <div class="col-md-6 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Modif</h4>
                      <form class="forms-sample formulaiupdate">
                        <div class="form-group">
                      <input type="hidden" class="form-control" id="exampleInputUsername1"  name="idnote" value="<% out.print( service.getidnote() ); %>" >
                          <label for="exampleInputUsername1">idfdetaille_cr</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="idfdetaille_cr" value="<% out.print( service.getidfdetaille_cr() ); %>" >
                          <label for="exampleInputUsername1">note</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="note" value="<% out.print( service.getnote() ); %>" >
                          <label for="exampleInputUsername1">idfdemande</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="idfdemande" value="<% out.print( service.getidfdemande() ); %>" >
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
        fetch("http://localhost:8080/RHgestion/insertnotecritere.do", {
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
      fetch("http://localhost:8080/RHgestion/modificationnotecritere.do", {
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
