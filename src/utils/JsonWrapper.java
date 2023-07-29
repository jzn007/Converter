package utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class JsonWrapper {

	public String GetFromAPI(String url) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		HttpResponse<String> response = null;
		String json = "";

		try {
			response = client.send(request, BodyHandlers.ofString());
			json = response.body().toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
	
	public String GetFromAPI(String url, String headerKey, String headerValue) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header(headerKey, headerValue)
				.GET().build();
		HttpResponse<String> response = null;
		String json = "";

		try {
			response = client.send(request, BodyHandlers.ofString());
			json = response.body().toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
	
	
	
	public String GetFromFile(String pathToFile) {
		String json = "";
		try {
			json = Util.readFileAsString(pathToFile);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}	
}
