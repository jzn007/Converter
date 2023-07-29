/*
 * package alura;
 * 
 * import java.io.IOException;
 * 
 * import com.squareup.moshi.JsonAdapter; import com.squareup.moshi.Moshi;
 * import com.squareup.moshi.Types;
 * 
 * import java.lang.reflect.Type; import java.net.URI; import
 * java.net.URISyntaxException; import java.net.http.HttpClient; import
 * java.net.http.HttpRequest; import java.net.http.HttpResponse; import
 * java.net.http.HttpResponse.BodyHandlers;
 * 
 * import okhttp3.OkHttpClient; import okhttp3.Request; import okhttp3.Response;
 * import java.util.List; import java.util.ArrayList; import java.util.Iterator;
 * 
 * 
 * public class apiRateClient { private final static Moshi moshi = new
 * Moshi.Builder().build(); //private final static JsonAdapter<sample>
 * sampleJsonAdapter = moshi.adapter(List.class, sample.class);
 * 
 * public static List<sample> samples = new ArrayList<sample>();
 * 
 * public static void GetRate() {
 * //https://currencyfreaks.com/documentation.html#Conversion Get Currency Rates
 * By Changing Base Currency You can change the base currency of any provided
 * endpoint by passing the value of query parameter "base". It can be any
 * currency code which you want to use as a base currency.
 * 
 * This feature is available on all paid subscription plans only.
 * 
 * Here is a curl example to get rates of specific currency codes by EUR as a
 * base currency:
 * 
 * $ curl
 * 'https://api.currencyfreaks.com/v2.0/rates/latest?apikey=YOUR_APIKEY&symbols=
 * PKR,GBP,EUR,INR&base=EUR'
 * 
 * { "date": "2023-03-21 13:29:00+00", "base": "EUR", "rates": { "EUR": "1.0",
 * "GBP": "0.8810222794437683", "PKR": "303.60317616075287", "USD":
 * "1.0780547579946744" } }
 * //https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp/4.10.0
 * OkHttpClient client = new OkHttpClient().newBuilder().build(); //.url(
 * "https://api.currencyfreaks.com/v2.0/convert/latest?from=usd&to=pkr&amount=500&apikey=YOUR_APIKEY")
 * Request request = new Request.Builder()
 * .url("https://jsonplaceholder.typicode.com/posts") .get().build(); try {
 * Response response = client.newCall(request).execute(); Type type =
 * Types.newParameterizedType(List.class, sample.class);
 * JsonAdapter<List<sample>> samplesJsonAdapter = moshi.adapter(type);
 * List<sample> samples = samplesJsonAdapter.fromJson(response.body().source());
 * //List<sample> samples =
 * samplesJsonAdapter.fromJson(response.body().source()); for (sample sample :
 * samples) { System.out.println("User ID: " + sample.userId + ", " + " Id: " +
 * sample.id + ", Title: " + sample.title + ", Body: " + sample.body);
 * System.out.println(); }
 * 
 * } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } // .newCall(request).execute(); }
 * 
 * public static void GetHttpClient() { try { var request =
 * HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/posts"))
 * .GET() .build();
 * 
 * HttpClient client = HttpClient.newHttpClient(); String ss = "";
 * client.send(request, BodyHandlers.ofString()); ss= response.`
 * 
 * 
 * 
 * 
 * Async(request, BodyHandlers.ofString()) .thenApply(HttpResponse::body)
 * .thenAccept(HttpResponse::body) .join();
 * 
 * System.out.println(client);
 * 
 * 
 * 
 * 
 * } catch (URISyntaxException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * 
 * }
 * 
 * public void GetFlags() { //$ curl
 * 'https://api.currencyfreaks.com/v2.0/supported-currencies' Supported
 * Currencies This endpoint returns the complete information of all supported
 * currencies by CurrencyFreaks APi such as currency code, currency full name,
 * currency icon. country code & country name. It doesn't require an apikey.
 * Note: If currency type is crypto and metal, its countryCode value will be
 * "Crypto" and "Metal", respectively, and countryName value will be "Global".
 * This endpoint is accessible on all subscription plans The URL for this
 * endpoint is https://api.currencyfreaks.com/v2.0/supported-currencies and its
 * curl example with JSON response is below:
 * 
 * 
 * { "supportedCurrenciesMap": { "PKR": { "currencyCode": "PKR", "currencyName":
 * "Pakistan Rupee", "countryCode": "PK", "countryName": "Pakistan", "status":
 * "AVAILABLE", "availableFrom": "1985-10-02", "availableUntil":
 * "{CURRENT_DATE}", "icon": "https://currencyfreaks.com/photos/flags/pkr.png" }
 * } }
 * 
 * }
 * 
 * 
 * }
 */