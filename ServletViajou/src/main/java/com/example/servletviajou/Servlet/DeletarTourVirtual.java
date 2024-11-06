package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.TourVirtualDAO;
import com.example.servletviajou.Model.TourVirtual;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "DeletarTourVirtual", value = "/DeletarTourVirtual-servlet")
public class DeletarTourVirtual extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // instanciando um objeto da classe tourVirtualDAO
        TourVirtualDAO tourVirtualDAO = new TourVirtualDAO();

        // obtendo os dados do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        TourVirtual tourVirtual = new TourVirtual();

        // chamando o método deletar
        int resultado = tourVirtualDAO.deletarTourVirtual(id, tourVirtual);

        // verifica os retornos do método
        if(resultado == 1){
            request.setAttribute("mensagem", "Tour virtual excluído com sucesso!");
            response.sendRedirect("paginaSucesso.jsp"); // retorna a mensagem de sucess
        }
        else if(resultado == 0){
            request.setAttribute("erro", "Erro! Não foi possível excluir este tour virtual!");
            response.sendRedirect("error.jsp"); // quando der erro, redireciona para a página jsp de erros
        }
        else if(resultado == -1){
            request.setAttribute("erro", "Erro! Não foi possível excluir este tour virtual!");
            request.getRequestDispatcher("erro.jsp").forward(request, response); // retorna o erro para a página de erro
        }


    }
}
