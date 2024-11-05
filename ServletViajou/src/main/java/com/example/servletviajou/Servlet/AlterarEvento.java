package com.example.servletviajou.Servlet;

import com.example.servletviajou.DAO.AtracaoDAO;
import com.example.servletviajou.DAO.EventosDAO;
import com.example.servletviajou.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet(name = "AlterarEventos", value = "/AlterarEventos-servlet")
public class AlterarEvento extends HelloServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // ontendo valores do formulário

        int id = Integer.parseInt(request.getParameter("id"));
        int idAtracao = Integer.parseInt(request.getParameter("idAtracao"));
        String faixaEtaria = request.getParameter("novaFaixa_Etaria");
        String descricao = request.getParameter("novaDescricao");
        String Stringcapacidade = request.getParameter("novaCapacidade");
        String Stringhorario = request.getParameter("novoHorario");
        String StringdataInicio = request.getParameter("novaData_inicial");
        String StringdataTermino = request.getParameter("novaData_Termino");
        String StringprecoPessoa = request.getParameter("novoPreco_Pessoa");

        //instanciando a classe EventosDAO
        EventosDAO eventosDAO = new EventosDAO();


        // Verifica cada campo antes de atualizar

        if ( faixaEtaria!= null && !faixaEtaria.isEmpty()) {
            eventosDAO.alterarFaixaEtaria(id,faixaEtaria);
        }
        if (descricao != null && !descricao.isEmpty()) {
            eventosDAO.alterarDescricao(id,descricao);
        }
        if (Stringcapacidade != null && !Stringcapacidade.isEmpty()) {
            try {
                int capacidade = Integer.parseInt(Stringcapacidade);
                eventosDAO.alterarCapacidade(id,capacidade);
            }catch (NumberFormatException e) {
                request.setAttribute("mensagem", "Erro ao alterar admin: " + e.getMessage());
            }
        }
        if (Stringhorario != null && !Stringhorario.isEmpty()) {
            if (Stringhorario.length() == 5){
                Stringhorario += "00";
            }
            Time horario = Time.valueOf(Stringhorario);
            eventosDAO.alterarHorario(id,horario);
        }
        if (StringdataInicio != null && !StringdataInicio.isEmpty()) {
            Date dataInicio = Date.valueOf(StringdataInicio);
            eventosDAO.alterarDataInicio(id,dataInicio);
        }
        if (StringdataTermino != null && !StringdataTermino.isEmpty()) {
            Date dataTermino = Date.valueOf(StringdataTermino);
            eventosDAO.alterarDataTermino(id,dataTermino);
        }
        if (StringprecoPessoa != null && !StringprecoPessoa.isEmpty()) {
            double precoPessoa = Double.parseDouble(StringprecoPessoa);
            eventosDAO.alterarPrecoPessoa(id,precoPessoa);
        }


    }
    
}
