package com.example.servletviajou;

import com.example.servletviajou.DAO.AdminDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "BuscarAdminPorIdServlet", value = "/BuscarAdminPorIdServlet")
public class BuscarAdminPorIdServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        AdminDAO adminDAO = new AdminDAO();
        ResultSet busca = null;

        try {
            int id = Integer.parseInt(idStr);
            busca = adminDAO.buscar(id); // Método buscarPorId implementado no DAO

            // Adiciona os resultados à requisição para que o JSP possa acessar
            request.setAttribute("resultadoBusca", busca);
            request.setAttribute("id", idStr);
            request.getRequestDispatcher("BuscarAdminPorId.jsp").forward(request, response); // Redireciona para o JSP
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar administrador.");
        } finally {
            if (busca != null) {
                try {
                    busca.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
