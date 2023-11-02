<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Candidat"%>
<%@page import="java.util.HashMap"%>


<%
  Vector liste= (Vector) request.getAttribute("liste");
  String iddemande = (String) request.getAttribute("iddemande");

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

</style>
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
<%  for(int i=0; i<liste.size();i++) { Candidat candidat = (Candidat) liste.get(i);  %>
    <div style="width: 100%;" class="Candidat" <% if(i!=0) { out.print(" style='display:none;' "); }  %> >
    
    <!-- partial -->
    <div class="container-fluid page-body-wrapper critere" style="width:50%;margin: auto;background-color: none;margin-bottom: -5%;">
        <div class="col-lg-12 grid-margin stretch-card demande" >
            <div class="card">
              <div class="card-body">
                <h4 class="card-title"><%= candidat.getnom() %> <b style="color: white;"> XXXXXXXXX</b> <%= candidat.getprenom() %></h4>
                <p class="card-description">
                 <%= candidat.getnotegenerale() %>
                 <br>
                 <!-- <a href="http://localhost:8080/RHgestion/deletedemande_besoin.do">
                    <button class="btn btn-success btn-rounded btn-icon">
                        <i class="fas fa-angle-left"></i>
                    </button>
                 </a> -->
                <div class="content-wrapper"  class="pagination">
                    <div class="btn-group" role="group" aria-label="Basic example" class="pagination2"></div>
                     <a href="#" >  <button type="button" class="btn btn-outline-secondary"  ></button> </a>
                      <a href="/RHgestion/listedemandeclient.do?iddemande=<%= iddemande %>"> <button type="button" class="btn btn-outline-secondary" href="#" >X</button></a>
                      <a  href="#"> <button type="button" class="btn btn-outline-secondary"></button> </a>
                </div>

                </p>

                <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Critere</th>
                        <th> Sous critere</th>
                        <th>Note</th>
                        <!-- <th>
                            <button class="btn btn-success btn-rounded btn-icon" onclick="submita(event,<%= i %>,'Candidat','question','critere')">
                                <i class="fas fa-angle-right"></i>
                            </button>
                        </th> -->
                      </tr>
                    </thead>
                    <tbody>
                        <% for(int a=0 ; a < candidat.getchoixcritere().size() ; a++) {

                            HashMap<String,Object> choisunique = (HashMap<String,Object>) candidat.getchoixcritere().get(a);  %>
                            <tr>
                            <td></td>
                            <td><%= choisunique.get("nomcritere") %></td>
                            <td><%= choisunique.get("nomdetaillecritere") %></td>
                            <td><%= choisunique.get("note") %></td>
                            </tr>
                        <% } %>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                  </table>
                </div>

                

              </div>
            </div>
          </div>
    </div>
            <div class="container-fluid page-body-wrapper question" style="width:50%;margin: auto;background-color: none;" style="display: none;">
                <div class="col-lg-12 grid-margin stretch-card demande" >
                    <div class="card">
                    <div class="card-body">
                        <!-- <h4 class="card-title"><%= candidat.getnom() %> <b style="color: white;"> XXXXXXXXX</b> <%= candidat.getprenom() %></h4>
                        <p class="card-description">
                        <%= candidat.getnotegenerale() %>
                        </p> -->
                        <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <!-- <th>
                                    <button class="btn btn-success btn-rounded btn-icon" onclick="submita(event,<%= i %>,'Candidat','critere','question')">
                                        <i class="fas fa-angle-left"></i>
                                    </button>
                                </th> -->
                                <th>Question</th>
                                <th>Response</th>
                                <th>Note</th>
                                <th>
                                    
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                                <% for(int a=0 ; a < candidat.getchoixquestion().size() ; a++) {  
                                    HashMap<String,Object> choisunique = (HashMap<String,Object>) candidat.getchoixquestion().get(a);  %>
                                    <tr>
                                    <td></td>
                                    <td><%= choisunique.get("textquestion") %></td>
                                    <td><%= choisunique.get("choix") %></td>
                                    <td><%= choisunique.get("note") %></td>
                                    </tr>
                                <% } %>
                                    <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td> <a href="embauchecandidat.do?idcandidat=<%=  candidat.getidcandidat() %>"> <button  class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" >Embauche</button>  </a> </td>
                                </tr>
                            </tbody>
                        </table>
                        </div>

                        

                    </div>
                    </div>
                </div>
            </div>
    </div>
<% } %>
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
<script type="text/javascript"> 
    function submita(event,id,nomclass,sousclass,sousclass1){
        console.log("kkkkk")
     event.preventDefault();
    // Sélectionnez tous les éléments avec la classe "nomclass" qui ont un enfant avec la classe "sousclass"
    var bilan = document.querySelectorAll("."+nomclass+" ."+sousclass+"");
    bilan[id].style.display = "block";
    // // Parcourez la liste des éléments correspondants
    // for (var i = 0; i < bilan.length; i++) {
    //     // Modifiez le style de chaque élément
    //     bilan[i].style.display = "block";
    // }

     var bilan1 = document.querySelectorAll( "."+nomclass+" ."+sousclass1);
     bilan1[id].style.display = "none";
    //  for (var i = 0; i < bilan.length; i++) {
    //     // Modifiez le style de chaque élément
    //     bilan1[i].style.display = "none";
    // }

 }

 function subcandidat(event,id){
     console.log("llllll "+id)
     event.preventDefault();
     var bilan = document.getElementsByClassName('Candidat');
     if(id >=bilan.length  ){
         id=0;
     }
     for(let i=0;i<bilan.length;i++){
         bilan[i].style.display="none";
     }
     bilan[id].style.display="block";
 }
</script>
