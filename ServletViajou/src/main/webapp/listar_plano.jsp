<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.servletviajou.DAO.PlanoDAO" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <!-- Configurações de charset, viewport e favicon -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="imagex/svg" href="images/icone-viajou.svg">
    <title>Listar Plano</title>
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/encontrado.css">
</head>
<body>
<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
    <%
        // Recupera a URL da imagem e o nome do admin armazenados na sessão
        HttpSession sessao = request.getSession();
        String urlImagem = (String) sessao.getAttribute("urlImagem");
        String nomeAdmin = (String) sessao.getAttribute("nomeAdmin");
    %>

    <!-- Exibe a imagem e o nome do admin no cabeçalho -->
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
            <li><a href="https://area-restrita-main.onrender.com"><img src="images/cadeado.svg" alt="">Área Restrita</a></li>            </ul>
        </ul>
    </nav>
</aside>

<main>
    <h1>Planos</h1>

    <div class="button-group">
        <!-- Botão para adicionar um novo plano -->
        <a href="inserir_plano.jsp">
            <button class="inserir">Adicionar</button>
        </a>

        <!-- Formulário de busca de planos com campo obrigatório -->
        <form action="buscarPlano-servlet" method="get" class="search-form">
            <input type="text" name="search" placeholder="Buscar plano..." required>
            <button type="submit">Buscar</button>
        </form>

        <!-- Botão para listar todos os planos -->
        <a href="listar_plano.jsp">
            <button class="all">All</button>
        </a>
    </div>

    <%
        // Verifica se há uma mensagem de "não encontrado" para exibir
        String naoEncontrado = (String) request.getAttribute("naoEncontrado");
        if (naoEncontrado == null) {
    %>
    <section class="table-section">
        <!-- Tabela para exibir a lista de planos -->
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descricao</th>
                <th>Livre propaganda</th>
                <th>Preço</th>
                <th>Duração</th>
                <th>Criação</th>
                <th>Atualização</th>
                <th>Opções</th>
            </tr>
            </thead>
            <tbody>
            <%
                // Recupera o ResultSet de planos ou consulta o banco de dados se não houver resultados
                ResultSet busca = (ResultSet) request.getAttribute("resultados");
                if (busca == null) {
                    PlanoDAO planoDAO = new PlanoDAO();
                    busca = planoDAO.buscar();
                }
            %>
            <%
                try {
                    // Itera sobre os resultados para exibir os planos
                    while (busca.next()) {
                        int planoId = busca.getInt("id");
            %>
            <tr>
                <td><%= planoId %></td>
                <td><%= busca.getString("nome") %></td>
                <td><%= busca.getString("descricao") %></td>
                <td><%= busca.getBoolean("livre_propaganda") %></td>
                <td><%= busca.getString("preco") %></td>
                <td><%= busca.getString("duracao") %></td>
                <td><%= busca.getString("data_criacao") %></td>
                <td><%= busca.getString("data_atualizacao") %></td>
                <td>
                    <!-- Link para deletar o plano, com confirmação -->
                    <a href="DeletarPlano-servlet?id=<%= planoId %>" onclick="return confirm('Tem certeza que deseja deletar este admin?')">
                        <button class="deletar">
                            <img src="images/lixeira.svg" alt="Deletar"></img>
                        </button>
                    </a>
                </td>
            </tr>
            <%
                    }
                } catch (SQLException sqle) {
                    // Exibe o erro em caso de exceção SQL
                    sqle.printStackTrace();
                }
            %>
            </tbody>
        </table>
    </section>
    <%
    } else {
    %>
    <!-- Exibe uma mensagem de "não encontrado" se não houver resultados -->
    <p class="naoEncontrado"><%= request.getAttribute("naoEncontrado") %></p>
    <%
        }
    %>
</main>
</body>
</html>
