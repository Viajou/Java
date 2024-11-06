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

@WebServlet(name = "inserirAdminServlet", value = "/inserirAdmin-servlet")
public class InserirAdmin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Obtendo os dados da URL (Query String)
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String urlImagem = request.getParameter("url");


        // Criando o objeto Admin
        AdminDAO adminDAO = new AdminDAO();

        // criptografia da senha
        String hashedPassword = BCrypt.hashpw(senha, BCrypt.gensalt());

        //Criando objeto de admin
        Admin novoAdmin = new Admin(nome,email,hashedPassword,urlImagem);

        try {
            // Verificando se o email já está cadastrado

                // Inserindo o novo admin
                int resultado = adminDAO.inserirAdmin(novoAdmin);

                //verifica retorno do método DAO
                if (resultado == 1) {
                    request.setAttribute("retorno", "certo");
                } else {
                    request.setAttribute("retorno", "erro");
                }

        // tratamento de exceção
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Redirecionando para uma página de confirmação ou erro
        request.setAttribute("caminho", "listar_admin.jsp");
        request.getRequestDispatcher("sucesso.jsp").forward(request, response);
    }
}
