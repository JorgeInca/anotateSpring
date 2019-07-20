<html>
<head>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="screen" id="bootstrap-css">
	
	<link href="${pageContext.request.contextPath}/resources/css/loginStyle.css"
	rel="stylesheet" type="text/css">
	
</head>

<body style="zoom: 1.5;">
	 <div class="sidenav">
         <div class="login-main-text">
            <h2>Control de Operaciones <br> Grupo Tama</h2>
            <p>Pantalla de inicio de sesión.</p>
         </div>
      </div>
      <div class="main">         
            <div class="login-form">
               <form action="getBandejaInicial" method="post">
                  <div class="form-group">
                     <label><h1>Usuario: </h1></label>
                     <input name="user" type="text" class="form-control input-group-lg" placeholder="User Name">
                  </div>
                  <div class="form-group">
                     <label><h1>Contraseña: </h1></label>
                     <input  name="password" type="password" class="form-control input-group-lg" placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-warning" value="Submit">Login</button>
                  <button type="submit" class="btn btn-warning">Register</button>
               </form>
            </div>         
      </div>
    
    <script	src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js"></script>  
	<script	src="${pageContext.request.contextPath}/resources/js/jquery/bootstrap.min.js"></script>
	
</body>
</html>