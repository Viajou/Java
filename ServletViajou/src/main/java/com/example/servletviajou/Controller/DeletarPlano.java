package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.PlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletarPlano", value = "/DeletarPlano-servlet")
public class DeletarPlano extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PlanoDAO planoDAO = new PlanoDAO();

        int id = Integer.parseInt(request.getParameter("id"));

        int resultado = planoDAO.deletarPlano(id);
        if (resultado == 1) {
            request.getSession().setAttribute("mensagem", "Plano deletado com sucesso!");
            response.sendRedirect("paginaSucesso.jsp");
        }
        else if(resultado == 0){
            request.getSession().setAttribute("erro", "Erro! Não foi possível deletar esse plano");
            response.sendRedirect("paginaErro.jsp");
        }
        else if(resultado == -1){
            request.getSession().setAttribute("erro","Erro! Não foi possível deletar esse plano");
            response.sendRedirect("paginaErro.jsp");
        }
    }
}