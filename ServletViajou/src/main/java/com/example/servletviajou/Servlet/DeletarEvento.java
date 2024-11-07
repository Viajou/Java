package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.EventosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletarEventos", value = "/DeletarEventos-servelet")
public class DeletarEvento extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // obtém o id correspondente a o que irá ser apagado
        int id = Integer.parseInt(request.getParameter("id"));

        //instancia a classe DAO
        EventosDAO eventosDAO = new EventosDAO();

        try {
            int resultado = eventosDAO.deletarEvento(id); // Método deletar implementado no DAO para remover o admin

            //armazena o valor retornado pelo método e o verifica
            if(resultado == 1){
                request.setAttribute("mensagem", "Evento excluído com sucesso!");
                request.setAttribute("caminho","paginaSucesso.jsp"); // retorna a mensagem de sucess
            }
            else if(resultado == 0){
                request.setAttribute("erro", "Erro! Não foi possível excluir este evento!");
                request.getRequestDispatcher("error.jsp"); // quando der erro, redireciona para a página jsp de erros
            }
            else if(resultado == -1){
                request.setAttribute("erro", "Erro! Não foi possível excluir este evento!");
                request.getRequestDispatcher("erro.jsp").forward(request, response); // retorna o erro para a página de erro
            }

            //redireciona de volta ao listar
            request.getRequestDispatcher("/listar_evento.jsp").forward(request, response);

            //tratamento de exceção
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Erro ao deletar administrador.");
        }
    }
}
