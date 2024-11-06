package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import com.example.servletviajou.Model.Atracao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "InserirAtracao", value = "/InserirAtracao-servlet")
    public class InserirAtracao extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        //Obtendo os dados da URL (Query String)
        String descricao = request.getParameter("descricao");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        boolean acessibilidade = Boolean.parseBoolean(request.getParameter("acessibilidade"));
        String categoria = request.getParameter("categoria");


        // Criando o objeto Atracao
        AtracaoDAO atracaoDAO = new AtracaoDAO();

        //Criando objeto de atracao
        Atracao novaAtracao = new Atracao(descricao, nome, endereco, acessibilidade, categoria);

        // Redirecionando para a página de confirmação
        try {
                int resultado = atracaoDAO.inserirAtracao(novaAtracao);
                if (resultado == 1) {
                    request.setAttribute("retorno", "certo");
                } else if (resultado == 0) {
                    request.setAttribute("retorno", "not found");
                } else {
                    request.setAttribute("retorno", "erro");
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Redirecionando para uma página de confirmação ou erro
        request.getRequestDispatcher("/listar_atracao.jsp").forward(request, response);

    }
}