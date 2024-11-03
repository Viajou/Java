package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "alterarAdmin", value = "/alterarAdmin-servlet")
public class AlterarAdmin extends HttpServlet {
    @Override
<<<<<<< HEAD:ServletViajou/src/main/java/com/example/servletviajou/Controller/AlterarAdmin.java
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
=======
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>>>>>>> fb94d84f2288922892d865431038773eede776fe:ServletViajou/src/main/java/com/example/servletviajou/Servlet/AlterarAdmin.java
        try {
            // Obtendo os dados do formulário
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
<<<<<<< HEAD:ServletViajou/src/main/java/com/example/servletviajou/Controller/AlterarAdmin.java
=======
            String senhaAtual = request.getParameter("senhaAtual");
>>>>>>> fb94d84f2288922892d865431038773eede776fe:ServletViajou/src/main/java/com/example/servletviajou/Servlet/AlterarAdmin.java
            String novaSenha = request.getParameter("novaSenha");
            String url = request.getParameter("url");
            // Instanciando o DAO para alterar os dados
            AdminDAO adminDAO = new AdminDAO();



            // Verifica cada campo antes de atualizar
            if (nome != null && !nome.isEmpty()) {
                adminDAO.alterarNome(id, nome);
<<<<<<< HEAD:ServletViajou/src/main/java/com/example/servletviajou/Controller/AlterarAdmin.java
=======
                adminDAO.alterarSenha(id, novaSenha);
                adminDAO.alterarEmail(id, email);
                adminDAO.alterarUrlImagem(id, url);
                request.setAttribute("mensagem","Admin alterado com sucesso");
            }else {
                request.setAttribute("mensagem", "senha atual incorreta");
>>>>>>> fb94d84f2288922892d865431038773eede776fe:ServletViajou/src/main/java/com/example/servletviajou/Servlet/AlterarAdmin.java
            }
            if (email != null && !email.isEmpty()) {
                adminDAO.alterarEmail(id, email);
            }
            if (url != null && !url.isEmpty()) {
                adminDAO.alterarUrlImagem(id, url);
            }
            if (novaSenha != null && !novaSenha.isEmpty()) {
                adminDAO.alterarSenha(id, novaSenha);
            }



        }catch (Exception e){
            request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());

        }

<<<<<<< HEAD:ServletViajou/src/main/java/com/example/servletviajou/Controller/AlterarAdmin.java
        request.getRequestDispatcher("ListarAdmins.jsp").forward(request, response);
=======
        request.getRequestDispatcher("listar_admin.jsp").forward(request, response);
>>>>>>> fb94d84f2288922892d865431038773eede776fe:ServletViajou/src/main/java/com/example/servletviajou/Servlet/AlterarAdmin.java
    }
}
