<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Question"%>
<%@page import="etu002087.demandebesoin.Choixquestion"%>

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
  <link rel="stylesheet" href="assets/ownCSS/Service.css">
</head>

<body>
      <!-- partial -->
    <div class="main-panel" style="margin: auto;">   
      <form class="forms-sample" action="insertquestioncv.do" method="get"> 
          
       
        <!--fin billan -->
        <!-- billan -->
        <div class="col-12 grid-margin stretch-card bilan" >
            <div class="card">
              <div class="card-body corpsmedicament">
                <h4 class="card-title">Question 
                    
                  <br>
                  <br> 
                    <button class="btn btn-success btn-rounded btn-icon" onclick="submita(event,0)">
                        <i class="fas fa-angle-left"></i>
                    </button>
                    
                    <button class="btn btn-success btn-rounded btn-icon"  type="submit">
                      <i class="fas fa-plane-departure"></i>
                    </button>
                </h4>
                <% for(int i=0; i<liste.size() ;i++){
                    Question question = (Question) liste.get(i);
                %>
                <div class="form-group critere">
                  <label for="exampleInputEmail3"><h3><%= question.gettextquestion() %></h3>   <b style="color: white;">xxxxxxx</b>
                    <!-- <button class="btn btn-success btn-rounded btn-icon" onclick="addService(event,i,'critere')">
                        <i class="fas fa-plus"></i>
                    </button> -->
                  </label>
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <select class="form-control" id="exampleSelectGender" name='idchoix[]'>
                        <% for(int a=0; a<question.getchoix().size() ;a++) {  Choixquestion detaille = (Choixquestion) question.getchoix().get(a);  %>
                          <option value="<%= detaille.getidchoixquestion() %>"><%= detaille.getchoix() %></option>
                        <% } %>
                      </select>
                    </div>
                  </div>
                </div>
                <% } %>
               
              </div>
             
            </div>
        </div>

       
        <!--fin billan -->
      </form>
       
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

<script type="text/javascript">

    function submita(event,id){
        console.log("kkkkk"+id);
        event.preventDefault();
        var bilan = document.getElementsByClassName('bilan');
        for(let i=0;i<bilan.length;i++){
            bilan[i].style.display="none";
        }
        bilan[id].style.display="block";
    }
    // console.log("oooooo");
    // function fetchDataWithXHR() {
    //     const xhr = new XMLHttpRequest();
    //     xhr.open("GET", "http://localhost:8080/ClientCejb-war/Ajaxpersonne", true);
    //     xhr.setRequestHeader("Content-Type", "application/json"); // Spécifiez le type de contenu si nécessaire
    //     xhr.onreadystatechange = function () {
    //       if (xhr.readyState === 4) {
    //         if (xhr.status === 200) {
    //           console.log("nnnnnn");
    //           const data = JSON.parse(xhr.responseText);
    //           console.log(data);
    //         } else {
    //           console.error(`La requête a échoué avec le code : ${xhr.status}`);
    //         }
    //       }
    //     };

    //   xhr.send();
    // }

    // // Appelez la fonction pour effectuer la requête
    // fetchDataWithXHR();


    // console.log("ooooooiiiiii");


    // var monInput = document.getElementById("cinp");
    // monInput.addEventListener("input", function() {
    //     var valeurSaisie = monInput.value;
    //     console.log("Vous avez saisi : " + valeurSaisie);
    // });
    // //donne mikasika ni ola rehetra misi cin
    // var dropdownpersonne = document.getElementById("bpersonne");
    // monInput.addEventListener("submit", function() {
    
    // });

    function addService(event,id,nomclass){
          event.preventDefault()
          let medicament = document.getElementsByClassName(nomclass)[id];
          let corpsmedicament = document.getElementsByClassName("corpsmedicament")[id];
          let div = document.createElement("div"); // Créez un nouvel élément div
          div.innerHTML = medicament.outerHTML; // Copiez le contenu HTML de l'élément medicament dans le div créé
          corpsmedicament.appendChild(div);
    }
    


</script>
