/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import beans.ContatoEstagiario;
import beans.Estagiario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan Huf Silveira
 */
public class ContatoEstagiarioDAO {

    ConexaoRenan con;
    PreparedStatement pstm;
    ResultSet rs;

    public ContatoEstagiarioDAO() {
        con = new ConexaoRenan();
    }

    public int inserir(ContatoEstagiario es) {
        String sql = "INSERT INTO contato VALUES(default, ?);";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, es.getValor());
            pstm.executeQuery();            
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
        return consultarValor(es.getValor());
    }

    public ArrayList<ContatoEstagiario> listar() {
        ArrayList<ContatoEstagiario> lista = new ArrayList();
        String sql = "SELECT * FROM contato";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                ContatoEstagiario es = new ContatoEstagiario();
                es.setId(rs.getInt("id"));
                es.setValor(rs.getString("valor"));
                lista.add(es);

            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ContatoEstagiario consultarId(int id) {
        ContatoEstagiario curso = new ContatoEstagiario();
        String sql = "SELECT * FROM contato WHERE id = ?";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros

                curso.setId(rs.getInt("id"));
                curso.setValor(rs.getString("valor"));

            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }

    private int consultarValor(String valor) {
        String sql = "SELECT * FROM contato WHERE valor = ?";
        int i = 0;
        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setString(1, valor);
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
        ContatoEstagiario ce = new ContatoEstagiario();
        ce.setValor("35341111");
        ContatoEstagiarioDAO dao = new ContatoEstagiarioDAO();
        System.out.println(dao.inserir(ce));
    }
}
