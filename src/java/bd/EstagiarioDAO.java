/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd;

import beans.ContatoEstagiario;
import beans.Curso;
import beans.EnderecoEstagiario;
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
    CursoDAO cDAO;
    ContatoEstagiarioDAO ctDAO;
    EnderecoEstagiarioDAO eeDAO;
    ResultSet rs;

    public EstagiarioDAO() {
        con = new ConexaoRenan();
    }

    public void inserir(Estagiario es) {
        String sql = "INSERT INTO estagiario VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setInt(1, es.getMatricula());
            pstm.setString(2, es.getNome());
            pstm.setString(3, es.getRG());
            pstm.setString(4, es.getCPF());
            pstm.setString(5, es.getDtNascimento());
            pstm.setString(6, es.getPai());
            pstm.setString(7, es.getMae());
            pstm.setInt(8, es.getContato());
            pstm.setInt(9, es.getEndereco());
            pstm.setString(10, es.getDisponibilidadeHorarioEstagio());
            pstm.setString(11, es.getEmpresaTrabalha());
            pstm.setString(12, es.getHorarioTrabalha());
            pstm.setInt(13, es.getCurso());            
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Estagiario> listar() {
        ArrayList<Estagiario> lista = new ArrayList();
        String sql = "SELECT * FROM estagiario ";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                Estagiario es = new Estagiario();
                es.setId(rs.getInt("id"));
                es.setMatricula(rs.getInt("matricula"));
                es.setNome(rs.getString("nome"));
                es.setRG(rs.getString("rg"));
                es.setCPF(rs.getString("cpf"));
                es.setDtNascimento(rs.getString("dtnascimento"));
                es.setPai(rs.getString("nomepai"));
                es.setMae(rs.getString("nomemae"));
                es.setDisponibilidadeHorarioEstagio(rs.getString("disponibilidadehorarioestagio"));
                es.setEmpresaTrabalha(rs.getString("empresatrabalha"));
                es.setHorarioTrabalha(rs.getString("horariotrabalha"));
                es.setCurso(rs.getInt("idcurso"));
                es.setContato(rs.getInt("idcontatos"));
                es.setEndereco(rs.getInt("idenderecoestagiario"));
                lista.add(es);                
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public ArrayList<Estagiario> consultar(String nome) {
        
        String sql = "SELECT * FROM estagiario WHERE nome like ?;";
        ArrayList<Estagiario> list = new ArrayList();
        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setString(1, "%"+nome+"%");
            rs = pstm.executeQuery();

            while (rs.next()) {    //move o curso de registros
                Estagiario es = new Estagiario();
                es.setId(rs.getInt("id"));
                es.setMatricula(rs.getInt("matricula"));
                es.setNome(rs.getString("nome"));
                es.setRG(rs.getString("rg"));
                es.setCPF(rs.getString("cpf"));
                es.setDtNascimento(rs.getString("dtnascimento"));
                es.setPai(rs.getString("nomepai"));
                es.setMae(rs.getString("nomemae"));
                es.setDisponibilidadeHorarioEstagio(rs.getString("disponibilidadehorarioestagio"));
                es.setEmpresaTrabalha(rs.getString("empresatrabalha"));
                es.setHorarioTrabalha(rs.getString("horariotrabalha"));                
                es.setCurso(rs.getInt("idcurso"));
                es.setContato(rs.getInt("idcontatos"));
                es.setEndereco(rs.getInt("idenderecoestagiario"));
                list.add(es);
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Estagiario consultarId(int id) {
        Estagiario es = new Estagiario();
        String sql = "SELECT * FROM estagiario WHERE id = ?";

        try {
            pstm = this.con.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                es.setId(rs.getInt("id"));
                es.setMatricula(rs.getInt("matricula"));
                es.setNome(rs.getString("nome"));
                es.setRG(rs.getString("rg"));
                es.setCPF(rs.getString("cpf"));
                es.setDtNascimento(rs.getString("dtnascimento"));
                es.setPai(rs.getString("nomepai"));
                es.setMae(rs.getString("nomemae"));
                es.setDisponibilidadeHorarioEstagio(rs.getString("disponibilidadehorarioestagio"));
                es.setEmpresaTrabalha(rs.getString("empresatrabalha"));
                es.setHorarioTrabalha(rs.getString("horariotrabalha"));                
                es.setCurso(rs.getInt("idcurso"));
                es.setContato(rs.getInt("idcontatos"));
                es.setEndereco(rs.getInt("idenderecoestagiario"));
                
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return es;
    }
    
    public void alterarEstagiario(Estagiario es) {
        String sql = "UPDATE estagiario SET matricula = ?, nome = ?, rg = ?, cpf = ?, dtnascimento = ?, nomepai = ?, nomemae = ?, disponibilidadehorarioestagio = ?, empresatrabalha = ?, horariotrabalha = ?, idcurso = ? where id=?";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setInt(1, es.getMatricula());
            System.out.println(es.getMatricula());
            pstm.setString(2, es.getNome());
            System.out.println(es.getNome());
            pstm.setString(3, es.getRG());
            System.out.println(es.getRG());
            pstm.setString(4, es.getCPF());
            System.out.println(es.getCPF());
            pstm.setString(5, es.getDtNascimento());
            System.out.println(es.getDtNascimento());
            pstm.setString(6, es.getPai());
            System.out.println(es.getPai());
            pstm.setString(7, es.getMae());
            System.out.println(es.getMae());
            pstm.setString(8, es.getDisponibilidadeHorarioEstagio());
            System.out.println(es.getDisponibilidadeHorarioEstagio());
            pstm.setString(9, es.getEmpresaTrabalha());
            System.out.println(es.getEmpresaTrabalha());
            pstm.setString(10, es.getHorarioTrabalha());
            System.out.println(es.getHorarioTrabalha());
            pstm.setInt(11, es.getCurso());
            System.out.println(es.getCurso());
            pstm.setInt(12, es.getId());
            System.out.println(es.getId());
            pstm.executeUpdate();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
    }
}
