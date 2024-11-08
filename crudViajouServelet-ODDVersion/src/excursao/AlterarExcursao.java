package org.viajou.crudviajou.excursao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
    public class AlterarExcursao extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            // Obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            String novoNomeEmpresa = request.getParameter("nomeEmpresa");
            int novaCapacidade = Integer.parseInt(request.getParameter("capacidade"));
            String novaDuracao = request.getParameter("descricao");
            String novoSite = request.getParameter("site");
            double novoPrecoTotal = Double.parseDouble(request.getParameter("precoTotal"));
            Date novaDataInicio = new Date(request.getParameter("dataInicio"));
            Date novaDataTermino = new Date(request.getParameter("dataTermino"));

            // Instanciando o DAO para alterar os dados
            ExcursaoDAO excursaoDAO = new ExcursaoDAO();
            excursaoDAO.alterarNomeEmpresa(id, novoNomeEmpresa);
            excursaoDAO.alterarCapacidade(id,novaCapacidade);
            excursaoDAO.alterarDuracao(id, novaDuracao);
            excursaoDAO.alterarSite(id, novoSite);
            excursaoDAO.alterarPrecoTotal(id, novoPrecoTotal);
            excursaoDAO.alterarDataInicio(id, (java.sql.Date) novaDataInicio);
            excursaoDAO.alterarDataTermino(id, (java.sql.Date) novaDataTermino);

            request.setAttribute("mensagem", "Excursão alterada com sucesso!");

        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro ao alterar a excursão: " + e.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/jsp/excursao.jsp").forward(request, response);
    }
}
