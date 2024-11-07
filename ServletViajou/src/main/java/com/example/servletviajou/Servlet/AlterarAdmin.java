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

            // criptografa a senha
            String hashedPassword = BCrypt.hashpw(novaSenha, BCrypt.gensalt());


            // Verifica cada campo antes de atualizar
            //verifica e altera o email
            if (email != null && !email.isEmpty()) { // se não for vazio
                adminDAO.alterarEmail(id, email);
            }

            //verifica e altera a url
            if (url != null && !url.isEmpty()) {// se não for vazio
                adminDAO.alterarUrlImagem(id, url);
            }

            //verifica e altera a senha
            if (novaSenha != null && !novaSenha.isEmpty()) { // se não for vazio
                adminDAO.alterarSenha(id, hashedPassword); // id e senha criptografada
            }

            // verifica e altera o nome
            if (nome != null && !nome.isEmpty()) {// se não for vazio
                adminDAO.alterarNome(id, nome);
            }

        // tratamento de exceção
        }catch (Exception e){
            request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());

        }

        request.setAttribute("caminho", "listar_admin.jsp");
        request.setAttribute("sucessMessage", "sucesso");
        request.getRequestDispatcher("sucesso.jsp").forward(request, response);

    }
}
