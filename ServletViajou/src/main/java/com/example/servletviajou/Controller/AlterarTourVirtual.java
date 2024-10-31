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
            // declaração de variáveis
            int retorno;

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

            // alterarDescricao
            retorno = tourVirtualDAO.alterarDescricao(id, novaDescricao);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!")
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento")
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração")
            }

            // alterarPreco
            retorno = tourVirtualDAO.alterarPreco(id, novoPreco);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!")
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento")
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração")
            }

            // alterarMediaClassificacao
            retorno = tourVirtualDAO.alterarMediaClassificacao(id, novaMediaClassificacao);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!")
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento")
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração")
            }

            // alterarQntClassificacao
            retorno = tourVirtualDAO.alterarQntClassificacao(id, novaQntClassificacao);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!")
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento")
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração")
            }

            // alterarVideo
            retorno = tourVirtualDAO.alterarVideo(id, novoVideo);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!")
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento")
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração")
            }

            // alterarIdAtracao
            retorno = tourVirtualDAO.alterarIdAtracao(id, idAtracao);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!")
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento")
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração")
            }

            // alterarIdFigurinhas
            retorno = tourVirtualDAO.alterarIdFigurinhas(id, idFigurinhas);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!")
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento")
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração")
            }

            // enviando os dados para a página JSP
            request.getRequestDispatcher("tourVirtual.jsp").forward(request, response);

        } catch (NumberFormatException nfe) {
            request.setAttribute("erro", "Erro ao alterar tour virtual:" + nfe.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);

        }

    }
}
