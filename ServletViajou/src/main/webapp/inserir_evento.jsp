<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir Evento</title>
</head>
<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
</header>
<body>
    <h1>Inserir um novo evento</h1>
    <form action="InserirEvento-servlet" method="post">
        <label for="faixa-etaria">Faixa Etária do evento:</label>
        <input type="text" name="faixa-etaria" id="faixa-etaria" placeholder="Ex: +16">
        <br>
        <label for="descricao">Descrição do evento:</label>
        <input type="text" name="descricao" id="descricao" placeholder="Ex: Evento de música ao vivo">
        <br>
        <label for="capacidade">Capacidade do evento:</label>
        <input type="text" name="capacidade" id="capacidade" placeholder="Ex: 1500">
        <br>
        <label for="horario">Horário do evento:</label>
        <input type="text" name="horario" id="horario" placeholder="Ex: 15:30">
        <br>
        <label for="data-inicio">Data de início do evento:</label>
        <input type="text" name="data-inicio" id="data-inicio" placeholder="Formato: aaaa-mm-dd">
        <br>
        <label for="data-termino">Data de término do evento:</label>
        <input type="text" name="data-termino" id="data-termino" placeholder="Formato: aaaa-mm-dd">
        <br>
        <label for="preco-pessoa">Preço por pessoa:</label>
        <input type="text" name="preco-pessoa" id="preco-pessoa" placeholder="Ex: 34.50">
        <br>
        <label for="id-tour">ID do tour virtual:</label>
        <input type="text" name="id-tour" id="id-tour" placeholder="Ex: 76">
        <br>
        <label for="id-atracao">ID da atração:</label>
        <input type="text" name="id-atracao" id="id-atracao" placeholder="Ex: 76">
        <br>
        <input type="submit" value="Inserir novo evento">
        <br>
        <a href="listar_evento.jsp">
            <button>Voltar</button>
        </a>
    </form>
</body>
</html>
