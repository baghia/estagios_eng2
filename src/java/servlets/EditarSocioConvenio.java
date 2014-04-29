/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import beans.SocioConvenio;
import dao.SocioConvenioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago
 */
@WebServlet(name = "EditarSocioConvenio", urlPatterns = {"/EditarSocioConvenio"})
public class EditarSocioConvenio extends HttpServlet {

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
        processRequest(request, response);
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
        try {
            SocioConvenio socio_convenio = new SocioConvenio();
            SocioConvenioDAO socio_convenioDAO = new SocioConvenioDAO();
      
            socio_convenio.setId_socio(Integer.parseInt(request.getParameter("id_socio_convenio")));
            socio_convenio.setCpf(request.getParameter("cpf"));
            socio_convenio.setNome(request.getParameter("nome"));
            socio_convenio.setRg(request.getParameter("rg"));
            
            
            
 
            socio_convenioDAO.editar(socio_convenio.getId_socio(),socio_convenio);

           
            response.sendRedirect("EditarConvenio.jsp?id="+request.getParameter("id_convenio"));
        } catch (Exception e) {
            
            
             response.sendRedirect("CadastroSocioConvenio.jsp?id_socio_convenio="+request.getParameter("id_socio_convenio"));
            
            
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
