package com.example.servletviajou;

import com.example.servletviajou.DAO.AdminDAO;
import com.example.servletviajou.Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/listarAdmins")
public class ListarAdminsServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();
        Admin admin = new Admin();

        try{
            ResultSet busca = adminDAO.buscar();
            while (busca.next()){
                int id = busca.getInt("id");
                String nome = busca.getString("nome");
                String email = busca.getString("email");
                String dataCriacao= busca.getString("data_criacao");
                String dataAtualizacao= busca.getString("data_atualizacao");
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }



    }
}