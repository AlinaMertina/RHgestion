<%@page import="etu002087.demandebesoin.Candidat"%>
<%@page import="etu002087.payement.Majorationheursup"%>
<%@page import="etu002087.payement.Primeemployer"%>
<%@page import="etu002087.payement.Cnaps"%>


<%

Candidat moi = (Candidat) request.getAttribute("moi");
Double possitif = moi.getSalaire();
Double negatif = moi.getPrixtaux();

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
  li {
    display: inline;
    justify-content: center;
  }
</style>
</head>
<body>
    <div class="main-panel" style="margin: auto;">
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
              <div class="card-body">
                <h4 class="card-title">Fiche de pay Arret au <b>date </b></h4>
                <div style="display: flex;">
                    <div style="width: 50%;" >
                      <ul >
                        <li>Nom et Prenome:</li>
                        <li style="margin-left: 10%;"><%= moi.getnom() %> <b style="color: white;"> XXXXXXXXXX</b><%= moi.getprenom() %></li>
                      </ul>
                       <ul >
                        <li>Matriculation:</li>
                        <li style="margin-left: 15%;" ><%= moi.getmatricule() %></li>
                      </ul>
                       <ul >
                        <li>Fonction:</li>
                        <li style="margin-left: 20%;"><%= moi.getHierarchie().getnomhierarchie() %></li>
                      </ul>
                       <ul >
                        <li>N CNAPS:</li>
                        <li style="margin-left: 19%;" > l</li>
                      </ul>
                       <ul >
                        <li>Date d'embauche:</li>
                        <li style="margin-left: 9%;" ><%= moi.getdateembouche() %></li>
                      </ul>
                       <ul >
                        <li>Anciennete:</li>
                        <li style="margin-left: 16%;" ><%= moi.getAncienetee() %></li>
                      </ul>
                    </div>
                    <div style="width: 50%;" >
                      <ul>
                        <li></li>
                        <li></li>
                      </ul>
                      <ul >
                        <li>Classification:</li>
                        <li style="margin-left: 10%;"> lllll </li>
                      </ul>
                       <ul >
                        <li>Salaire de base:</li>
                        <li style="margin-left: 7%;" ><%= moi.getSalaire() %></li>
                      </ul>
                       <ul >
                        <li>Taux Journalier:</li>
                        <li style="margin-left: 7%;"><%=  moi.getPrixParheur()*16 %></li>
                      </ul>
                       <ul >
                        <li>Taux horaire:</li>
                        <li style="margin-left: 10%;" ><%=  moi.getPrixParheur() %></li>
                      </ul>
                      <ul >
                        <li>heure de traville:</li>
                        <li style="margin-left: 18%;" ><%= moi.getHeurTravaille() %></li>
                      </ul>
                      
                    </div>
                </div>
                
                <div class="table-responsive pt-3">
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>Designation</th>
                        <th>Nombre</th>
                        <th>Taux</th>
                        <th>Montant</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td style="width:60%">Salaire de base </td>
                        <td></td>
                        <td></td>
                        <td><%= moi.getSalaire() %></td>
                      </tr>
                      <tr>
                        <td style="width:60%">Heure supplemantentaire <%= moi.getHeurSup() %> </td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <!-- heure supplemantentaire -->
                      <% for(int i=0;i<moi.getMajoration().size(); i++) {  Majorationheursup value = (Majorationheursup)  moi.getMajoration().get(i); %>
                      <tr>
                        <td style="width:60%">Montant de majoration entre  <%= value.getinferieur() %>  et  <%= value.getsup() %> </td>
                        <td> <%= value.getHeure() %></td>
                        <td><%= value.getmajoration() %></td>
                        <td><%= value.getPrixmajoration() %></td>
                      </tr>
                      <%  possitif=possitif+value.getPrixmajoration();
                    } %>
                      <tr>
                        <td style="width:60%">Prime </td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <% for(int i=0;i<moi.getlisteprime().size(); i++) {  Primeemployer value = (Primeemployer)  moi.getlisteprime().get(i);  value.setnomprime(); %>
                        <tr>
                          <td style="width:60%"><%= value.getnomprime() %></td>
                          <td> </td>
                          <td> </td>
                          <td><%= value.getmontant() %></td>
                        </tr>
                      <%  possitif=possitif+value.getmontant();
                    } %>
                      <tr>
                        <td style="width:60%">Salaire Brute</td>
                        <td></td>
                        <td></td>
                        <td><%= moi.getSalaire()  %></td>
                      </tr>

                      <tr>
                        <td style="width:60%">CNAPS</td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>

                      <% for(int i=0;i<moi.getListecnaps().size(); i++) {  Cnaps value = (Cnaps)  moi.getListecnaps().get(i);   %>
                        <tr>
                          <td style="width:60%"><%= value.getdescription() %></td>
                          <td> </td>
                          <td><%= value.getpourcentage() %> </td>
                          <td><%= value.getPrixcnapscandidat() %></td>
                        </tr>
                      <%  negatif = negatif + value.getPrixcnapscandidat();
                    } %>

                      <tr>
                        <td style="width:60%">IRSA</td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                    
                      <tr>
                        <td style="width:60%"></td>
                        <td></td>
                        <td><%= moi.getTauxIrsa() %></td>
                        <td><%= moi.getPrixtaux() %></td>
                      </tr>

                      <tr>
                        <td style="width:60%">Salaire net</td>
                        <td></td>
                        <td></td>
                        <td><%= possitif-negatif  %></td>
                      </tr>

                      <tr>
                        <td style="width:60%"></td>
                        <td></td>
                        <td></td>
                        <td>
                          <a href="/RHgestion/sudo.do">
                            <button  class="btn btn-primary mr-2">X</button>
                          </a>
                          
                        </td>
                      </tr>

                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          
    </div>

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