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
        response.setContentType("text/html");

        try{
            //Obtendo os dados do formulario

            int id = Integer.parseInt(request.getParameter("id"));
            String descricao  = request.getParameter("novaDescricao");
            boolean livrePropaganda = Boolean.parseBoolean(request.getParameter("novoLivrePropaganda"));
            String nome = request.getParameter("novoNome");
            double preco = Double.parseDouble(request.getParameter("novoPreco"));
            String precoString = request.getParameter("novoPreco");

            // instanciando um objeto da classe planoDAO

            PlanoDAO planoDAO = new PlanoDAO();

            // Verifiica cada campo antes de atualizar

            int retorno;

            //verifica e altera a descricao
            if(descricao!=null && !descricao.isEmpty()){
                retorno=planoDAO.alterarDescricao(id, descricao);
                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            //verifica e altera o livre propaganda
            retorno = planoDAO.alterarLivrePropaganda(id, livrePropaganda);
            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!");
            } else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
            } else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
            }

            //verifica e altera o nome
            if(nome!=null && !nome.isEmpty()){
                retorno=planoDAO.alterarNome(id,nome);
                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            // verifica e altera o preço
            retorno=planoDAO.alterarPreco(id,precoString);
            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!");
            } else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
            } else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
            }
        }

        // tratamento de exceção
        catch (Exception e) {
            request.setAttribute("mensagem", "Erro ao alterar o plano: " + e.getMessage());
        }

        request.setAttribute("caminho", "listar_plano.jsp");
        request.setAttribute("sucessMessage", "sucesso");
        request.getRequestDispatcher("sucesso.jsp").forward(request, response);

    }
}