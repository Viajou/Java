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
            <li><a href="https://area-restrita-main.onrender.com"><img src="images/cadeado.svg" alt="">Área Restrita</a></li>        </ul>
    </nav>
</aside>
<body>

<h1>Alterar Tour Virtual</h1>

<div class="formulario">
    <form class="alteracao">
        <h2>Atual</h2>
        <div class="campo">
            <label for="id">Id:</label>
            <input class="entrada" type="number" id="id" name="id" disabled value="<%= request.getParameter("id") %>">
        </div>
        <div class="campo">
            <label for="descricao-atual">Descrição atual:</label>
            <input class="entrada" type="text" id="descricao-atual" name="descricao-atual" disabled value="<%= request.getParameter("descricao") %> " >
        </div>
        <div class="campo">
            <label for="video-atual">Vídeo atual:</label>
            <input class="entrada" type="text" id="video-atual" name="video-atual" disabled value="<%= request.getParameter("video")%>">
        </div>
        <div class="campo">
            <label for="media-classificacao-atual">Média das avaliações atual:</label>
            <input class="entrada" type="text" id="media-classificacao-atual" name="media-classificacao-atual" disabled value="<%= request.getParameter("media_classificacao")%>">
        </div>
        <div class="campo">
            <label for="qnt-classificacao-atual">Quantidade de avaliações atual:</label>
            <input class="entrada" type="text" id="qnt-classificacao-atual" name="qnt-classtual" disabled value=" <%= request.getParameter("qnt_classificacao")%>" >
        </div>
        <div class="campo">
            <label for="preco-atual">Preço atual:</label>
            <input class="entrada" type="text" name="preco-atual" id="preco-atual" disabled value="<%= request.getParameter("preco")%>">
        </div>
        <div class="campo">
            <label for="id-atracao-atual">ID da atração:</label>
            <input class="entrada" type="text" name="id-atracao-atual" id="id-atracao-atual" disabled value="<%= request.getParameter("id_atracao")%>">

        </div>
        <div class="campo">
            <label for="id-atracao-atual">ID da figurinhas:</label>
            <input class="entrada" type="text" name="id-atracao-atual" id="id-figurinhas-atual" disabled value="<%= request.getParameter("id_figurinha")%>">

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

