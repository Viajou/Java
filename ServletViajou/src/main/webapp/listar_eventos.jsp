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
            <li><a href="#"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
        </ul>
    </nav>
</aside>

<main>
    <h1>Eventos</h1>

    <div class="button-group">
        <a href="inserir_evento.jsp">
            <button class="inserir">Adicionar</button>
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
                <th>Início</th>
                <th>Fim</th>
                <th>Faixa etária</th>
                <th>Opções</th>
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
            %>

            <tr>
                <td><%= busca.getInt("id") %></td>
                <td><%= busca.getString("nome") %></td>
                <td><%= busca.getString("descricao") %></td>
                <td><%= busca.getString("categoria") %></td>
                <td><%= busca.getInt("capacidade") %></td>
                <td><%= busca.getDouble("preco_pessoa") %></td>
                <td><%= busca.getDate("data_inicio") %></td>
                <td><%= busca.getDate("data_termino") %></td>
                <td><%= busca.getString("faixa_etaria") %></td>
                <td>
                    <a href="alterar_evento.jsp?id=<%= busca.getInt("id") %>&nome=<%= busca.getString("nome") %>&descricao=<%= busca.getString("descricao") %>&capacidade=<%= busca.getInt("capacidade")%>&data_inicio=<%= busca.getDate("data_inicio")%>&data_termino=<%= busca.getDate("data_termino")%>&preco_pessoa=<%= busca.getDouble("preco_pessoa") %>&faixa_etaria=<%= busca.getString("faixa_etaria") %>">
                        <button class="deletar">
                            <img src="images/lapis.svg" alt="">
                        </button>
                    </a>
                    <a href="DeletarEventos-servlet?id=<%= busca.getInt("id") %>" onclick="return confirm('Tem certeza que deseja deletar este evento?')">
                        <button class="deletar">
                            <img src="images/lixeira.svg" alt="Deletar">
                        </button>
                    </a>
                </td>
            </tr>
            <%
                    }
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            %>
            </tbody>
        </table>
    </section>
    <%
    } else {
    %>
    <p class="naoEncontrado"><%= naoEncontrado %></p>
    <%
        }
    %>
</main>
</body>
</html>
