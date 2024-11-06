package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.PlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarPlano", value = "/buscarPlano-servlet")
public class BuscarPlano extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String search = request.getParameter("search");
            PlanoDAO planoDAO = new PlanoDAO();

            int planoId = Integer.parseInt(search);
            ResultSet busca = planoDAO.buscar(planoId);
            // Verifica se o ResultSet está vazio
            if (busca.next()) { // Se não há resultados
                ResultSet certo = planoDAO.buscar(planoId);
                request.setAttribute("resultados", certo);
                // Redireciona para a página de listagem
                request.getRequestDispatcher("listar_plano.jsp").forward(request, response);
            } else {
                request.setAttribute("naoEncontrado", "Plano não encontrado...");
                request.getRequestDispatcher("listar_plano.jsp").forward(request, response);
            }


        } catch (NumberFormatException nfe) {
            // Trata o caso onde o ID não é um número válido
            String erro = nfe.getMessage();
            request.setAttribute("errorMessage", erro);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }catch (SQLException sqle) {
            request.setAttribute("errorMessage", sqle.getMessage());
        }
    }
}
