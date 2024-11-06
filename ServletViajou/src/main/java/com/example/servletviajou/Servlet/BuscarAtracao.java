package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.AtracaoDAO;
import com.example.servletviajou.DAO.ExcursaoDAO;
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

            // armazena o id obtido no formulário
            String id = request.getParameter("search");

            //instancia a classe DAO
            AtracaoDAO atracaoDAO = new AtracaoDAO();

            //converte o tipo para int e passa como parâmetro
            int atracaoId = Integer.parseInt(id);
            ResultSet busca = atracaoDAO.buscar(atracaoId);

            // Verifica se o ResultSet está vazio
            if (busca.next()) { // Se não há resultados
                ResultSet certo = atracaoDAO.buscar(atracaoId);

                //retorna a busca feita
                request.setAttribute("resultados", certo);

                // Redireciona para a página de listagem
                request.getRequestDispatcher("listar_atracao.jsp").forward(request, response);
            } else {
                // se der erro redireciona a página de erros
                request.setAttribute("naoEncontrado", "Atração não encontrada...");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (NumberFormatException nfe) {
            // Trata o caso onde o ID não é um número válido
            String erro = nfe.getMessage();
            request.setAttribute("errorMessage", erro);
            request.setAttribute("caminho", "listar_atracao.jsp");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
