<%--
  Created by IntelliJ IDEA.
  User: heloisamachado-ieg
  Date: 01/11/2024
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crud</title>
</head>
<body>
    <header>
        <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
    </header>
    <main>
        <h1>Inserindo Admin</h1>
        <form action="inserirAdmin-servlet" method="get">
            <label for="nome">Nome do admin:</label>
            <input type="text" name="nome" id="nome" placeholder="Ex: Joao">
            <br><br>
            <label for="email">Email do admin:</label>
            <input type="text" name="email" id="email" placeholder="Ex: usuari@gmail.com">
            <br><br>
            <label for="senha">Senha do admin:</label>
            <input type="text" name="senha" id="senha" placeholder="Ex: 12345">
            <br><br>
            <label for="url">Foto do admin:</label>
            <input type="text" name="url" id="url" placeholder="Ex: https://imagem-usuario">
            <br><br>
            <input type="submit" value="Inserir usuario" >
        </form>
        <br><br>
        <a href="ListarAdmins.jsp">
            <button>Voltar</button>
        </a>
    </main>
</body>
</html>
