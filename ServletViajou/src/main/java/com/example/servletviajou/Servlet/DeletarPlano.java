package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.PlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletarPlano", value = "/DeletarPlano-servlet")
public class DeletarPlano extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));
        PlanoDAO planoDAO = new PlanoDAO();

        try {
            planoDAO.deletarPlano(id); // Método deletar implementado no DAO para remover o admin
            request.getRequestDispatcher("/listar_plano.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao deletar administrador.");
        }
    }

}