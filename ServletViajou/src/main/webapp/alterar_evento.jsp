<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.servletviajou.DAO.EventosDAO" %>
<%@ page import="com.example.servletviajou.Servlet.ValidarData" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <img src="<%= urlImagem %>" alt="" class="admin-image">
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
            <li><a href="https://area-restrita-main.onrender.com"><img src="images/cadeado.svg" alt="">Área Restrita</a></li>
        </ul>
    </nav>
</aside>
<body>

<h1>Alterar eventos</h1>

<div class="fundo">
    <div class="formulario">
        <form class="alteracao">
            <h2>Atual</h2>
            <div class="campo">
                <label for="idAtual">Id atual:</label>
                <input class="entrada" type="number" id="idAtual" name="idAtual" disabled value="<%= request.getParameter("id") %>">
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
                <input class="entrada" type="text" id="faixa_etariaAtual" name="faixa_etariaAtual" disabled value=" <%= request.getParameter("faixa_etaria")%>" >
            </div>
            <div class="campo">
                <p>Para alterar nome e categoria vá até atrações</p>
            </div>
        </form> <!-- Fechamento do primeiro form -->

    <form method="post" action="AlterarEventos-servlet?id=<%= request.getParameter("id") %>">
        <h2>Novo</h2>
        <div class="campo">
            <label for="nova-descricao">Nova descrição:</label>
            <input class="entrada" type="text" id="nova-descricao" name="nova-descricao" placeholder="Novo descrição">
        </div>
        <div class="campo">
            <label for="nova-capacidade">Nova capacidade:</label>
            <input class="entrada" type="text" id="nova-capacidade" name="nova-capacidade" placeholder="Nova capacidade" >
        </div>
        <div class="campo">
            <label for="novo-preco-pessoa">Novo preço por pessoa:</label>
            <input class="entrada" type="text" id="novo-preco-pessoa" name="novo-preco-pessoa" placeholder="Ex: 15.90">
        </div>

        <div class="campo">
            <label for="novo-horario">Novo horario:</label>
            <input class="entrada" type="text" id="novo-horario" name="novo-horario" placeholder="Ex: hh:mm:ss ou hh:mm">
        </div>
        <div class="campo">
            <label for="nova-data-inicial">Nova data de inicio:</label>
            <input class="entrada" type="text" id="nova-data-inicial" name="nova-data-inicial" placeholder="Ex: (aaaa-mm-dd)">
        </div>
        <div class="campo">
            <label for="nova-data-termino">Data de Termino atual:</label>
            <input class="entrada" type="text" id="nova-data-termino" name="nova-data-termino" placeholder="Ex: (aaaa-mm-dd)" >
            <input type="hidden" id="url" value="alterar_evento.jsp">
            <% try {
                ValidarData validarData = new ValidarData();
                request.getParameter("data_inicio");
                request.getParameter("data_termino");

                String invalido = (String) request.getAttribute("invalido");

                if (invalido != null){
            %>
            <p class="erro">Inválido! <%=invalido%></p>
            <% } // fim do if
                String valido = (String) request.getAttribute("valido");
            if (valido != null){
            %>
        </div>
        <div class="campo">
            <label for="nova-faixa-etaria">Nova faixa etária:</label>
            <select class="entrada" id="nova-faixa-etaria" name="nova-faixa-etaria">
                <option value="" disabled selected>Escolha uma opção</option>
                <option value="livre">Livre</option>
                <option value="12+">12+</option>
                <option value="14+">14+</option>
                <option value="16+">16+</option>
                <option value="18+">18+</option>
            </select>
        </div>
            <input type="submit" value="Alterar">
        <div class="botoes">
            <button>
                <a href="listar_admin.jsp">Voltar</a>
            </button>
        </div>
        </form>
    </div>
</div>

<% } // fim do segundo if
} catch (NullPointerException npe){
    request.setAttribute("erro", "Valores nulos!");
    request.getRequestDispatcher("error.jsp").forward(request, response);
}%>

</body>
</html>