package org.viajou.crudviajou.plano;

import java.sql.*;
import org.viajou.crudviajou.Conexao;

public class PlanoDAO  {
    private PreparedStatement pstmt;
    Conexao conexao = new Conexao();
    Plano plano = new Plano();
    private Connection conn;

// Metodo para leitura da tabela plano
    public ResultSet buscar(){
        ResultSet rset;
        try {
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM plano");
            rset = pstmt.executeQuery();
            return rset;
        }catch (SQLException e){
            System.out.println("erro no buscar");
            return rset=null;
        }
        finally {
            conexao.desconectar();
        }
    }

// Metodo para leitura da tabela plano com base em um ID
    public ResultSet buscar(int id){
        ResultSet rset = null;
        try {
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM plano WHERE id = ? ");
            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();
            return rset;
        }catch (SQLException e){
            // Caso ocorra alguma exceção SQL, o retorno cai no catch
            System.out.println("Erro. Não foi possível concluir a busca");
            return rset;
        }
        finally {
            //usando o finally para toda fez antes do return use o método desconectar
            conexao.desconectar();
        }
    }

    public int inserirPlano(){
        try {
            conexao.conectar();
            pstmt = conn.prepareStatement("INSERT INTO plano(descricao, livre_propaganda, nome, preco, dataCriacao) VALUES (?,?,?,?,?)");
            pstmt.setString(1, plano.getDescricao());
            pstmt.setBoolean(2, plano.getLivrePropaganda());
            pstmt.setString(3, plano.getNome());
            pstmt.setDouble(4, plano.getPreco());
            pstmt.setDate(5, plano.getDataCriacao());
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterarDescricao(int id){
        try{
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE plano SET descricao = ? WHERE id = ?");
            pstmt.setString(1, plano.getDescricao());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarLivrePropaganda(int id){
        try{
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE plano SET livre_propaganda = ? WHERE id = ?");
            pstmt.setBoolean(1, plano.getLivrePropaganda());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarNome(int id){

        try{
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE plano SET nome = ? WHERE id = ?");
            pstmt.setString(1, plano.getNome());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;

        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarPreco(int id){
        try{
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE plano SET preco = ? WHERE id = ?");
            pstmt.setDouble(1, plano.getPreco());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarDataAtualizacao(int id){
        try{
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE plano SET dataAtualizacao = ? WHERE id = ?");
            pstmt.setDate(1, plano.getDataAtualizacao());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int deletarPlano(int id) {
        conexao.conectar();
        try {
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
            conexao.desconectar();
        }
    }
}
