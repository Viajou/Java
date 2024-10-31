package com.example.servletviajou.DAO;

import java.sql.*;

import com.example.servletviajou.Model.Plano;
import com.example.servletviajou.Conexao;

public class PlanoDAO  {

// Método para leitura da tabela plano
    public ResultSet buscar(){
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM plano");
            rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException e){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

// Método para leitura da tabela plano com base em um ID
    public ResultSet buscar(int id){
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM plano WHERE id = ? ");
            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException e){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int inserirPlano(Plano plano){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO plano(descricao, livre_propaganda, nome, preco) VALUES (?,?,?,?)");
            pstmt.setString(1, plano.getDescricao());
            pstmt.setBoolean(2, plano.isLivrePropaganda());
            pstmt.setString(3, plano.getNome());
            pstmt.setDouble(4, plano.getPreco());
            pstmt.execute();
            return 1;
        } catch (SQLException sqle){
            return -1;
        } finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }

//  Alterações na tabela plano
    // Método para alterar a descrição do plano
    public int alterarDescricao(int id,String descricao){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o plano existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if(busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET descricao = ? WHERE id = ?");
                pstmt.setString(1, descricao);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam planos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    public int alterarLivrePropaganda(int id, boolean livrePropaganda){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            ResultSet busca = buscar(id);
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET livre_propaganda = ? WHERE id = ?");
                pstmt.setBoolean(1, livrePropaganda);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam planos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    public int alterarNome(int id, String nome){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o plano existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET nome = ? WHERE id = ?");
                pstmt.setString(1, nome);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam planos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    public int alterarPreco(int id, double preco){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o plano existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET preco = ? WHERE id = ?");
                pstmt.setDouble(1, preco);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam planos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }


    public int deletarPlano(int id) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o plano existe
            ResultSet busca = buscar(id);

            // Verififcando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM plano WHERE id = ?");
                pstmt.setInt(1, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam planos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException e) {
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
}
