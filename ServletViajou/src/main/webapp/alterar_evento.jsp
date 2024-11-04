<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Evento</title>
</head>
<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
</header>
<body>
<h1>Alterar um Evento</h1>
<form action="/AlterarEventos-servlet" method="post">
    <label for="faixa-etaria">Nova faixa Etária do evento:</label>
    <input type="text" name="faixa-etaria" id="faixa-etaria" placeholder="Ex: +16">
    <br>
    <label for="descricao">Nova descrição do evento:</label>
    <input type="text" name="descricao" id="descricao" placeholder="Ex: Evento de música ao vivo">
    <br>
    <label for="capacidade">Nova capacidade do evento:</label>
    <input type="text" name="capacidade" id="capacidade" placeholder="Ex: 1500">
    <br>
    <label for="horario">Novo horário do evento:</label>
    <input type="text" name="horario" id="horario" placeholder="Ex: 15:30">
    <br>
    <label for="data-inicio">Nova data de início do evento:</label>
    <input type="text" name="data-inicio" id="data-inicio" placeholder="Formato: aaaa-mm-dd">
    <br>
    <label for="data-termino">Nova data de término do evento:</label>
    <input type="text" name="data-termino" id="data-termino" placeholder="Formato: aaaa-mm-dd">
    <br>
    <label for="preco-pessoa">Novo preço por pessoa:</label>
    <input type="text" name="preco-pessoa" id="preco-pessoa" placeholder="Ex: 34.50">
    <br>
    <label for="id-tour">Novo ID do tour virtual:</label>
    <input type="text" name="id-tour" id="id-tour" placeholder="Ex: 76">
    <br>
    <label for="id-atracao">Novo ID da atração:</label>
    <input type="text" name="id-atracao" id="id-atracao" placeholder="Ex: 76">
    <br>
    <input type="submit" value="Alterar evento">
    <br>
    <a href="listar_eventos.jsp">
        <button>Voltar</button>
    </a>
</form>
</body>
</html>
