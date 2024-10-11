package Plano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ClasseConexao.Conexao;

public class PlanoDAO  {
    private PreparedStatement pstmt;
    Conexao conexao = new Conexao();
    Plano plano = new Plano();
    private Connection conn;

    public ResultSet buscar(){
        ResultSet rset = null;
        try {
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM plano");
            rset = pstmt.executeQuery();
            return rset;
        }catch (SQLException e){
            System.out.println("erro no buscar");
            return rset;
        }
        finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscar(int id){
        ResultSet rset = null;
        try {
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM plano WHERE id = ? ");
            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();
            return rset;
        }catch (SQLException e){
            //cath para retornar erro de Sql
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
            pstmt = conn.prepareStatement("INSERT INTO plano(descricao, livre_propaganda, nome, preco, dataCriacao, ) VALUES (?,?,?,?,?)");
            pstmt.setString(1, plano.getDescricao());
            pstmt.setBoolean(2, plano.getLivrePropaganda());
            pstmt.setString(3, plano.getNome());
            pstmt.setDouble(4, plano.getPreco());
            pstmt.s

        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
