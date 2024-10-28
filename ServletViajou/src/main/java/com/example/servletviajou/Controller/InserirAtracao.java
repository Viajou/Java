package com.example.servletviajou.Controller;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Obtendo os dados do formulário
        String novaDescricao = request.getParameter("descricao");
        String novoNome = request.getParameter("nome");
        String novoEndereco = request.getParameter("endereco");
        boolean novaAcessibilidade = Boolean.parseBoolean(request.getParameter("acessibilidade"));
        String novaCategoria = request.getParameter("categoria");


        // Criando o objeto Atracao
        AtracaoDAO atracaoDAO = new AtracaoDAO();

        //Criando objeto de excursao
        Atracao novaAtracao = new Atracao(novaDescricao, novoNome, novoEndereco, novaAcessibilidade, novaCategoria);

        // Redirecionando para a página de confirmação
        try {
            ResultSet rs = atracaoDAO.buscar();
            if (!rs.next()) {
                int num = atracaoDAO.inserirAtracao(novaAtracao);
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