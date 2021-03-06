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
            CursoDAO c = new CursoDAO();
            ContatoEstagiario ce  = new ContatoEstagiario();
            ce.setValor(request.getParameter("contatoValor"));
            ContatoEstagiarioDAO cedao = new ContatoEstagiarioDAO();

            EnderecoEstagiario e = new EnderecoEstagiario();
            EnderecoEstagiarioDAO ee = new EnderecoEstagiarioDAO();
            e.setLogradouro(request.getParameter("logradouro"));
            e.setBairro(request.getParameter("bairro"));
            e.setCidade(request.getParameter("cidade"));
            e.setEstado(request.getParameter("estado"));
            e.setCep(request.getParameter("cep"));

            Estagiario es = new Estagiario();
            EstagiarioDAO esDao = new EstagiarioDAO();
            es.setMatricula(Integer.parseInt(request.getParameter("matricula")));
            System.out.println(es.getMatricula());
            es.setNome(request.getParameter("nome"));
            System.out.println(es.getNome());
            es.setCPF(request.getParameter("cpf"));
            System.out.println(es.getCPF());
            es.setRG(request.getParameter("rg"));
            System.out.println(es.getRG());
            es.setMae(request.getParameter("nomeMae"));
            System.out.println(es.getMae());
            es.setPai(request.getParameter("nomePai"));
            System.out.println(es.getPai());
            es.setContato(cedao.inserir(ce));//
            System.out.println(es.getContato());
            es.setEndereco(ee.inserir(e));//
            System.out.println(es.getEndereco());
            es.setCurso(c.consultarRetornaID(request.getParameter("curso")));
            System.out.println(es.getCurso());
            es.setDisponibilidadeHorarioEstagio(request.getParameter("disponibilidade"));
            System.out.println(es.getDisponibilidadeHorarioEstagio());
            es.setDtNascimento(request.getParameter("dtNascimento"));
            System.out.println(es.getDtNascimento());
            es.setEmpresaTrabalha(request.getParameter("empresa"));
            System.out.println(es.getEmpresaTrabalha());
            es.setHorarioTrabalha(request.getParameter("horario"));
            System.out.println(es.getHorarioTrabalha());
            esDao.inserir(es);
        
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
