package controller;

import dao.ClienteDAO;
import model.Cliente;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
    private ClienteDAO clienteDAO = new ClienteDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");

            Cliente cliente = new Cliente(0, nome, email, telefone);
            clienteDAO.adicionarCliente(cliente);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");

            Cliente cliente = new Cliente(id, nome, email, telefone);
            clienteDAO.atualizarCliente(cliente);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            clienteDAO.deletarCliente(id);
        }

        response.sendRedirect("clientes.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = clienteDAO.listarClientes();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }
}
