package org.viajou.crudviajou.atracao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.viajou.crudviajou.excursao.ExcursaoDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
    public class DeletarAtracao extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            AtracaoDAO AtracaoDAO = new AtracaoDAO();

            int id = Integer.parseInt(request.getParameter("id"));

            // Atualizando o nome da empresa no banco de dados
            int resultado = AtracaoDAO.deletarAtracao(id);

            // Redirecionando para a página de confirmação

    }
}