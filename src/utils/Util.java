package utils;

import java.awt.Image;
import java.io.*;
import java.net.http.*;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import alura.models.CurrencyFinal;
import alura.models.ImageWithDescription;

public class Util {
	public static String readFileAsString(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	public ImageIcon getIcon(String path, int width, int height) {
		return new ImageIcon(new ImageIcon(getClass()
				.getResource(path))
				.getImage()
				.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
	
	public static ArrayList<ImageWithDescription> GetImageWithDescription(){
		ArrayList<ImageWithDescription> imagesWithDescriptions = new ArrayList<>();
		
		
		return imagesWithDescriptions;
	}
	
	public static ArrayList<ImageWithDescription> GetImagesWithDescriptions() {

		// Obtener las monedas soportadas
		Exchange exchange = new Exchange();
		var currencies = exchange.GetCurrencies();
		ArrayList<ImageWithDescription> imagesWithDescriptions = new ArrayList<ImageWithDescription>();
		
		// Dar forma a la lista que contenga la descripciion de la moneda y la url de la
		// bandera
		
		//Collections.sort(currencies);
		
		for (CurrencyFinal c : currencies) {
			ImageWithDescription iwd = new ImageWithDescription(c.getCurrencyCode()+ " - " + c.getCurrencyName(), c.getPathImage());
			imagesWithDescriptions.add(iwd);
		}

		return imagesWithDescriptions;
	}
	
	/*
	 * public static String GetImageFromUrlToBase64(String imageUrl) { URL url; try
	 * { url = new URL(imageUrl); } catch (MalformedURLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * BufferedInputStream bis; try { bis = new
	 * BufferedInputStream(url.openConnection().getInputStream()); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * String result; try { result =
	 * Base64.getUrlEncoder().encodeToString(bis.readAllBytes()); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return result;
	 * 
	 * }
	 */
	
	/*
	 * public Static String Decode(String StringBase64){ byte[] actualByte =
	 * Base64.getUrlDecoder() }
	 */
	
	public static void downloadFile(String url, String fileName){
		
		HttpClient client = HttpClient.newBuilder().followRedirects(Redirect.ALWAYS).build();

		URI uri = URI.create(url);
		
		HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

		// use the client to send the asynchronous request
		/*
		 * var response = client.send(request, BodyHandlers.ofInputStream());
		 * response.thenApply()
		 */
		
		InputStream is = client.sendAsync(request, BodyHandlers.ofInputStream())
				.thenApply(HttpResponse::body).join();

		try (FileOutputStream out = new FileOutputStream(fileName)) {
		    is.transferTo(out);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * for(Currency currency : currencies) { Util.downloadFile(currency.getIcon(),
		 * "/home/jzn007/Icons/" + currency.getCurrencyCode() + ".png"); }
		 */
}
