package com.example.servletviajou.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet(name = "validar-data", value = "/validarData-servlet")
public class ValidarData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            LocalDate dataIn = LocalDate.parse("data_inicio");
            LocalDate dataFim = LocalDate.parse("data_termino");

            String url = request.getParameter("url");

            if (dataFim.isBefore(dataIn)){
                request.setAttribute("invalido", "A data de término é maior que a data de início");
                request.getRequestDispatcher("url").forward(request, response);
            }
            else {
                request.setAttribute("valido", "valor válido");
                request.getRequestDispatcher("url").forward(request, response);
            }
        } catch (DateTimeParseException dtpe){
            request.setAttribute("falha", "Erro de excecão do dateTime");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
