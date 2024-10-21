package org.viajou.crudviajou.atracao;

import org.viajou.crudviajou.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtracaoDAO {



    public ResultSet buscar() {
        Conexao conexao = new Conexao();
        conexao.conectar();
        ResultSet rset = null;
        try{
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM atracao");
            rset = pstmt.executeQuery();
            return rset;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            System.out.println(sqle.getMessage());
            return rset;
        }
        finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscar(int id) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        ResultSet rset = null;
        try{
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM atracao WHERE id = ?");
            rset = pstmt.executeQuery();
            return rset;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            System.out.println(sqle.getMessage());
            return rset;
        }
        finally {
            conexao.desconectar();
        }
    }

    public int inserir(Atracao atracao) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO atracao(descricao,nome,endereco,acessibilidade,categoria) VALUES ?,?,?,?,?");
            pstmt.setString(1, atracao.getDescricao());
            pstmt.setString(2, atracao.getNome());
            pstmt.setString(3, atracao.getEndereco());
            pstmt.setBoolean(4, atracao.getAcessibilidade());
            pstmt.setString(5, atracao.getCategoria());
            return 1;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            System.out.println(sqle.getMessage());
            return 0;
        }finally {
            conexao.desconectar();
        }
    }

    public int alterarDescricao(int id, String descricao) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {;
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET descricao = ? WHERE id = ?");
                pstmt.setString(1, descricao);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            return 0;
        }
        finally {
            conexao.desconectar();
        }
    }

    public int alterarNome(int id, String nome) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET nome = ? WHERE id = ?");
                pstmt.setString(1, nome);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            return 0;
        }
        finally {
            conexao.desconectar();
        }
    }

    public int alterarEndereco(int id, String endereco) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET endereco = ? WHERE id = ?");
                pstmt.setString(1, endereco);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            return 0;
        }
        finally {
            conexao.desconectar();
        }
    }

    public int alterarAcessibilidade(int id, Boolean acessibilidade) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET acessibilidade = ? WHERE id = ?");
                pstmt.setBoolean(1, acessibilidade);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            return 0;
        }
        finally {
            conexao.desconectar();
        }
    }

    public int alterarCategoria(int id, String categoria) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE atracao SET categoria = ? WHERE id = ?");
                pstmt.setString(1, categoria);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            return 0;
        }
        finally {
            conexao.desconectar();
        }
    }

    public int deletarAtracao(int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM atracao WHERE id = ?");
                pstmt.setInt(1,id);
                pstmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException e){
            System.out.println("Erro no atualizar nome :"+e.getMessage());
            e.printStackTrace();
            return 0;
        }
        finally {
            conexao.desconectar();
        }
    }


}
