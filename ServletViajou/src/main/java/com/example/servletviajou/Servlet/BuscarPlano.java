// Declara o pacote da classe
package com.example.servletviajou.Servlet;

// Importa as classes necessárias para a manipulação de dados e a criação do servlet
import com.example.servletviajou.DAO.PlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarPlano", value = "/buscarPlano-servlet")
public class BuscarPlano extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtém o valor do parâmetro de busca fornecido pelo usuário
            String search = request.getParameter("search");
            PlanoDAO planoDAO = new PlanoDAO();

            // Converte o valor de busca para um inteiro, assumindo que se trata de um ID
            int planoId = Integer.parseInt(search);

            // Executa a busca do plano no banco de dados usando o ID
            ResultSet busca = planoDAO.buscar(planoId);
            // Verifica se o ResultSet está vazio
            if (busca.next()) { // Se não há resultados
                ResultSet certo = planoDAO.buscar(planoId);// Realiza novamente a busca para obter os dados completos
                request.setAttribute("resultados", certo);// Atribui o resultado da busca à requisição
                // Redireciona para a página de listagem
                request.getRequestDispatcher("listar_plano.jsp").forward(request, response);
            } else {
                // Caso o plano não seja encontrado, define uma mensagem de erro e encaminha para a listagem
                request.setAttribute("naoEncontrado", "Plano não encontrado...");
                request.getRequestDispatcher("listar_plano.jsp").forward(request, response);
            }

            //tratamento de exceções
        } catch (NumberFormatException nfe) {
            String erro = nfe.getMessage();
            request.setAttribute("errorMessage", erro);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }catch (SQLException sqle) {
            // Imprime a exceção SQL para facilitar o rastreamento de erros
            request.setAttribute("errorMessage", sqle.getMessage());
        }
    }
}
