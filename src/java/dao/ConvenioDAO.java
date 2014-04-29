
package dao;

import bd.Conexao;
import beans.Convenio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConvenioDAO {

    Conexao con = null;
    Connection objConnection = null;
    PreparedStatement pstm;
    ResultSet rs;
    Convenio convenios;

    public ConvenioDAO() {
        con = new Conexao();

    }

    public void inserir(Convenio convenios) {
        String sql = "insert into convenios values(default,?,?,?,?,?,default)";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setString(1, convenios.getNome_da_empresa());
            pstm.setString(2, convenios.getCnpj());
            pstm.setString(3, convenios.getArea_de_atuacao());
            pstm.setString(4, convenios.getData_inicio_convenio());
            pstm.setString(5, convenios.getDuracao_convenio());
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void excluir(int id) {
        String sql = "UPDATE convenios SET status = ? where id_convenios = ?";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setInt(2, id);
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List listarConvenios(String parametro, String nome) throws Exception {

        List<Convenio> listConvenios = new ArrayList<Convenio>();
        String sql = "";
        if (nome.equals("") || nome == null) {
            sql = "select * from convenios where status = 1";
            nome = "";
        } else {
            
            sql = "select * from convenios where upper("+parametro+") like upper(?) and status = 1";
            
        }

        try {

            objConnection = con.conectar();

            pstm = this.objConnection.prepareStatement(sql);

            if (!nome.equals("")) {
                //pstm.setString(1, parametro);
                pstm.setString(1, "%" + nome + "%");
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                convenios = new Convenio();
                convenios.setId_convenio(rs.getInt("id_convenios"));
                convenios.setArea_de_atuacao(rs.getString("area_de_atuacao"));
                convenios.setCnpj(rs.getString("cnpj"));
                convenios.setData_inicio_convenio(rs.getString("data_inicio_convenio"));
                convenios.setDuracao_convenio(rs.getString("area_de_atuacao"));
                convenios.setNome_da_empresa(rs.getString("nome_da_empresa"));
                listConvenios.add(convenios);
            }

        } catch (SQLException ex) {
            System.out.println("Erro na consulta" + ex.getMessage());
            throw new Exception(ex);
        }
        return listConvenios;

    }
    
     public Convenio consultarConvenios(String parametro, String nome) throws Exception {

        String sql = "select * from convenios where " + parametro + " = '"+nome+"' and status = 1";
            

        try {
            objConnection = con.conectar();

            pstm = this.objConnection.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                convenios = new Convenio();
                convenios.setId_convenio(rs.getInt("id_convenios"));
                convenios.setArea_de_atuacao(rs.getString("area_de_atuacao"));
                convenios.setCnpj(rs.getString("cnpj"));
                convenios.setData_inicio_convenio(rs.getString("data_inicio_convenio"));
                convenios.setDuracao_convenio(rs.getString("area_de_atuacao"));
                convenios.setNome_da_empresa(rs.getString("nome_da_empresa"));
               
            }

        } catch (SQLException ex) {
            System.out.println("Erro na consulta" + ex.getMessage());
            throw new Exception(ex);
        }
        return convenios;

    }
    
    public void editar(int id, Convenio convenios) {
        String sql = "UPDATE convenios SET nome_da_empresa = ?, cnpj = ?, area_de_atuacao = ? ,  data_inicio_convenio = ?, duracao_convenio = ? where id_convenios = ?";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setString(1, convenios.getNome_da_empresa());
            pstm.setString(2, convenios.getCnpj());
            pstm.setString(3, convenios.getArea_de_atuacao());
            pstm.setString(4, convenios.getData_inicio_convenio());
            pstm.setString(5, convenios.getDuracao_convenio());
            pstm.setInt(6, convenios.getId_convenio());
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConvenioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
