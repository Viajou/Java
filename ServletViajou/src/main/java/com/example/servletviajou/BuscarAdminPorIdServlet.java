package com.example.servletviajou;

import com.example.servletviajou.DAO.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/BuscarAdminPorIdServlet")
public class BuscarAdminPorIdServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        AdminDAO adminDAO = new AdminDAO();
        ResultSet busca;

        try {
            if (search != null && !search.isEmpty()) {
                int adminId = Integer.parseInt(search);
                busca = adminDAO.buscar(adminId);
                request.setAttribute("resultados", busca);
            }

            // Redireciona para a página de listagem
            request.getRequestDispatcher("listar_admin.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Trata o caso onde o ID não é um número válido
            request.setAttribute("errorMessage", "Por favor, insira um ID válido.");
            request.getRequestDispatcher("listar_admin.jsp").forward(request, response);
        }
    }
}
