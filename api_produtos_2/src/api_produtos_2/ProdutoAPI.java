package api_produtos_2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import entities.Produto;

public class ProdutoAPI {
	 private static final int PORT = 8080;
	    private static Map<Long, Produto> produtos = new HashMap<>();
	    private static Long proximoId = 2L;

	    public static void main(String[] args) throws Exception {
	        produtos.put(1L, new Produto(1L, "produto 1"));
	        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
	        server.createContext("/produtos", new ProdutoHandler());
	        server.setExecutor(null);
	        server.start();
	        System.out.println("Servidor iniciado na porta " + PORT);
	    }

	    static class ProdutoHandler implements HttpHandler {
	        @Override
	        public void handle(HttpExchange exchange) throws IOException {
	            String requestMethod = exchange.getRequestMethod();
	            String path = exchange.getRequestURI().getPath();
	            String[] pathParts = path.split("/");
	            if (pathParts.length == 3 && "produtos".equals(pathParts[1])) {
	                Long id = Long.parseLong(pathParts[2]);
	                if ("GET".equals(requestMethod)) {
	                    handleGetProduto(exchange, id);
	                } else if ("DELETE".equals(requestMethod)) {
	                    handleDeleteProduto(exchange, id);
	                } else {
	                    handleBadRequest(exchange, "Método não suportado: " + requestMethod);
	                }
	            } else if ("GET".equals(requestMethod)) {
	                handleGetProdutos(exchange);
	            } else if ("POST".equals(requestMethod)) {
	                handlePostProduto(exchange);
	            } else {
	                handleBadRequest(exchange, "Requisição inválida: " + requestMethod + " " + path);
	            }
	        }

	        private void handleGetProduto(HttpExchange exchange, Long id) throws IOException {
	            Produto produto = produtos.get(id);
	            if (produtos == null) {
	                handleNotFound(exchange, "Produto não encontrado com o ID: " + id);
	            } else {
	                sendResponse(exchange, produto.toJson());
	            }
	        }

	        private void handleDeleteProduto(HttpExchange exchange, Long id) throws IOException {
	            Produto produto = produtos.remove(id);
	            if (produto == null) {
	                handleNotFound(exchange, "Produto não encontrado com o ID: " + id);
	            } else {
	                sendResponse(exchange, "Produto excluído com sucesso");
	            }
	        }

	        private void handleNotFound(HttpExchange exchange, String message) throws IOException {
	            exchange.sendResponseHeaders(404, message.length());
	            OutputStream os = exchange.getResponseBody();
	            os.write(message.getBytes());
	            os.close();
	        }

	        private void handleGetProdutos(HttpExchange exchange) throws IOException {
	            StringBuilder response = new StringBuilder();
	            response.append("[");
	            for (Produto produto : produtos.values()) {
	                response.append(produto.toJson());
	                response.append(",");
	            }
	            if (produtos.size() > 0) {
	                response.deleteCharAt(response.length() - 1);
	            }
	            response.append("]");
	            sendResponse(exchange, response.toString());
	        }

	        private void handlePostProduto(HttpExchange exchange) throws IOException {
	            String requestBody = new String(exchange.getRequestBody().readAllBytes());
	            Produto produto = Produto.fromJson(requestBody);
	            produto.setId(proximoId++);
	            produtos.put(produto.getId(), produto);
	            sendResponse(exchange, produto.toJson());
	        }

	        private void handleBadRequest(HttpExchange exchange, String message) throws IOException {
	            exchange.sendResponseHeaders(400, message.length());
	            OutputStream os = exchange.getResponseBody();
	            os.write(message.getBytes());
	            os.close();
	        }

	        private void sendResponse(HttpExchange exchange, String response) throws IOException {
	            exchange.sendResponseHeaders(200, response.getBytes().length);
	            OutputStream os = exchange.getResponseBody();
	            os.write(response.getBytes());
	            os.close();
	        }
	    }
}
