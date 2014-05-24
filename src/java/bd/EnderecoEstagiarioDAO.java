/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd;

import beans.ContatoEstagiario;
import beans.EnderecoEstagiario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan Huf Silveira
 */
public class EnderecoEstagiarioDAO {
    ConexaoRenan con;
    PreparedStatement pstm;
    ResultSet rs;

    public EnderecoEstagiarioDAO() {
        con = new ConexaoRenan();
    }

    public int inserir(EnderecoEstagiario es) {
        String sql = "INSERT INTO enderecoestagiario VALUES(default, ?, ?, ?, ?, ?);";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, es.getLogradouro());
            pstm.setString(2, es.getBairro());
            pstm.setString(3, es.getCidade());
            pstm.setString(4, es.getEstado());
            pstm.setString(5, es.getCep());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
        return consultarValor(es);
    }
    
    public ArrayList<EnderecoEstagiario> listar() {
        ArrayList<EnderecoEstagiario> lista = new ArrayList();
        String sql = "SELECT * FROM contato";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                EnderecoEstagiario es = new EnderecoEstagiario();
                es.setId(rs.getInt("id"));
                es.setLogradouro(rs.getString("logradouro"));
                es.setBairro(rs.getString("bairro"));
                es.setCidade(rs.getString("cidade"));
                es.setEstado(rs.getString("estado"));
                es.setCep(rs.getString("cep"));
                lista.add(es);
                System.out.println("tamanho "+ lista.size());
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public EnderecoEstagiario consultarId(int id) {
        EnderecoEstagiario curso = new EnderecoEstagiario();
        String sql = "SELECT * FROM enderecoestagiario WHERE id = ?";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                
                curso.setId(rs.getInt("id"));
                curso.setLogradouro(rs.getString("logradouro"));
                curso.setBairro(rs.getString("bairro"));
                curso.setCidade(rs.getString("cidade"));
                curso.setEstado(rs.getString("estado"));
                curso.setCep(rs.getString("cep"));
                
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }
    
    private int consultarValor(EnderecoEstagiario es) {
        String sql = "SELECT * FROM enderecoestagiario WHERE logradouro = ? and bairro = ? and Cidade = ? and estado = ? and cep = ? LIMIT 1";
        int i = 0;
        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setString(1, es.getLogradouro());
            pstm.setString(2, es.getBairro());
            pstm.setString(3, es.getCidade());
            pstm.setString(4, es.getEstado());
            pstm.setString(5, es.getCep());
            rs = pstm.executeQuery();

            while (rs.next()) { 
                i = (rs.getInt("id"));      
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    public static void main(String[] args) {
        EnderecoEstagiario e = new EnderecoEstagiario();
        EnderecoEstagiarioDAO ee = new EnderecoEstagiarioDAO();
        e.setLogradouro("Rua 10 de maio");
        e.setBairro("Bairoo Flor do Nascer");
        e.setCidade("Videira");
        e.setCep("89560000");
        e.setEstado("SC");
        System.out.println(ee.inserir(e));
    }
}
