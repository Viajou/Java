package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.EventosDAO;
import com.example.servletviajou.Model.Eventos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

@WebServlet(name = "InserirEvento", value = "InserirEvento-servlet")
public class InserirEvento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            //obtendo os valores do formulário

            EventosDAO eventosDAO = new EventosDAO();

            int id = Integer.parseInt(getInitParameter("id"));
            String faixaEtaria = req.getParameter("faixa-etaria");
            String categoria = req.getParameter("categoria");
            String descricao = req.getParameter("descricao");
            int capacidade = Integer.parseInt("capacidade");
            Time horario = Time.valueOf(req.getParameter("horario"));
            Date data_inicio = Date.valueOf(req.getParameter("data-inicio"));
            Date data_termino = Date.valueOf(req.getParameter("data-termino"));
            double preco_pessoa = Double.parseDouble(req.getParameter("preco-pessoa"));
            int id_atracao = Integer.parseInt(req.getParameter("id-atracao"));
            int id_tourVirtual = Integer.parseInt(req.getParameter("id-tour"));
            Date data_criacao = Date.valueOf(req.getParameter("data-criacao"));
            Date data_atualizacao = Date.valueOf(req.getParameter("data-atualizacao"));

            Eventos eventos = new Eventos(id, capacidade, categoria, data_inicio, data_termino, descricao,
                    faixaEtaria, horario, id_atracao, id_tourVirtual, preco_pessoa, data_criacao);

            ResultSet rsBuscar = eventosDAO.buscar(id_atracao);

            if (!rsBuscar.next()){
                int inserirEvento = eventosDAO.inserirEvento(eventos);
                if (inserirEvento == 1){
                    req.setAttribute("mensagem", "Evento inserido com sucesso!");
                }
                else if (inserirEvento == 0) {
                    req.setAttribute("mensagem", "not found");
                }
                else {
                    req.setAttribute("mensagem", "erro");
                }
            }
            else {
                req.setAttribute("erro", "Erro! Esse evnto ja existe.");
            }
        } catch (SQLException sqle){
            req.setAttribute("erro", "Erro ao inserir o evento no banco de dados: " + sqle.getMessage());
        }
    }
}
