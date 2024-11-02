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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // instanciando um objeto da classe tourvirtualDAO
        TourVirtualDAO tourVirtualDAO = new TourVirtualDAO();

        // obtendo os atributos do formulário
        String descricao = request.getParameter("descricao");
        String video = request.getParameter("video");
        double mediaClassificacao = Double.parseDouble(request.getParameter("mediaClassificacao"));
        int qntClassificacao = Integer.parseInt(request.getParameter("qntClassificacao"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        int idAtracao = Integer.parseInt(request.getParameter("idAtracao"));
        int idFigurinhas = Integer.parseInt(request.getParameter("idFigurinhas"));

        // criando um novo objeto para a inserção no banco de dados
        TourVirtual novoTourVirtual = new TourVirtual(descricao, video, qntClassificacao, mediaClassificacao, preco, idAtracao, idFigurinhas);

        try{
            ResultSet rs = tourVirtualDAO.buscar(idAtracao);

            if(!rs.next()){
                int num = tourVirtualDAO.inserirTourVirtual(novoTourVirtual);
                if(num == 1){
                    request.setAttribute("mensagem", "certo");
                }
                if(num == 0){
                    request.setAttribute("erro", "notFound");
                }
                else if (num == -1) {
                    request.setAttribute("erro", "erro");
                }else{
                    request.setAttribute("erro", "erro");

                }
                request.setAttribute("erro", "existente");  // esse tour virtual já existe
            }

        } catch(SQLException sqle){
            request.setAttribute("mensagem", "Erro ao inserir informações no tour virtual:"+sqle.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);

        }


    }
}
