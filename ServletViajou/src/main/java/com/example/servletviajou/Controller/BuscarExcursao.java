package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.ExcursaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "BuscarExcursao", value = "/BuscarExcursao-servlet")
    public class BuscarExcursao extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        ExcursaoDAO excursaoDAO = new ExcursaoDAO();


        try {
            int id = Integer.parseInt(request.getParameter("id"));
            excursaoDAO.buscar(id);

            if (excursaoDAO.buscar(id) != null) {
                request.setAttribute("excursao", excursaoDAO.buscar(id));
                request.getRequestDispatcher("/WEB-INF/views/excursaoDetalhes.jsp").forward(request, response);
            } else {
                request.setAttribute("erro", "Excursão não encontrada!");
                request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("erro", "ID inválido!");
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("erro", "Erro ao buscar a excursão.");
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        }


    }
}