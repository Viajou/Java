package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.TourVirtualDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet (name = "BuscarTourVirtual", value = "/BuscarTourVirtual-servlet")
public class BuscarTourVirtual extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {

        try {
            // obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));

            // instanciando um objeto da classe tourVirtualDAO
            TourVirtualDAO tourVirtualDAO = new TourVirtualDAO();

            // chamando os métodos buscar

            // buscar com id
            ResultSet rsComId = tourVirtualDAO.buscar(id);

            if (rsComId.next()) {
                request.setAttribute("mensagem", tourVirtualDAO.buscar(id));
                request.getRequestDispatcher("tourVirtualDetalhes.jsp").forward(request, response);
            } else{
               request.setAttribute("erro", "Tour virtual não encontrado!");
               request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

            // buscar sem id
            ResultSet rsSemId = tourVirtualDAO.buscar();

            if(rsSemId.next()) {
                request.setAttribute("mensagem", tourVirtualDAO.buscar(id));
                request.getRequestDispatcher("tourVirtualDetalhes.jsp").forward(request, response);
            } else{
                request.setAttribute("erro", "Tour virtual não encontrado!");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

        } catch (NumberFormatException nfe){
            request.setAttribute("erro", "Erro! ID inválido!");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }

    }
}
