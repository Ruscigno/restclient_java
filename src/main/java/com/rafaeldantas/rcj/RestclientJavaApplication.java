package com.rafaeldantas.rcj;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RestclientJavaApplication {
	
	private static String API_WEB = "https://jsonplaceholder.typicode.com/todos";
	private static String API_JSON = getApiJson();
	private static List<User> LISTA_USERS = getUsersJson();
	
	public static List<User> getUsersJson() {
		List<User> lista = new ArrayList<>();
		
		try {
		    Gson gson = new Gson();
		    lista = gson.fromJson(API_JSON, new TypeToken<List<User>>(){}.getType());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	public static String getApiJson() {
		String json = "";
		
		try {
		    Client c = Client.create();
		    WebResource wr = c.resource(API_WEB);
		    json = wr.get(String.class);
		}
	    catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    
		return json;
	}	

	public static void main(String[] args) {
		System.out.println(" --------------------------------- ");
		System.out.println("             API JSON              ");
		System.out.println(" --------------------------------- ");
		System.out.println(API_JSON);
		System.out.println("");
		System.out.println(" --------------------------------- ");
		System.out.println("           LISTA USERS             ");
		System.out.println(" --------------------------------- ");		
		LISTA_USERS.forEach((x)->System.out.println(x.toString()));
		System.out.println("");
	}

}
