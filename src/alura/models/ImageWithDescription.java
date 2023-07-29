package alura.models;

public class ImageWithDescription {
	
	private String _urlImage;
	private String _description;
	
	public ImageWithDescription(String description, String urlImage) {
		_urlImage = urlImage;
		_description = description;
	}
	
	public String get_urlImage() {
		return _urlImage;
	}

	public void set_urlImage(String _urlImage) {
		this._urlImage = _urlImage;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

	
	
	
}
