<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.servletviajou.DAO.EventosDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="image/svg+xml" href="images/icone-viajou.svg">
    <title>Listar Eventos</title>
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/encontrado.css">
</head>
<body>
<header>

    <img src="images/Viajou logo pequena.svg" alt="Viajou logo" id="Viajou-logo">

    <%
        //traz o nome a imagem armazenados na sessão
        HttpSession sessao = request.getSession();
        String imagem = (String) sessao.getAttribute("url_imagem");
        String nomeAdmin = (String) sessao.getAttribute("nome_admin");
    %>

    <div class="usuario">
        <img src="<%=imagem%>" alt="Imagem do admin" class="admin-image">
        <h3 class="admin-name"><%=nomeAdmin%></h3>
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
            <li><a href="#"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
        </ul>
    </nav>
</aside>

<main>
    <h1>Eventos</h1>

    <div class="button-group">
        <a href="InserirEvento-servlet">
            <button class="inserir">Adicionar</button>
        </a>

        <a href="AlterarEventos-servlet">
            <button class="alterar">Alterar</button>
        </a>

        <form action="BuscarEvento-servlet" method="get" class="search-form">
            <input type="text" name="search" placeholder="Buscar evento...">
            <button type="submit">Buscar</button>
        </form>

        <a href="listar_eventos.jsp">
            <button class="all">ALL</button>
        </a>
    </div>


    <%
        //verifica se naoEncontrado não é nulo
        String naoEncontrado = (String) request.getAttribute("naoEncontrado");
        if (naoEncontrado == null) {
    %>
    <section class="table-section">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Categoria</th>
                <th>Capacidade</th>
                <th>Preço</th>
                <th>Inicio</th>
                <th>Fim</th>
                <th>Faixa etária</th>
            </tr>
            </thead>

            <tbody>
            <%
                ResultSet busca = (ResultSet) request.getAttribute("resultados");
                if (busca == null){
                    EventosDAO eventosDAO = new EventosDAO();
                    busca = eventosDAO.buscar();
                }
            %>
            <%
                try {
                    while (busca.next()){
                        int eventosId = busca.getInt("id");
            %>

            <tr>
                <td><%= eventosId %></td>
                <td><%=busca.getString("nome")%></td>
                <td><%=busca.getString("descricao")%></td>
                <td><%=busca.getString("categoria")%></td>
                <td><%=busca.getInt("capacidade")%></td>
                <td><%=busca.getDouble("preco_pessoa")%></td>
                <td><%=busca.getDate("data_inicio")%></td>
                <td><%=busca.getDate("data_termino")%></td>
                <td><%=busca.getString("faixa_etaria")%></td>
                <td>

                    <a href="DeletarEevntos-servelet?="<%=eventosId%> onclick="return confirm('Tem certeza que deseja deletar este evento?')"
                       <button class="deletar">
                           <img src="images/lixeira.svg">
                       </button>

                </td>
            </tr>
            <%
                } // fim do while
                } catch (SQLException sqle){
                    sqle.printStackTrace();
                } //fim do try
            %>
            </tbody>
        </table>
    </section>
    <%
        // fim do if
        } else {
    %>
    <p class="naoEncontrado"<%= request.getAttribute("naoEncontrado")%>></p>
    <%
        } //fim do else
    %>

</main>
</body>
</html>
