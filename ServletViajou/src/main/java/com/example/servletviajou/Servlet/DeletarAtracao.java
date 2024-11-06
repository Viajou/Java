package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.AtracaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.InputMismatchException;


@WebServlet(name = "DeletarAtracao", value = "/DeletarAtracao-servlet")
    public class DeletarAtracao extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            AtracaoDAO atracaoDAO = new AtracaoDAO();
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                // Redirecionando para a página de confirmação
                try {
                    int resultado = atracaoDAO.deletarAtracao(id); // Método deletar implementado no DAO para remover o admin
                    if (resultado ==1) {
                        request.getRequestDispatcher("/listar_atracao.jsp").forward(request, response);
                    }
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao deletar administrador.");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao deletar administrador.");
                }
            }catch (InputMismatchException ime){
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao deletar administrador.");
            }
            request.setAttribute("caminho", "listar_atracao.jsp");
            request.setAttribute("sucessMessage", "sucesso");
            request.getRequestDispatcher("sucesso.jsp").forward(request, response);

    }
}