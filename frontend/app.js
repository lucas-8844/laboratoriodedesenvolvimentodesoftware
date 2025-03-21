const API_URL = "http://localhost:8080/clientes";

// 🔹 Função para listar clientes
function listarClientes() {
    fetch(API_URL)
        .then(response => response.json())
        .then(clientes => {
            const tbody = document.getElementById("clientesTableBody");
            tbody.innerHTML = "";
            clientes.forEach(cliente => {
                const row = `
                    <tr>
                        <td>${cliente.id}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.telefone}</td>
                        <td>
                            <button class="btn btn-warning btn-sm" onclick="editarCliente(${cliente.id}, '${cliente.nome}', '${cliente.email}', '${cliente.telefone}')">Editar</button>
                            <button class="btn btn-danger btn-sm" onclick="deletarCliente(${cliente.id})">Excluir</button>
                        </td>
                    </tr>`;
                tbody.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao listar clientes:", error));
}

// 🔹 Função para salvar (criar ou editar) um cliente
document.getElementById("clienteForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const id = document.getElementById("clienteId").value;
    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const telefone = document.getElementById("telefone").value;

    const cliente = { nome, email, telefone };

    if (id) {
        // Atualizar cliente existente
        fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(cliente)
        }).then(() => listarClientes());
    } else {
        // Criar novo cliente
        fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(cliente)
        }).then(() => listarClientes());
    }

    // Resetar o formulário
    document.getElementById("clienteForm").reset();
    document.getElementById("clienteId").value = "";
});

// 🔹 Função para preencher os campos do formulário ao editar
function editarCliente(id, nome, email, telefone) {
    document.getElementById("clienteId").value = id;
    document.getElementById("nome").value = nome;
    document.getElementById("email").value = email;
    document.getElementById("telefone").value = telefone;
}

// 🔹 Função para excluir um cliente
function deletarCliente(id) {
    if (confirm("Tem certeza que deseja excluir este cliente?")) {
        fetch(`${API_URL}/${id}`, { method: "DELETE" })
            .then(() => listarClientes());
    }
}

// 🔹 Carregar clientes ao abrir a página
document.addEventListener("DOMContentLoaded", listarClientes);
