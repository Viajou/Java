package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.ExcursaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletarExcursao", value = "/DeletarExcursao-servlet")
    public class DeletarExcursao extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // obtém o id correspondente a o que irá ser apagado
        int id = Integer.parseInt(request.getParameter("id"));

        //instancia a classe DAO
        ExcursaoDAO excursaoDAO = new ExcursaoDAO();

        try {
            int resultado = excursaoDAO.deletarExcursao(id); // Método deletar implementado no DAO para remover o admin

            //armazena o valor retornado pelo método e o verifica
            if(resultado == 1){
                request.setAttribute("mensagem", "Excursão excluído com sucesso!");
                request.setAttribute("caminho","paginaSucesso.jsp"); // retorna a mensagem de sucess
            }
            else if(resultado == 0){
                request.setAttribute("erro", "Erro! Não foi possível excluir esta excursão!");
                request.getRequestDispatcher("error.jsp"); // quando der erro, redireciona para a página jsp de erros
            }
            else if(resultado == -1){
                request.setAttribute("erro", "Erro! Não foi possível excluir este excursão!");
                request.getRequestDispatcher("erro.jsp").forward(request, response); // retorna o erro para a página de erro
            }

            //redireciona de volta ao listar
            request.getRequestDispatcher("/listar_excursão.jsp").forward(request, response);

            //tratamento de exceção
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Erro ao deletar administrador.");
        }
    }

    }
}
