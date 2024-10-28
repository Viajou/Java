package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.PlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class BuscarPlano extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PlanoDAO planoDAO = new PlanoDAO();

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            planoDAO.buscar(id);
            if(planoDAO.buscar(id) != null){
                request.setAttribute("plano", planoDAO.buscar(id));
                request.getRequestDispatcher("/WEB-INF/views/excursaoDetalhes.jsp").forward(request, response);
            }
        }
        catch (NumberFormatException e) {
            request.setAttribute("erro", "ID inválido!");
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        }
        catch (Exception e) {
            request.setAttribute("erro", "Erro ao buscar o plano.");
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        }
    }
}