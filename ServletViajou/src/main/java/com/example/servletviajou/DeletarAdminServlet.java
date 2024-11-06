package com.example.servletviajou;

import com.example.servletviajou.DAO.AdminDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletarAdminServlet", value = "/DeletarAdminServlet")
public class DeletarAdminServlet extends HttpServlet {
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
                request.setAttribute("mensagem", "Admin excluído com sucesso!");
                response.sendRedirect("paginaSucesso.jsp"); // retorna a mensagem de sucess
            }
            else if(resultado == 0){
                request.setAttribute("erro", "Erro! Não foi possível excluir este admin!");
                response.sendRedirect("error.jsp"); // quando der erro, redireciona para a página jsp de erros
            }
            else if(resultado == -1){
                request.setAttribute("erro", "Erro! Não foi possível excluir este admin!");
                request.getRequestDispatcher("erro.jsp").forward(request, response); // retorna o erro para a página de erro
            }

            //redireciona de volta ao listar
            request.getRequestDispatcher("/listar_admin.jsp").forward(request, response);

        //tratamento de exceção
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Erro ao deletar administrador.");
        }
    }

}