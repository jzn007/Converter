package alura.models;

import java.util.Map;

public class CurrencyApiLayer {
    private Map<String, String> currencies;
    private boolean success;

    public Map<String, String> getCurrencies() { return currencies; }
    public void setCurrencies(Map<String, String> value) { this.currencies = value; }

    public boolean getSuccess() { return success; }
    public void setSuccess(boolean value) { this.success = value; }
}