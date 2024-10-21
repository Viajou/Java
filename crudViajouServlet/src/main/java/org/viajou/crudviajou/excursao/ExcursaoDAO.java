package org.viajou.crudviajou.excursao;
import org.viajou.crudviajou.Conexao;

import java.sql.*;

public class ExcursaoDAO {



    public ResultSet buscar() {
        Conexao conexao = new Conexao();
        conexao.conectar();
        ResultSet rset = null;
        try{
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM excursao");
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM excursao");
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

    public int inserirExcursao(Excursao excursao) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO excursao(nomeEmpresa, capacidade, duracao, site, precoTotal, dataInicio, dataTermino, categoria, idAtracao) VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, excursao.getNomeEmpresa());
            pstmt.setInt(2, excursao.getCapacidade());
            pstmt.setString(3, excursao.getDuracao());
            pstmt.setString(4, excursao.getSite());
            pstmt.setDouble(5, excursao.getPrecoTotal());
            pstmt.setDate(6, (Date) excursao.getDataInicio());
            pstmt.setDate(7, (Date) excursao.getDataTermino());
            pstmt.setString(8, excursao.getCategoria());
            pstmt.setInt(9, excursao.getIdAtracao());
            return 1;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            System.out.println(sqle.getMessage());
            return 0;
        }finally {
            conexao.desconectar();
        }
    }

    public int alterarNomeEmpresa(int id, String nomeEmpresa) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET nome_empresa = ? WHERE id = ?");
                pstmt.setString(1, nomeEmpresa);
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

    public int alterarCapacidade(int id, int capacidade) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET capacidade = ? WHERE id = ?");
                pstmt.setInt(1, capacidade);
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

    public int alterarDuracao(int id, String duracao) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET duracao = ? WHERE id = ?");
                pstmt.setString(1, duracao);
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

    public int alterarSite(int id, String site) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET site = ? WHERE id = ?");
                pstmt.setString(1, site);
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

    public int alterarPrecoTotal(int id, double precoTotal) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET preco_total = ? WHERE id = ?");
                pstmt.setDouble(1, precoTotal);
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

    public int alterarDataInicio(int id, Date dataInicio) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET data_inicio = ? WHERE id = ?");
                pstmt.setDate(1, dataInicio);
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

    public int alterarData_termino(int id, Date dataTermino) {
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET data_termino = ? WHERE id = ?");
                pstmt.setDate(1, dataTermino);
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
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET categoria = ? WHERE id = ?");
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

    public int deletarExcursao(int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM excursao WHERE id = ?");
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
