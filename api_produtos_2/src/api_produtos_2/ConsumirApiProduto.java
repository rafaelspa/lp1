package api_produtos_2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConsumirApiProduto {
	private static final String BASE_URL = "http://localhost:8080/produtos";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
	
		// GET /produtos
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET /produtos: " + response.body());
        
        // POST /produtos
        String requestBody = "{\"descricao\":\"Caneta esferográfica azul Vic\"}";
        request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("POST /produtos: " + response.body());
        
        // GET /produtos/{id}
        int id = 1;
        request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET /produtos/" + id + ": " + response.body());
        

        // DELETE /produtos/{id}
        request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .DELETE()
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("DELETE /produtos/" + id + ": " + response.body());
        
        // GET /produtos
        request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET /produtos: " + response.body());
	}
}
