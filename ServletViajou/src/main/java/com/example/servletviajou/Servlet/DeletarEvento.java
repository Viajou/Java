package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.EventosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletarEventos", value = "DeletarEevntos-servelet")
public class DeletarEvento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // obtendo valores do formulário

            int id = Integer.parseInt(req.getParameter("id"));

            //instanciando classe DAO

            EventosDAO eventosDAO = new EventosDAO();

            //verificando os dados

            int DelComid = eventosDAO.deletarEvento(id);

            if (DelComid == 1){
                req.getSession().setAttribute("mensagem", "Evento excluido com sucesso");
                resp.sendRedirect("deletarEvento.jsp");
            }
            else if (DelComid == 0) {
                req.getSession().setAttribute("mensagem", "Evento não encontrado");
                resp.sendRedirect("erro.jsp");
            }
            else {
                req.getSession().setAttribute("mensagem", "Erro de SQL");
                resp.sendRedirect("erro.jsp");
            }
        } catch (NumberFormatException nfe){
            req.setAttribute("Erro", "ID inválido!");
            req.getRequestDispatcher("erro.jsp").forward(req, resp);
        }
    }
}
