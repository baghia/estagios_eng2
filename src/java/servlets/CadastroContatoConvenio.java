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
@WebServlet(name = "CadastroContatoConvenio", urlPatterns = {"/CadastroContatoConvenio"})
public class CadastroContatoConvenio extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    
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
            contato_convenio.setId_convenio(Integer.parseInt(request.getParameter("id_convenio")));
            
            
 
            contato_convenioDAO.inserir(contato_convenio);

           
            response.sendRedirect("EditarConvenio.jsp?id="+request.getParameter("id_convenio"));
        } catch (Exception e) {
            
            
             response.sendRedirect("CadastroContatoConvenio.jsp?erro=1");
            
            
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
