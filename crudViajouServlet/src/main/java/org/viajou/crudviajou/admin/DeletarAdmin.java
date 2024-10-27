package org.viajou.crudviajou.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletarAdmin", value = "/deletar-admin")
public class DeletarAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        AdminDAO adminDAO = new AdminDAO();

        // Obtendo o dado da URL (Query String)
        int id = Integer.parseInt(request.getParameter("id"));

        // Atualizando o nome da empresa no banco de dados
        int resultado = adminDAO.deletarAdmin(id);

        // Redirecionando para a página de confirmação
        if (resultado > 0) {
            request.getSession().setAttribute("mensagem", "Admin deletado com sucesso!");
            response.sendRedirect("paginaSucesso.jsp");
        } else {
            request.getSession().setAttribute("mensagem", "Erro ao deletar admin!");
            response.sendRedirect("paginaErro.jsp");
        }

    }
}
