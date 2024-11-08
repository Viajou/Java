package com.example.servletviajou.DAO;

import com.example.servletviajou.Conexao;
import com.example.servletviajou.Model.Eventos;
import com.example.servletviajou.Conexao;


import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class EventosDAO {
//  Método para leitura da tabela eventos
    public ResultSet buscar(){
        //  Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT eventos.id, eventos.id_atracao,atracao.nome,eventos.descricao,atracao.categoria,eventos.capacidade,eventos.preco_pessoa,eventos.data_inicio,eventos.data_termino,eventos.faixa_etaria FROM eventos JOIN atracao ON atracao.id = eventos.id_atracao order by eventos.id");
            rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    //  Metodo para leitura da tabela eventos com base em um ID
    public ResultSet buscar(int id){
        // Instanciando os objetos
        Conexao conexao = new Conexao();
        ResultSet rset = null;

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("SELECT eventos.id,eventos.id_atracao,atracao.nome,eventos.descricao,atracao.categoria,eventos.capacidade,eventos.preco_pessoa,eventos.data_inicio,eventos.data_termino,eventos.faixa_etaria FROM eventos JOIN atracao ON atracao.id = eventos.id_atracao WHERE eventos.id = ?");
            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();
            return rset;
        } catch (SQLException sqle){
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

    //Método para adicionar um evento na tabela
    public int inserirEvento(Eventos eventos){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            Connection conn = conexao.getConn();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO eventos(faixa_etaria,descricao,capacidade,horario,data_inicio,data_termino,preco_pessoa,id_atracao,id_tour_virtual) VALUES(?,?,?,?,?,?,?,?,?) ");
            pstmt.setString(1, eventos.getFaixaEtaria());
            pstmt.setString(2, eventos.getDescricao());
            pstmt.setInt(3, eventos.getCapacidade());
            pstmt.setTime(4, eventos.getHorario());
            pstmt.setDate(5, eventos.getDataInicio());
            pstmt.setDate(6, eventos.getDataTermino());
            BigDecimal precoPessoa = BigDecimal.valueOf(eventos.getPrecoPessoa());
            pstmt.setBigDecimal(7, precoPessoa);
            pstmt.setInt(8, eventos.getIdAtracao());
            pstmt.setInt(9, eventos.getIdTourVirtual());
            pstmt.execute();
            return 1;
        }catch (SQLException sqle){
            return -1;
        }finally {
            // Desconectando do DB ao final do try
            conexao.desconectar();
        }
    }

//  Alterações na tabela eventos
    // Método para alterar a faixaEtaria
    public int alterarFaixaEtaria(int id, String faixaEtaria){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o evento existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()){
                Connection conn = conexao.getConn();
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE eventos SET faixa_etaria = ?,data_atualizacao = ? WHERE id = ? ");
                pstmt.setString(1, faixaEtaria);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);                pstmt.execute();
                return 1;
            }
            // Caso não existam eventos com o id do parâmetro, o retorno é 0
            return 0;
        } catch (SQLException sqle) {
            return -1;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    //Método para mudar a descrição do evento
    public int alterarDescricao(int id, String descricao){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se o evento existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()){
                Connection conn = conexao.getConn();
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE eventos SET descricao = ?,data_atualizacao =? WHERE id = ? ");                pstmt.setString(1, descricao);
                pstmt.setString(1, descricao);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
    //Método para mudar a categoria de um evento
    public int alterarCategoria(int id, String categoria){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se o evento existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()){
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE eventos SET categoria = ? WHERE id = ? ");
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
    //Método a seguir para mudar a capacidade de um evento
    public int alterarCapacidade(int id, int capacidade){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se o evento existe
            Connection conn = conexao.getConn();

            // Verificando se a busca teve resultados
            ResultSet busca = buscar(id);
            if (busca.next()){
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE eventos SET capacidade = ?,data_atualizacao =? WHERE id = ? ");
                pstmt.setInt(1, capacidade);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
    //Método para alterar o horario de um evento
    public int alterarHorario(int id, Time horario){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o evento existe
            ResultSet busca = buscar(id);
            if (busca.next()){
                Connection conn = conexao.getConn();
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE eventos SET horario = ?,data_atualizacao=? WHERE id = ? ");
                pstmt.setTime(1, horario);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
    //Método para alterar a data de inicio de um evento
    public int alterarDataInicio(int id, Date dataInicio){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se evento existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()){
                Connection conn = conexao.getConn();
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE eventos SET data_inicio = ?,data_atualizacao=? WHERE id = ? ");
                pstmt.setDate(1, dataInicio);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
    //Método para alterar a data de término de um evento
    public int alterarDataTermino(int id, Date dataTermino){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se o evento existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()){
                Connection conn = conexao.getConn();
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE eventos SET data_termino = ?,data_atualizacao=? WHERE id = ? ");
                pstmt.setDate(1, dataTermino);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
    //Método para alterar o preço por pessoa de um evento
    public int alterarPrecoPessoa(int id, double precoPessoa){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o evento existe
            ResultSet busca = buscar(id);
            // Verificando se a busca teve resultados
            if (busca.next()){
                Connection conn = conexao.getConn();
                Date dataAtual = Date.valueOf(LocalDate.now());
                PreparedStatement pstmt = conn.prepareStatement("UPDATE eventos SET preco_pessoa = ?,data_atualizacao=? WHERE id = ? ");
                BigDecimal money = BigDecimal.valueOf(precoPessoa);
                pstmt.setBigDecimal(1, money);
                pstmt.setDate(2, dataAtual);
                pstmt.setInt(3, id);
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
    //Método para deletar um evento
    public int deletarEvento(int id){
        // Instanciando os objetos
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se o evento existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()){
                Connection conn = conexao.getConn();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM eventos WHERE id = ? ");
                pstmt.setInt(1, id);
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
}
