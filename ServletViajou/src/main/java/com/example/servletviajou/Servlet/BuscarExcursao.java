package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.EventosDAO;
import com.example.servletviajou.DAO.ExcursaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "buscarExcursao", value = "/BuscarExcursao-servlet")
public class BuscarExcursao extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        ExcursaoDAO excursaoDAO = new ExcursaoDAO();

        int excursaoId = Integer.parseInt(search);
        ResultSet busca = excursaoDAO.buscar(excursaoId);

        try {
            // Verifica se o ResultSet está vazio
            if (busca.next()) { // Se não há resultados
                ResultSet certo = excursaoDAO.buscar(excursaoId);
                request.setAttribute("resultados", certo);
                // Redireciona para a página de listagem
                request.getRequestDispatcher("listar_excursao.jsp").forward(request, response);
            } else {
                request.setAttribute("naoEncontrado", "Excursão não encontrada...");
                request.getRequestDispatcher("listar_excursao.jsp").forward(request, response);
            }

        } catch (NumberFormatException nfe) {
            // Trata o caso onde o ID não é um número válido
            request.setAttribute("errorMessage", "Por favor, insira um ID válido.");
            request.getRequestDispatcher("listar_excursao.jsp").forward(request, response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}