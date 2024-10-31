package com.example.servletviajou.DAO;

import com.example.servletviajou.Model.Atracao;
import com.example.servletviajou.Conexao;

import java.sql.*;
import java.time.LocalDate;

public class AtracaoDAO {

// Método para leitura da tabela atracao
    public ResultSet buscar() {
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM atracao");
            rset = pstmt.executeQuery();
            return rset;

        } catch (SQLException sqle){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

//  Metodo para leitura da tabela atracao com base em um ID
    public ResultSet buscar(int id) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;
        // Conectando com o BD
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM atracao WHERE id = ?");
            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();
            return rset;

        } catch (SQLException sqle){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int inserirAtracao(Atracao atracao) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO atracao(descricao,nome,endereco,acessibilidade,categoria) VALUES (?,?,?,?,?)");
            pstmt.setString(1, atracao.getDescricao());
            pstmt.setString(2, atracao.getNome());
            pstmt.setString(3, atracao.getEndereco());
            pstmt.setBoolean(4, atracao.getAcessibilidade());
            pstmt.setString(5, atracao.getCategoria());
            pstmt.execute();
            return 1;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

// Alterações na tabela atracao
    // Método para alterar a descrição da atracao
    public int alterarDescricao(int id, String descricao) {
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
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET descricao = ?,data_atualizacao = ? WHERE id = ?");
                pstmt.setString(1, descricao);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam atrações com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    // Método para alterar o nome da atracao
    public int alterarNome(int id, String nome) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o atração existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET nome = ?, data_atualizacao = ? WHERE id = ?");
                pstmt.setString(1, nome);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam atrações com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    // Método para alterar o endereço da atracao
    public int alterarEndereco(int id, String endereco) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try{
            // Verificando se o atração existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET endereco = ?, data_atualizacao = ? WHERE id = ?");
                pstmt.setString(1, endereco);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam atrações com o id do parâmetro, o retorno é 0
            return 0;
        }catch (SQLException sqle){
            return -1;
        }
        finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    // Método para alterar a acessibilidade
    public int alterarAcessibilidade(int id, Boolean acessibilidade) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o atracao existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET acessibilidade = ?, data_atualizacao = ? WHERE id = ?");
                pstmt.setBoolean(1, acessibilidade);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam atrações com o id do parâmetro, o retorno é 0
            return 0;
        }catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    // Método para alterar a categoria da atracao
    public int alterarCategoria(int id, String categoria) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se a atração existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                // Obtendo a data atual
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET categoria = ?, data_atualizacao = ? WHERE id = ?");
                pstmt.setString(1, categoria);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam atrações com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    // Método para deletar uma atracao
    public int deletarAtracao(int id){
        //Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se a a busca teve resultados
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM atracao WHERE id = ?");
                pstmt.setInt(1,id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam atrações com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException e){
            return -1;
        }
        finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }


}
