package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.PlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterarPlano", value = "/AlterarPlano-servlet")
public class AlterarPlano extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try{
            //Obtendo os dados do formulario
            int id = Integer.parseInt(request.getParameter("id"));
            String descricao  = request.getParameter("novaDescricao");
            boolean livrePropaganda = Boolean.parseBoolean(request.getParameter("novoLivrePropaganda"));
            String livrePropagandaString = "";
            if(livrePropaganda){
                livrePropagandaString = "true";
            }
            else if(!livrePropaganda){
                livrePropagandaString = "false";
            }
            String nome = request.getParameter("novoNome");
            String precoString = request.getParameter("novoPreco");

            // instanciando um objeto da classe planoDAO
            PlanoDAO planoDAO = new PlanoDAO();

            // Verifiica cada campo antes de atualizar

            //verifica e altera a descricao
            if(descricao!=null && !descricao.isEmpty()){
                planoDAO.alterarDescricao(id, descricao);
            }

            //verifica e altera o livre propaganda
            if(livrePropagandaString!=null && !nome.isEmpty()){
                planoDAO.alterarLivrePropaganda(id, livrePropaganda);
            }

            //verifica e altera o nome
            if(nome!=null && !nome.isEmpty()){
                planoDAO.alterarNome(id,nome);
            }

            // verifica e altera o preço
            if(precoString!=null && !precoString.isEmpty()){
                planoDAO.alterarPreco(id,precoString);
            }
            //dando o caminho para resposta do servlet
            request.setAttribute("mensagem", "Plano alterado com sucesso!");
        }

        // tratamento de exceção
        catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        request.setAttribute("caminho", "listar_plano.jsp");
        request.setAttribute("sucessMessage", "sucesso");
        request.getRequestDispatcher("sucesso.jsp").forward(request, response);

    }
}