package org.viajou.crudviajou.excursao;
import org.viajou.crudviajou.Conexao;

import java.sql.*;

public class ExcursaoDAO {

    Conexao conexao = new Conexao();
    Excursao excursao = new Excursao();
    ResultSet rset;


    private PreparedStatement pstmt;
    private Connection conn;

    public ResultSet buscar() {
        try{
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM excursao");
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
        try{
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM excursao");
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
        try {
            conexao.conectar();
            pstmt = conn.prepareStatement("INSERT INTO excursao(nome_empresa, capacidade, duracao, site, preco_total, data_inicio, data_termino, categoria, ID_atracao) VALUES (?,?,?,?,?,?,?,?,?)");
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

    public int alterarNome_empresa(int id, String nome_empresa) {
        try{
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                pstmt = conn.prepareStatement("UPDATE excursao SET nome_empresa = ? WHERE id = ?");
                pstmt.setString(1, nome_empresa);
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
        try {
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                pstmt = conn.prepareStatement("UPDATE excursao SET capacidade = ? WHERE id = ?");
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
        try {
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                pstmt = conn.prepareStatement("UPDATE excursao SET duracao = ? WHERE id = ?");
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
        try {
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                pstmt = conn.prepareStatement("UPDATE excursao SET site = ? WHERE id = ?");
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

    public int alterarPreco_total(int id, double preco_total) {
        try {
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                pstmt = conn.prepareStatement("UPDATE excursao SET preco_total = ? WHERE id = ?");
                pstmt.setDouble(1, preco_total);
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

    public int alterarData_inicio(int id, Date data_inicio) {
        try {
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                pstmt = conn.prepareStatement("UPDATE excursao SET data_inicio = ? WHERE id = ?");
                pstmt.setDate(1, data_inicio);
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

    public int alterarData_termino(int id, Date data_termino) {
        try {
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                pstmt = conn.prepareStatement("UPDATE excursao SET data_termino = ? WHERE id = ?");
                pstmt.setDate(1, data_termino);
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
        try {
            ResultSet busca = buscar(id);
            if (busca.next()) {
                conexao.conectar();
                pstmt = conn.prepareStatement("UPDATE excursao SET categoria = ? WHERE id = ?");
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
        conexao.conectar();
        try {
            ResultSet busca = buscar(id);
            if (busca.next()) {
                pstmt = conn.prepareStatement("DELETE FROM excursao WHERE id = ?");
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
