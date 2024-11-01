package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.PlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class BuscarPlano extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        try{
            //obtendo dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            //instanciando um objeto a classe PlanoDAO
            PlanoDAO planoDAO = new PlanoDAO();
            //chamando métodos para buscar com id
            ResultSet comID = planoDAO.buscar(id);
            if(comID.next()){
                request.setAttribute("plano", planoDAO.buscar(id));
                request.getRequestDispatcher("/WEB-INF/views/planoDetalhes.jsp").forward(request, response);
            }
            else{
                request.setAttribute("erro", "Plano não encontrado!");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
            //chamando métodos para chamar sem id
            ResultSet semID = planoDAO.buscar();
            if(semID.next()){
                request.setAttribute("plano", planoDAO.buscar(id));
                request.getRequestDispatcher("/WEB-INF/views/planoDetalhes.jsp").forward(request, response);
            }
            else{
                request.setAttribute("erro", "Plano não encontrado!");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        }
        catch (NumberFormatException e) {
            request.setAttribute("erro", "ID inválido!");
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        }
        catch (Exception e) {
            request.setAttribute("erro", "Erro ao buscar o plano.");
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        }
    }
}