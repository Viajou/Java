package org.viajou.crudviajou.tourVirtual;

import org.viajou.crudviajou.Conexao;
import org.viajou.crudviajou.plano.Plano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourVirtualDAO {
    public ResultSet buscar(){
        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConn();
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM tour_virtual");
            rset = pstmt.executeQuery();
            return rset;
        }catch (SQLException e){
            System.out.println("Erro. Não foi possível concluir a busca.");
            return rset=null;
        }
        finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscar(int id){
        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConn();
            conexao.conectar();
            pstmt = conn.prepareStatement("SELECT * FROM tour_virtual WHERE id = ? ");
            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();
            return rset;
        }catch (SQLException e){
            // Caso ocorra alguma exceção SQL, o retorno cai no catch
            System.out.println("Erro. Não foi possível concluir a busca");
            return rset=null;
        }
        finally {
            //usando o finally para toda vez antes do return use o método desconectar
            conexao.desconectar();
        }
    }

    public int inserirTourVirtual(TourVirtual tourVirtual){
        Conexao conexao = new Conexao();
        PreparedStatement pstmt;
        try {
            conexao.conectar();
            Connection conn = conexao.getConn();
            pstmt = conn.prepareStatement("INSERT INTO tour_virtual(descricao, video, media_classificacao, qnt_classificacao, preco, idAtracao, id_figurinhas) VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1, tourVirtual.getDescricao());
            pstmt.setString(2, tourVirtual.getVideo());
            pstmt.setDouble(3, tourVirtual.getMediaClassificacao());
            pstmt.setInt(4, tourVirtual.getQntClassificacao());
            pstmt.setDouble(5, tourVirtual.getPreco());
            pstmt.setInt(6, tourVirtual.getIdAtracao());
            pstmt.setInt(7, tourVirtual.getIdFigurinhas());
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterarDescricao(String descricao, int id){
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();

        try{
            Connection conn = conexao.getConn();
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE tour_virtual SET descricao = ? WHERE id = ?");
            pstmt.setString(1, descricao);
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
    public int alterarVideo(String video, int id){
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConn();
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE tour_virtual SET video = ? WHERE id = ?");
            pstmt.setString(1, video);
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

    //    String descricao;
//    String video;
//    double mediaClassificacao;
//    int qntClassificacao;
//    double preco;
//    int idAtracao;
//    int idFigurinhas;
    public int alterarMediaClassificacao(double mediaClassificacao, int id){
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();
        try{
            conexao.conectar();
            Connection conn = conexao.getConn();
            pstmt = conn.prepareStatement("UPDATE tour_virtual SET media_classificacao = ? WHERE id = ?");
            pstmt.setDouble(1, mediaClassificacao);
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

    public int alterarQntClassificacao(int qntClassificacao, int id){
        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConn();
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE tour_virtual SET qnt_classificacao = ? WHERE id = ?");
            pstmt.setInt(1,qntClassificacao);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate();
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterarPreco(double preco, int id){
        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();
        Connection conn;
        try{
            conn = conexao.getConn();
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE tour_virtual SET media_classificacao = ? WHERE id = ?");
            pstmt.setDouble(1,preco);
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

    public int alterarIdAtracao(int idAtracao, int id){

        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();
        Connection conn;
        try{
            conn = conexao.getConn();
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE tour_virtual SET idAtracao = ? WHERE id = ?");
            pstmt.setInt(1,idAtracao);
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
    public int alterarIdFigurinhas(int idFigurinhas, int id){
        ResultSet rset;
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();
        Connection conn;
        try{
            conn = conexao.getConn();
            conexao.conectar();
            pstmt = conn.prepareStatement("UPDATE tour_virtual SET id_figurinhas = ? WHERE id = ?");
            pstmt.setInt(1,idFigurinhas);
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
    public int deletarTourVirtual(int id, TourVirtual tourVirtual) {
        PreparedStatement pstmt;
        Conexao conexao = new Conexao();
        Connection conn;
        conexao.conectar();
        try {
            conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()) {
                pstmt = conn.prepareStatement("DELETE FROM tour_virtual WHERE id = ?");
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
