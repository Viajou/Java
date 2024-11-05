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
<hader>
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
</hader>

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

<main>
  <h1>Inserir Tour Virtual</h1>

  <form action="InserirTourVirtual-servlet" method="post">
    <div class="form-container">
      <label for="descricao">Descrição do tour: </label>
      <input class="entrada" type="text" name="descricao" id="descricao" placeholder="Exemplo: Praça com exposição de artes" required>

      <label for="video">URL do video: </label>
      <input class="entrada" type="text" name="video" id="video" required>

      <label for="mediaClassificacao">Média Classificação:</label>
      <input class="entrada" type="text" name="mediaClassificacao" id="mediaClassificacao" pattern="^\d+(\.\d{1,2})?$" placeholder="Exemplo: 4.52" title="Digite um número com até duas casas decimais, utilizando '.' como separador" required>

      <label for="qntClassificacao">Quantidade de Classificações:</label>
      <input class="entrada" type="text" name="qntClassificacao" id="qntClassificacao" placeholder="Exemplo: 150" required>

      <label for="preco">Preço do tour: </label>
      <input class="entrada" type="text" name="preco" id="preco" pattern="^\d+(\.\d{1,2})?$" placeholder="Exemplo: 12.56" title="Digite um número com até duas casas decimais, utilizando '.' como separador" required>

      <label for="idAtracao">ID da atração: </label>
      <input class="entrada" type="text" name="idAtracao" id="idAtracao" placeholder="Exemplo: 3" required>

      <label for="idFigurinhas">ID da figurinha:</label>
      <input class="entrada" type="text" name="idFigurinhas" id="idFigurinhas" placeholder="Exemplo: 20" required>
    </div>
    <input type="submit" value="Inserir tour">
  </form>
  <br><br>
  <a href="listar_tour_virtual.jsp">
    <button>Voltar</button>
  </a>
</main>
</body>
</html>
