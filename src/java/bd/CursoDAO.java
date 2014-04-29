/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;

/**
 *
 * @author Renan Huf Silveira
 */
public class CursoDAO {

    ConexaoRenan con;
    PreparedStatement pstm;
    ResultSet rs;

    public CursoDAO() {
        con = new ConexaoRenan();
    }

    public void inserir(Curso curso) {
        String sql = "INSERT INTO curso VALUES(default, ?, ?, ?);";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, curso.getNome());
            pstm.setString(2, curso.getTipo());
            pstm.setString(3, curso.getTurno());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public void alterarNome(Curso curso) {
        String sql = "UPDATE curso SET nome=? where id=?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, curso.getNome());
            pstm.setInt(2, curso.getId());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public void alterarTipo(Curso curso) {
        String sql = "UPDATE curso SET tipo=? where id=?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, curso.getTipo());
            pstm.setInt(2, curso.getId());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Curso> consultar(String nome) {
        
        String sql = "SELECT * FROM curso WHERE nome like ? and status = 1;";
        ArrayList<Curso> listCurso = new ArrayList();
        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setString(1, "%"+nome+"%");
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setTipo(rs.getString("tipo"));
                curso.setTurno(rs.getString("turno"));
                listCurso.add(curso);
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCurso;
    }

    public ArrayList<Curso> listar() {
        ArrayList<Curso> lista = new ArrayList();
        String sql = "SELECT * FROM curso where status = 1";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setTipo(rs.getString("tipo"));
                curso.setTurno(rs.getString("turno"));
                lista.add(curso);
                
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void alterarCurso(Curso curso) {
        String sql = "UPDATE curso SET nome=? ,turno=? ,tipo=? where id=?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, curso.getNome());
            pstm.setString(2, curso.getTurno());
            pstm.setString(3, curso.getTipo());
            pstm.setInt(4, curso.getId());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public void excluir(Curso curso) {
        String sql = "UPDATE curso SET status = ? where id = ?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setInt(2, curso.getId());
            pstm.execute();

        } catch (SQLException ex) {
 
        }
    }
    
    public Curso consultarId(int id) {
        Curso curso = new Curso();
        String sql = "SELECT * FROM curso WHERE id = ?";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setTipo(rs.getString("tipo"));
                curso.setTurno(rs.getString("turno"));
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }
}
