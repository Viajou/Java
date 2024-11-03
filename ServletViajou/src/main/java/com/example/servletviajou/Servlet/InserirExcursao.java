package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.ExcursaoDAO;
import com.example.servletviajou.Model.Excursao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "InserirExcursao", value = "/InserirExcursao-servlet")
    public class InserirExcursao extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        ExcursaoDAO excursaoDAO = new ExcursaoDAO();

        // Obtendo os dados do formulário
        String novoNomeEmpresa = request.getParameter("nomeEmpresa");
        int novaCapacidade = Integer.parseInt(request.getParameter("capacidade"));
        String novaDuracao = request.getParameter("duracao");
        String novoSite = request.getParameter("site");
        double novoPrecoTotal = Double.parseDouble(request.getParameter("precoTotal"));
        Date novaDataInicio = Date.valueOf(request.getParameter("dataInicio"));
        Date novaDataTermino = Date.valueOf(request.getParameter("dataTermino"));
        String novaCategoria = request.getParameter("categoria");
        int novoIdAtracao = Integer.parseInt(request.getParameter("idAtracao"));


        // Inserindo a excursão no banco de dados

        //Criando objeto de excursao
        Excursao novaExcursao = new Excursao(novoNomeEmpresa, novaCapacidade, novaDuracao, novoSite, novoPrecoTotal, novaDataInicio, novaDataTermino, novaCategoria, novoIdAtracao);

        // Redirecionando para a página de confirmação
        try {
            ResultSet rs = excursaoDAO.buscar(novoIdAtracao);
            if (!rs.next()) {
                int num = excursaoDAO.inserirExcursao(novaExcursao);
                if (num == 1) {
                    request.setAttribute("retorno", "certo");
                } else if (num == 0) {
                    request.setAttribute("retorno", "notfound");
                } else {
                    request.setAttribute("retorno", "erro");
                }
            } else {
                request.setAttribute("retorno", "existente");  // Categoria já existe
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}