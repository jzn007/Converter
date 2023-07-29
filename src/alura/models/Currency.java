package alura.models;


import java.util.Date;

public class Currency implements Comparable<Currency> {
	public String currencyCode;
	private String currencyName;
	private String countryCode;
	private String countryName;
	private String status;
	private Date availableFrom;
	private Date availableUntil;
	private String icon;
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAvailableFrom() {
		return availableFrom;
	}
	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}
	public Date getAvailableUntil() {
		return availableUntil;
	}
	public void setAvailableUntil(Date availableUntil) {
		this.availableUntil = availableUntil;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public int compareTo(Currency c) {
		// TODO Auto-generated method stub
		return this.getCurrencyCode().compareTo(c.currencyCode);
	}
	
	
}
