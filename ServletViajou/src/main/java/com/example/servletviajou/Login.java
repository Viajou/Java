//package org.viajou.crudviajou;
package com.example.servletviajou;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.servletviajou.DAO.AdminDAO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();

        String emailInserido = request.getParameter("email");
        String senhaInserida = request.getParameter("senha");
        String senhaCerta = null; // Inicializa a variável

        // Busca o resultado do admin pelo email
        ResultSet resultados = adminDAO.buscar(emailInserido); // Altere para buscar o ResultSet

        try {
            if (resultados.next()) { // Verifica se há resultados
                // Extrai a senha do ResultSet
                senhaCerta = resultados.getString("senha"); // Altere "senha" para o nome da coluna que armazena a senha
            }

            // Verifica se a senha inserida corresponde à senha armazenada
            if (senhaInserida.equals(senhaCerta)) {
                // Após validar o login
                String urlImagem = resultados.getString("url_imagem");
                String nomeAdmin = resultados.getString("nome");

                request.getSession().setAttribute("nomeAdmin", nomeAdmin);
                request.getSession().setAttribute("urlImagem", urlImagem);
                // Redireciona para a página inicial caso o login seja bem-sucedido
                request.getRequestDispatcher("ListarAdmins.jsp").forward(request, response);
            } else {
                // Define a mensagem de erro e redireciona para a página de login
                request.setAttribute("errorMessage", "Senha incorreta ou email não encontrado.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate exceções adequadamente
        }
    }
}
