package interfaces;

public interface IJsonToJava<T> {
	T GetJsonToObject(String json, Class<T> type);	
}
