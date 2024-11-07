package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import com.example.servletviajou.DAO.EventosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;


@WebServlet(name = "AlterarEventos", value = "/AlterarEventos-servlet")
public class AlterarEvento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // obtendo valores do formulário

            int id = Integer.parseInt(request.getParameter("id"));
            String faixaEtaria = request.getParameter("nova-faixa-etaria");
            String descricao = request.getParameter("nova-descricao");
            String Stringcapacidade = request.getParameter("nova-capacidade");
            String Stringhorario = request.getParameter("novo-horario");
            String StringdataInicio = request.getParameter("nova-data-inicial");
            String StringdataTermino = request.getParameter("nova-data-termino");
            String StringprecoPessoa = request.getParameter("novo-preco-pessoa");

            //instanciando um objeto da classe EventosDAO
            EventosDAO eventosDAO = new EventosDAO();


            //verifica e altera faixa etária
            if (faixaEtaria != null && !faixaEtaria.isEmpty()) { // se não for vazio
                eventosDAO.alterarFaixaEtaria(id, faixaEtaria);

            }

            // verifica e altera descricao
            if (descricao != null && !descricao.isEmpty()) { // se não for vazio
                eventosDAO.alterarDescricao(id, descricao);
            }

            //verifica e altera a capacidade
            if (Stringcapacidade != null && !Stringcapacidade.isEmpty()) { // se não for vazio

                int capacidade = Integer.parseInt(Stringcapacidade);
                eventosDAO.alterarCapacidade(id, capacidade);
            }

            // verifica e altera o horiário
            if (Stringhorario != null && !Stringhorario.isEmpty()) { // se não for vazio
                if (Stringhorario.length() == 5) {
                    Stringhorario += ":00";
                }
                Time horario = Time.valueOf(Stringhorario);
                eventosDAO.alterarHorario(id, horario);

            }

            //verifica e altera a data de início
            if (StringdataInicio != null && !StringdataInicio.isEmpty()) { // se não for vazio
                Date dataInicio = Date.valueOf(StringdataInicio);
                eventosDAO.alterarDataInicio(id, dataInicio);

            }

            //verifica e altera a data de término
            if (StringdataTermino != null && !StringdataTermino.isEmpty()) { // se não for vazio
                Date dataTermino = Date.valueOf(StringdataTermino);
                eventosDAO.alterarDataTermino(id, dataTermino);

            }

            //verifica e altera o preco por pessoa
            if (StringprecoPessoa != null && !StringprecoPessoa.isEmpty()) { // se não for vazio
                double precoPessoa = Double.parseDouble(StringprecoPessoa);
                eventosDAO.alterarPrecoPessoa(id, precoPessoa);

            }

        //tratamento de exceção
        }catch (Exception e){
            request.setAttribute("mensagem", "Erro ao alterar eventos: " + e.getMessage());

        }

        request.setAttribute("caminho", "listar_eventos.jsp");
        request.setAttribute("sucessMessage", "sucesso");
        request.getRequestDispatcher("sucesso.jsp").forward(request, response);

    }


}
