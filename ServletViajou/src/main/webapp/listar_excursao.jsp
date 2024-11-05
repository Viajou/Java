<%--
  Created by IntelliJ IDEA.
  User: biancaclarindo-ieg
  Date: 03/11/2024
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.servletviajou.DAO.EventosDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.servletviajou.DAO.ExcursaoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="image/svg+xml" href="images/icone-viajou.svg">
    <title>Listar Excursões</title>
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
            <li><a href="#"><img src="images/icone-excursao-crud.svg" alt="">Excursão</a></li>
            <li><a href="listar_atracao.jsp"><img src="images/icone-eventos-crud.svg" alt="">Atração</a></li>
            <li><a href="listar_tour_virtual.jsp"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
        </ul>
    </nav>
</aside>

<main>
    <h1>Excursão</h1>

    <div class="button-group">
        <a href="InserirExcursao-servlet">
            <button class="inserir">Adicionar</button>
        </a>

        <form action="BuscarExcursao-servlet" method="get" class="search-form">
            <input type="text" name="search" placeholder="Buscar excursão...">
            <button type="submit">Buscar</button>
        </form>
        <a href="listar_excursao.jsp">
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
                <th>Nome da empresa</th>
                <th>Site da empresa</th>
                <th>Capacidade</th>
                <th>Duração</th>
                <th>Preço</th>
                <th>Data de Inicio</th>
                <th>Data de término</th>
                <th>Data de atualização</th>
                <th>Opções</th>
            </tr>
            </thead>

            <tbody>
            <%
                ResultSet busca = (ResultSet) request.getAttribute("resultados");
                if (busca == null){
                    ExcursaoDAO excursaoDAO = new ExcursaoDAO();
                    busca = excursaoDAO.buscar();
                }
            %>
            <%
                try {
                    while (busca.next()){
                        int excursaoId = busca.getInt("id");
            %>

            <tr>
                <td><%= excursaoId %></td>
                <td><%=busca.getString("nome")%></td>
                <td><%=busca.getString("nome_empresa")%></td>
                <td><%=busca.getString("site")%></td>
                <td><%=busca.getInt("capacidade")%></td>
                <td><%=busca.getString("duracao")%></td>
                <td><%=busca.getDouble("preco_total")%></td>
                <td><%=busca.getDate("data_inicio")%></td>
                <td><%=busca.getDate("data_termino")%></td>
                <td><%=busca.getDate("data_atualizacao")%></td>
                <td>
                    <a href="alterar_excursao.jsp?id=<%=busca.getInt("id")%>nome=<%=busca.getString("nome")%>nome_empresa=<%=busca.getString("nome_empresa")%>site=<%=busca.getString("site")%>capacidade=<%=busca.getInt("capacidade")%>duracao=<%=busca.getString("duracao")%>preco=<%=busca.getDouble("preco_total")%>data_inicio=<%=busca.getDate("data_inicio")%>data_termino=<%=busca.getDate("data_termino")%>data_atualizacao=<%=busca.getDate("data_atualizacao")%>">
                        <button class="deletar">
                            <img src="images/lapis.svg">
                        </button>
                    </a>
                    <a href="DeletarExcursao-servlet?="<%= excursaoId%> onclick="return confirm('Tem certeza que deseja deletar este evento?')">
                        <button class="deletar">
                            <img src="images/lixeira.svg">
                        </button>
                    </a>
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

