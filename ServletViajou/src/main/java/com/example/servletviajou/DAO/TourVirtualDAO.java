package com.example.servletviajou.DAO;

import com.example.servletviajou.Conexao;
import com.example.servletviajou.Model.TourVirtual;

import com.example.servletviajou.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourVirtualDAO {
    public ResultSet buscar(){
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;
        
        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();

            conexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM tour_virtual order by id");
            rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException e){
            return rset;        
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public ResultSet buscar(int id){
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;
        
        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM tour_virtual WHERE id = ? ");
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

    public int inserirTourVirtual(TourVirtual tourVirtual){
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        
        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tour_virtual(descricao, video, media_classificacao, qnt_classificacao, preco, id_atracao, id_figurinhas) VALUES (?,?,?,?,CAST(? AS money),?,?)");
            pstmt.setString(1, tourVirtual.getDescricao());
            pstmt.setString(2, tourVirtual.getVideo());
            pstmt.setDouble(3, tourVirtual.getMediaClassificacao());
            pstmt.setInt(4, tourVirtual.getQntClassificacao());
            pstmt.setString(5, tourVirtual.getPreco());
            pstmt.setInt(6, tourVirtual.getIdAtracao());
            pstmt.setInt(7, tourVirtual.getIdFigurinhas());
            pstmt.execute();
            return 1;
        } catch (SQLException sqle){
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarDescricao(int id, String descricao){
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        
        // Conectando com o BD
        conexao.conectar();
        
        try{
            // Verificando se o tour existe
            ResultSet busca = buscar();

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE tour_virtual SET descricao = ? WHERE id = ?");
                pstmt.setString(1, descricao);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam tours com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarVideo(int id, String video){
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        
        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o tour existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE tour_virtual SET video = ? WHERE id = ?");
                pstmt.setString(1, video);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam tours com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterarMediaClassificacao(int id, double mediaClassificacao){
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        
        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o tour existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE tour_virtual SET media_classificacao = ? WHERE id = ?");
                pstmt.setDouble(1, mediaClassificacao);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam tours com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int alterarQntClassificacao(int id, int qntClassificacao){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o tour existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE tour_virtual SET qnt_classificacao = ? WHERE id = ?");
                pstmt.setInt(1, qntClassificacao);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam tours com o id do parâmetro, o retorno é 0
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
            // Verificando se o tour existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE tour_virtual SET preco = ? WHERE id = ?");
                pstmt.setDouble(1, preco);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam tours com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int alterarIdAtracao(int id, int idAtracao){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o tour existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE tour_virtual SET idAtracao = ? WHERE id = ?");
                pstmt.setInt(1, idAtracao);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam tours com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    public int alterarIdFigurinhas(int id, int idFigurinhas){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try{
            // Verificando se o tour existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE tour_virtual SET id_figurinhas = ? WHERE id = ?");
                pstmt.setInt(1, idFigurinhas);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam tours com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    public int deletarTourVirtual(int id, TourVirtual tourVirtual) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o tour existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tour_virtual WHERE id = ?");
                pstmt.setInt(1, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam tours com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle) {
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

}
