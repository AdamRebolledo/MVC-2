/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 56974
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    Persona p= new Persona();
    PersonaDAO dao = new PersonaDAO();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
      
          
        
        
        
        
        
         
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String acceso ="";
String action = request.getParameter("accion");
if(action.equalsIgnoreCase("listar")){
acceso = listar;
}
else if(action.equalsIgnoreCase("editar")){
    request.setAttribute("id", request.getParameter("id"));
    acceso=edit;
}
else if(action.equalsIgnoreCase("Actualizar")){
    int id= Integer.parseInt(request.getParameter("id"));
    String rut = request.getParameter("rut");
    String nombre = request.getParameter("nombre");
    p.setId(id);
    p.setRut(rut);
    p.setNombre(nombre);
    dao.edit(p);
    acceso=listar;
} else if(action.equalsIgnoreCase("add")){
        acceso=add;
        
        }
else if(action.equalsIgnoreCase("eliminar")){
    int id= Integer.parseInt(request.getParameter("id"));
    p.setId(id);
    dao.eliminar(id);
    acceso=listar;

}


    RequestDispatcher vista = request.getRequestDispatcher(acceso);
    vista.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
      String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
      if(rut!=null){
       p.setRut(rut);
         p.setNombre(nombre);
         dao.add(p);
           RequestDispatcher vista = request.getRequestDispatcher(listar);
    vista.forward(request, response);
      } 
    
        
        
       
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
