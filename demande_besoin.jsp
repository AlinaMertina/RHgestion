<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Demande_besoin"%>
<%@page import="etu002087.demandebesoin.Hierarchie"%>

<%

  Vector hierarchie=(Vector)  request.getAttribute("hierarchie");
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
                        <h2 class="card-title">Liste demande_besoin</h2>

                        <button class="btn btn-success btn-rounded btn-icon" onclick="addService()">
                          <i class="fas fa-plus"></i>
                        </button>
                          
                        <div class="content-wrapper"  class="pagination">
                          <div class="btn-group" role="group" aria-label="Basic example" class="pagination2"></div>
                           <a href="http://localhost:8080/RHgestion/paginationdemande_besoin.do?nbr=<%  out.println(precedent); %>" >  <button type="button" class="btn btn-outline-secondary"  >1</button> </a>
                            <a href="/RHgestion/superieur.do">   <button type="button" class="btn btn-outline-secondary"  >X</button> </a>
                            <a  href="http://localhost:8080/RHgestion/paginationdemande_besoin.do?nbr=<%  out.println(suivant); %>"> <button type="button" class="btn btn-outline-secondary">3</button> </a>
                          </div>
                        <div class="table-responsive">
                          <table class="table table-striped">
                            <!-- champ existant -->
                            <thead>
                              <tr>
 <th>iddemande</th>
 <!-- <th>horaire</th> -->
 <th>Fonction</th>
 <th>Nombre employee</th>
 <!-- <th>production_actuelle</th> -->
 <!-- <th>production_demander</th> -->
 <th>datedemande</th>
 <th>datefin</th>
 <th>modif</th>
 <th>Critere</th>
 <th>QCM</th>
 <th>Liste recruter</th>


 <!-- <th>description</th> -->
                                    </tr>
                                <% for(int i=0; i<liste.size();i++) { Demande_besoin service =  (Demande_besoin) liste.get(i); service.sethierarchie(); %>
                                    <tr>
                                      <td class="py-1"><% out.println( service.getiddemande() ); %> </td>
                                      <td class="py-1"><% out.println( service.gethierarchie().getnomhierarchie() ); %> </td>          
                                      <td class="py-1"><% out.println( service.getnbr_employee() ); %> </td>
                                      <td class="py-1"><% out.println( service.getdatedemande() ); %> </td>
                                      <td class="py-1"><% out.println( service.getdatefin() ); %> </td>
                                     
                                      <td>
                                      <button class="btn btn-info btn-rounded btn-icon" onclick="updateService(<%out.println(i);%>)">
                                        <i class="fas fa-edit"></i>
                                      </button>
                                      </td>
                                      <!-- <td>
                                      <a href="http://localhost:8080/RHgestion/deletedemande_besoin.do?iddemande=<% out.println( service.getiddemande() ); %>">
                                          <button class="btn btn-danger btn-rounded btn-icon">
                                              <i class="fas fa-trash-alt"></i>
                                          </button>
                                      </a>
                                      </td> -->
                                      <td>
                                        <a href="http://localhost:8080/RHgestion/notecriteredemande.do?iddemande=<% out.print( service.getiddemande() ); %>">
                                          <button class="btn btn-info btn-rounded btn-icon" >
                                            <i class="fas fa-align-justify">C</i>
                                          </button>
                                        </a>
                                      </td>
                                      <td>
                                        <a href="http://localhost:8080/RHgestion/accuillequestion.do?iddemande=<% out.print( service.getiddemande() ); %>">
                                          <button class="btn btn-info btn-rounded btn-icon" >
                                            <i class="fas fa-align-justify">Q</i>
                                          </button>
                                        </a>
                                      </td>
                                      <td>
                                        <a href="http://localhost:8080/RHgestion/listedemandeclient.do?iddemande=<% out.print( service.getiddemande() ); %>">
                                          <button class="btn btn-info btn-rounded btn-icon" >
                                            <i class="fas fa-align-justify">D</i>
                                          </button>
                                        </a>
                                      </td>

                                      
                                      <% if( service.getfait()!=null )  {  if(service.getfait().compareTo("false")==0) { %>
                                        <td>
                                          <a href="http://localhost:8080/RHgestion/demandefait.do?fa=true&&iddemande=<% out.print( service.getiddemande() ); %>">
                                            <button class="btn btn-info btn-rounded btn-icon" >
                                              <i class="far fa-thumbs-up"></i>
                                            </button>
                                          </a>
                                        </td>
                                      <% 
                                      } 
                                      } %>
                                      
 
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
                  <h4 class="card-title">Ajouter Demande_besoin</h4>
                  <form class="forms-sample" id="creation">
                    <div class="form-group">
                      <input type="hidden" class="form-control" id="exampleInputUsername1"  name="iddemande">
                      
                          <label for="exampleInputUsername1">Fonction</label>
                          <select class="form-select" aria-label="Default select example" name="idfhi">
                            <% for(int i=0;i<hierarchie.size();i++){ Hierarchie fonction= (Hierarchie) hierarchie.get(i); %>
                              <option value="<% out.print( fonction.getidhierarchie() ); %>"> <% out.println( fonction.getnomhierarchie() ); %> </option>
                            <% } %>
                          </select>
                          <!-- <label for="exampleInputUsername1">horaire</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="horaire"> -->
                          <label for="exampleInputUsername1">Nombre employee</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="nbre">
                          <!-- <label for="exampleInputUsername1">production_actuelle</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="production_actuelle">
                          <label for="exampleInputUsername1">production_demander</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="production_demander"> -->
                          <label for="exampleInputUsername1">datedemande</label>
                      <input type="date" class="form-control" id="exampleInputUsername1"  name="debut">
                          <label for="exampleInputUsername1">datefin</label>
                      <input type="date" class="form-control" id="exampleInputUsername1"  name="fin">
                          <!-- <label for="exampleInputUsername1">description</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="description"> -->
                         
                      <input type="hidden" class="form-control" id="exampleInputUsername1"  name="idfservice">
                    </div>
                    <button type="submit" class="btn btn-primary mr-2" >Submit</button>
                  </form>
                </div>
              </div>
          </div>
        </div>
        </div>
<% for(int i=0; i<liste.size();i++) {  Demande_besoin service =  (Demande_besoin) liste.get(i); %>
            <div  class="service" >
              <div class="content-popup">
                <span id="closePopup" class="close-popup"><button onclick="closepopuppdate(<%out.println(i);%>)"><i class="fas fa-plus"></i></button></span>
                <div class="col-md-6 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Modif</h4>
                      <form class="forms-sample formulaiupdate" >
                        <div class="form-group">
                      <input type="hidden" class="form-control" id="exampleInputUsername1"  name="idde" value="<% out.print( service.getiddemande() ); %>" >
                          <!-- <label for="exampleInputUsername1">horaire</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="horaire" value="<% out.print( service.gethoraire() ); %>" > --> -->
                          <label for="exampleInputUsername1">Nombre employee</label>
                      <input type="text" class="form-control" id="exampleInputUsername1"  name="nbre" value="<% out.print( service.getnbr_employee() ); %>" >
                          <!-- <label for="exampleInputUsername1">production_actuelle</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="production_actuelle" value="<% out.print( service.getproduction_actuelle() ); %>" >
                          <label for="exampleInputUsername1">production_demander</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="production_demander" value="<% out.print( service.getproduction_demander() ); %>" > -->
                          <!-- <label for="exampleInputUsername1">datedemande</label> -->
                      <!-- <input type="date" class="form-control" id="exampleInputUsername1"  name="datedemande" value="<% out.print( service.getdatedemande() ); %>" > -->
                          <!-- <label for="exampleInputUsername1">datefin</label> -->
                      <!-- <input type="date" class="form-control" id="exampleInputUsername1"  name="datefin" value="<% out.print( service.getdatefin() ); %>" > -->
                          <!-- <label for="exampleInputUsername1">idfservice</label>
                      <input type="texte" class="form-control" id="exampleInputUsername1"  name="idfservice" value="<% out.print( service.getidfservice() ); %>" > -->
                      <label for="exampleInputUsername1">Fonction</label>
                      
                      <select class="form-select" aria-label="Default select example" name="ihe" value="<%= service.getidfhierarchie() %>">
                        <% for(int a=0;a<hierarchie.size();a++){ Hierarchie fonction= (Hierarchie) hierarchie.get(a); %>
                          <option value="<% out.print( fonction.getidhierarchie() ); %>"> <% out.println( fonction.getnomhierarchie() ); %> </option>
                        <% } %>
                      </select>

                        </div>
                        <button type="submit" class="btn btn-primary mr-2" onclick="updateforme(<%= i  %>)">Submit</button>
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
        fetch("http://localhost:8080/RHgestion/insertnewdemande.do", {
            method: "POST", 
            body: formData // Les données du formulaire
            // "http://localhost:8080/RHgestion/insertdemande_besoin.do
             
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
      fetch("http://localhost:8080/RHgestion/modificationdemande_besoin.do", {
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
