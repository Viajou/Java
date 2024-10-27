package org.viajou.crudviajou.excursao;
import org.viajou.crudviajou.Conexao;

import java.sql.*;

public class ExcursaoDAO {
// Método para leitura da tabela excursao
    public ResultSet buscar() {
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM excursao");
            rset = pstmt.executeQuery();
            return rset;

        } catch (SQLException sqle){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

//  Metodo para leitura da tabela excursao com base em um ID
    public ResultSet buscar(int id) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try{
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM excursao WHERE id = ?");
<<<<<<< HEAD
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM excursao");
=======
            pstmt.setInt(1, id);
>>>>>>> 230b086696e5787d35bbaad7bd19c7612716caaf
            rset = pstmt.executeQuery();
            return rset;

        } catch (SQLException sqle){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    // Método para adicionar uma excursão na tabela
    public int inserirExcursao(Excursao excursao) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO excursao(nome_empresa, capacidade, duracao, site, preco_total, dataInicio, dataTermino, categoria, idAtracao) VALUES (?,?,?,?,?,?,?,?,?)");
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
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

//  Alterações na tabela excursao
    public int alterarNomeEmpresa(int id, String nomeEmpresa) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();

        try{
            // Verificando se o adminstrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET nome_empresa = ? WHERE id = ?");
                pstmt.setString(1, nomeEmpresa);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int alterarCapacidade(int id, int capacidade) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se a excursão existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET capacidade = ? WHERE id = ?");
                pstmt.setInt(1, capacidade);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int alterarDuracao(int id, String duracao) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se a excursão existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET duracao = ? WHERE id = ?");
                pstmt.setString(1, duracao);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int alterarSite(int id, String site) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();

        try {
            // Verificando se a excursão existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET site = ? WHERE id = ?");
                pstmt.setString(1, site);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int alterarPreco_total(int id, double preco_total) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();

        try {
            // Verificando se a excursão existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET preco_total = ? WHERE id = ?");
                pstmt.setDouble(1, preco_total);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int alterardataInicio(int id, Date dataInicio) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o evento existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET dataInicio = ? WHERE id = ?");
                pstmt.setDate(1, dataInicio);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

<<<<<<< HEAD

    public int alterardataTermino(int id, Date dataTermino) {
=======
    public int alterarDataTermino(int id, Date dataTermino) {
        // Instanciando os objetos
>>>>>>> 230b086696e5787d35bbaad7bd19c7612716caaf
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se a excursão existe no BD
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET dataTermino = ? WHERE id = ?");
                pstmt.setDate(1, dataTermino);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int alterarCategoria(int id, String categoria) {
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se a excursão existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE excursao SET categoria = ? WHERE id = ?");
                pstmt.setString(1, categoria);
                pstmt.setInt(2, id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle){
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    public int deletarExcursao(int id){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se a excursão existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM excursao WHERE id = ?");
                pstmt.setInt(1,id);
                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        }catch (SQLException e){
            return -1;
        }
        finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
}
