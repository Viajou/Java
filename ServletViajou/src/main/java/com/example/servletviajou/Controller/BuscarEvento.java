<<<<<<< HEAD
//package com.example.servletviajou.Controller;
//
//import com.example.servletviajou.DAO.EventosDAO;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@WebServlet(name = "BuscarEvento", value = "BuscarEvento-servlet")
//public class BuscarEvento extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        try {
//            // obtendo dados do formulário
//            int id = Integer.parseInt(req.getParameter("id"));
//
//            //instanciando a classe DAO de eventos
//            EventosDAO eventosDAO = new EventosDAO();
//
//            //buscar com id
//            eventosDAO.buscar(id);
//
//            //verificação de retorno
//            ResultSet rsComid = eventosDAO.buscar(id);
//
//            if (rsComid.next()){
//                req.setAttribute("mensagem", rsComid);
//                req.getRequestDispatcher("BuscarEventos.jsp").forward(req, resp);
//            }
//            else {
//                req.setAttribute("erro", "Evento não encontrado");
//                req.getRequestDispatcher("erro.jsp").forward(req, resp);
//            }
//
//            //buscar sem id
//
//            ResultSet rsSemid = eventosDAO.buscar();
//
//            if (rsSemid.next()){
//                req.setAttribute("mensagem", rsComid);
//                req.getRequestDispatcher("BuscarEventos.jsp").forward(req, resp);
//            }
//            else {
//                req.setAttribute("erro", "Evento não encontrado");
//                req.getRequestDispatcher("erro.jsp").forward(req, resp);
//            }
//
//        } catch (NumberFormatException nfe){
//            req.setAttribute("Erro", "ID inválido!");
//            req.getRequestDispatcher("erro.jsp").forward(req, resp);
//        } catch (SQLException sqle){
//            req.setAttribute("erro", "Erro de SQLexception" + sqle.getMessage());
//            req.getRequestDispatcher("erro.jsp").forward(req, resp);
//        }
//    }
//}
=======
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // obtendo dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));

            //instanciando a classe DAO de eventos
            EventosDAO eventosDAO = new EventosDAO();

            //buscar com id
            eventosDAO.buscar(id);

            //verificação de retorno
            ResultSet rsComid = eventosDAO.buscar(id);

            if (rsComid.next()){
                request.setAttribute("mensagem", eventosDAO.buscar(id));
                request.getRequestDispatcher("BuscarEventos.jsp").forward(request, response);
            }
            else {
                request.setAttribute("erro", "Evento não encontrado");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

            //buscar sem id

            ResultSet rsSemid = eventosDAO.buscar();

            if (rsSemid.next()){
                request.setAttribute("mensagem", eventosDAO.buscar());
                request.getRequestDispatcher("BuscarEventos.jsp").forward(request, response);
            }
            else {
                request.setAttribute("erro", "Evento não encontrado");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

        } catch (NumberFormatException nfe){
            request.setAttribute("Erro", "ID inválido!");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } catch (SQLException sqle){
            request.setAttribute("erro", "Erro de SQLexception" + sqle.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}
>>>>>>> c3784e9b47c7c99edb2de8355250dfb4d8244318
