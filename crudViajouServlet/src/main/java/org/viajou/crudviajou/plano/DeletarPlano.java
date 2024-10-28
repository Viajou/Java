package org.viajou.crudviajou.plano;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class DeletarPlano extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PlanoDAO planoDAO = new PlanoDAO;

        int id = Integer.parseInt(request.getParameter("id"));

        int resultado = planoDAO.deletarPlano(id);
        if (resultado > 0) {
            request.getSession().setAttribute("mensagem", "Plano deletado com sucesso!");
            response.sendRedirect("paginaSucesso.jsp");
        }
        else{
            request.getSession().setAttribute("mensagem", "Erro ao deletar plano.");
            response.sendRedirect("paginaErro.jsp");
        }
    }
}