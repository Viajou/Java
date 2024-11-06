<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.servletviajou.DAO.AtracaoDAO" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <!-- Configuração do charset, propriedades de visualização para dispositivos móveis e ícone do site -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="imagex/svg" href="images/icone-viajou.svg">
    <title>Listar atracao</title>
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/encontrado.css">
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
        <img src="<%= urlImagem %>" alt="" class="admin-image">
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
    <h1>Atrações</h1>

    <div class="button-group">
        <!-- Botão para adicionar uma nova atração -->
        <a href="inserir_atracao.jsp">
            <button class="inserir">Adicionar</button>
        </a>
        <!-- Formulário de busca de atrações -->
        <form action="buscarAtracao-servlet" method="get" class="search-form">
            <input type="text" name="search" placeholder="Buscar atracao..." required>
            <button type="submit">Buscar</button>
        </form>
        <!-- Botão para listar todas as atrações -->
        <a href="listar_atracao.jsp"> <!-- Substitua "listar_admin.jsp" pela URL da sua página de listagem -->
            <button class="all">All</button>
        </a>


    </div>
    <%
        // Verifica se há uma mensagem de "não encontrado"
        String naoEncontrado = (String) request.getAttribute("naoEncontrado");
        if (naoEncontrado == null) {
    %>
    <section class="table-section">
        <!-- Tabela para listar as excursões -->
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descricao</th>
                <th>Endereco</th>
                <th>acessibilidade</th>
                <th>Categoria</th>
                <th>Criacao</th>
                <th>Atualização</th>
                <th>Opções</th>
            </tr>
            </thead>
            <tbody>
            <%
                // Recupera o ResultSet de atrações ou consulta o banco de dados se não houver resultados na requisição
                ResultSet busca = (ResultSet) request.getAttribute("resultados");
                if (busca == null) {
                    AtracaoDAO atracaoDAO = new AtracaoDAO();
                    busca = atracaoDAO.buscar();
                }
            %>
            <%
                try {
                    // Itera sobre os resultados para exibir as atrações
                    while (busca.next()) {

            %>
            <tr>
                <td><%= busca.getInt("id") %></td>
                <td><%= busca.getString("nome") %></td>
                <td><%= busca.getString("descricao") %></td>
                <td><%= busca.getString("endereco") %></td>
                <td><%= busca.getBoolean("acessibilidade") %></td>
                <td><%= busca.getString("categoria") %></td>
                <td><%= busca.getString("data_criacao") %></td>
                <td><%= busca.getString("data_atualizacao") %></td>

                <td>
                    <!-- Link para alterar atração -->
                    <a href="alterar_atracao.jsp?id=<%= busca.getInt("id") %>&nome=<%= busca.getString("nome") %>&descricao=<%= busca.getString("descricao") %>&endereco=<%= busca.getString("endereco") %>&acessibilidade=<%= busca.getBoolean("acessibilidade") %>&categoria=<%= busca.getString("categoria") %>">
                        <button class="deletar">
                            <img src="images/lapis.svg" alt="">
                        </button>
                    </a>
                    <a href="DeletarAtracao-servlet?id=<%= busca.getInt("id") %>" onclick="return confirm('Tem certeza que deseja deletar esta atração?')">

                        <button class="deletar">
                            <img src="images/lixeira.svg" alt="">
                        </button>
                    </a>
                </td>
            </tr>
            <%
                    }//fim do while
                } catch (SQLException sqle) {
                        // Exibe o erro em caso de exceção SQL
                        sqle.printStackTrace();
                }//fim do try
                }
            %>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>

