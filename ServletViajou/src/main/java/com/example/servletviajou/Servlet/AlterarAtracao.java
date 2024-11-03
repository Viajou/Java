package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterarAtracao", value = "/AlterarAtracao-servlet")
    public class AlterarAtracao extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

            // Obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            String novaDescricao = request.getParameter("descricao");
            String novoNome = request.getParameter("nome");
            String novoEndereco = request.getParameter("endereco");
            boolean novaAcessibilidade = Boolean.parseBoolean(request.getParameter("acessibilidade"));
            String novaCategoria = request.getParameter("categoria");

            // Instanciando o DAO para alterar os dados
            AtracaoDAO atracaoDAO = new AtracaoDAO();
            atracaoDAO.alterarDescricao(id, novaDescricao);
            atracaoDAO.alterarNome(id, novoNome);
            atracaoDAO.alterarEndereco(id, novoEndereco);
            atracaoDAO.alterarAcessibilidade(id, novaAcessibilidade);
            atracaoDAO.alterarCategoria(id, novaCategoria);
            request.setAttribute("mensagem", "Excursão alterada com sucesso!");

        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro ao alterar a excursão: " + e.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/jsp/excursao.jsp").forward(request, response);
    }
}