/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nolasco
 */
public class ProductosError extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
   //Agregar metodo listaCategorias
    protected void listaProducto(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        //Instancia a categoria DAO
        ProductoDAO producto = new ProductoDAOImplementar();
        //crear instacia de session; true para iniciar session
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", producto.listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Producto/listarProducto.jsp");
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion");
        if(parametro.equals("crear")){
            String pagina = "/Vistas-Producto/crearProducto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        }else if(parametro.equals("listar")){
            this.listaProducto(request, response);
        }else if(parametro.equals("editar")){
            //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
            int id_producto = Integer.parseInt(request.getParameter("id_p"));
            String nom_producto = request.getParameter("nombre_p");
            String des_producto = request.getParameter("des_p");
            float stock = Float.parseFloat(request.getParameter("stock_p"));
            float precio = Float.parseFloat(request.getParameter("precio_p"));
            String unidad_de_medida = request.getParameter("unidad_p");
            int estado_producto = Integer.parseInt(request.getParameter("estado_p"));
            String categoria = request.getParameter("categoria_p");
            String fecha_entrada = request.getParameter("fecha_p");
           
            String pagina = "/Vistas-Producto/crearProducto.jsp?id_pro="+id_producto+"&&nombre_pro="+
                    nom_producto+"&&estado_pro="+estado_producto+"&&des_pro="+des_producto+"&&stock_pro="+stock+
                    "&&precio_pro="+precio+"&&unidad_pro="+unidad_de_medida+"&&categoria_pro="+categoria+
                    "&&fecha_pro="+fecha_entrada+"&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        }else if(parametro.equals("eliminar")){
            int Producto_id = Integer.parseInt(request.getParameter("id"));
            ProductoDAO producto = new ProductoDAOImplementar();
            producto.borrarPro(Producto_id);    
            this.listaProducto(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        String parametro = request.getParameter("accion");
            
                
             Producto producto = new Producto();
             Categoria categoria = new Categoria();
        //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
        
         int id_producto = Integer.parseInt(request.getParameter("txtId_producto"));
            String nom_producto = request.getParameter("txtNombreProducto");
            String des_producto = request.getParameter("txtDescripcionProducto");
            float stock = Float.parseFloat(request.getParameter("txtStockProducto"));
            float precio = Float.parseFloat(request.getParameter("txtPrecioProducto"));
            String unidad_de_medida = request.getParameter("txtUnidadProducto");
            int estado_producto = Integer.parseInt(request.getParameter("txtEstadoProducto"));
            String catego = request.getParameter("txtCategoriaProducto");
            String fecha_entrada = request.getParameter("txtFechaProducto");
        
        producto.setId_producto(id_producto);
        producto.setNom_producto(nom_producto);
        producto.setDes_producto(des_producto);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setUnidadMedida(unidad_de_medida);
        producto.setEstado(estado_producto);
        producto.setFecha_entrada(fecha_entrada);
        categoria.setNom_categoria(catego);
        producto.setCategoria(categoria);
        
        ProductoDAO guardarProducto = new ProductoDAOImplementar();
        guardarProducto.guardarPro(producto);
        
        this.listaProducto(request, response);
        //se efectua el casting o conversion de datos porque lo ingresado en el formulario es texto
     
        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}