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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();

        String emailInserido = request.getParameter("email");
        String senhaInserida = request.getParameter("senha");
        ResultSet busca = adminDAO.buscar(emailInserido);
        String senhaCerta = String.valueOf(adminDAO.buscar(emailInserido));

        if (senhaCerta == senhaInserida) {
            // Redireciona para a página inicial caso o login seja bem-sucedido
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListarAdmins.jsp");
            rd.forward(request, response);
        } else {
            // Define a mensagem de erro e redireciona para a página de login
            request.setAttribute("errorMessage", "Senha incorreta.");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListarAdmins.jsp");
            rd.forward(request, response);
        }

        try {
            if (busca.next()) {
                if (senhaCerta == senhaInserida) {
                    // Redireciona para a página inicial caso o login seja bem-sucedido
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListarAdmins.jsp");
                    rd.forward(request, response);
                } else {
                    // Define a mensagem de erro e redireciona para a página de login
                    request.setAttribute("errorMessage", "Senha incorreta.");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListarAdmins.jsp");
                    rd.forward(request, response);
                }
            }else {
                request.setAttribute("errorMessage", "Usario não cadastrado.");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListarAdmins");
                rd.forward(request, response);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
