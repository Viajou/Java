package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.EventosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "BuscarEvento", value = "BuscarEvento-servlet")
public class BuscarEvento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // obtendo dados do formulário
            int id = Integer.parseInt(req.getParameter("id"));

            //instanciando a classe DAO de eventos
            EventosDAO eventosDAO = new EventosDAO();

            //buscar com id
            eventosDAO.buscar(id);

            //verificação de retorno
            ResultSet rsComid = eventosDAO.buscar(id);

            if (rsComid.next()){
                req.setAttribute("mensagem", rsComid);
                req.getRequestDispatcher("/eventos.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("erro", "Evento não encontrado");
                req.getRequestDispatcher("erro.jsp").forward(req, resp);
            }

            //buscar sem id

            ResultSet rsSemid = eventosDAO.buscar();

            if (rsSemid.next()){
                req.setAttribute("mensagem", rsComid);
                req.getRequestDispatcher("/eventos.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("erro", "Evento não encontrado");
                req.getRequestDispatcher("erro.jsp").forward(req, resp);
            }

        } catch (NumberFormatException nfe){
            req.setAttribute("Erro", "ID inválido!");
            req.getRequestDispatcher("erro.jsp").forward(req, resp);
        } catch (SQLException sqle){
            req.setAttribute("erro", "Erro de SQLexception" + sqle.getMessage());
            req.getRequestDispatcher("erro.jsp").forward(req, resp);
        }
    }
}
