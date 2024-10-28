package org.viajou.crudviajou;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.viajou.crudviajou.admin.AdminDAO;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String emailInserido = request.getParameter("email");
        String senhaInserida = request.getParameter("senha");
        String senhaCerta = String.valueOf(adminDAO.buscar(emailInserido));

//        if (BCrypt.checkpw(senhaInserida,senhaCerta)) {
//            RequestDispatcher rd;
//            rd = getServletContext().getRequestDispatcher("/pages/listagemAdministradores.jsp");
//            rd.include(request, response);
//        } else {
//            out.println("Senha incorreta");
//        }


    }
}
