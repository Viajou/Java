package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.AtracaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "alterarAdmin", value = "/alterarAdmin-servlet")
public class AlterarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senhaAtual = request.getParameter("senhaAtual");
            String novaSenha = request.getParameter("novaSenha");
            String url = request.getParameter("url");
            // Instanciando o DAO para alterar os dados
            AdminDAO adminDAO = new AdminDAO();

            ResultSet busca = adminDAO.buscar(id);
            String senhaCerta = busca.getString("senha");

            if (senhaAtual.equals(senhaCerta)){
                adminDAO.alterarNome(id, nome);
                adminDAO.alterarSenha(id, novaSenha);
                adminDAO.alterarEmail(id, email);
                adminDAO.alterarUrlImagem(id, url);
                request.setAttribute("mensagem","Admin alterado com sucesso");
            }else {
                request.setAttribute("mensagem", "senha atual incorreta");
            }
        }catch (Exception e){
            request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());

        }

        request.getRequestDispatcher("ListarAdmins.jsp").forward(request, response);
    }
}
