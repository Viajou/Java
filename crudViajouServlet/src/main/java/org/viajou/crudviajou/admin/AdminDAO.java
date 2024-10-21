package org.viajou.crudviajou.admin;

import org.viajou.crudviajou.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {


    // metodo para leitura da tabela admin
    public ResultSet buscar(){
        Conexao conexao = new Conexao();
        conexao.conectar();
        ResultSet rset = null;
        try {
            Connection conn = conexao.getConn();
            //usando o psmt para fazer um instrução sql
             PreparedStatement psmt = conn.prepareStatement("SELECT * FROM admin");
            rset = psmt.executeQuery();
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
            PreparedStatement psmt = conn.prepareStatement("Select * from admin where id = ? ");
            psmt.setInt(1,id);
            rset = psmt.executeQuery();
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
            PreparedStatement psmt  = conn.prepareStatement("INSERT INTO admin(nome,email,senha) VALUES (?,?,?)");
            psmt.setString(1,admin.getNome());
            psmt.setString(2, admin.getEmail());
            psmt.setString(3,admin.getSenha());
            psmt.execute();
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
                PreparedStatement psmt = conn.prepareStatement("UPDATE admin SET nome =  ? WHERE id = ? ");
                //usar metodods get e set da classe admim, execto id
                psmt.setString(1, admin.getNome());
                psmt.setInt(2, id);
                psmt.execute();
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
                PreparedStatement psmt = conn.prepareStatement("UPDATE admin SET email =  ? WHERE id = ? ");
                psmt.setString(1, admin.getEmail());
                psmt.setInt(2, id);
                psmt.execute();
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
                PreparedStatement psmt = conn.prepareStatement("UPDATE admin SET senha =  ? WHERE id = ? ");
                psmt.setString(1, admin.getSenha());
                psmt.setInt(2, id);
                psmt.execute();
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
                PreparedStatement psmt = conn.prepareStatement("Delete from admin where id = ?  ");
                psmt.setInt(1, id);
                psmt.execute();
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
