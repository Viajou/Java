package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.EventosDAO;
import com.example.servletviajou.DAO.ExcursaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "buscarExcursao", value = "/BuscarExcursao-servlet")
public class BuscarExcursao extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            //obtém o valor passado como parâmetro no buscar
            String search = request.getParameter("search");

            //instância a classe
            ExcursaoDAO excursaoDAO = new ExcursaoDAO();

            // converte o valor e passa como parâmetro
            int excursaoId = Integer.parseInt(search);
            ResultSet busca = excursaoDAO.buscar(excursaoId);

            // Verifica se o ResultSet está vazio
            if (busca.next()) { // Se há resultados
                ResultSet certo = excursaoDAO.buscar(excursaoId); // chama o método passando o id como parâmetro
                request.setAttribute("resultados", certo); // retorna a busca realizada

                // Redireciona para a página de listagem
                request.getRequestDispatcher("listar_excursao.jsp").forward(request, response);
            } else {
                request.setAttribute("naoEncontrado", "Excursão não encontrada..."); // envia mensagem de erro
                request.getRequestDispatcher("listar_excursao.jsp").forward(request, response);
            }

        } catch (NumberFormatException nfe) {
            // Trata o caso onde o ID não é um número válido
            String erro = nfe.getMessage();
            request.setAttribute("errorMessage", erro);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}