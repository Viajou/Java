package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.EventosDAO;
import com.example.servletviajou.DAO.TourVirtualDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet (name = "BuscarTourVirtual", value = "/BuscarTourVirtual-servlet")
public class BuscarTourVirtual extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {

        try {
            // Obtém o valor do parâmetro de busca fornecido pelo usuário
            String search = request.getParameter("search");
            TourVirtualDAO tourVirtualDAO = new TourVirtualDAO(); // Cria uma instância de EventosDAO para acesso aos dados

            // Converte o valor de busca para um inteiro, assumindo que se trata de um ID
            int tourVirtualId = Integer.parseInt(search);

            // Executa a busca do evento no banco de dados usando o ID
            ResultSet busca = tourVirtualDAO.buscar(tourVirtualId);
            // Verifica se o ResultSet está vazio (se o evento existe)
            if (busca.next()) { // Se há resultados
                ResultSet certo = tourVirtualDAO.buscar(tourVirtualId); // Realiza novamente a busca para obter os dados completos
                request.setAttribute("resultados", certo); // Atribui o resultado da busca à requisição

                // Encaminha o usuário para a página de listagem, agora com o evento encontrado
                request.getRequestDispatcher("listar_tour_virtual.jsp").forward(request, response);
            } else {
                // Caso o evento não seja encontrado, define uma mensagem de erro e encaminha para a listagem
                request.setAttribute("naoEncontrado", "Tour virtual não encontrado...");
                request.getRequestDispatcher("listar_tour_virtual.jsp").forward(request, response);
            }

        // tratamento de exceções
        } catch (NumberFormatException nfe) {
            String erro = nfe.getMessage();
            request.setAttribute("errorMessage", erro);
            request.setAttribute("caminho", "listar_atracao.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (SQLException sqle) {
            // Imprime a exceção SQL para facilitar o rastreamento de erros
            sqle.printStackTrace();
        }
    }
}
