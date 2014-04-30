/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import beans.ContatoConvenio;
import dao.ContatoConvenioDAO;
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
@WebServlet(name = "EditarContatoConvenio", urlPatterns = {"/EditarContatoConvenio"})
public class EditarContatoConvenio extends HttpServlet {

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
            ContatoConvenio contato_convenio = new ContatoConvenio();
            ContatoConvenioDAO contato_convenioDAO = new ContatoConvenioDAO();
      

            contato_convenio.setCargo(request.getParameter("cargo"));
            contato_convenio.setNome(request.getParameter("nome"));
            contato_convenio.setSetor(request.getParameter("setor"));
            contato_convenio.setTelefone(request.getParameter("telefone"));
            contato_convenio.setCelular(request.getParameter("celular"));
            contato_convenio.setEmail(request.getParameter("email"));
            contato_convenio.setHorario(request.getParameter("horario"));
            contato_convenio.setId_contato(Integer.parseInt(request.getParameter("id_contato_convenio")));
            
            
 
            contato_convenioDAO.editar(contato_convenio.getId_contato(),contato_convenio);

           
            response.sendRedirect("GerenciamentoConvenio/EditarConvenio.jsp?id="+request.getParameter("id_convenio"));
        } catch (Exception e) {
            
            
             response.sendRedirect("GerenciamentoConvenio/EditarContatoConvenio.jsp?id_contato_convenio="+request.getParameter("id_contato_convenio"));
            
            
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
