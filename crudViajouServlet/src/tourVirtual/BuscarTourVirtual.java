package org.viajou.crudviajou.tourVirtual;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet (name = "helloServlet", value = "/hello-servlet")
public class BuscarTourVirtual extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {

        try {
            // obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));

            // instanciando um objeto da classe tourVirtualDAO
            TourVirtualDAO tourVirtualDAO = new TourVirtualDAO();

            // chamando os métodos buscar
            ResultSet rs = tourVirtualDAO.buscar(id);

            if (rs != null) {
                request.setAttribute("tourVirtual", tourVirtualDAO.buscar(id));
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
