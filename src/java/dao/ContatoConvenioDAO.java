
package dao;

import bd.Conexao;
import beans.ContatoConvenio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ContatoConvenioDAO {

    Conexao con = null;
    Connection objConnection = null;
    PreparedStatement pstm;
    ResultSet rs;
    ContatoConvenio contato_convenio;

    public ContatoConvenioDAO() {
        con = new Conexao();

    }

    public void inserir(ContatoConvenio contato_convenio) {
        String sql = "insert into contato_convenio values(default,?,?,?,?,?,?,?,default,?)";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setString(1, contato_convenio.getNome());
            pstm.setString(2, contato_convenio.getEmail());
            pstm.setString(3, contato_convenio.getCargo());
            pstm.setString(4, contato_convenio.getSetor());
            pstm.setString(5, contato_convenio.getHorario());
            pstm.setString(6, contato_convenio.getTelefone());
            pstm.setString(7, contato_convenio.getCelular());
            pstm.setInt(8, contato_convenio.getId_convenio());

            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void excluir(int id) {
        String sql = "UPDATE contato_convenio SET status = ? where id_contato_convenio = ?";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setInt(2, id);
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List listarContatoConvenio(String parametro, String nome) throws Exception {

        List<ContatoConvenio> listContatoConvenio = new ArrayList<ContatoConvenio>();
        String sql = "";
        if (nome.equals("") || nome == null) {
            sql = "select * from contato_convenio where status = 1";
            nome = "";
        } else {
            
                sql = "select * from contato_convenio where " + parametro + " = '" + nome +"' and status = 1";
            
        }

        try {

            objConnection = con.conectar();

            pstm = this.objConnection.prepareStatement(sql);

           

            rs = pstm.executeQuery();

            while (rs.next()) {
                contato_convenio = new ContatoConvenio();
                contato_convenio.setId_contato(rs.getInt("id_contato_convenio"));
                contato_convenio.setCargo(rs.getString("cargo"));
                contato_convenio.setCelular(rs.getString("celular"));
                contato_convenio.setEmail(rs.getString("email"));
                contato_convenio.setHorario(rs.getString("horario"));
                contato_convenio.setNome(rs.getString("nome"));
                contato_convenio.setSetor(rs.getString("setor"));
                contato_convenio.setTelefone(rs.getString("telefone"));
                contato_convenio.setId_convenio(Integer.parseInt(rs.getString("id_convenio")));
                listContatoConvenio.add(contato_convenio);
            }

        } catch (SQLException ex) {
            System.out.println("Erro na consulta" + ex.getMessage());
            throw new Exception(ex);
        }
        return listContatoConvenio;

    }
    
    public ContatoConvenio consultarContatoConvenio(String parametro, String nome) throws Exception {

       
        String sql =  "select * from contato_convenio where " + parametro + " = '" + nome +"' and status = 1";
            

        try {

            objConnection = con.conectar();

            pstm = this.objConnection.prepareStatement(sql);

            

            rs = pstm.executeQuery();

            while (rs.next()) {
                contato_convenio = new ContatoConvenio();
                contato_convenio.setId_contato(rs.getInt("id_contato_convenio"));
                contato_convenio.setCargo(rs.getString("cargo"));
                contato_convenio.setCelular(rs.getString("celular"));
                contato_convenio.setEmail(rs.getString("email"));
                contato_convenio.setHorario(rs.getString("horario"));
                contato_convenio.setNome(rs.getString("nome"));
                contato_convenio.setSetor(rs.getString("setor"));
                contato_convenio.setTelefone(rs.getString("telefone"));
                contato_convenio.setId_convenio(Integer.parseInt(rs.getString("id_convenio")));
            }

        } catch (SQLException ex) {
            System.out.println("Erro na consulta" + ex.getMessage());
            throw new Exception(ex);
        }
        return contato_convenio;

    }
    
    public void editar(int id, ContatoConvenio contato_convenio) {
        String sql = "UPDATE contato_convenio SET nome = ?, email = ?, cargo = ?, setor = ?, horario = ?, telefone = ?, celular = ? where id_contato_convenio = ?";
       
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setString(1, contato_convenio.getNome());
            pstm.setString(2, contato_convenio.getEmail());
            pstm.setString(3, contato_convenio.getCargo());
            pstm.setString(4, contato_convenio.getSetor());
            pstm.setString(5, contato_convenio.getHorario());
            pstm.setString(6, contato_convenio.getTelefone());
            pstm.setString(7, contato_convenio.getCelular());
            pstm.setInt(8, contato_convenio.getId_contato());
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}

