package com.example.servletviajou.Controller;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.AtracaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class AlterarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtendo os dados do formulário
            int id = Integer.parseInt(req.getParameter("id"));
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String senhaAtual = req.getParameter("senhaAtual");
            String senhaNova = req.getParameter("senhaNova");

            // Instanciando o DAO para alterar os dados
            AdminDAO adminDAO = new AdminDAO();

            String senhaCerta = String.valueOf(adminDAO.buscar(email));
            if (senhaAtual.equals(senhaCerta)){
                adminDAO.alterarNome(id, nome);
                adminDAO.alterarSenha(id, senhaNova);
                adminDAO.alterarEmail(id, email);
                req.setAttribute("mensagem","Admin alterado com sucesso");
            }else {
                req.setAttribute("mensagem", "senha atual incorreta");
            }
        }catch (Exception e){
            req.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());

        }
        req.getRequestDispatcher("ListarAdmins.jsp").forward(req, resp);
    }
}
