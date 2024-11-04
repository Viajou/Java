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

<h1>Alterar um Evento</h1>

<div class="fundo">
    <div class="formulario">

        <form class="alteracao">

            <label for="faixaetaria">Faixa Etária do evento:</label>
            <input type="text" name="faixa-etaria" id="faixaetaria" placeholder="Ex: +16">

            <br>

            <label for="descricao2">Descrição do evento:</label>
            <input type="text" name="descricao" id="descricao2" placeholder="Ex: Evento de música ao vivo">

            <br>

            <label for="capacidade2">Capacidade do evento:</label>
            <input type="text" name="capacidade" id="capacidade2" placeholder="Ex: 1500">

            <br>

            <label for="horario2">Horário do evento:</label>
            <input type="text" name="horario" id="horario2" placeholder="Ex: 15:30">

            <br>

            <label for="datainicio">Data de início do evento:</label>
            <input type="text" name="data-inicio" id="datainicio" placeholder="Formato: aaaa-mm-dd">

            <br>

            <label for="datatermino">Data de término do evento:</label>
            <input type="text" name="data-termino" id="datatermino" placeholder="Formato: aaaa-mm-dd">

            <br>

            <label for="precopessoa">Preço por pessoa:</label>
            <input type="text" name="preco-pessoa" id="precopessoa" placeholder="Ex: 34.50">

        </form>

        <form action="AlterarEventos-servlet" method="post">

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

       </form>
    </div>
    <div class="botoes">
        <button>
            <a href="listar_admin.jsp">Voltar</a>
        </button>
        <input type="submit" value="Alterar">
    </div>
</div>
</body>
</html>
