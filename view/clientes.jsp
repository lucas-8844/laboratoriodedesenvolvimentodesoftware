<%@ page import="java.util.List" %>
<%@ page import="model.Cliente" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Lista de Clientes</title>
</head>
<body>
    <h2>Cadastro de Cliente</h2>
    <form action="cliente" method="post">
        <input type="hidden" name="action" value="create">
        Nome: <input type="text" name="nome"><br>
        Email: <input type="text" name="email"><br>
        Telefone: <input type="text" name="telefone"><br>
        <input type="submit" value="Cadastrar">
    </form>

    <h2>Clientes Cadastrados</h2>
    <table border="1">
        <tr><th>ID</th><th>Nome</th><th>Email</th><th>Telefone</th><th>Ações</th></tr>
        <%
            List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
            if (clientes != null) {
                for (Cliente cliente : clientes) {
        %>
            <tr>
                <td><%= cliente.getId() %></td>
                <td><%= cliente.getNome() %></td>
                <td><%= cliente.getEmail() %></td>
                <td><%= cliente.getTelefone() %></td>
                <td>
                    <form action="cliente" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="<%= cliente.getId() %>">
                        <input type="submit" value="Excluir">
                    </form>
                </td>
            </tr>
        <% 
                }
            } 
        %>
    </table>
</body>
</html>
