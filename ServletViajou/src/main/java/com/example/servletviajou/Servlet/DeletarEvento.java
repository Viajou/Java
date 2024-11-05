package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.EventosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletarEventos", value = "/DeletarEventos-servelet")
public class DeletarEvento extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));
        EventosDAO eventosDAO = new EventosDAO();

        try {
            eventosDAO.deletarEvento(id); // Método deletar implementado no DAO para remover o admin
            request.getRequestDispatcher("/listar_evento.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao deletar administrador.");
        }
    }
}
