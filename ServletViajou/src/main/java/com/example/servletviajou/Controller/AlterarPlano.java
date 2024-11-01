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
            //alterar descrição
            int retorno = planoDAO.alterarDescricao(id,novaDescricao);
            if(retorno == 1){
                request.setAttribute("mensagem", "Descrição alterada com sucesso!");
            }
            else if(retorno == 0){
                request.setAttribute("mensagem", "Não foi possível alterar a descrição nesse momento");
            } else if (retorno==-1) {
                request.setAttribute("erro", "Erro ao alterar descrição");
            }
            //alterar livre propaganda
            retorno = planoDAO.alterarLivrePropaganda(id,novoLivrePropaganda);
            if(retorno == 1){
                request.setAttribute("mensagem", "Livre propaganda alterado com sucesso!");
            }
            else if(retorno == 0){
                request.setAttribute("mensagem", "Não foi possível alterar o livre propaganda nesse momento");
            } else if (retorno==-1) {
                request.setAttribute("erro", "Erro ao alterar o livre propaganda");
            }
            //alterar nome
            retorno = planoDAO.alterarNome(id, novoNome);
            if(retorno == 1){
                request.setAttribute("mensagem", "Nome alterado com sucesso!");
            }
            else if(retorno == 0){
                request.setAttribute("mensagem", "Não foi possível alterar o nome nesse momento");
            } else if (retorno==-1) {
                request.setAttribute("erro", "Erro ao alterar o nome");
            }
            //alterar preço
            retorno = planoDAO.alterarPreco(id, novoPreco);
            if(retorno == 1){
                request.setAttribute("mensagem", "Preço alterado com sucesso!");
            }
            else if(retorno == 0){
                request.setAttribute("mensagem", "Não foi possível alterar o preço nesse momento");
            } else if (retorno==-1) {
                request.setAttribute("erro", "Erro ao alterar o preço");
            }
            request.getRequestDispatcher("/WEB-INF/jsp/plano.jsp").forward(request, response);
        }
        catch (Exception e) {
            request.setAttribute("mensagem", "Erro ao alterar o plano: " + e.getMessage());
        }
    }
}