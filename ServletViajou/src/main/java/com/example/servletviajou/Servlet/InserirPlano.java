package com.example.servletviajou.Servlet;


import com.example.servletviajou.DAO.PlanoDAO;
import com.example.servletviajou.Model.Plano;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "InserirPlano", value = "/InserirPlano-servlet")
public class InserirPlano extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Obtendo os dados da URL (Query String)
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        boolean livrePropaganda = Boolean.parseBoolean(request.getParameter("livrePropaganda"));
        String preco = request.getParameter("preco");
        String duracao = request.getParameter("duracao");


        // Criando o objeto Plano
        PlanoDAO planoDAO = new PlanoDAO();

        //Criando objeto de plano
        Plano novoPlano = new Plano(nome,descricao,livrePropaganda,preco,duracao);

        try {
            // Inserindo o novo plano
            int resultado = planoDAO.inserirPlano(novoPlano);
            if (resultado == 1) {
                request.setAttribute("retorno", "certo");
            }
            else if (resultado == 0) {
                request.setAttribute("retorno", "not found");
            }
            else {
                request.setAttribute("retorno", "erro");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Redirecionando para uma página de confirmação ou erro
        request.getRequestDispatcher("/listar_plano.jsp").forward(request, response);
    }
}