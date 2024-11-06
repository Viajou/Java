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
            String strMediaClassificacao = request.getParameter("nova-media-classificacao");
            String strQntClassificacao = request.getParameter("nova-qnt-classificacao");
            String preco = request.getParameter("novo-preco");
            String strIdAtracao = request.getParameter("novo-id-atracao");
            String strIdFigurinhas = request.getParameter("novo-id-figurinhas");

            // instanciando um objeto da classe tourVirtualDAO
            TourVirtualDAO tourVirtualDAO = new TourVirtualDAO();


            // Verifiica cada campo antes de atualizar

            // verifica e altera a descricao
            if (descricao != null && !descricao.isEmpty()) { // se não for vazio
                retorno = tourVirtualDAO.alterarDescricao(id, descricao);
                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            // verifica e altera o video
            if (video != null && !video.isEmpty()) { // se não for vazio
                retorno = tourVirtualDAO.alterarVideo(id, video);
                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }


            // verifica e altera a classificação
            if (strMediaClassificacao != null && !strMediaClassificacao.isEmpty()) { // se não for vazio
                double mediaClassificacao = Double.parseDouble(strMediaClassificacao);
                retorno = tourVirtualDAO.alterarMediaClassificacao(id, mediaClassificacao);

                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            // verifica e altera a quantidade de classificação
            if (strQntClassificacao != null && !strQntClassificacao.isEmpty()) { // se não for vazio
                int qntClassificacao = Integer.parseInt(strQntClassificacao);
                retorno = tourVirtualDAO.alterarQntClassificacao(id, qntClassificacao);

                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            // verifica e altera o preço
            if (preco != null && !preco.isEmpty()) { // se não for vazio
                retorno = tourVirtualDAO.alterarPreco(id, preco);

                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            // verifica e altera o id da atração
            if (strIdAtracao != null && !strIdAtracao.isEmpty()) {// se não for vazio
                int idAtracao = Integer.parseInt(strIdAtracao);
                retorno = tourVirtualDAO.alterarIdAtracao(id, idAtracao);

                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            // verifica e altera o id das figurinhas
            if (strIdFigurinhas != null && !strIdFigurinhas.isEmpty()) { // se não for vazio
                int idFigurinhas = Integer.parseInt(strIdFigurinhas);
                retorno = tourVirtualDAO.alterarIdFigurinhas(id, idFigurinhas);

                if (retorno == 1) {
                    request.setAttribute("mensagem", "Alteração realizada com sucesso!");
                } else if (retorno == 0) {
                    request.setAttribute("mensagem", "Não foi possível alterar nesse momento");
                } else if (retorno == -1) {
                    request.setAttribute("erro", "Houve um erro no Banco de Dados. Não foi possível realizar a alteração");
                }
            }

            // enviando os dados para a página JSP
            request.getRequestDispatcher("listar_tour_virtual.jsp").forward(request, response);

        } catch (NumberFormatException nfe) {
            request.setAttribute("erro", "Erro ao alterar tour virtual: " + nfe.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }

    }
}
