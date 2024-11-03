package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "DeletarAtracao", value = "/DeletarAtracao-servlet")
    public class DeletarAtracao extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            AtracaoDAO AtracaoDAO = new AtracaoDAO();

            int id = Integer.parseInt(request.getParameter("id"));

            // Atualizando o nome da empresa no banco de dados
            int resultado = AtracaoDAO.deletarAtracao(id);

            // Redirecionando para a página de confirmação

    }
}