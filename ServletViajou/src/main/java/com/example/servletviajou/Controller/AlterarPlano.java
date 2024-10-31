package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.PlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterarPlano", value = "/AlterarPlano-servlet")
public class AlterarPlano extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        try{
            //Obtendo os dados do formulario
            int id = Integer.parseInt(request.getParameter("id"));
            String novaDescricao  = request.getParameter("descricao");
            boolean novoLivrePropaganda = Boolean.parseBoolean(request.getParameter("livrePropaganda"));
            String novoNome = request.getParameter("nome");
            double novoPreco = Double.parseDouble(request.getParameter("preco"));

            //Instanciando o DAO para alterar os dados
            PlanoDAO planoDAO = new PlanoDAO();
            planoDAO.alterarDescricao(id,novaDescricao);
            planoDAO.alterarLivrePropaganda(id,novoLivrePropaganda);
            planoDAO.alterarNome(id, novoNome);
            planoDAO.alterarPreco(id, novoPreco);
            request.setAttribute("mensagem", "Plano alterado com sucesso!");
        }
        catch (Exception e) {
            request.setAttribute("mensagem", "Erro ao alterar o plano: " + e.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/jsp/excursao.jsp").forward(request, response);
    }
}