package org.viajou.crudviajou.admin;

import org.viajou.crudviajou.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    //Declarando as variaveis do método
//    private Connection conn;
//    private PreparedStatement pstmt;
//    private Conexao conexao = new Conexao();
    
// metodo para leitura da tabela admin
    public ResultSet buscar(){
        Conexao conexao = new Conexao();
        conexao.conectar();
        ResultSet rset = null;
        try {
            Connection conn = conexao.getConn();
            //usando o pstmt para fazer um instrução sql
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin");
            rset = pstmt.executeQuery();
            return rset;
            // Fazendo o catch para verificar se o sql apresentar algum erro séra apresentado retonar uma string
        }catch (SQLException sqle){
            return rset;
        }finally {
            //usando o finally para toda fez antes do return use o método desconectar
            conexao.desconectar();
        }
    }
    //Uma sobrecarga no metodo buscar, para fazer uma leitura na tabela pela pk dela
    public ResultSet buscar(int id){
        //declarando objetos
        Conexao conexao = new Conexao();
        conexao.conectar();
        ResultSet rset = null;
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("Select * from admin where id = ? ");
            pstmt.setInt(1,id);
            rset = pstmt.executeQuery();
            return rset;
        }catch (SQLException sqle){
            //cath para retornar erro de Sql
            return rset;
        }
        finally {
            //usando o finally para toda vez antes do return use o método desconectar
            conexao.desconectar();
        }
    }
    //método para adicionar um admim na tabela
    public int inserirAdmin(Admin admin){
        //declarando objetos
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt  = conn.prepareStatement("INSERT INTO admin(nome,email,senha) VALUES (?,?,?)");
            pstmt.setString(1,admin.getNome());
            pstmt.setString(2, admin.getEmail());
            pstmt.setString(3,admin.getSenha());
            pstmt.execute();
            return 1;
        }catch (SQLException sqle){
            // retornado -1 para enviar para uma pagina especifica
            return -1;
        }finally {
            //usando o finally para toda vez antes do return use o método desconectar
            conexao.desconectar();
        }
    }
    // Os métodos a seguir se referem a mudança de um campo na tabela admin
    // Método para mudar o nome de usuario dos admin
    public int alterarNome(int id,Admin admin){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            //verificando se existe o adminitrador
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET nome =  ? WHERE id = ? ");
                //usar metodods get e set da classe admim, execto id
                pstmt.setString(1, admin.getNome());
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }
        finally {
            //usando o finally para toda vez antes do return use o método desconectar
            conexao.desconectar();
        }
    }
    // Método para mudar o e-mail de usuario dos admin
    public int alterarEmail(int id, Admin admin){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            //verificando se existe o adminitrador
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET email =  ? WHERE id = ? ");
                pstmt.setString(1, admin.getEmail());
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }
        finally {
            conexao.desconectar();
        }
    }
    // Método para mudar a senha de usuario dos admin
    public int alterarSenha(int id, Admin admin){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            //verificando se existe o adminitrador
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET senha =  ? WHERE id = ? ");
                pstmt.setString(1, admin.getSenha());
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }
        finally {
            //usando o finally para toda vez antes do return use o método desconectar
            conexao.desconectar();
        }
    }
    // Método excluir um usuario da tabela admin
    public int alterarAdmin(int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            //verificando se existe o adminitrador
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("Delete from admin where id = ?  ");
                pstmt.setInt(1, id);
                pstmt.execute();
                return 0;
            }
            return 1;
        }catch (SQLException sqle){
            return -1;
        }finally {
            //usando o finally para toda vez antes do return use o método desconectar
            conexao.desconectar();
        }
    }
}
