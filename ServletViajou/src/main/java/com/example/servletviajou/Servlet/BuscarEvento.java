// Declara o pacote da classe
package com.example.servletviajou.Servlet;

// Importa as classes necessárias para a manipulação de dados e a criação do servlet
import com.example.servletviajou.DAO.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Define o servlet e a URL que irá acionar este servlet
@WebServlet(name = "buscarEvento", value = "/BuscarEvento-servlet")
public class BuscarEvento extends HttpServlet {

    // Método principal que lida com requisições GET
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            // Obtém o valor do parâmetro de busca fornecido pelo usuário
            String search = request.getParameter("search");
            EventosDAO eventosDAO = new EventosDAO(); // Cria uma instância de EventosDAO para acesso aos dados

            // Converte o valor de busca para um inteiro, assumindo que se trata de um ID
            int eventoId = Integer.parseInt(search);

            // Executa a busca do evento no banco de dados usando o ID
            ResultSet busca = eventosDAO.buscar(eventoId);
            // Verifica se o ResultSet está vazio (se o evento existe)
            if (busca.next()) { // Se há resultados
                ResultSet certo = eventosDAO.buscar(eventoId); // Realiza novamente a busca para obter os dados completos
                request.setAttribute("resultados", certo); // Atribui o resultado da busca à requisição

                // Encaminha o usuário para a página de listagem, agora com o evento encontrado
                request.getRequestDispatcher("listar_eventos.jsp").forward(request, response);
            } else {
                // Caso o evento não seja encontrado, define uma mensagem de erro e encaminha para a listagem
                request.setAttribute("naoEncontrado", "Evento não encontrado...");
                request.getRequestDispatcher("listar_eventos.jsp").forward(request, response);
            }

        } catch (NumberFormatException nfe) {
            // Captura exceções quando o ID inserido pelo usuário não é um número válido
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
