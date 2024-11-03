<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir Evento</title>
</head>
<body>
    <h1>Inserir um novo admin</h1>
    <form action="InserirEvento-servlet" method="post">
        <label for="faixa-etaria">Faixa Etária: </label>
        <input type="text" name="faixa-etaria" id="faixa-etaria" placeholder="Ex: +16">
        <br>
        <label for="descricao">Descrição: </label>
        <input type="text" name="descricao" id="descricao" placeholder="Ex: Evento de música ao vivo">
        <br>
        <label for="capacidade">Capacidade: </label>
        
    </form>
</body>
</html>
