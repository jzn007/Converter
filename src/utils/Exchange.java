package utils;

import alura.models.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.reflect.TypeToken;

public class Exchange {
	
	public ArrayList<CurrencyFinal> GetCurrencies(){
		//First Get the json string, depending of the source, use the correct method
		JsonWrapper jw = new JsonWrapper();
		String pathToFile = "/home/jzn007/Currencies.json";
		String json = jw.GetFromFile(pathToFile);
		
		GsonWrapper<ArrayList<CurrencyFinal>> gw = new GsonWrapper<ArrayList<CurrencyFinal>>();
		Type collectionType = new TypeToken<List<CurrencyFinal>>(){}.getType();
		ArrayList<CurrencyFinal> currencies = gw.FromArrayList(json, collectionType);
		
		/*
		 * String pathToApiLayers = "/home/jzn007/CurrenciesApiLayer.json"; String
		 * jsonCurrencyApiLayers;
		 * 
		 * jsonCurrencyApiLayers = jw.GetFromFile(pathToApiLayers);
		 * 
		 * GsonWrapper<CurrencyApiLayer> gwa = new GsonWrapper<CurrencyApiLayer>();
		 * CurrencyApiLayer cal = gwa.fromNestedItems(jsonCurrencyApiLayers,
		 * CurrencyApiLayer.class);
		 * 
		 * List<CurrencySymbol> currencySymbols = new ArrayList<>(); List<CurrencyFinal>
		 * lcf = new ArrayList<CurrencyFinal>(); ArrayList<Rate> rates = new
		 * ArrayList<>(); for (Map.Entry<String, String> entry :
		 * cal.getCurrencies().entrySet()) { Rate r = new Rate();
		 * r.setCode(entry.getKey()); r.setValue(entry.getValue()); rates.add(r); }
		 * 
		 * for(Currency c : currencies) { for(Rate r : rates) {
		 * if(c.currencyCode.equals(r.Code)) { CurrencyFinal cf = new CurrencyFinal();
		 * cf.setCurrencyCode(c.currencyCode); cf.setCurrencyName(c.getCurrencyName());
		 * cf.setCountryCode(c.getCountryCode()); cf.setCountryName(c.getCountryName());
		 * cf.setUrlImage(c.getIcon()); cf.setPathImage("/home/jzn007/Images/"+
		 * c.getCurrencyCode()+".png"); lcf.add(cf); } } }
		 * 
		 * String path = "/home/jzn007/Currencies2.json"; try { PrintWriter out = new
		 * PrintWriter(new FileWriter(path)); Gson gson = new Gson(); String jsonFinal =
		 * gson.toJson(lcf); out.write(jsonFinal); out.close(); } catch (Exception e) {
		 * // TODO: handle exception e.printStackTrace(); }
		 */
		
		return currencies; 
	}
	
	public CurrencySymbolSupported GetItem(){
		JsonWrapper jw = new JsonWrapper();
		String url = "https://api.currencyfreaks.com/v2.0/currency-symbols";
		String json = jw.GetFromAPI(url);
		
		GsonWrapper<CurrencySymbolSupported> gw = new GsonWrapper<CurrencySymbolSupported>();
		
		//Type collectionType = new TypeToken<List<Currency>>(){}.getType();
		CurrencySymbolSupported css = gw.fromNestedItems(json, CurrencySymbolSupported.class);	
		List<CurrencySymbol> currencySymbols = new ArrayList<>();
		 		  
		for (Map.Entry<String, String> entry : css.currencySymbols.entrySet()) {
			CurrencySymbol cs = new CurrencySymbol();
			cs.setSymbolId(entry.getKey());
			cs.setSymbolName(entry.getValue());
			currencySymbols.add(cs);
		}
		  
		return css; 
	}
	
	
	public ApiLayerResponse Convert(String codeCurrencyFrom, String codeCurrencyTo, String amount) {
		//First Get the json string, depending of the source, use the correct method
		JsonWrapper jw = new JsonWrapper();
		String urlApi = "https://api.apilayer.com/currency_data/";
		String pathToApiFile = "/home/jzn007/apikey.json";
		
		String apiKey = GetApiKey(pathToApiFile);
		urlApi += "convert?to=" + codeCurrencyTo + "&from=" +  codeCurrencyFrom + "&amount=" + amount;
		System.out.println(urlApi);
		
		String json = jw.GetFromAPI(urlApi, "apikey", apiKey);
		System.out.println(json);
		//Type collectionType = new TypeToken<List<Currency>>(){}.getType();		
		GsonWrapper<ApiLayerResponse> gw = new GsonWrapper<ApiLayerResponse>();
		ApiLayerResponse alr = gw.fromNestedItems(json, ApiLayerResponse.class);
		var result = alr.getResult();
		System.out.println(result);
		
		
		return alr;
	}

	
	public String GetApiKey(String pathToFile) {
		JsonWrapper jw = new JsonWrapper();
		String json = jw.GetFromFile(pathToFile);
		GsonWrapper<ApiInfo> gw = new GsonWrapper<ApiInfo>();
		ApiInfo ai = gw.fromNestedItems(json, ApiInfo.class);
		return ai.getApikey();
	}
	
}

