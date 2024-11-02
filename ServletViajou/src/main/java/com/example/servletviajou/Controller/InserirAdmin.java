package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "inserirAdminServlet", value = "/inserirAdmin-servlet")
public class InserirAdmin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Obtendo os dados da URL (Query String)
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String urlImagem = request.getParameter("urlImagem");
        Date dataCriacao = Date.valueOf(request.getParameter("dataCriacao"));
        Date dataAtualizacao = Date.valueOf(request.getParameter("dataAtualizacao"));


        // Criando o objeto Atracao
        AdminDAO adminDAO = new AdminDAO();

        //Criando objeto de excursao
        Admin novoAdmin = new Admin(nome,email,senha,urlImagem,dataCriacao,dataAtualizacao);

        try {
            // Verificando se o email já está cadastrado

                // Inserindo o novo admin
                int resultado = adminDAO.inserirAdmin(novoAdmin);
                if (resultado == 1) {
                    request.setAttribute("retorno", "certo");
                } else {
                    request.setAttribute("retorno", "erro");
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Redirecionando para uma página de confirmação ou erro
        request.getRequestDispatcher("/ListarAdmins.jsp").forward(request, response);
    }
}
