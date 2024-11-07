package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletarAdminServlet", value = "/DeletarAdminServlet")
public class DeletarAdmin extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // obtém o id correspondente a o que irá ser apagado
        int id = Integer.parseInt(request.getParameter("id"));

        //instancia a classe DAO
        AdminDAO adminDAO = new AdminDAO();

        try {
            int resultado = adminDAO.deletarAdmin(id); // Método deletar implementado no DAO para remover o admin


            //armazena o valor retornado pelo método e o verifica
            if(resultado == 1){
                request.setAttribute("caminho", "listar_admin.jsp");
                request.getRequestDispatcher("sucesso.jsp").forward(request, response);
            }
            else if(resultado == 0){
                request.setAttribute("erro", "Erro! Não foi possível excluir este admin!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            else if(resultado == -1){
                request.setAttribute("erro", "Erro! Não foi possível excluir este admin!");
                request.getRequestDispatcher("error.jsp").forward(request, response); // retorna o erro para a página de erro
            }

            //tratamento de exceção
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
