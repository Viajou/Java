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

@WebServlet(name = "alterarAdmin", value = "/alterarAdmin-servlet")
public class AlterarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtendo os dados do formulário
            int id = Integer.parseInt(req.getParameter("id"));
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String senhaAtual = req.getParameter("senhaAtual");
            String novaSenha = req.getParameter("novaSenha");
            String url = req.getParameter("url");
            // Instanciando o DAO para alterar os dados
            AdminDAO adminDAO = new AdminDAO();

            ResultSet busca = adminDAO.buscar(id);
//            String senhaCerta = busca.getString("senha");
//            if (senhaAtual.equals(senhaCerta)){
                adminDAO.alterarNome(id, nome);
                adminDAO.alterarSenha(id, novaSenha);
                adminDAO.alterarEmail(id, email);
                adminDAO.alterarUrlImagem(id, url);
                req.setAttribute("mensagem","Admin alterado com sucesso");
//            }else {
//                req.setAttribute("mensagem", "senha atual incorreta");
//            }
        }catch (Exception e){
            req.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());

        }

        req.getRequestDispatcher("ListarAdmins.jsp").forward(req, resp);
    }
}
