package alura.models;

public class ApiLayerResponse {
	private boolean success;
	private ApiLayerQuery query;
	private String result;
	private ApiLayerInfo info;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ApiLayerQuery getQuery() {
		return query;
	}

	public void setQuery(ApiLayerQuery query) {
		this.query = query;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ApiLayerInfo getInfo() {
		return info;
	}

	public void setInfo(ApiLayerInfo info) {
		this.info = info;
	}
	
	
}
