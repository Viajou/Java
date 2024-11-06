package com.example.servletviajou;

import com.example.servletviajou.DAO.AdminDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletarAdminServlet", value = "/DeletarAdminServlet")
public class DeletarAdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));
        AdminDAO adminDAO = new AdminDAO();

        try {
            adminDAO.deletarAdmin(id); // Método deletar implementado no DAO para remover o admin
            request.setAttribute("caminho", "listar_admin.jsp");
            request.getRequestDispatcher("sucesso.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}