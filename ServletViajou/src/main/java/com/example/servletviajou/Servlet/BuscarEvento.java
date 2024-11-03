package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.EventosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "BuscarEvento", value = "/BuscarEvento-servlet")
public class BuscarEvento extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        EventosDAO eventosDAO = new EventosDAO();

        int eventoId = Integer.parseInt(search);
        ResultSet busca = eventosDAO.buscar(eventoId);

        try {
            // Verifica se o ResultSet está vazio
            if (busca.next()) { // Se não há resultados
                ResultSet certo = eventosDAO.buscar(eventoId);
                request.setAttribute("resultados", certo);
                // Redireciona para a página de listagem
                request.getRequestDispatcher("listar_eventos.jsp").forward(request, response);
            } else {
                request.setAttribute("naoEncontrado", "Admin não encontrado...");
                request.getRequestDispatcher("listar_eventos.jsp").forward(request, response);
            }


        } catch (NumberFormatException nfe) {
            // Trata o caso onde o ID não é um número válido
            request.setAttribute("errorMessage", "Por favor, insira um ID válido.");
            request.getRequestDispatcher("listar_eventos.jsp").forward(request, response);
        }catch (SQLException sqle) {
            request.setAttribute("errorMessage", sqle.getMessage());
        }
    }
}
