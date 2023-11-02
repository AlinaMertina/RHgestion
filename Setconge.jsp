<%@page import="java.lang.String"%>
<%@page import="java.util.Vector"%>
<%@page import="etu002087.conge.Congespecifie"%>

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

                   
                    <div class="col-8 grid-margin stretch-card" style="margin: auto;">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">Conge Employee
                                <b style="color: white;">XXXXXXX</b>
                                        <a href="/RHgestion/employee.do">
                                            <button class="btn btn-success btn-rounded btn-icon" >
                                                <i class="fas fa-angle-left"></i>
                                            </button> 
                                </a>
                            </h4>
                            <form class="forms-sample" action="http://localhost:8080/RHgestion/insertcongevalider.do" method="get">
                             
                              
                              <div class="form-group">
                                <label for="exampleInputEmail3">Type de Congee</label>
                                <select class="form-control"  name="idconger">
                                  <% for(int i=0; i< liste.size() ;i++) {  Congespecifie value =(Congespecifie) liste.get(i); %>
                                  <option value="<%= value.getidcongespecifie() %>"><%=  value.getnomconge() %></option>
                                  <% } %>
                                </select>  
                              </div>

                              <div class="form-group">
                                <label for="exampleInputEmail3">Debut</label>
                                <input type="date" class="form-control" id="exampleInputEmail3" placeholder="yyyy-mm-dd hh:mm:ss" name="datedebut">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword4">Fin</label>
                                <input type="date" class="form-control" id="exampleInputPassword4" placeholder="yyyy-mm-dd hh:mm:ss" name="datefin">
                              </div>
                             
                              <button type="submit" class="btn btn-primary mr-2">Submit</button>
                             
                            </form>
                          </div>
                        </div>
                    </div>
                    

                    
                </div>                  
            </div>
  
        </div>
  
          
  
  
          
        <script src="assets/vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <script src="assets/vendors/chart.js/Chart.min.js"></script>
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="assets/js/off-canvas.js"></script>
        <script src="assets/js/hoverable-collapse.js"></script>
        <script src="assets/js/template.js"></script>
        <script src="assets/js/settings.js"></script>
        <script src="assets/js/todolist.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <script src="assets/js/chart.js"></script>
  </body>
  
  
  </html>
  
  <script type="text/javascript">
    
  </script>
  