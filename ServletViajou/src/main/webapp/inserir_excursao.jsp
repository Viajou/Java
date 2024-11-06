<%--
  Created by IntelliJ IDEA.
  User: biancaclarindo-ieg
  Date: 03/11/2024
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir atraçaõ</title>
    <link rel="stylesheet" href="CSS/crud.css">
</head>
<body>

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

<h1>Inserir atração</h1>
<form action="InserirAtracao-servlet" method="post">

    <label for="nome">Nome da excursao: </label>
    <input type="text" name="nome" id="nome" placeholder="Ex:Catavento" required>


    <br><br>

    <label for="nome_empresa">Nome da empresa: </label>
    <input type="text" name="descricao" id="nome_empresa" placeholder="Ex:Museu" required>

    <br><br>

    <label for="site">Site da empresa: </label>
    <input type="text" name="endereco" id="site" placeholder="Ex: Av.Getulio vagas" required>

    <br><br>

    <label for="capacidade">Capacidade: </label>
    <input type="text" name="acessibilidade" id="capacidade" placeholder="Ex: true/false" required>

    <br><br>

    <label for="duracao">duração:</label>
    <input type="text" name="categoria" id="duracao" placeholder="Ex: Exposições" required>

    <label for="preco">Preço:</label>
    <input type="text" name="categoria" id="preco" placeholder="Ex: Exposições">

    <label for="data_inicio">Data de Inicio:</label>
    <input type="text" name="categoria" id="data_inicio" placeholder="YYYY-MM-DD" pattern="\d{4}-\d{2}-\d{2}" required title="Utilize o formato exemplo: YYYY-MM-DD">

    <label for="data_termino">Data de término:</label>
    <input type="text" name="categoria" id="data_termino" placeholder="YYYY-MM-DD" pattern="\d{4}-\d{2}-\d{2}" required title="Utilize o formato exemplo: YYYY-MM-DD">

    <br>

    <input type="submit" value="Inserir atração">

    <a href="listar_excursao.jsp">
        <button>Cancelar</button>
    </a>
</form>
</body>
</html>
