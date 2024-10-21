package org.viajou.crudviajou.evento;

import org.viajou.crudviajou.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventoDAO {
    //Declarando as variaveis do método

    // metodo para leitura da tabela admin
    public ResultSet busca(){
        Conexao conexao = new Conexao();
        conexao.conectar();
        ResultSet rset = null;
        try {
            Connection conn = conexao.getConn();
            //usando o psmt para fazer um instrução sql
            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM evento");
            rset = psmt.executeQuery();
            return rset;
            // Fazendo o catch para verificar se o sql apresentar algum erro séra apresentado retonar uma string
        }catch (SQLException sqle){
            return rset;
        }finally {
            //usando o finally para toda fez antes do return use o método desconectar
            conexao.desconectar();
        }
    }
    //Uma sobrecarga no metod
    // o buscar, para fazer uma leitura na tabela pela pk dela
    public ResultSet buscar(int pk){
        Conexao conexao = new Conexao();
        conexao.conectar();
        ResultSet rset = null;
        try {
            Connection conn = conexao.getConn();
            PreparedStatement psmt = conn.prepareStatement("Select * from evento where id = ? ");
            psmt.setInt(1,pk);
            rset = psmt.executeQuery();
            return rset;
        }catch (SQLException sqle){
            //cath para retornar erro de Sql
            return rset;
        }
        finally{
            conexao.desconectar();
        }
    }
    //método para adicionar um evento na tabela
    public int inserirEvento(Evento evento){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO evento(faixa_etaria,descricao,categoria,capacidade,horario,data_inicio,data_termino,preco_pessoa,id_atracao,id_tour_virtual) VALUES(?,?,?,?,?,?,?,?,?,?) ");
            psmt.setString(1, evento.getFaixa_etaria());
            psmt.setString(2, evento.getDescricao());
            psmt.setString(3, evento.getCategoria());
            psmt.setInt(4, evento.getCapacidade());
            psmt.setTime(5, evento.getHorario());
            psmt.setDate(6, evento.getData_inicio());
            psmt.setDate(7, evento.getData_termino());
            psmt.setDouble(8, evento.getPreco_pessoa());
            psmt.setInt(9, evento.getId_atracao());
            psmt.setInt(10, evento.getId_tour_virtual());
            psmt.execute();
            return 1;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    // Os métodos a seguir se referem a mudança de um campo na tabela evetos
    //Método para mudar a faixa etaria de um evento
    public int alterarFaixaEtaria(Evento evento, int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("UPDATE evento SET faixa_etaria = ? WHERE id = ? ");
                psmt.setString(1, evento.getFaixa_etaria());
                psmt.setInt(2, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //Método para mudar a descrição do evento
    public int alterarDescricao(Evento evento, int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("UPDATE evento SET descricao = ? WHERE id = ? ");
                psmt.setString(1, evento.getDescricao());
                psmt.setInt(2, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //Método a seguir para mudar a categoria de um evento
    public int alterarCategoria(Evento evento, int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("UPDATE evento SET categoria = ? WHERE id = ? ");
                psmt.setString(1, evento.getCategoria());
                psmt.setInt(2, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //Método a seguir para mudar a capacidade de um evento
    public int alterarCapacidade(Evento evento, int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("UPDATE evento SET capacidade = ? WHERE id = ? ");
                psmt.setInt(1, evento.getCapacidade());
                psmt.setInt(2, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //Método a seguir para mudar o horario de um evento
    public int alterarHorario(Evento evento, int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("UPDATE evento SET horario = ? WHERE id = ? ");
                psmt.setTime(1, evento.getHorario());
                psmt.setInt(2, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //Método a seguir para mudar a data de inicio de um evento
    public int alterarDataInicio(Evento evento, int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("UPDATE evento SET data_inicio = ? WHERE id = ? ");
                psmt.setDate(1, evento.getData_inicio());
                psmt.setInt(2, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //Método a seguir para mudar a data de termino de um evento
    public int alterarDataTermino(Evento evento, int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("UPDATE evento SET data_termino = ? WHERE id = ? ");
                psmt.setDate(1, evento.getData_termino());
                psmt.setInt(2, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //Método a seguir para mudar o preço por pessoa de um evento
    public int alterarPrecoPessoa(Evento evento, int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("UPDATE evento SET preco_pessoa = ? WHERE id = ? ");
                psmt.setDouble(1, evento.getPreco_pessoa());
                psmt.setInt(2, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }finally {
            conexao.desconectar();
        }
    }
    //Método a seguir serve para deletar um evento
    public int deletar(int id){
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            ResultSet busca = buscar(id);
            if (busca.next()){
                PreparedStatement psmt = conn.prepareStatement("DELETE FROM evento WHERE id = ? ");
                psmt.setInt(1, id);
                psmt.execute();
                return 1;
            }
            return 0;
        }catch (SQLException sqle){
            return -1;
        }
    }
}
