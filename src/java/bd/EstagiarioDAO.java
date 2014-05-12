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
            pstm.setString(10, es.getDisponibilidadeHorarioEstagio());
            pstm.setString(11, es.getEmpresaTrabalha());
            pstm.setString(12, es.getHorarioTrabalha());
            
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
                es.setDtNascimento("dtnascimento");
                es.setPai("nomepai");
                es.setMae("nomemae");
                es.setDisponibilidadeHorarioEstagio("disponibilidadehorarioestagio");
                es.setEmpresaTrabalha("empresatrabalha");
                es.setHorarioTrabalha("horariotrabalha");                
                lista.add(es);
                
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
