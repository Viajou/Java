<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir Evento</title>
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
        <h1>Inserir um novo evento</h1>
        <form action="InserirEvento-servlet" method="post">
            <div class="form-container">
                <label for="faixa-etaria">Faixa Etária do evento:</label>
                <input type="text" name="faixa-etaria" id="faixa-etaria" placeholder="Ex: +16">
                <br>
                <fieldset>
                    <legend >Faixa etaria</legend>
                    <br>
                    <label for="nova-faixa-etaria">livre</label>
                    <input type="radio" name="nova-faixa-etaria" id="nova-faixa-etaria" value="livre">
                    <br>
                    <label for="nova-faixa-etaria">+10</label>
                    <input type="radio" name="nova-faixa-etaria" id="nova-faixa-etaria" value="10+">
                    <br>
                    <label for="nova-faixa-etaria">+12</label>
                    <input type="radio" name="nova-faixa-etaria" id="nova-faixa-etaria" value="12+">
                    <br>
                    <label for="nova-faixa-etaria">+14</label>
                    <input type="radio" name="nova-faixa-etaria" id="nova-faixa-etaria" value="14+">
                    <br>
                    <label for="nova-faixa-etaria">+16</label>
                    <input type="radio" name="nova-faixa-etaria" id="nova-faixa-etaria" value="16+">
                    <br>
                    <label for="nova-faixa-etaria">+18</label>
                    <input type="radio" name="nova-faixa-etaria" id="nova-faixa-etaria" value="18+">
                    <br>
                </fieldset>
                <label for="descricao">Descrição do evento:</label>
                <input type="text" name="descricao" id="descricao" placeholder="Ex: Evento de música ao vivo">
                <br>
                <label for="capacidade">Capacidade do evento:</label>
                <input type="text" name="capacidade" id="capacidade" placeholder="Ex: 1500">
                <br>
                <label for="horario">Horário do evento:</label>
                <input type="text" name="horario" id="horario" placeholder="Ex: 15:30">
                <br>
                <label for="data-inicio">Data de início do evento:</label>
                <input type="text" name="data-inicio" id="data-inicio" placeholder="Formato: aaaa-mm-dd">
                <br>
                <label for="data-termino">Data de término do evento:</label>
                <input type="text" name="data-termino" id="data-termino" placeholder="Formato: aaaa-mm-dd">
                <br>
                <label for="preco-pessoa">Preço por pessoa:</label>
                <input type="text" name="preco-pessoa" id="preco-pessoa" placeholder="Ex: 34.50">
                <br>
                <label for="id-tour">ID do tour virtual:</label>
                <input type="text" name="id-tour" id="id-tour" placeholder="Ex: 76">
                <br>
                <label for="id-atracao">ID da atração:</label>
                <input type="text" name="id-atracao" id="id-atracao" placeholder="Ex: 76">
            </div>

            <input type="submit" value="Inserir novo evento">
        </form>
        <br>
        <a href="listar_eventos.jsp">
            <button>Voltar</button>
        </a>
    </main>
</body>
</html>
