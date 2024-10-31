package org.viajou.crudviajou.excursao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
    public class DeletarExcursao extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ExcursaoDAO excursaoDAO = new ExcursaoDAO();

        int id = Integer.parseInt(request.getParameter("id"));

        // Atualizando o nome da empresa no banco de dados
        int resultado = excursaoDAO.de(id);

        // Redirecionando para a página de confirmação
        if (resultado > 0) {
            request.getSession().setAttribute("mensagem", "Nome da empresa alterado com sucesso!");
            response.sendRedirect("paginaSucesso.jsp");
        } else {
            request.getSession().setAttribute("mensagem", "Erro ao alterar nome da empresa.");
            response.sendRedirect("paginaErro.jsp");
        }

    }
}
