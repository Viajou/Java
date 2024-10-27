package org.viajou.crudviajou.plano;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class InserirPlano extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PlanoDAO planoDAO = new PlanoDAO;

        // Obtendo os dados do formulario
        String descricao = request.getParameter("descricao");
        boolean livrePropaganda = request.getParameter("livrePropaganda");
        String nome = request.getParameter("nome");
        double preco = request.getParameter("preco");

        //Criando objeto Plano
        Plano novoPlano = new Plano(descricao, livrePropaganda, nome, preco);

        //Redirecionando para a pagina de confirmação
        try{
            ResultSet rs = planoDAO.buscar();
            if(!rs.next()){
                int num = planoDAO.inserirPlano(novoPlano);
                if (num == 1) {
                    request.setAttribute("retorno", "certo");
                } else if (num == 0) {
                    request.setAttribute("retorno", "notfound");
                } else {
                    request.setAttribute("retorno", "erro");
                }
            }
            else{
                request.setAttribute("retorno", "existente");  // Categoria já existe
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}