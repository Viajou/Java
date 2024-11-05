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
        int adminId;
        adminId = Integer.parseInt(search);
        ResultSet busca = adminDAO.buscar(adminId);

        try {
            // Verifica se o ResultSet está vazio
            if (busca.next()) { // Se não há resultados
                ResultSet certo = adminDAO.buscar(adminId);
                request.setAttribute("resultados", certo);
                // Redireciona para a página de listagem
                request.getRequestDispatcher("listar_admin.jsp").forward(request, response);
            } else {
                request.setAttribute("naoEncontrado", "Admin não encontrado...");
                request.getRequestDispatcher("listar_admin.jsp").forward(request, response);
            }


        } catch (NumberFormatException nfe) {
            // Trata o caso onde o ID não é um número válido
            request.setAttribute("errorMessage", "Por favor, insira um ID válido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }catch (SQLException sqle) {
            request.setAttribute("errorMessage", sqle.getMessage());
        }
    }
}
