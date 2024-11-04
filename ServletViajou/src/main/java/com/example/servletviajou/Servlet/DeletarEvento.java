package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.EventosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletarEventos", value = "/DeletarEventos-servelet")
public class DeletarEvento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // obtendo valores do formulário

            int id = Integer.parseInt(request.getParameter("id"));

            //instanciando classe DAO

            EventosDAO eventosDAO = new EventosDAO();

            //verificando os dados

            int DelComid = eventosDAO.deletarEvento(id);

            if (DelComid == 1){
                request.getSession().setAttribute("mensagem", "Evento excluido com sucesso");
                response.sendRedirect("deletarEvento.jsp");
            }
            else if (DelComid == 0) {
                request.getSession().setAttribute("mensagem", "Evento não encontrado");
                response.sendRedirect("erro.jsp");
            }
            else {
                request.getSession().setAttribute("mensagem", "Erro de SQL");
                response.sendRedirect("erro.jsp");
            }
        } catch (NumberFormatException nfe){
            request.setAttribute("Erro", "ID inválido!");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}
