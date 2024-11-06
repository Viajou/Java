// Declara o pacote da classe
package com.example.servletviajou.Servlet;

// Importa as classes necessárias para a manipulação de dados e a criação do servlet
import com.example.servletviajou.DAO.AtracaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarAtracao", value = "/buscarAtracao-servlet")
public class BuscarAtracao extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            // Obtém o valor do parâmetro de busca fornecido pelo usuário
            String id = request.getParameter("search");

            // Converte o valor de busca para um inteiro, assumindo que se trata de um ID
            AtracaoDAO atracaoDAO = new AtracaoDAO();

            // Executa a busca do evento no banco de dados usando o ID
            int atracaoId = Integer.parseInt(id);
            ResultSet busca = atracaoDAO.buscar(atracaoId);

            // Verifica se o ResultSet está vazio
            if (busca.next()) { // Se não há resultados
                ResultSet certo = atracaoDAO.buscar(atracaoId);// Realiza novamente a busca para obter os dados completos

                request.setAttribute("resultados", certo);// Atribui o resultado da busca à requisição

                // Encaminha o usuário para a página de listagem, agora com a atração encontrada
                request.getRequestDispatcher("listar_atracao.jsp").forward(request, response);
            } else {
                // Caso o evento não seja encontrado, define uma mensagem de erro e encaminha para a listagem
                request.setAttribute("naoEncontrado", "Atração não encontrada...");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (NumberFormatException nfe) {
            // Captura exceções quando o ID inserido pelo usuário não é um número válido
            String erro = nfe.getMessage();
            request.setAttribute("errorMessage", erro);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (SQLException sqle) {
            // Imprime a exceção SQL para facilitar o rastreamento de erros
            sqle.printStackTrace();
        }
    }
}
