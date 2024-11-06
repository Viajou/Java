package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.DAO.AtracaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.InputMismatchException;


@WebServlet(name = "DeletarAtracao", value = "/DeletarAtracao-servlet")
    public class DeletarAtracao extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            // armazena o id obtido do campo que deseja deletar
            int id = Integer.parseInt(request.getParameter("id"));

            //instancia a classe DAO
            AtracaoDAO atracaoDAO = new AtracaoDAO();
            
            try {
                int resultado = atracaoDAO.deletarAtracao(id); // Método deletar implementado no DAO para remover o admin

                //armazena o valor retornado pelo método e o verifica
                if (resultado == 1) {
                    request.setAttribute("mensagem", "Atração excluído com sucesso!");
                    response.sendRedirect("paginaSucesso.jsp"); // retorna a mensagem de sucesso

                } else if (resultado == 0) {
                    request.setAttribute("erro", "Erro! Não foi possível excluir esta atração!");
                    response.sendRedirect("error.jsp"); // quando der erro, redireciona para a página jsp de erro

                } else if (resultado == -1) {
                    request.setAttribute("erro", "Erro! Não foi possível excluir esta atração!");
                    request.getRequestDispatcher("erro.jsp").forward(request, response); // retorna o erro para a página de erro
                }

                //redireciona ao listar
                request.getRequestDispatcher("/listar_admin.jsp").forward(request, response);

                //tratamento de exceção
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("Erro ao deletar administrador.");
        }
    }
}