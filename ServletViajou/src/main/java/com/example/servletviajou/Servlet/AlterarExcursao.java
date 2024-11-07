package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.EventosDAO;
import com.example.servletviajou.DAO.ExcursaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

//ARRUMAR
@WebServlet(name = "AlterarExcursao", value = "/AlterarExcursao-servlet")
    public class AlterarExcursao extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            // Obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            String novoNomeEmpresa = request.getParameter("nomeEmpresa");
            String novaCapacidade = request.getParameter("capacidade");
            String novaDuracao = request.getParameter("descricao");
            String novoSite = request.getParameter("site");
            String novoPrecoTotal = request.getParameter("precoTotal");
            String novaDataInicio = request.getParameter("dataInicio");
            String novaDataTermino = request.getParameter("dataTermino");

            //instanciando a classe ExcursãoDAO
            ExcursaoDAO excursaoDAO = new ExcursaoDAO();

            //verificar os campos antes de altera-los
            // verificando e alterando o nome da empresa
            if (novoNomeEmpresa != null && !novoNomeEmpresa.isEmpty()){
                int situacao = excursaoDAO.alterarNomeEmpresa(id, novoNomeEmpresa);

                // verifica os resultados retonados pelo método
                if (situacao == 1){
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }
                else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar excursão");
                }
                else{
                    request.setAttribute("mensagem", "Erro no alterar excursão");
                }
            }

            // verificando e alterando a capacidade

            if (novaCapacidade != null && !novaCapacidade.isEmpty()) { // se não for vazio
                try {
                    int capacidade = Integer.parseInt(novaCapacidade);
                    int situacao = excursaoDAO.alterarCapacidade(id, capacidade);

                    //veriifca o retorno dos métodos das classes DAO
                    if (situacao == 1) {
                        request.setAttribute("mensagem", "Alterado com sucesso!");
                    }else if (situacao == 0) {
                        request.setAttribute("mensagem", "Erro no alterar capacidade, verique se foi colocado no formato correto.");
                    }else {
                        request.setAttribute("mensagem", "Erro no alterar capacidade, verique se foi colocado no formato correto.");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());
                }
            }


            //verificando e alterando a descrição


            //verificando e alteran do o site
            if (novoSite != null && !novoSite.isEmpty()){
                int situacao = excursaoDAO.alterarSite(id, novoSite);
                // verifica os resultados retonados pelo método
                if (situacao == 1){
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }
                else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar excursão");
                }
                else{
                    request.setAttribute("mensagem", "Erro no alterar excursão");
                }
            }

            // verificando e alterando preço


           //verificando e alterando a data de início
            if (novaDataInicio != null && !novaDataInicio.isEmpty()) { // se não for vazio
                java.sql.Date data_inicio = Date.valueOf(novaDataInicio);
                int situacao = excursaoDAO.alterarDataTermino(id, data_inicio);

                //veriifca o retorno dos métodos das classes DAO
                if (situacao == 1) {
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar data de termino, verique se foi colocado no formato correto.");
                }else {
                    request.setAttribute("mensagem", "Erro no alterar data de termino, verique se foi colocado no formato correto.");
                }
            }

            //verificando e alterando a data de término
            if (novaDataTermino != null && !novaDataTermino.isEmpty()) { // se não for vazio
                java.sql.Date data_termino = Date.valueOf(novaDataTermino);
                int situacao = excursaoDAO.alterarDataTermino(id, data_termino);

                //veriifca o retorno dos métodos das classes DAO
                if (situacao == 1) {
                    request.setAttribute("mensagem", "Alterado com sucesso!");
                }else if (situacao == 0) {
                    request.setAttribute("mensagem", "Erro no alterar data de termino, verique se foi colocado no formato correto.");
                }else {
                    request.setAttribute("mensagem", "Erro no alterar data de termino, verique se foi colocado no formato correto.");
                }
            }

            //dando o caminho de resposta para o servlet
            request.setAttribute("mensagem", "Excursão alterada com sucesso!");

        // tratamento de exceção
        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro ao alterar a excursão: " + e.getMessage());
        }

        request.setAttribute("caminho", "listar_excursao.jsp");
        request.setAttribute("sucessMessage", "sucesso");
        request.getRequestDispatcher("sucesso.jsp").forward(request, response);

    }
}
