<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir Evento</title>
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
        </nav>
    </aside>
    <main>
        <h1>Inserir um novo evento</h1>
        <form action="InserirEvento-servlet" method="post">
            <div class="form-container">
                <div class="campo">
                    <label for="nova-faixa-etaria">Faixa etária:</label>
                    <select class="entrada" id="nova-faixa-etaria" name="nova-faixa-etaria" required>
                        <option value="" disabled selected>Escolha uma opção</option>
                        <option value="livre">Livre</option>
                        <option value="12+">12+</option>
                        <option value="14+">14+</option>
                        <option value="16+">16+</option>
                        <option value="18+">18+</option>
                    </select>
                </div>
                <label for="descricao">Descrição do evento:</label>
                <input class="entrada" type="text" name="descricao" id="descricao" placeholder="Ex: Evento de música ao vivo" required>
                <br>
                <label for="capacidade">Capacidade do evento:</label>
                <input class="entrada" type="text" name="capacidade" id="capacidade" placeholder="Ex: 1500" required>
                <br>
                <label for="horario">Horário do evento:</label>
                <input class="entrada" type="text" name="horario" id="horario" placeholder="Ex: 15:30" required>
                <br>
                <label for="data-inicio">Data de início do evento:</label>
                <input class="entrada" type="text" name="data-inicio" id="data-inicio" placeholder="Formato: aaaa-mm-dd" required>
                <br>
                <label for="data-termino">Data de término do evento:</label>
                <input class="entrada" type="text" name="data-termino" id="data-termino" placeholder="Formato: aaaa-mm-dd" required>
                <br>
                <label for="preco-pessoa">Preço por pessoa:</label>
                <input class="entrada" type="text" name="preco-pessoa" id="preco-pessoa" placeholder="Ex: 34.50" required>
                <br>
                <label for="id-tour">ID do tour virtual:</label>
                <input class="entrada" type="text" name="id-tour" id="id-tour" placeholder="Ex: 76" required>
                <br>
                <label for="id-atracao">ID da atração:</label>
                <input class="entrada" type="text" name="id-atracao" id="id-atracao" placeholder="Ex: 76" required>
            </div>

            <div class="botoes2">
                <a  class="voltar" href="listar_eventos.jsp">Voltar</a>
                <input type="submit" value="Inserir tour">
            </div>
        </form>
    </main>
</body>
</html>
