/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import bd.ContatoEstagiarioDAO;
import bd.CursoDAO;
import bd.EnderecoEstagiarioDAO;
import bd.EstagiarioDAO;
import beans.ContatoEstagiario;
import beans.EnderecoEstagiario;
import beans.Estagiario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renan Huf Silveira
 */
@WebServlet(name = "EditarEstagiario", urlPatterns = {"/EditarEstagiario"})
public class EditarEstagiario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            CursoDAO c = new CursoDAO();
            ContatoEstagiario ce  = new ContatoEstagiario();
            ce.setValor(request.getParameter("contatoValor"));
            ce.setId(Integer.parseInt(request.getParameter("idContato")));
            ContatoEstagiarioDAO cedao = new ContatoEstagiarioDAO();
            cedao.alterarContatoEstagiario(ce);
                        
            EnderecoEstagiario e = new EnderecoEstagiario();
            EnderecoEstagiarioDAO ee = new EnderecoEstagiarioDAO();
            e.setId(Integer.parseInt(request.getParameter("idEndereco")));
            e.setLogradouro(request.getParameter("logradouro"));
            e.setBairro(request.getParameter("bairro"));
            e.setCidade(request.getParameter("cidade"));
            e.setEstado(request.getParameter("estado"));
            e.setCep(request.getParameter("cep"));
            ee.alterarEnderecoEstagiario(e);
            
            
            Estagiario es = new Estagiario();
            EstagiarioDAO esDao = new EstagiarioDAO();
            es.setId(Integer.parseInt(request.getParameter("idEstagiario")));
            es.setMatricula(Integer.parseInt(request.getParameter("matricula")));
            es.setNome(request.getParameter("nome"));
            es.setCPF(request.getParameter("cpf"));
            es.setRG(request.getParameter("rg"));
            es.setMae(request.getParameter("nomeMae"));
            es.setPai(request.getParameter("nomePai"));
            es.setCurso(c.consultarRetornaID(request.getParameter("curso")));
            es.setDisponibilidadeHorarioEstagio(request.getParameter("disponibilidade"));
            es.setDtNascimento(request.getParameter("dtNascimento"));
            es.setEmpresaTrabalha(request.getParameter("empresa"));
            es.setHorarioTrabalha(request.getParameter("horario"));
            esDao.alterarEstagiario(es);
        
            response.sendRedirect("GerenciamentoEstagiario/GerenciamentoEstagiario.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("GerenciamentoEstagiario/GerenciamentoEstagiario.jsp");
        } 
       
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
        processRequest(request, response);
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
