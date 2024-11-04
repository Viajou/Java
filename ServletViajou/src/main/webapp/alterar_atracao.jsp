<%--
  Created by IntelliJ IDEA.
  User: heloisamachado-ieg
  Date: 02/11/2024
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Administrador</title>
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

<body>
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

    <h1>Alterar atração</h1>
    <form action="AlterarAtracao-servlet" method="post">

        <label for="nome">Nome da atração: </label>
        <input type="text" name="nome" id="nome" placeholder="Ex:Catavento">

        <br><br>

        <label for="descricao">Descrição da atração: </label>
        <input type="text" name="descricao" id="descricao" placeholder="Ex:Museu">

        <br><br>

        <label for="endereco">Endereço da atração: </label>
        <input type="text" name="endereco" id="endereco" placeholder="Ex: Av.Getulio vagas">

        <br><br>

        <label for="acessibilidade">Acessibilidade da atração: </label>
        <input type="text" name="acessibilidade" id="acessibilidade" placeholder="Ex: true/false">

        <br><br>

        <label for="categoria">Categoria da atração: </label>
        <input type="text" name="categoria" id="categoria" placeholder="Ex: Exposições">
    </form>
</body>
</html>
