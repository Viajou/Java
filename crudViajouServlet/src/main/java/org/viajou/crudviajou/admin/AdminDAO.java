package org.viajou.crudviajou.admin;

import org.viajou.crudviajou.Conexao;

import java.sql.*;
import java.time.LocalDate;

public class AdminDAO {

// Método para leitura da tabela admin

    public ResultSet buscar(){
    //  Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin");
            rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle) {
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

//  Metodo para leitura da tabela admin com base em um ID
    public ResultSet buscar(int id){

    //  Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin WHERE id = ? ");
            pstmt.setInt(1,id);
            rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
//  Método para adicionar um admim na tabela
    public int inserirAdmin(Admin admin){
    //  Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt  = conn.prepareStatement("INSERT INTO admin(nome,email,senha,url_imagem) VALUES (?,?,?,?)");
            pstmt.setString(1,admin.getNome());
            pstmt.setString(2, admin.getEmail());
            pstmt.setString(3,admin.getSenha());
            pstmt.setString(4,admin.getUrlImagem());
            pstmt.execute();
            return 1;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

// Alterações na tabela admin
    // Método para alterar o nome de usuário do admin
    public int alterarNome(int id, String nome){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();

        // Obtendo a data atual
        Date dataAtual = Date.valueOf(LocalDate.now());
        try {
            // Verificando se o administrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET nome =  ? ,data_atualizacao = ? WHERE id = ? ");
                pstmt.setString(1, nome);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    // Método para alterar o e-mail do admin
    public int alterarEmail(int id, String email){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();

        // Obtendo a data atual
        Date dataAtual = Date.valueOf(LocalDate.now());
        try {
            // Verificando se o adminstrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET email =  ?,data_atualizacao = ? WHERE id = ? ");
                pstmt.setString(1, email);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();

                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    // Método para alterar a senha do admin
    public int alterarSenha(int id, String senha){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();

        // Obtendo a data atual
        Date dataAtual = Date.valueOf(LocalDate.now());
        try {
            // Verificando se o administrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET senha =  ?,data_atualizacao = ? WHERE id = ? ");
                pstmt.setString(1, senha);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();

                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    // Método para alterar a url do admin
    public int alterarUrl(int id, String url_imagem){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();

        // Obtendo a data atual
        Date dataAtual = Date.valueOf(LocalDate.now());
        try {
            // Verificando se o administrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET url_imagem =  ?,,data_atualizacao = ? WHERE id = ? ");
                pstmt.setString(1, url_imagem);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();

                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    // Método para excluir um usuario da tabela admin
    public int deletarAdmin(int id){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se o adminstrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM admin WHERE id = ?");
                pstmt.setInt(1, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
}
