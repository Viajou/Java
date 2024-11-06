package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import com.example.servletviajou.Model.Atracao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "InserirAtracao", value = "/InserirAtracao-servlet")
    public class InserirAtracao extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Obtendo os dados do formulário
        String descricao = request.getParameter("descricao");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        boolean acessibilidade = Boolean.parseBoolean(request.getParameter("acessibilidade"));
        String categoria = request.getParameter("categoria");


        // Criando o objeto Atracao
        AtracaoDAO atracaoDAO = new AtracaoDAO();

        //Criando objeto atracao
        Atracao novaAtracao = new Atracao(descricao, nome, endereco, acessibilidade, categoria);

        // Redirecionando para a página de confirmação
        try {
                int num = atracaoDAO.inserirAtracao(novaAtracao);
                if (num == 1) {
                    request.setAttribute("retorno", "certo");
                } else if (num == 0) {
                    request.setAttribute("retorno", "notfound");
                } else {
                    request.setAttribute("retorno", "erro");
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("caminho", "listar_atracao.jsp");
        request.setAttribute("sucessMessage", "sucesso");
        request.getRequestDispatcher("sucesso.jsp").forward(request, response);
    }
}