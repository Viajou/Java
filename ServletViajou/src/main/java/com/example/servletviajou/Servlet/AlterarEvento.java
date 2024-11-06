package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import com.example.servletviajou.DAO.EventosDAO;
import com.example.servletviajou.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet(name = "AlterarEventos", value = "/AlterarEventos-servlet")
public class AlterarEvento extends HelloServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // obntendo valores do formulário

            int id = Integer.parseInt(request.getParameter("id"));
            String faixaEtaria = request.getParameter("nova-faixa-etaria");
            String descricao = request.getParameter("nova-descricao");
            String Stringcapacidade = request.getParameter("nova-capacidade");
            String Stringhorario = request.getParameter("novo-horario");
            String StringdataInicio = request.getParameter("nova-data-inicial");
            String StringdataTermino = request.getParameter("nova-data-termino");
            String StringprecoPessoa = request.getParameter("novo-preco-pessoa");

            //instanciando a classe EventosDAO
            EventosDAO eventosDAO = new EventosDAO();


            // Verifica cada campo antes de atualizar

            if (faixaEtaria != null && !faixaEtaria.isEmpty()) {
                eventosDAO.alterarFaixaEtaria(id, faixaEtaria);
            }
            if (descricao != null && !descricao.isEmpty()) {
                eventosDAO.alterarDescricao(id, descricao);
            }
            if (Stringcapacidade != null && !Stringcapacidade.isEmpty()) {
                try {
                    int capacidade = Integer.parseInt(Stringcapacidade);
                    eventosDAO.alterarCapacidade(id, capacidade);
                } catch (NumberFormatException e) {
                    request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());
                }
            }
            if (Stringhorario != null && !Stringhorario.isEmpty()) {
                if (Stringhorario.length() == 5) {
                    Stringhorario += ":00";
                }
                Time horario = Time.valueOf(Stringhorario);
                eventosDAO.alterarHorario(id, horario);
            }
            if (StringdataInicio != null && !StringdataInicio.isEmpty()) {
                Date dataInicio = Date.valueOf(StringdataInicio);
                eventosDAO.alterarDataInicio(id, dataInicio);
            }
            if (StringdataTermino != null && !StringdataTermino.isEmpty()) {
                Date dataTermino = Date.valueOf(StringdataTermino);
                eventosDAO.alterarDataTermino(id, dataTermino);
            }
            if (StringprecoPessoa != null && !StringprecoPessoa.isEmpty()) {
                double precoPessoa = Double.parseDouble(StringprecoPessoa);
                eventosDAO.alterarPrecoPessoa(id, precoPessoa);
            }
        }catch (Exception e){
            request.setAttribute("mensagem", "Erro ao alterar eventos: " + e.getMessage());

        }

        request.getRequestDispatcher("listar_eventos.jsp").forward(request, response);
    }


}
