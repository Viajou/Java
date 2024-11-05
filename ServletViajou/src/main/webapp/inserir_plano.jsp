<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/Inserir.css">
    <title>Crud</title>
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
            <li><a href="https://area-restrita-main.onrender.com">Área Restrita</a></li>
        </ul>
    </nav>
</aside>

<main>
    <h1>Inserir plano</h1>

    <form action="InserirPlano-servlet" method="get">
        <div class="form-container">
            <label for="nome">Nome do plano: </label>
            <input class="entrada" type="text" name="nome" id="nome" placeholder="Ex: Systeam+" required>


            <label for="descricao">Descrição do plano: </label>
            <input class="entrada" type="text" name="descricao" id="descricao" placeholder="Ex: Plano anual" required>


            <label> Livre de propaganda? </label>
            <label>
                <input class="entrada" type="radio" name="livre_propaganda" value="true" required> Sim
            </label>
            <label>
                <input class="entrada" type="radio" name="livre_propaganda" value="false" required> Não
            </label>

            <label for="preco">Preço do plano: </label>
            <input class="entrada" type="text" name="preco" id="preco" pattern="^\d+(\.\d{1,2})?$" placeholder="Exemplo: 12.56" title="Digite um número com até duas casas decimais, utilizando '.' como separador" required>

            <label for="duracao">Duração do plano: </label>
            <input class="entrada" type="text" name="duracao" id="duracao" placeholder="Ex: 6 meses" required>

        </div>
        <input type="submit" value="Inserir plano">
    </form>
</main>
</body>
</html>
