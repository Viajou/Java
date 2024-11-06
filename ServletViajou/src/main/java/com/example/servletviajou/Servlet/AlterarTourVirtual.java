package com.example.servletviajou.Servlet;


import com.example.servletviajou.DAO.TourVirtualDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AlterarTourVirtual", value = "/AlterarTourVirtual-servlet")
public class AlterarTourVirtual extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            // declaração de variáveis
            int retorno;

            // obter os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            String descricao = request.getParameter("nova-descricao");
            String video = request.getParameter("novo-video");
            double mediaClassificacao = Double.parseDouble(request.getParameter("nova-media-classificacao"));
            int qntClassificacao = Integer.parseInt(request.getParameter("nova-qnt-classificacao"));
            double preco = Double.parseDouble(request.getParameter("novo-preco"));
            int idAtracao = Integer.parseInt(request.getParameter("novo-id-atracao"));
            int idFigurinhas = Integer.parseInt(request.getParameter("novo-id-figurinhas"));

            // instanciando um objeto da classe tourVirtualDAO
            TourVirtualDAO tourVirtualDAO = new TourVirtualDAO();

            //chamando os métodos de alterar

            // Verifiica cada campo antes de atualizar

            // alterarDescricao
            if (descricao != null && !descricao.isEmpty()) {
                retorno = tourVirtualDAO.alterarDescricao(id, descricao);
                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            // alterarPreco
            retorno = tourVirtualDAO.alterarPreco(id, preco);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!");
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
            }

            // alterarMediaClassificacao
            retorno = tourVirtualDAO.alterarMediaClassificacao(id, mediaClassificacao);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!");
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
            }

            // alterarQntClassificacao
            retorno = tourVirtualDAO.alterarQntClassificacao(id, qntClassificacao);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!");
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
            }

            // alterarVideo
            retorno = tourVirtualDAO.alterarVideo(id, video);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!");
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
            }

            // alterarIdAtracao
            retorno = tourVirtualDAO.alterarIdAtracao(id, idAtracao);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!");
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
            }

            // alterarIdFigurinhas
            retorno = tourVirtualDAO.alterarIdFigurinhas(id, idFigurinhas);

            if (retorno == 1) {
                request.setAttribute("mensagem", "Alteração realizada com sucesso!");
            }
            else if (retorno == 0) {
                request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
            }
            else if (retorno == -1) {
                request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
            }

            // enviando os dados para a página JSP
            request.getRequestDispatcher("tourVirtual.jsp").forward(request, response);

        } catch (NumberFormatException nfe) {
            request.setAttribute("erro", "Erro ao alterar tour virtual:" + nfe.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);

        }

    }
}
