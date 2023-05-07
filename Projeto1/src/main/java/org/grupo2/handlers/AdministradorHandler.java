package org.grupo2.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

import org.grupo2.modelos.Biblioteca;
import org.grupo2.modelos.Administrador;

public class AdministradorHandler implements HttpHandler{
	  private static Integer proximoId = 2;

	    @Override
	    public void handle(HttpExchange exchange) throws IOException {
	        String requestMethod = exchange.getRequestMethod();
	        String path = exchange.getRequestURI().getPath();
	        String[] pathParts = path.split("/");
	        if (pathParts.length == 3 && "administradores".equals(pathParts[1])) {
	            Integer id = Integer.parseInt(pathParts[2]);
	            if ("GET".equals(requestMethod)) {
	                handleGetAdministrador(exchange, id);
	            } else if ("DELETE".equals(requestMethod)) {
	                handleDeleteAdministrador(exchange, id);
	            }
	        } else if ("GET".equals(requestMethod)) {
	            handleGetAdministradors(exchange);
	        } else if ("POST".equals(requestMethod)) {
	            handlePostAdministrador(exchange);
	        } else {
	            handleBadRequest(exchange, "Requisicao invalida: " + requestMethod + " " + path);
	        }
	    }

	    private void handleGetAdministradors(HttpExchange exchange) throws IOException {
	        StringBuilder response = new StringBuilder();
	        response.append("[");
	        for (Administrador administrador : Biblioteca.getAdministradores().values()) {
	            response.append(administrador.toJson());
	            response.append(",");
	        }
	        if (Biblioteca.getAdministradores().size() > 0) {
	            response.deleteCharAt(response.length() - 1);
	        }
	        response.append("]");
	        sendResponse(exchange, response.toString());
	    }

	    private void handleGetAdministrador(HttpExchange exchange, Integer id) throws IOException {
	        Administrador administrador = Biblioteca.getAdministradores().get(id);
	        if (administrador == null) {
	            handleNotFound(exchange, "Administrador não encontrado com o id " + id);
	        } else {
	            sendResponse(exchange, administrador.toJson());
	        }
	    }

	    private void handleNotFound(HttpExchange exchange, String s) throws IOException {
	        sendResponse(exchange, s, 404);
	    }

	    private void handlePostAdministrador(HttpExchange exchange) throws IOException {
	        String requestBody = new String(exchange.getRequestBody().readAllBytes());
	        Administrador administrador = Administrador.fromJson(requestBody);
	        administrador.setId(proximoId++);
	        Biblioteca.getAdministradores().put(administrador.getId(), administrador);
	        sendResponse(exchange, administrador.toJson(), 201);
	    }

	    private void handleDeleteAdministrador(HttpExchange exchange, Integer id) {
	    }

	    private void handleBadRequest(HttpExchange exchange, String s) {
	    }

	    private void sendResponse(HttpExchange exchange, String response, int rCode) throws IOException {
	        long headerLength = rCode != 404 ? response.getBytes().length : response.length();
	        exchange.sendResponseHeaders(rCode, headerLength);
	        OutputStream os = exchange.getResponseBody();
	        os.write(response.getBytes());
	        os.close();
	    }

	    private void sendResponse(HttpExchange exchange, String response) throws IOException {
	        sendResponse(exchange, response, 200);
	    }
}
