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
@WebServlet(name = "CadastroSocioConvenio", urlPatterns = {"/CadastroSocioConvenio"})
public class CadastroSocioConvenio extends HttpServlet {

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

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SocioConvenio socio_convenio = new SocioConvenio();
            SocioConvenioDAO socio_convenioDAO = new SocioConvenioDAO();
      

            socio_convenio.setCpf(request.getParameter("cpf"));
            socio_convenio.setId_convenio(Integer.parseInt(request.getParameter("id_convenio")));
            socio_convenio.setNome(request.getParameter("nome"));
            socio_convenio.setRg(request.getParameter("rg"));
            
            
            
 
            socio_convenioDAO.inserir(socio_convenio);

           
            response.sendRedirect("GerenciamentoConvenio/EditarConvenio.jsp?id="+request.getParameter("id_convenio"));
        } catch (Exception e) {
            
            
             response.sendRedirect("GerenciamentoConvenio/CadastroSocioConvenio.jsp?erro=1");
            
            
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
