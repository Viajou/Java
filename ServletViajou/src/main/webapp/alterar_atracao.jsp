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
    <title>Alterar atraçaõ</title>
</head>
<body>
<h1>Alterar atração</h1>
<form action="AlterarAtracao-servlet" method="post">
    <%--@declare id="id"--%><label for="id">Id da atração: </label>
    <input for="id" name="id" placeholder="Ex: 0">
    <br><br>
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
    <br>
    <input type="submit" value="Inserir atração">
</form>
</body>
</html>
