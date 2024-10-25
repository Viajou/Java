package org.viajou.crudviajou.plano;

import java.sql.*;
import org.viajou.crudviajou.Conexao;

public class PlanoDAO  {
// Metodo para leitura da tabela plano
    public ResultSet buscar(){
        ResultSet rset = null;
        Conexao conexao = new Conexao(); // instanciando o objeto da classe Conexao,
        // que possui os métodos para conectar e desconectar do o banco de dados
        try {
            conexao.conectar(); // Conectando com o BD
            Connection conn = conexao.getConn(); // Inicializando o objeto da classe Connection
            // com o método getConn da classe Conexao
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM plano");
            rset = pstmt.executeQuery();
            return rset; // caso a busca ocorra corretamente, o método retorna o resultado
        }catch (SQLException e){
            // Caso ocorra alguma exceção SQL, ela cai no catch
            return rset;
        }
        finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }

// Metodo para leitura da tabela plano com base em um ID
    public ResultSet buscar(int id){
        ResultSet rset = null;
        Conexao conexao = new Conexao(); // instanciando o objeto da classe Conexao,
        // que possui os métodos para conectar e desconectar do o banco de dados
        try {
            conexao.conectar(); // Conectando com o BD
            Connection conn = conexao.getConn(); // Inicializando o objeto da classe Connection
            // com o método getConn da classe Conexao
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM plano WHERE id = ? ");
            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();
            return rset; // caso a busca ocorra corretamente, o método retorna o resultado
        }catch (SQLException e){
            // Caso ocorra alguma exceção SQL, ela cai no catch
            System.out.println("Erro. Não foi possível concluir a busca");
            return rset;
        }
        finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }

    public int inserirPlano(Plano plano){
        Conexao conexao = new Conexao(); // instanciando o objeto da classe Conexao,
        // que possui os métodos para conectar e desconectar do o banco de dados
        try {
            conexao.conectar();
            Connection conn = conexao.getConn(); // Inicializando o objeto da classe Connection
            // com o método getConn da classe Conexao
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO plano(descricao, livre_propaganda, nome, preco) VALUES (?,?,?,?)");
            pstmt.setString(1, plano.getDescricao());
            pstmt.setBoolean(2, plano.getLivrePropaganda());
            pstmt.setString(3, plano.getNome());
            pstmt.setDouble(4, plano.getPreco());
            return pstmt.executeUpdate();
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }

    public int alterarDescricao(String descricao, int id){
        ResultSet rset;
        Conexao conexao = new Conexao(); // instanciando o objeto da classe Conexao,
        // que possui os métodos para conectar e desconectar do o banco de dados
        try{
            conexao.conectar();
            Connection conn = conexao.getConn(); // Inicializando o objeto da classe Connection
            // com o método getConn da classe Conexao
            PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET descricao = ? WHERE id = ?");
            pstmt.setString(1, descricao);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }
    public int alterarLivrePropaganda(boolean livrePropaganda, int id){
        ResultSet rset;
        Conexao conexao = new Conexao(); // instanciando o objeto da classe Conexao,
        // que possui os métodos para conectar e desconectar do o banco de dados

        try{
            conexao.conectar();
            Connection conn = conexao.getConn(); // Inicializando o objeto da classe Connection
            // com o método getConn da classe Conexao
            PreparedStatement pstmt = conn.prepareStatement("UPDATE plano SET livre_propaganda = ? WHERE id = ?");
            pstmt.setBoolean(1, livrePropaganda);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }
    public int alterarNome(String nome, int id){
        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao(); // instanciando o objeto da classe Conexao,
        // que possui os métodos para conectar e desconectar do o banco de dados
        try{
            conexao.conectar();
            Connection conn = conexao.getConn(); // Inicializando o objeto da classe Connection
            // com o método getConn da classe Conexao
            pstmt = conn.prepareStatement("UPDATE plano SET nome = ? WHERE id = ?");
            pstmt.setString(1, nome);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;

        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }
    public int alterarPreco(double preco, int id){
        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao(); // instanciando o objeto da classe Conexao,
        // que possui os métodos para conectar e desconectar com o banco de dados
        try{
            conexao.conectar();
            Connection conn = conexao.getConn(); // Inicializando o objeto da classe Connection
            // com o método getConn da classe Conexao
            pstmt = conn.prepareStatement("UPDATE plano SET preco = ? WHERE id = ?");
            pstmt.setDouble(1, preco);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }


    public int deletarPlano(int id) {
        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao(); // instanciando o objeto da classe Conexao,
        // que possui os métodos para conectar e desconectar com o banco de dados
        try {
            conexao.conectar();
            Connection conn = conexao.getConn(); // Inicializando o objeto da classe Connection
            // com o método getConn da classe Conexao
            ResultSet busca = buscar(id);
            if (busca.next()) {
                pstmt = conn.prepareStatement("DELETE FROM plano WHERE id = ?");
                pstmt.setInt(1, id);
                pstmt.execute();
                return 1;
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Erro no atualizar nome :" + e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar(); // Desconectando do BD ao final do try
        }
    }
}
