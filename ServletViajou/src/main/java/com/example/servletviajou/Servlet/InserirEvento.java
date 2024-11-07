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
        try {

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

            ResultSet busca = eventosDAO.buscar(id_atracao);

            if (busca.next()){
                //Inserindo o novo Evento
                int resultado = eventosDAO.inserirEvento(eventos);
                if (resultado == 1){
                    request.setAttribute("mensagem", "Evento inserido com sucesso!");
                }
                else if (resultado == 0) {
                    request.setAttribute("mensagem", "not found");
                }
                else {
                    request.setAttribute("mensagem", "erro");
                }
            }
            else {
                request.setAttribute("erro", "Erro! Esse evento ja existe.");
            }
        } catch (SQLException sqle){
            request.setAttribute("erro", "Erro ao inserir o evento no banco de dados: " + sqle.getMessage());
        }
        // Redirecionando para uma página de confirmação ou erro
        request.getRequestDispatcher("listar_eventos.jsp").forward(request, response);
    }
}
