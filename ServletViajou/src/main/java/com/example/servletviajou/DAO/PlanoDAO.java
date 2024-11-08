package com.example.servletviajou.DAO;

import java.sql.*;
import java.time.LocalDate;

import com.example.servletviajou.Conexao;
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM plano order by id");
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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO plano(nome, descricao, livre_propaganda, preco, duracao) VALUES (?, ?, ?, CAST(? AS money), ?)");
            pstmt.setString(1, plano.getNome());
            pstmt.setString(2, plano.getDescricao());
            pstmt.setBoolean(3, plano.getLivrePropaganda());;
            pstmt.setString(4, plano.getPreco());
            pstmt.setString(5, plano.getDuracao());
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
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET descricao = ?,data_atualizacao = ? WHERE id = ?");
                pstmt.setString(1, descricao);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET livre_propaganda = ?,data_atualizacao = ? WHERE id = ?");
                pstmt.setBoolean(1, livrePropaganda);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET nome = ?,data_atualizacao = ? WHERE id = ?");
                pstmt.setString(1, nome);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
    public int alterarPreco(int id, String preco){
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
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET preco = CAST(? AS MONEY), data_atualizacao = ? WHERE id = ?");
                pstmt.setString(1, preco);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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

    public int alterarDuracao(int id, String duracao){
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
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET duracao = ?, data_atualizacao = ? WHERE id = ?");
                pstmt.setString(1, duracao);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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



