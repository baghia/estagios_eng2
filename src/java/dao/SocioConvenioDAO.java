
package dao;

import bd.Conexao;
import beans.SocioConvenio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SocioConvenioDAO {

    Conexao con = null;
    Connection objConnection = null;
    PreparedStatement pstm;
    ResultSet rs;
    SocioConvenio socio_convenio;

    public SocioConvenioDAO() {
        con = new Conexao();

    }

    public void inserir(SocioConvenio socio_convenio) {
        String sql = "insert into socio_convenio values(default,?,?,?,default,?)";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setString(1, socio_convenio.getNome());
            pstm.setString(2, socio_convenio.getRg());
            pstm.setString(3, socio_convenio.getCpf());
            pstm.setInt(4, socio_convenio.getId_convenio());



            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SocioConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void excluir(int id) {
        String sql = "UPDATE socio_convenio SET status = ? where id_socio_convenio = ?";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setInt(2, id);
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SocioConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List listarSocioConvenio(String parametro, String nome) throws Exception {

        List<SocioConvenio> listSocioConvenio = new ArrayList<SocioConvenio>();
        String sql = "";
        if (nome.equals("") || nome == null) {
            sql = "select * from socio_convenio where status = 1";
            nome = "";
        } else {
            
            sql = "select * from socio_convenio where " + parametro + " = '" + nome +"' and status = 1";
            
        }

        try {

            objConnection = con.conectar();

            pstm = this.objConnection.prepareStatement(sql);

            

            rs = pstm.executeQuery();

            while (rs.next()) {
                socio_convenio = new SocioConvenio();
                socio_convenio.setId_socio(rs.getInt("id_socio_convenio"));
                socio_convenio.setCpf(rs.getString("cpf"));
                socio_convenio.setNome(rs.getString("nome"));
                socio_convenio.setRg(rs.getString("rg"));
                socio_convenio.setId_convenio(Integer.parseInt(rs.getString("id_convenio")));
                listSocioConvenio.add(socio_convenio);
            }

        } catch (SQLException ex) {
            System.out.println("Erro na consulta" + ex.getMessage());
            throw new Exception(ex);
        }
        return listSocioConvenio;

    }
    
     public SocioConvenio consultarSocioConvenio(String parametro, String nome) throws Exception {

        String sql = "select * from socio_convenio where " + parametro + " = '" + nome +"' and status = 1";
            
        try {

            objConnection = con.conectar();

            pstm = this.objConnection.prepareStatement(sql);


            rs = pstm.executeQuery();

            while (rs.next()) {
                socio_convenio = new SocioConvenio();
                socio_convenio.setId_socio(rs.getInt("id_socio_convenio"));
                socio_convenio.setCpf(rs.getString("cpf"));
                socio_convenio.setNome(rs.getString("nome"));
                socio_convenio.setRg(rs.getString("rg"));
                socio_convenio.setId_convenio(Integer.parseInt(rs.getString("id_convenio")));
            }

        } catch (SQLException ex) {
            System.out.println("Erro na consulta" + ex.getMessage());
            throw new Exception(ex);
        }
        return socio_convenio;

    }
    
    public void editar(int id, SocioConvenio socio_convenio) {
        String sql = "UPDATE socio_convenio SET nome = ?, cpf = ?, rg = ? where id_socio_convenio = ?";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setString(1, socio_convenio.getNome());
            pstm.setString(2, socio_convenio.getCpf());
            pstm.setString(3, socio_convenio.getRg());
            pstm.setInt(4, socio_convenio.getId_socio());
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SocioConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
