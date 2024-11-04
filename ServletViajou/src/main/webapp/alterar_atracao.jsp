
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.servletviajou.DAO.AdminDAO" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Atração</title>
    <link rel="stylesheet" href="CSS/Alterar.css">
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
            <li><a href="#"><img src="images/icone-eventos-crud.svg" alt="">Eventos</a></li>
            <li><a href="listar_plano.jsp"><img src="images/icone-panos-crud.svg" alt="">Planos</a></li>
            <li><a href="#"><img src="images/icone-excursao-crud.svg" alt="">Excursão</a></li>
            <li><a href="#"><img src="images/icone-eventos-crud.svg" alt="">Atração</a></li>
            <li><a href="#"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
        </ul>
    </nav>
</aside>
<body>
    <h1>Alterar Atração</h1>

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
                <label for="descricao">Descrição atual:</label>
                <input class="entrada" type="text" id="descricao" name="emailAtual" disabled value="<%= request.getParameter("descricao")%>">
            </div>
            <div class="campo">
                <label for="endereco">Endereco atual:</label>
                <input class="entrada" type="text" id="endereco" name="endereco" disabled value="<%= request.getParameter("endereco")%>">
            </div>
            <div class="campo">
                <label for="acessibilidade">Acessibilidade atual:</label>
                <input class="entrada" type="text" id="acessibilidade" name="acessibilidade" disabled value=" <%=request.getParameter("acessibilidade")%>" >
            </div>
            <div class="campo">
                <label for="categoria">Categoria atual:</label>
                <input class="entrada" type="text" id="categoria" name="categoria" disabled value=" <%= request.getParameter("categoria")%>" >
            </div>
        </form>

        <form method="post" action="AlterarAtracao-servlet?id=<%= request.getParameter("id") %>">
            <h2>Novo</h2>
            <div class="campo">
                <label for="novoNome">Novo nome:</label>
                <input class="entrada" type="text" id="novoNome" name="novoNome" placeholder="Novo nome">
            </div>
            <div class="campo">
                <label for="novaDescricao">Nova descrição:</label>
                <input class="entrada" type="text" id="novaDescricao" name="novaDescricao" placeholder="novaDescricao">
            </div>
            <div class="campo">
                <label for="novoEndereco">Novo Endereco:</label>
                <input class="entrada" type="text" id="novoEndereco" name="novoEndereco" placeholder="novoEndereco" maxlength="1000">
            </div>
            <div class="campo">
                <label for="novaAcessibilidade">Nova acessibilidade:</label>
                <input class="entrada" type="text" id="novaAcessibilidade" name="novaAcessibilidade" placeholder="Ex:true/false">
            </div>
            <div class="campo">
                <label for="novaCategoria">Nova senha:</label>
                <input class="entrada" type="text" id="novaCategoria" name="novaCategoria" placeholder="Ex: Exposição">
            </div>
            <input type="submit" value="Alterar">

        </form>
    </div>

    <div class="botoes">
        <button>
            <a href="listar_admin.jsp">Voltar</a>
        </button>
    </div>
</body>
</html>


