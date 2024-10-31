package com.example.servletviajou.Controller;


import com.example.servletviajou.DAO.TourVirtualDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AlterarTourVirtual", value = "/AlterarTourVirtual-servlet")
public class AlterarTourVirtual extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       try {
           // obter os dados do formulário
           int id = Integer.parseInt(request.getParameter("id"));
           int idAtracao = Integer.parseInt(request.getParameter("idAtracao"));
           int idFigurinhas = Integer.parseInt(request.getParameter("idFigurinhas"));
           int novaQntClassificacao = Integer.parseInt(request.getParameter("qntClassificacao"));
           double novoPreco = Double.parseDouble(request.getParameter("preco"));
           double novaMediaClassificacao = Double.parseDouble(request.getParameter("mediaClassificacao"));
           String novaDescricao = request.getParameter("descricao");
           String novoVideo = request.getParameter("video");

           // instanciando um objeto da classe tourVirtualDAO
           TourVirtualDAO tourVirtualDAO = new TourVirtualDAO();

           //chamando os métodos de alterar
           tourVirtualDAO.alterarDescricao(id,novaDescricao);
           tourVirtualDAO.alterarPreco(id,novoPreco);
           tourVirtualDAO.alterarMediaClassificacao(id,novaMediaClassificacao);
           tourVirtualDAO.alterarQntClassificacao(id, novaQntClassificacao);
           tourVirtualDAO.alterarVideo(id, novoVideo);
           tourVirtualDAO.alterarIdAtracao(id,idAtracao);
          tourVirtualDAO.alterarIdFigurinhas(id, idFigurinhas);

           // enviando os dados para a página JSP
           request.getRequestDispatcher("tourVirtual.jsp").forward(request, response);

       } catch (NumberFormatException nfe){
           request.setAttribute("mensagem", "Erro ao alterar tour virtual:"+nfe.getMessage());
           request.getRequestDispatcher("erro.jsp").forward(request, response);

       }

       // mensagem de sucesso nas etapas anteriores
       request.setAttribute("mensagem", "Tour virtual alterado com sucesso!");




   }
}
