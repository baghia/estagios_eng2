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
                Curso c = cDAO.consultarId(rs.getInt("idcurso"));
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
    
    public static void main(String[] args) {
        CursoDAO c = new CursoDAO();
        ContatoEstagiario ce  = new ContatoEstagiario();
        ce.setValor("99931111");
        ContatoEstagiarioDAO cedao = new ContatoEstagiarioDAO();
        
        EnderecoEstagiario e = new EnderecoEstagiario();
        EnderecoEstagiarioDAO ee = new EnderecoEstagiarioDAO();
        e.setLogradouro("Rua 19 de maio");
        e.setBairro("Bairro Flor do Nascer");
        e.setCidade("Videira");
        e.setCep("89560000");
        e.setEstado("SC");
        
        Estagiario es = new Estagiario();
        EstagiarioDAO esDao = new EstagiarioDAO();
        es.setMatricula(1234567);
        es.setNome("Teste da Silva");
        es.setCPF("00000000000");
        es.setRG("11111111");
        es.setMae("Mãe da Silva");
        es.setPai("Pai da Silva");
        es.setContato(cedao.inserir(ce));
        es.setEndereco(ee.inserir(e));
        es.setCurso(c.consultarRetornaID("Ciência da Computação"));
        es.setDisponibilidadeHorarioEstagio("Tarde");
        es.setDtNascimento("03/10/1993");
        es.setEmpresaTrabalha("Não Trabalha");
        es.setHorarioTrabalha(" - ");
        esDao.inserir(es);
    }
}
