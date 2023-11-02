<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.demandebesoin.Critere"%>
<%@page import="etu002087.demandebesoin.Detaille_critere"%>

<%
Vector liste= (Vector) request.getAttribute("listecritere");

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
      <form class="forms-sample" action="insertcandidature.do" method="get"> 
           <!-- billan -->
        <div class="col-12 grid-margin stretch-card bilan">
            <div class="card">
              <div class="card-body">
                <!-- content -->
                <h4 class="card-title">Information
                  <a href="/ClientCejb-war/Infosanteruser">
                    <button class="btn btn-success btn-rounded btn-icon" >
                      <i class="fas fa-angle-left"></i>
                    </button>
                  </a>
                  <button class="btn btn-success btn-rounded btn-icon" onclick="submita(event,1)">
                    <i class="fas fa-angle-right"></i>
                  </button>
                </h4>
                <div class="form-group">
                  <label for="exampleInputEmail3">Nom</label>
                  <input type="texte" class="form-control" id="exampleInputEmail3"  name="nom" value="TOTO">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail3">Prenom</label>
                  <input type="texte" class="form-control" id="exampleInputEmail3"  name="prenom" value="Mertina Claudie">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail3">Date de Naissance</label>
                  <input type="texte" class="form-control" id="exampleInputEmail3"  name="datedenaisance" value="2023-09-10">
                </div>

                <div class="form-group">
                  <label for="exampleInputEmail3">mail</label>
                  <input type="email" class="form-control" id="exampleInputEmail3"  name="mail" value="mertinaclaudietoto@gmail.com">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail3">Tel</label>
                    <input type="text" class="form-control" id="exampleInputEmail3"  name="tel" valeu="0346603384">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail3">Date depot</label>
                    <input type="text" class="form-control" id="exampleInputEmail3"  name="depotdecandidature" value="2023-09-08">
                </div>
                <div class="form-group">
                    <label for="exampleSelectGender">Genre</label>
                      <select class="form-control" id="exampleSelectGender" name="idfsexe" value="0">
                        <option value="0">Femme</option>
                        <option value="1">Homme</option>
                      </select>
                </div>
                
                <!-- fin content -->
              </div>
            </div>
        </div>
        <!--fin billan -->
        <!-- billan -->
        <div class="col-12 grid-margin stretch-card bilan" style="display: none;">
            <div class="card">
              <div class="card-body corpsmedicament">
                <h4 class="card-title">Critere demander
                  <br>
                  <br> 
                    <button class="btn btn-success btn-rounded btn-icon" onclick="submita(event,0)">
                        <i class="fas fa-angle-left"></i>
                    </button>
                       
                    <button class="btn btn-success btn-rounded btn-icon" onclick="submita(event,2)">
                      <i class="fas fa-angle-right"></i>
                    </button>
                    <button class="btn btn-success btn-rounded btn-icon"  type="submit">
                      <i class="fas fa-plane-departure"></i>
                    </button>
                </h4>
                <% for(int i=0; i<liste.size() ;i++){
                    Critere critere = (Critere) liste.get(i);
                %>
                <div class="form-group critere">
                  <label for="exampleInputEmail3"><%= critere.getnomcritere() %>   <b style="color: white;">xxxxxxx</b>
                    <!-- <button class="btn btn-success btn-rounded btn-icon" onclick="addService(event,i,'critere')">
                        <i class="fas fa-plus"></i>
                    </button> -->
                  </label>
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <select class="form-control" id="exampleSelectGender" name='idsouscritere[]'>
                        <% for(int a=0; a<critere.getdetaillecritere().size() ;a++) {  Detaille_critere detaille = (Detaille_critere) critere.getdetaillecritere().get(a);  %>
                          <option value="<%= detaille.getiddetaille_cr() %>"><%= detaille.getnomdetaillecritere() %></option>
                        <% } %>
                      </select>
                    </div>
                    <input type="text" class="form-control"  placeholder="description" name="description[]" value="ITU">
                    <input type="text" class="form-control"   placeholder="datedebut 2023-09-08" name="datedebut[]" value="2023-09-10">
                    <input type="text" class="form-control"  placeholder="datefin 2023-09-08" name="datefin[]" value="2023-09-10">
                    
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
