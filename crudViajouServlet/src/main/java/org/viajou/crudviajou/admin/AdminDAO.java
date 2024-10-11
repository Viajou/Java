package org.viajou.crudviajou.admin;

import org.viajou.crudviajou.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    //Declarando as variaveis do método
    private Connection conn;
    private PreparedStatement psmt;
    private Conexao conexao = new Conexao();
    private Admin admin = new Admin();
    // metodo para leitura da tabela admin
    public ResultSet buscar(){
        conexao.conectar();
        ResultSet rset = null;
        try {
            //usando o psmt para fazer um instrução sql
            psmt = conn.prepareStatement("SELECT * FROM admin");
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
    public ResultSet buscar(int pk){
        conexao.conectar();
        ResultSet rset = null;
        try {
            psmt = conn.prepareStatement("Select * from admin where id = ? ");
            psmt.setInt(1,pk);
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
    public int inserirAdmin(){
        conexao.conectar();
        try {
            psmt = conn.prepareStatement("INSERT INTO admin VALUES (?,?,?)");
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
    public int atualizarNome(int id){
        conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            //verificando se existe o adminitrador
            if (busca.next()) {
                psmt = conn.prepareStatement("UPDATE admin SET nome =  ? WHERE id = ? ");
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
    public int atualizarEmail(int id){
       conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            //verificando se existe o adminitrador
            if (busca.next()) {
                psmt = conn.prepareStatement("UPDATE admin SET email =  ? WHERE id = ? ");
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
    public int atualizarSenha(int id){
        conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            //verificando se existe o adminitrador
            if (busca.next()) {
                psmt = conn.prepareStatement("UPDATE admin SET senha =  ? WHERE id = ? ");
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
    public int deletarAdmin(int id){
        conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            //verificando se existe o adminitrador
            if (busca.next()) {
                psmt = conn.prepareStatement("Delete from admin where id = ?  ");
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
