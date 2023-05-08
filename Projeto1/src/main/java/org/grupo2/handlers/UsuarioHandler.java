package org.grupo2.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.grupo2.modelos.Biblioteca;
import org.grupo2.modelos.Cliente;

import java.io.IOException;
import java.io.OutputStream;

public class UsuarioHandler implements HttpHandler {

    private static Integer proximoId = 2;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        String[] pathParts = path.split("/");
        if (pathParts.length == 3 && "usuarios".equals(pathParts[1])) {
            Integer id = Integer.parseInt(pathParts[2]);
            if ("GET".equals(requestMethod)) {
//                handleGetUsuario(exchange, id);
                handleBadRequest(exchange, "Requisicao inválida: " + requestMethod + " " + path);
            } else if ("DELETE".equals(requestMethod)) {
//                handleDeleteUsuario(exchange, id);
                handleBadRequest(exchange, "Requisicao inválida: " + requestMethod + " " + path);
            } else if ("PUT".equals(requestMethod)) {
//                handlePutUsuario(exchange, id);
                handleBadRequest(exchange, "Requisicao inválida: " + requestMethod + " " + path);
            }
        } else if ("GET".equals(requestMethod)) {
            try {
                handleGetUsuarios(exchange);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if ("POST".equals(requestMethod)) {
//            handlePostUsuario(exchange);
            handleBadRequest(exchange, "Requisicao inválida: " + requestMethod + " " + path);
        } else {
            handleBadRequest(exchange, "Requisicao inválida: " + requestMethod + " " + path);
        }
    }

//    // CREATE
//    private void handlePostUsuario(HttpExchange exchange) throws IOException {
//        String requestBody = new String(exchange.getRequestBody().readAllBytes());
//        Cliente cliente = Cliente.fromJson(requestBody);
//        cliente.setId(proximoId);
//        proximoId++;
//        Biblioteca.getClientes().put(cliente.getId(), cliente);
//        sendResponse(exchange, cliente.toJson(), 201);
//    }

    // READ ALL
    private void handleGetUsuarios(HttpExchange exchange) throws Exception {
        sendResponse(exchange, Biblioteca.listarUsuarios().toString());
    }

//    // READ
//    private void handleGetUsuario(HttpExchange exchange, Integer id) throws IOException {
//        Cliente cliente = Biblioteca.getClientes().get(id);
//        if (cliente == null) {
//            handleNotFound(exchange, "Cliente não encontrado com o id " + id);
//        } else {
//            sendResponse(exchange, cliente.toJson());
//        }
//    }

//    // UPDATE
//    private void handlePutUsuario(HttpExchange exchange, Integer id) throws IOException {
//        Cliente cliente = Biblioteca.getClientes().get(id);
//        if (cliente == null) {
//            handleNotFound(exchange, "Cliente não encontrado com ID: " + id);
//        } else {
//            String requestBody = new String(exchange.getRequestBody().readAllBytes());
//            Cliente clienteAtualizado = Cliente.fromJson(requestBody);
//            cliente.setId(clienteAtualizado.getId());
//            cliente.setNome(clienteAtualizado.getNome());
//            cliente.setCpf(clienteAtualizado.getCpf());
//            cliente.setEndereco(clienteAtualizado.getEndereco());
//            cliente.setEmail(clienteAtualizado.getEmail());
//            cliente.setSenha(clienteAtualizado.getSenha());
//            sendResponse(exchange, cliente.toJson());
//        }
//    }

//    // DELETE
//    private void handleDeleteUsuario(HttpExchange exchange, Integer id) throws IOException {
//        Cliente cliente = Biblioteca.getClientes().remove(id);
//        if (cliente == null) {
//            handleNotFound(exchange, "Cliente não encontrado com ID: " + id);
//        } else {
//            try {
//                System.out.println("DELETE /clientes/" + id + ": Cliente deletado com sucesso.");
//                sendResponse(exchange, "", 204);
//            } catch (IOException e) {
//                throw new IOException();
//            }
//        }
//    }

    private void handleNotFound(HttpExchange exchange, String s) throws IOException {
        sendResponse(exchange, s, 404);
    }

    private void handleBadRequest(HttpExchange exchange, String s) throws IOException {
        sendResponse(exchange, s, 400);
    }

    private void sendResponse(HttpExchange exchange, String response, int rCode) throws IOException {
        long headerLength = (rCode == 404 || rCode == 400) ? response.length() : response.getBytes().length;
        if (rCode == 204) {
            headerLength = -1L;
        }
        exchange.sendResponseHeaders(rCode, headerLength);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private void sendResponse(HttpExchange exchange, String response) throws IOException {
        sendResponse(exchange, response, 200);
    }
}