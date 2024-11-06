package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "alterarAdmin", value = "/alterarAdmin-servlet")
public class AlterarAdmin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("novoNome");
            String email = request.getParameter("novoEmail");
            String novaSenha = request.getParameter("novaSenha");
            String url = request.getParameter("novaFoto");
            // Instanciando o DAO para alterar os dados
            AdminDAO adminDAO = new AdminDAO();

            String hashedPassword = BCrypt.hashpw(novaSenha, BCrypt.gensalt());


            // Verifica cada campo antes de atualizar
            if (email != null && !email.isEmpty()) {
                adminDAO.alterarEmail(id, email);
            }
            if (url != null && !url.isEmpty()) {
                adminDAO.alterarUrlImagem(id, url);
            }
            if (novaSenha != null && !novaSenha.isEmpty()) {
                adminDAO.alterarSenha(id, hashedPassword);
            }
            if (nome != null && !nome.isEmpty()) {
                adminDAO.alterarNome(id, nome);
            }


        }catch (Exception e){
            request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());

        }

        request.getRequestDispatcher("listar_admin.jsp").forward(request, response);
    }
}
