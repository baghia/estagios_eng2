package dao;

import bd.Conexao;
import beans.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDAO {

    Conexao con = null;
    Connection objConnection = null;
    PreparedStatement pstm;
    ResultSet rs;
    Endereco endereco;

    public EnderecoDAO() {
        con = new Conexao();

    }

    public void inserir(Endereco endereco) {
        String sql = "insert into endereco values(default,?,?,?,?,?,?,?,?,?,default,?)";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setString(1, endereco.getLogradouro());
            pstm.setString(2, endereco.getBairro());
            pstm.setString(3, endereco.getCidade());
            pstm.setString(4, endereco.getEstado());
            pstm.setString(5, endereco.getCep());
            pstm.setString(6, endereco.getTelefone());
            pstm.setString(7, endereco.getTelefax());
            pstm.setString(8, endereco.getEmail1());
            pstm.setString(9, endereco.getEmail2());
            pstm.setInt(10, endereco.getId_convenio());
          
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void excluir(int id) {
        String sql = "UPDATE endereco SET status = ? where id_endereco = ?";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setInt(2, id);
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List listarEndereco(String parametro, String nome) throws Exception {

        List<Endereco> listEndereco = new ArrayList<Endereco>();
        String sql = "";
        if (nome.equals("") || nome == null) {
            sql = "select * from endereco where status = 1";
            nome = "";
        } else {
            
                sql = "select * from endereco where " + parametro + " = " + nome + " and status = 1";
            
        }

        try {

            objConnection = con.conectar();

            pstm = this.objConnection.prepareStatement(sql);

            if (!nome.equals("") && !parametro.equals("id")) {
                //pstm.setString(1, parametro);
                pstm.setString(1, "%" + nome + "%");
            }

            rs = pstm.executeQuery();

            while (rs.next()) {
                endereco = new Endereco();
                endereco.setId_endereco(rs.getInt("id_endereco"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getString("cep"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEmail1(rs.getString("email1"));
                endereco.setEmail2(rs.getString("email2"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setTelefax(rs.getString("telefax"));
                endereco.setTelefone(rs.getString("telefone"));
                listEndereco.add(endereco);

            }

        } catch (SQLException ex) {
            System.out.println("Erro na consulta" + ex.getMessage());
            throw new Exception(ex);
        }
        return listEndereco;

    }
    
    public Endereco consultarEndereco(String parametro, String nome) throws Exception {

        String sql = "select * from endereco where " + parametro + " = '" + nome + "' and status = 1";
            

        try {

            objConnection = con.conectar();

            pstm = this.objConnection.prepareStatement(sql);

            

            rs = pstm.executeQuery();

            while (rs.next()) {
                endereco = new Endereco();
                endereco.setId_endereco(rs.getInt("id_endereco"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getString("cep"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEmail1(rs.getString("email1"));
                endereco.setEmail2(rs.getString("email2"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setTelefax(rs.getString("telefax"));
                endereco.setTelefone(rs.getString("telefone"));
               

            }

        } catch (SQLException ex) {
            System.out.println("Erro na consulta" + ex.getMessage());
            throw new Exception(ex);
        }
        return endereco;

    }

    public void editar(int id, Endereco endereco) {
        String sql = "UPDATE endereco SET logradouro = ?, bairro  = ?, cidade = ?, estado = ?, cep = ? , telefone = ? , telefax = ? , email1 = ? , email2 = ?  where id_endereco = ?";
        try {
            objConnection = con.conectar();
            pstm = this.objConnection.prepareStatement(sql);
            pstm = this.objConnection.prepareStatement(sql);
            pstm.setString(1, endereco.getLogradouro());
            pstm.setString(2, endereco.getBairro());
            pstm.setString(3, endereco.getCidade());
            pstm.setString(4, endereco.getEstado());
            pstm.setString(5, endereco.getCep());
            pstm.setString(6, endereco.getTelefone());
            pstm.setString(7, endereco.getTelefax());
            pstm.setString(8, endereco.getEmail1());
            pstm.setString(9, endereco.getEmail2());
            pstm.setInt(10, endereco.getId_endereco());
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
