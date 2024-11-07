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
                int situacao = eventosDAO.alterarFaixaEtaria(id, faixaEtaria);

                //veriifca o retorno dos métodos das classes DAO
                if (situacao == 1) {
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar faixa étaria, verique sefoi colocado no formato correto.");
                }else {
                    request.setAttribute("mensagem", "Erro no alterar faixa étaria, verique sefoi colocado no formato correto.");
                }
            }

            // verifica e altera descricao
            if (descricao != null && !descricao.isEmpty()) { // se não for vazio
                int situacao = eventosDAO.alterarDescricao(id, descricao);

                //veriifca o retorno dos métodos das classes DAO
                if (situacao == 1) {
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar descricao, verique sefoi colocado no formato correto.");
                }else {
                    request.setAttribute("mensagem", "Erro no alterar alterar descricao, verique sefoi colocado no formato correto.");
                }
            }

            //verifica e altera a capacidade
            if (Stringcapacidade != null && !Stringcapacidade.isEmpty()) { // se não for vazio
                try {
                    int capacidade = Integer.parseInt(Stringcapacidade);
                    int situacao = eventosDAO.alterarCapacidade(id, capacidade);

                    //veriifca o retorno dos métodos das classes DAO
                    if (situacao == 1) {
                        request.setAttribute("mensagem", "Alterado com sucesso!");
                    }else if (situacao == 0) {
                        request.setAttribute("mensagem", "Erro no alterar data de inicio, verique sefoi colocado no formato correto.");
                    }else {
                        request.setAttribute("mensagem", "Erro no alterar data de inicio, verique sefoi colocado no formato correto.");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());
                }
            }

            // verifica e altera o horiário
            if (Stringhorario != null && !Stringhorario.isEmpty()) { // se não for vazio
                if (Stringhorario.length() == 5) {
                    Stringhorario += ":00";
                }
                Time horario = Time.valueOf(Stringhorario);
                int situacao = eventosDAO.alterarHorario(id, horario);

                //veriifca o retorno dos métodos das classes DAO
                if (situacao == 1) {
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar horário, verique se foi colocado no formato correto.");
                }else {
                    request.setAttribute("mensagem", "Erro no alterar horário, verique se foi colocado no formato correto.");
                }
            }

            //verifica e altera a data de início
            if (StringdataInicio != null && !StringdataInicio.isEmpty()) { // se não for vazio
                Date dataInicio = Date.valueOf(StringdataInicio);
                int situacao = eventosDAO.alterarDataInicio(id, dataInicio);

                //veriifca o retorno dos métodos das classes DAO
                if (situacao == 1) {
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar data de inicio, verique se foi colocado no formato correto.");
                }else {
                    request.setAttribute("mensagem", "Erro no alterar data de inicio, verique se foi colocado no formato correto.");
                }
            }

            //verifica e altera a data de término
            if (StringdataTermino != null && !StringdataTermino.isEmpty()) { // se não for vazio
                Date dataTermino = Date.valueOf(StringdataTermino);
                int situacao = eventosDAO.alterarDataTermino(id, dataTermino);

                //veriifca o retorno dos métodos das classes DAO
                if (situacao == 1) {
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar data de termino, verique se foi colocado no formato correto.");
                }else {
                    request.setAttribute("mensagem", "Erro no alterar data de termino, verique se foi colocado no formato correto.");
                }
            }

            //verifica e altera o preco por pessoa
            if (StringprecoPessoa != null && !StringprecoPessoa.isEmpty()) { // se não for vazio
                double precoPessoa = Double.parseDouble(StringprecoPessoa);
                int situacao = eventosDAO.alterarPrecoPessoa(id, precoPessoa);

                //veriifca o retorno dos métodos das classes DAO
                if (situacao == 1) {
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar preço por pessoa, verique se foi colocado no formato correto.");
                }else {
                    request.setAttribute("mensagem", "Erro no alterar preço por pessoa, verique se foi colocado no formato correto.");
                }
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
