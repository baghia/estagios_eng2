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

    public void inserir(EnderecoEstagiario es) {
        String sql = "INSERT INTO enderecoEstagiario VALUES(default, ?, ?, ?, ?, ?);";
        try {
            pstm = con.conectar().prepareStatement(sql);
            pstm.setString(1, es.getLogradouro());
            pstm.setString(1, es.getBairro());
            pstm.setString(1, es.getCidade());
            pstm.setString(1, es.getEstado());
            pstm.setString(1, es.getCep());
            pstm.executeQuery();
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {

        }
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
                
            }
            pstm.close();
            con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
