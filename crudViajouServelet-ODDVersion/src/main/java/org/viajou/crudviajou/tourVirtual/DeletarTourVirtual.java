package org.viajou.crudviajou.tourVirtual;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "helloServlet", value = "/hello-servlet")
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

        if(resultado > 0){
            request.getSession().setAttribute("mensagem", "Tour virtual excluído com sucesso!");
            response.sendRedirect("paginaSucesso.jsp");
        }
        else{
            request.getSession().setAttribute("mensagem", "Erro! Não foi possível excluir este tour virtual!");
            response.sendRedirect("paginaErro.jsp");
        }


    }
}
