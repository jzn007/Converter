package utils;

import java.lang.reflect.Type;
//import java.util.ArrayList;
import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

//public class GsonWrapper<T> implements IJsonToJava<T> 

public class GsonWrapper<T> {
	
	public T FromArrayList(String json, Type type) {
		T result = null;
		
		try {
			// Devolvera el Json a un objeto con la estructura de Java
			result = new Gson().fromJson(json, type);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	public T fromNestedItems(String json, Class<T> cls) {	
		T result = null;
		
		try {
			// Devolvera el Json a un objeto con la estructura de Java
			result = new Gson().fromJson(json, cls);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
}
