<%@ page import="com.example.servletviajou.Servlet.ValidarData" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir atraçaõ</title>
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/inserir2.css">
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
            <li><a href="listar_eventos.jsp"><img src="images/icone-eventos-crud.svg" alt="">Eventos</a></li>
            <li><a href="listar_plano.jsp"><img src="images/icone-panos-crud.svg" alt="">Planos</a></li>
            <li><a href="listar_excursao.jsp"><img src="images/icone-excursao-crud.svg" alt="">Excursão</a></li>
            <li><a href="listar_atracao.jsp"><img src="images/icone-eventos-crud.svg" alt="">Atração</a></li>
            <li><a href="listar_tour_virtual.jsp"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-main.onrender.com"><img src="images/cadeado.svg" alt="">Área Restrita</a></li>
        </ul>
    </nav>
</aside>
<h1>Inserir excursao</h1>
<form action="InserirAtracao-servlet" method="post">

    <div class="form-container">
        <label for="nome">Nome da excursao: </label>
        <input class="entrada" type="text" name="nome" id="nome" placeholder="Ex:Catavento" required>

        <label for="nome_empresa">Nome da empresa: </label>
        <input class="entrada" type="text" name="descricao" id="nome_empresa" placeholder="Ex:Museu" required>

        <label for="site">Site da empresa: </label>
        <input class="entrada" type="text" name="endereco" id="site" placeholder="Ex: Av.Getulio vagas" required>

        <label for="capacidade">Capacidade: </label>
        <input class="entrada" type="text" name="acessibilidade" id="capacidade" placeholder="Ex: true/false" required>

        <label for="duracao">duração:</label>
        <input class="entrada" type="text" name="categoria" id="duracao" placeholder="Ex: Exposições">

        <label for="preco">Preço:</label>
        <input class="entrada" type="text" name="categoria" id="preco" placeholder="Ex: Exposições">

        <label for="data_inicio">Data de Inicio:</label>
        <input class="entrada" type="text" name="categoria" id="data_inicio" placeholder="Ex: Exposições">

        <label for="data_termino">Data de término:</label>
        <input class="entrada" type="text" name="categoria" id="data_termino" placeholder="Ex: Exposições">
        <input type="hidden" id="url" value="inserir_excursao.jsp">
        <%
            try {
                ValidarData validarData = new ValidarData();
                request.getParameter("data_inicio");
                request.getParameter("data_termino");

                String invalido = (String) request.getAttribute("invalido");

                if (invalido != null){
        %>
        <p class="erro">A data inserida está errada! A data de término não pode ser maior que a de início</p>
        <% } // fim do if
            String valido = (String) request.getAttribute("valido");
            if (valido != null){
        %>

    </div>

    <div class="botoes2">
        <a  class="voltar" href="listar_tour_virtual.jsp">Voltar</a>
        <input type="submit" value="Inserir tour">
    </div>
</form>
<% } // fim do if
} catch (NullPointerException npe){
    request.setAttribute("erro", "Valores nulos!");
    request.getRequestDispatcher("error.jsp").forward(request, response);
}
%>
</body>
</html>