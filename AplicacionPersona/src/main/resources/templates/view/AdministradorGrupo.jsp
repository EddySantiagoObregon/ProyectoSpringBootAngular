<%-- 
    Document   : AdministradorGrupo
    Created on : 24/08/2020, 04:53:44 PM
    Author     : PAULA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  
 if (session.getAttribute("idUsuario")!="900127905"){
   response.sendRedirect("Salir.jsp");
 }
%>
<!DOCTYPE html>
<html lang="es">
<head>
         <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <title>ListarGrupoDesdeAdmininstrador</title>
         <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
         <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
         <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
         
    </head>

   
    <body>
     
    </body>
</html>
