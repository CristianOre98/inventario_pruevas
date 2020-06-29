<%@page import="Model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- El id debe ser el mismo que se le colocó de nombre a la sesión en el controlador -->
<jsp:useBean id="lista" scope="session" class="java.util.List" />
<html>
    <head>
        <title>Control de Inventario</title>
        <meta charset="UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
       
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        
    </head>
    <body>
       
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
        <!-- Todo el contenido de la aplicación -->
        
        
            <br>
            <!--<a href="#" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button">Nueva categoria</a>-->
            <a href="<%= request.getContextPath() %>/categorias?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button">Nueva categoria</a>
            <h3>Listado de Categorias Registradas</h3>  <a class="btn btn-warning float-right" href="pdf">PDF</a>
           
         <table id="example" class="table text-center table-striped table-bordered" style="width:100%">
             <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>ESTADO</th>
                <th>ACCIONES</th>
            </tr>
             <%
                    for(int i=0;i < lista.size(); i++){
                        Categoria categoria = new Categoria();
                        categoria = (Categoria)lista.get(i);
                    //}
                %>
        </thead>
        
            <tr>
                <td><%= categoria.getId_categoria() %></td>
                <td><%= categoria.getNom_categoria() %></td>
                <td><%= categoria.getEstado_categoria() %></td>
                <td>
                        <!-- /Vistas-Categorias/crearCategoria.jsp -->
                <a href="<%= request.getContextPath() %>/categorias?opcion=modificar&&id_cat=<%= categoria.getId_categoria() %>&&nombre_cat=<%= categoria.getNom_categoria() %>&&estado_cat=<%= categoria.getEstado_categoria() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
                        
                <a href="<%= request.getContextPath() %>/categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>
                    </td>
            </tr>
             <%
                    }
                %>
        
    </table>
        
    
                    </div>
                </main>
                
            
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
               
         
      <script>
            $(document).ready(function() {
            $('#example').DataTable();
            } );
        </script>
  
    </body>
</html>

