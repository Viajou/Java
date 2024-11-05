<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.servletviajou.DAO.TourVirtualDAO" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Tour Virtual</title>
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

<h1>Alterar Tour Virtual</h1>

<div class="formulario">
    <form class="alteracao">
        <h2>Atual</h2>
        <div class="campo">
            <label for="nomeAtual">Id atual:</label>
            <input class="entrada" type="number" id="idAtual" name="idAtual" disabled value="<%= request.getParameter("id") %>">
        </div>
        <div class="campo">
            <label for="nomeAtual">Nome atual:</label>
            <input class="entrada" type="text" id="nomeAtual" name="nomeAtual" disabled value="<%= request.getParameter("nome") %> " >
        </div>
        <div class="campo">
            <label for="emailAtual">Email atual:</label>
            <input class="entrada" type="text" id="emailAtual" name="emailAtual" disabled value="<%= request.getParameter("email")%>">
        </div>
        <div class="campo">
            <label for="fotoAtual">Foto atual:</label>
            <input class="entrada" type="text" id="fotoAtual" name="fotoAtual" disabled value="<%= request.getParameter("url_imagem")%>">
        </div>
        <div class="campo">
            <label for="novaSenha">Senha atual:</label>
            <input class="entrada" type="text" id="senhaAtual" name="senhaAtual" disabled value=" <%= request.getParameter("senha")%>" >
        </div>
    </form>

    <form method="post" action="/AlterarTourVirtual-servlet?id=<%= request.getParameter("id") %>">
        <h2>Novo</h2>
        <div class="campo">
            <label for="novoNome">Novo nome:</label>
            <input class="entrada" type="text" id="novoNome" name="novoNome" placeholder="Novo nome">
        </div>
        <div class="campo">
            <label for="novoEmail">Novo email:</label>
            <input class="entrada" type="text" id="novoEmail" name="novoEmail" placeholder="Novo email">
        </div>
        <div class="campo">
            <label for="novaFoto">Nova foto:</label>
            <input class="entrada" type="text" id="novaFoto" name="novaFoto" placeholder="URL da nova foto" maxlength="1000">
        </div>
        <div class="campo">
            <label for="novaSenha">Nova senha:</label>
            <input class="entrada" type="text" id="novaSenha" name="novaSenha" placeholder="Nova senha">
        </div>

        <input type="submit" value="Alterar">

    </form>
</div>

<div class="botoes">
    <button>
        <a href="listar_tour_virtual.jsp">Voltar</a>
    </button>
</div>
</body>
</html>

