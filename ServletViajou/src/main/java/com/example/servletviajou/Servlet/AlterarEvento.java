package com.example.servletviajou.Servlet;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ontendo valores do formulário

        int id = Integer.parseInt(req.getParameter("id"));
        String faixaEtaria = req.getParameter("faixaEtaria");
        String descricao = req.getParameter("descricao");
        String categoria = req.getParameter("categoria");
        int capacidade = Integer.parseInt(req.getParameter("capacidade"));
        Time horario = Time.valueOf(req.getParameter("horario"));
        Date data_inicio = Date.valueOf(req.getParameter("data_inicio"));
        Date data_termino = Date.valueOf(req.getParameter("data_termino"));
        double preco_pessoa = Double.parseDouble(req.getParameter("preco_pessoa"));

        //instanciando a classe EventosDAO
        EventosDAO eventosDAO = new EventosDAO();

        //Alterando a faixa etária
        try {

            int numFaixa = eventosDAO.alterarFaixaEtaria(id, faixaEtaria);

            if (numFaixa == 1){
                req.setAttribute("mensagem", "Faixa etária alterada com sucesso!");
            }
            else if (numFaixa == 0) {
                req.setAttribute("mensagem", "O evento não foi encontrado");
            }
            else {
                req.setAttribute("mensagem", "Erro!Não foi possível alterar o banco de dados");
            }



           //alterando descrição



            int numdesc = eventosDAO.alterarDescricao(id, descricao);

            if (numdesc == 1){
                req.setAttribute("mensagem", "Descrição alterada com sucesso!");
            }
            else if (numdesc == 0){
                req.setAttribute("mensagem", "O evento não foi encontrado.");
            }
            else {
                req.setAttribute("mensagem", "Erro! Não foi possível alterar o banco de dados");
            }



            //alterando a categoria


            int numCat = eventosDAO.alterarCategoria(id, categoria);

            if (numCat ==1){
                req.setAttribute("mensagem", "A categoria foi alterada com sucesso!");
            }
            else if (numCat == 0) {
                req.setAttribute("mensagem", "O evento não foi encontrado");
            }
            else {
                req.setAttribute("mensagem", "Erro! Não foi possível alterar o banco de dados ");
            }

            //alterando capacidade

            int numCap = eventosDAO.alterarCapacidade(id, capacidade);

            if (numCap ==1){
                req.setAttribute("mensagem", "A capacidade foi alterada com sucesso!");
            }
            else if (numCap == 0) {
                req.setAttribute("mensagem", "O evento não foi encontrado");
            }
            else {
                req.setAttribute("mensagem", "Erro! Não foi possível alterar o banco de dados ");
            }


            //alterando horário

            int numhr = eventosDAO.alterarHorario(id, horario);

            if (numhr ==1){
                req.setAttribute("mensagem", "A categoria foi alterada com sucesso!");
            }
            else if (numhr == 0) {
                req.setAttribute("mensagem", "O evento não foi encontrado");
            }
            else {
                req.setAttribute("mensagem", "Erro! Não foi possível alterar o banco de dados ");
            }


            //alterando data de início

            int numDtInicio = eventosDAO.alterarDataInicio(id, data_inicio);

            if (numDtInicio ==1){
                req.setAttribute("mensagem", "A categoria foi alterada com sucesso!");
            }
            else if (numDtInicio == 0) {
                req.setAttribute("mensagem", "O evento não foi encontrado");
            }
            else {
                req.setAttribute("mensagem", "Erro! Não foi possível alterar o banco de dados ");
            }


            //alterando a data de término

            int numDtTermino = eventosDAO.alterarDataTermino(id, data_termino);

            if (numDtTermino ==1){
                req.setAttribute("mensagem", "A categoria foi alterada com sucesso!");
            }
            else if (numDtTermino == 0) {
                req.setAttribute("mensagem", "O evento não foi encontrado");
            }
            else {
                req.setAttribute("mensagem", "Erro! Não foi possível alterar o banco de dados ");
            }

            //alterando o preço por pessoa

            int numPreco = eventosDAO.alterarPrecoPessoa(id, preco_pessoa);

            if (numCat ==1){
                req.setAttribute("mensagem", "A categoria foi alterada com sucesso!");
            }
            else if (numCat == 0) {
                req.setAttribute("mensagem", "O evento não foi encontrado");
            }
            else {
                req.setAttribute("mensagem", "Erro! Não foi possível alterar o banco de dados ");
            }

        } catch (NumberFormatException nfe){
            req.setAttribute("Erro", "ID inválido!");
            req.getRequestDispatcher("erro.jsp").forward(req, resp);
        }
    }
}
