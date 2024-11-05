<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.servletviajou.DAO.EventosDAO" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Administrador</title>
    <link rel="stylesheet" href="CSS/Alterar.css">
    <title>Alterar Evento</title>
    <link rel="stylesheet" href="CSS/alterar2.css">
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/encontrado.css">
</head>
<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
    <%
        // Recupera a URL da imagem e nome do admin armazenados na sessão
        HttpSession sessao = request.getSession();
        String urlImagem = (String) sessao.getAttribute("urlImagem");
        String nomeAdmin = (String) sessao.getAttribute("nomeAdmin");
    %>

    <!-- Adiciona a imagem do admin logado, se existir -->
    <div class="usuario">
        <img src="<%= urlImagem %>" alt="Imagem do Admin" class="admin-image">
        <h3 class="admin-name"><%= nomeAdmin %></h3>
    </div>
</header>
<aside>
    <nav>
        <ul>
            <li><a href="listar_admin.jsp"><img src="images/icone-user-crud.svg" alt="">Admin</a></li>
            <li><a href="listar_eventos.jsp"><img src="images/icone-eventos-crud.svg" alt="">Eventos</a></li>
            <li><a href="listar_plano.jsp"><img src="images/icone-panos-crud.svg" alt="">Planos</a></li>
            <li><a href="listar_excursao.jsp"><img src="images/icone-excursao-crud.svg" alt="">Excursão</a></li>
            <li><a href="listar_atracao.jsp"><img src="images/icone-eventos-crud.svg" alt="">Atração</a></li>
            <li><a href="listar_tour_virtual.jsp"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
        </ul>
    </nav>
</aside>
<body>

<div class="formulario">
    <form class="alteracao">
        <h2>Atual</h2>
        <div class="campo">
            <label for="idAtual">Id atual:</label>
            <input class="entrada" type="number" id="idAtual" name="idAtual" disabled value="<%= request.getParameter("id") %>">
        </div>
        <div class="campo">
            <label for="idAtracaoAtual">Id atração atual:</label>
            <input class="entrada" type="text" id="idAtracaoAtual" name="idAtracaoAtual" disabled value="<%= request.getParameter("id_atracao") %> " >
        </div>
        <div class="campo">
            <label for="nomeAtual">Nome atual:</label>
            <input class="entrada" type="text" id="nomeAtual" name="nomeAtual" disabled value="<%= request.getParameter("nome") %> " >
        </div>
        <div class="campo">
            <label for="descricaoAtual">Descrição atual:</label>
            <input class="entrada" type="text" id="descricaoAtual" name="descricaoAtual" disabled value="<%= request.getParameter("descricao")%>">
        </div>
        <div class="campo">
            <label for="preco_pessoaAtual">Preço por pessoa atual:</label>
            <input class="entrada" type="text" id="preco_pessoaAtual" name="preco_pessoaAtual" disabled value="<%= request.getParameter("capacidade")%>">
        </div>
        <div class="campo">
            <label for="data_inicioAtual">Data de inicio atual:</label>
            <input class="entrada" type="text" id="data_inicioAtual" name="data_inicioAtual" disabled value="<%= request.getParameter("data_inicio")%>">
        </div>
        <div class="campo">
            <label for="data_terminoAtual">Data de Termino atual:</label>
            <input class="entrada" type="text" id="data_terminoAtual" name="data_terminoAtual" disabled value="<%= request.getParameter("data_termino")%>">
        </div>
        <div class="campo">
            <label for="faixa_etariaAtual">Faixa etaria atual:</label>
            <input class="entrada" type="text" id="faixa_etariaAtual" name="faixa_etariaAtual" disabled value=" <%= request.getParameter("senha")%>" >
        </div>
    </form>

    <form method="post" action="/AlterarEventos-servlet?id=<%= request.getParameter("id") %>">
        <h2>Novo</h2>
        <div class="campo">
            <label for="novaDescricao">Nova descrição:</label>
            <input class="entrada" type="text" id="novaDescricao" name="novaDescricao" placeholder="Novo descrição">
        </div>
        <div class="campo">
            <label for="novaCapacidade">Nova capacidade:</label>
            <input class="entrada" type="text" id="novaCapacidade" name="novaCapacidade" placeholder="Nova capacidade" >
        </div>
        <div class="campo">
            <label for="novo-preco-pessoa">Novo preço por pessoa:</label>
            <input class="entrada" type="text" id="novoPreco_Pessoa" name="novoPreco_Pessoa" placeholder="Ex: 15.90">
        </div>

        <div class="campo">
            <label for="novoHorario">Novo preço por pessoa:</label>
            <input class="entrada" type="text" id="novoHorario" name="novoHorario" placeholder="Ex: hh:mm:ss ou hh:mm">
        </div>
        <div class="campo">
            <label for="novaData_inicial">Nova data de inicio:</label>
            <input class="entrada" type="text" id="novaData_inicial" name="novaData_inicial" placeholder="Ex: (aaaa-mm-dd)">
        </div>
        <div class="campo">
            <label for="novaData_Termino">Data de Termino atual:</label>
            <input class="entrada" type="text" id="novaData_Termino" name="novaData_Termino" placeholder="Ex: (aaaa-mm-dd)" >
        </div>
        <div class="campo">
            <label for="novaFaixa_Etaria">Nova faixa etaria:</label>
            <input class="entrada" type="text" id="novaFaixa_Etaria" name="novaFaixa_Etaria" placeholder="opções: livre, 12+,14+, 16+, 18+">
        </div>
        <input type="submit" value="Alterar">
        </form>
    </div>
</body>
</html>