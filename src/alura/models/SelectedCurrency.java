package alura.models;

import java.util.*;

public class SelectedCurrency {
	private String date;
	private String base;
	private TreeMap<String, String> rates;
	
	public ArrayList<Currency> getRate() {
		Set<String> keys = rates.keySet();
		for(String key : keys) {
			System.out.println(key + " " + rates.get(key));
		}
		
		return null;
	}
	
	public TreeMap<String, String> getRates() {
		return rates;
	}
	public void setRates(TreeMap<String, String> rates) {
		this.rates = rates;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	
	
	
}


