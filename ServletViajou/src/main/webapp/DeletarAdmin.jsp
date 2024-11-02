<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="imagex/svg" href="images/icone-viajou.svg">
    <title>Deletar Admin</title>
    <link rel="stylesheet" href="Cascanding-styles-sheets/crud.css">
    <link rel="stylesheet" href="Cascanding-styles-sheets/DeletarAdmin.css"></link>
</head>
<body>
<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
</header>
<main>
    <h1>Deletar Admin</h1>
    <form action="DeletarAdminServlet" method="get" onsubmit="return confirm('Tem certeza que deseja deletar este admin?');">
        <label for="adminId">Digite o ID do admin que deseja deletar:</label>
        <input type="text" name="id" id="adminId" required>
        <button type="submit">Deletar</button>
    </form>
</main>
</body>
</html>

