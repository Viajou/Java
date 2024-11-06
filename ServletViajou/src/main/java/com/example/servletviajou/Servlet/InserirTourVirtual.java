package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.TourVirtualDAO;
import com.example.servletviajou.Model.TourVirtual;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet (name= "InserirTourVirtual", value = "/InserirTourVirtual-servlet")
public class InserirTourVirtual extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // obtendo os dados da URL (Query String)
        String descricao = request.getParameter("descricao");
        String video = request.getParameter("video");
        double mediaClassificacao = Double.parseDouble(request.getParameter("mediaClassificacao"));
        int qntClassificacao = Integer.parseInt(request.getParameter("qntClassificacao"));
        String preco = request.getParameter("preco");
        int idAtracao = Integer.parseInt(request.getParameter("idAtracao"));
        int idFigurinhas = Integer.parseInt(request.getParameter("idFigurinhas"));

        // instanciando um objeto da classe tourvirtualDAO
        TourVirtualDAO tourVirtualDAO = new TourVirtualDAO();

        // criando um novo objeto para a inserção no banco de dados
        TourVirtual novoTourVirtual = new TourVirtual(descricao, video, qntClassificacao, mediaClassificacao, preco, idAtracao, idFigurinhas);

        try{

            //armezena o resultado retornado no método e verifica
            int resultado = tourVirtualDAO.inserirTourVirtual(novoTourVirtual);
            if(resultado==1){
                request.setAttribute("retorno", "certo"); // retona mensagem ao jsp
            }
            else {
                request.setAttribute("retorno", "erro"); // retorna mensagem ao jsp
            }

        // tratamento de exceções
        } catch(Exception e){
            throw new RuntimeException(e);
        }

        // Redirecionando para uma página de confirmação ou erro
        request.getRequestDispatcher("/listar_tour_virtual.jsp").forward(request, response);

    }
}
