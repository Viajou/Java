package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
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

@WebServlet(name = "InserirEvento", value = "/InserirEvento-servlet")
public class InserirEvento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Criando o objeto Eventos
        EventosDAO eventosDAO = new EventosDAO();

        //Obtendo os dados da URL (Query String)

        String faixaEtaria = request.getParameter("faixa-etaria");
        String descricao = request.getParameter("descricao");
        int capacidade = Integer.parseInt(request.getParameter("capacidade"));
        String horarioStr = request.getParameter("horario");

        //verificando o formatodo da hora
        if (horarioStr.length() == 5) {
            horarioStr += ":00"; // Adiciona segundos se o formato for "HH:mm"
        }

        Time horario = Time.valueOf(horarioStr);
        Date dataInicio = Date.valueOf(request.getParameter("data-inicio"));
        Date dataTermino = Date.valueOf(request.getParameter("data-termino"));
        double precoPessoa = Double.parseDouble(request.getParameter("preco-pessoa"));
        int id_atracao = Integer.parseInt(request.getParameter("id-atracao"));
        int id_tourVirtual = Integer.parseInt(request.getParameter("id-tour"));

        //Criando objeto de Eventos
        Eventos eventos = new Eventos( capacidade,  dataInicio, dataTermino, descricao,
                faixaEtaria, horario, id_atracao, id_tourVirtual, precoPessoa);

        try {
            // Inserindo o novo evento
            int resultado = eventosDAO.inserirEvento(eventos);

            //verifica retorno do método DAO
            if (resultado == 1) { // método inseriri funcionou
                request.setAttribute("retorno", "certo");

            } else { // método inseirir não funcionou, erro de SQL
                request.setAttribute("retorno", "erro");

            }

            // tratamento de exceção
        } catch (Exception e) {
            request.setAttribute("retorno", "excecao");
        }

        // Redirecionando para uma página de confirmação ou erro
        request.setAttribute("caminho", "listar_eventos.jsp");
        request.getRequestDispatcher("sucesso.jsp").forward(request, response);
    }
}
