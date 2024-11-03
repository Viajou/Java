<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/InserirAdmin.css">
    <link rel="stylesheet" href="CSS/crud.css">
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
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
        </ul>
    </nav>
</aside>
    <main>
        <h1>Inserir Administrador</h1>
        <form action="inserirAdmin-servlet" method="post">
            <div class="form-container">
                <label for="nome">Nome do admin:</label>
                <input type="text" name="nome" id="nome" placeholder="Ex: Joao" required>

                <label for="email">Email do admin:</label>
                <input type="text" name="email" id="email" placeholder="Ex: usuario@gmail.com" required>

                <label for="senha">Senha do admin:</label>
                <input type="text" name="senha" id="senha" placeholder="Ex: 12345" required>

                <label for="url">Foto do admin:</label>
                <input type="text" name="url" id="url" placeholder="Ex: https://imagem-usuario">
            </div>

            <input type="submit" value="Adicionar">
        </form>
        <br><br>
        <a href="listar_admin.jsp">
            <button>Voltar</button>
        </a>
    </main>
</body>
</html>
