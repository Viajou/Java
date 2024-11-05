package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;

@WebServlet(name = "AlterarAtracao", value = "/AlterarAtracao-servlet")
    public class AlterarAtracao extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            // Obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("novoNome");
            String descricao = request.getParameter("novaDescricao");
            String endereco = request.getParameter("novoEndereco");
            String Stringacessibilidade = request.getParameter("novaAcessibilidade");
            String categoria = request.getParameter("novaCategoria");
            // Instanciando o DAO para alterar os dados
            AtracaoDAO atracaoDAO = new AtracaoDAO();



            // Verifica cada campo antes de atualizar
            if (descricao != null && !descricao.isEmpty()) {
                atracaoDAO.alterarDescricao(id, descricao);
            }
            if (endereco != null && !endereco.isEmpty()) {
                atracaoDAO.alterarEndereco(id, endereco);
            }
            if (Stringacessibilidade != null && !Stringacessibilidade.isEmpty()) {
                try {
                    boolean acessibilidade = Boolean.parseBoolean(request.getParameter("novaAcessibilidade"));
                    atracaoDAO.alterarAcessibilidade(id, acessibilidade);
                }catch (InputMismatchException e){
                    request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());

                }

            }
            if (nome != null && !nome.isEmpty()) {
                atracaoDAO.alterarNome(id, nome);
            }
            if (categoria != null && !categoria.isEmpty()) {
                atracaoDAO.alterarCategoria(id, categoria);
            }


        }catch (Exception e){
            request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());

        }
        request.getRequestDispatcher("listar_atracao.jsp").forward(request, response);
    }
}