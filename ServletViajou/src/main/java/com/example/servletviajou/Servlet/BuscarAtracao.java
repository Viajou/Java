package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import com.example.servletviajou.DAO.ExcursaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "BuscarAtracao" , value = "/BuscarAtracao-servelt")
public class BuscarAtracao extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        AtracaoDAO atracaoDAO = new AtracaoDAO();


        try {
            int id = Integer.parseInt(request.getParameter("id"));
            atracaoDAO.buscar(id);

            if (atracaoDAO.buscar(id) != null) {
                request.setAttribute("resultados", atracaoDAO.buscar(id));
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
