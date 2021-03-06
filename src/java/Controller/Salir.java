package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Salir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //HttpSession session= request.getSession(false);
            HttpSession session = request.getSession();
            try{
            //Se puede resetear o limpiar las variables de sesión de esta manera.
            session.invalidate();
            //Se puede resetear o limpiar las variables de sesión de esta otra manera. Usar una a la vez.
            /*session.removeAttribute("sessionNombres");
            session.removeAttribute("sessionTipo");
            session.removeAttribute("sessionUsuario");
            session.removeAttribute("sessionEmail");*/
            
            /*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("./");
            dispatcher.forward(request, response);*/
            response.sendRedirect("./");
            //response.sendRedirect("usuario/?eliminado=exito");
            
            }catch(Exception e){
                 e.printStackTrace();
            }  
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
