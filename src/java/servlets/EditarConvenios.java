/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import beans.Convenio;
import beans.Endereco;
import dao.ConvenioDAO;
import dao.EnderecoDAO;
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
@WebServlet(name = "EditarConvenios", urlPatterns = {"/EditarConvenios"})
public class EditarConvenios extends HttpServlet {

    
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
            Convenio convenio = new Convenio();
            Endereco endereco = new Endereco();
            ConvenioDAO convenioDao = new ConvenioDAO();
            EnderecoDAO enderecoDao = new EnderecoDAO();

            convenio.setId_convenio(Integer.parseInt(request.getParameter("id_convenio")));
            convenio.setNome_da_empresa(request.getParameter("nome_da_empresa"));
            convenio.setCnpj(request.getParameter("cnpj"));
            convenio.setArea_de_atuacao(request.getParameter("area_de_atuacao"));
            convenio.setData_inicio_convenio(request.getParameter("data_inicio_convenio"));
            convenio.setDuracao_convenio(request.getParameter("duracao_convenio"));
            convenioDao.editar(convenio.getId_convenio(),convenio);
            //convenio = convenioDao.consultarConvenios("cnpj", convenio.getCnpj());
            
            endereco.setId_endereco(Integer.parseInt(request.getParameter("id_endereco")));
            endereco.setLogradouro(request.getParameter("logradouro"));
            endereco.setBairro(request.getParameter("bairro"));
            endereco.setCidade(request.getParameter("cidade"));
            endereco.setEstado(request.getParameter("estado"));
            endereco.setCep(request.getParameter("cep"));
            endereco.setTelefone(request.getParameter("telefone"));
            endereco.setTelefax(request.getParameter("telefax"));
            endereco.setEmail1(request.getParameter("email1"));
            endereco.setEmail2(request.getParameter("email2"));
            endereco.setId_convenio(convenio.getId_convenio());
            
            enderecoDao.editar(endereco.getId_endereco(),endereco);
           
            response.sendRedirect("Convenios.jsp");
        } catch (Exception e) {
            
            
            response.sendRedirect("EditarConvenio.jsp?id="+request.getParameter("id_convenio"));
            
            
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
