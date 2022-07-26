import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class Main {

	
	public static void main(String[] args) throws Exception {
		
		// fazer uma conexão HTTP e buscar os top 250 filmes
		
		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		URI endereco = URI.create(url);
		
		//pode ser usado HttpClient/HttpRequest/HttpResponse OU só "var"  nas novas versões do Java
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		String body = response.body();
	//	System.out.println(body);
		
		
		// extrair só os dados que interessam (título, imagem do filme, classificação
		
		 JsonParser parser = new JsonParser();
		 List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		
		//exibir e manipular os dados
		
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.println("\n\u001b[34m Título: " + (filme.get("title")));
			System.out.println("\n\u001b[34m Imagem: " + (filme.get("image")));
			System.out.println("\n\u001b[34m Rank: " + (filme.get("rank")));
		}
		
		

	}

}
