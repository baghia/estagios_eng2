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
import beans.Curso;
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
@WebServlet(name = "CadastroEstagiario", urlPatterns = {"/CadastroEstagiario"})
public class CadastroEstagiario extends HttpServlet {

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
            EnderecoEstagiarioDAO eeDao = new EnderecoEstagiarioDAO();
            EnderecoEstagiario ee = new EnderecoEstagiario();
            ContatoEstagiarioDAO ceDao = new ContatoEstagiarioDAO();
            ContatoEstagiario ce = new ContatoEstagiario();
            CursoDAO cDao = new CursoDAO();
            Curso c = new Curso();
            EstagiarioDAO eDao = new EstagiarioDAO();
            Estagiario e = new Estagiario();
            ce.setValor(request.getParameter("contatoValor"));
            ee.setLogradouro(request.getParameter("logradouro"));
            ee.setBairro(request.getParameter("bairro"));
            ee.setCidade(request.getParameter("cidade"));
            ee.setCep(request.getParameter("cep"));
            ee.setEstado(request.getParameter("estado"));
            e.setContato(ceDao.inserir(ce));
            e.setEndereco(eeDao.inserir(ee));
            e.setCurso(cDao.consultarRetornaID(request.getParameter("curso")));
            e.setMatricula(Integer.parseInt(request.getParameter("matricula")));
            e.setNome(request.getParameter("nome"));
            e.setRG(request.getParameter("rg"));
            e.setCPF(request.getParameter("cpf"));
            e.setDtNascimento(request.getParameter("dtNascimento"));
            e.setPai(request.getParameter("nomePai"));
            e.setMae(request.getParameter("nomeMae"));
            e.setDisponibilidadeHorarioEstagio(request.getParameter("disponibilidade"));
            e.setEmpresaTrabalha(request.getParameter("empresa"));
            response.sendRedirect("GerenciamentoEstagiario.jsp");
        } catch (Exception e) {
            
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
