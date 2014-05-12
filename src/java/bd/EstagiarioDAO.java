/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd;

import beans.Estagiario;
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
public class EstagiarioDAO {
    ConexaoRenan con;
    PreparedStatement pstm;
    ResultSet rs;

    public EstagiarioDAO() {
        con = new ConexaoRenan();
    }

    public void inserir(Estagiario es) {
        String sql = "INSERT INTO curso VALUES(default, ?, ?, ?);";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, es.getNome());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public void alterarNome(Estagiario es) {
        String sql = "UPDATE curso SET nome=? where id=?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, es.getNome());
            pstm.setInt(2, es.getId());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public void alterarTipo(Estagiario es) {
        String sql = "UPDATE curso SET tipo=? where id=?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setInt(2, es.getId());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Estagiario> consultar(String nome) {
        
        String sql = "SELECT * FROM curso WHERE nome like ? and status = 1;";
        ArrayList<Estagiario> listCurso = new ArrayList();
        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setString(1, "%"+nome+"%");
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                Estagiario es = new Estagiario();
                es.setId(rs.getInt("id"));
                listCurso.add(es);
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCurso;
    }

    public ArrayList<Estagiario> listar() {
        ArrayList<Estagiario> lista = new ArrayList();
        String sql = "SELECT * FROM curso where status = 1";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                Estagiario es = new Estagiario();
                es.setId(rs.getInt("id"));
                lista.add(es);
                
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void alterarCurso(Estagiario es) {
        String sql = "UPDATE curso SET nome=? ,turno=? ,tipo=? where id=?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setInt(4, es.getId());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public void excluir(Estagiario es) {
        String sql = "UPDATE curso SET status = ? where id = ?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setInt(2, es.getId());
            pstm.execute();

        } catch (SQLException ex) {
 
        }
    }
    
    public Estagiario consultarId(int id) {
        Estagiario es = new Estagiario();
        String sql = "SELECT * FROM curso WHERE id = ?";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                es.setId(rs.getInt("id"));
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return es;
    }
}
