package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.PlanoDAO;
import com.example.servletviajou.Model.Plano;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

@WebServlet(name = "InserirPlano", value = "/InserirPlano-servlet")
public class InserirPlano extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PlanoDAO planoDAO = new PlanoDAO();

        // Obtendo os dados do formulario
        try {
            String descricao = request.getParameter("descricao");
            boolean livrePropaganda = Boolean.parseBoolean(request.getParameter("livrePropaganda"));
            String nome = request.getParameter("nome");
            double preco = Double.parseDouble(request.getParameter("preco"));
            //Criando objeto Plano
            Plano novoPlano = new Plano(descricao, livrePropaganda, nome, preco);

            //Redirecionando para a pagina de confirmação
            try{
                ResultSet rs = planoDAO.buscar();
                if(!rs.next()){
                    int num = planoDAO.inserirPlano(novoPlano);
                    if (num == 1) {
                        request.setAttribute("mensagem", "certo");
                    } else if (num == 0) {
                        request.setAttribute("mensagem", "notfound");
                    } else if(num == -1){
                        request.setAttribute("mensagem", "erro");
                    }
                }
                else{
                    request.setAttribute("mensagem", "existente");  // Categoria já existe
                }
            }
            catch (SQLException sqle) {
                request.setAttribute("erro", "Erro ao buscar o plano.");
                request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
            }
        }catch (InputMismatchException e){
            request.setAttribute("erro", "Erro ao buscar o plano.");
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        }



    }
}