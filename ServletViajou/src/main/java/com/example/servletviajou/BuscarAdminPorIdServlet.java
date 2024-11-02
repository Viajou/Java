package com.example.servletviajou;

import com.example.servletviajou.DAO.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

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
            } else {
                busca = adminDAO.buscar();
            }
            request.setAttribute("resultados", busca);
            request.getRequestDispatcher("ListarAdmins.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ListarAdmins.jsp?erro=Erro na busca");
        }
    }
}
