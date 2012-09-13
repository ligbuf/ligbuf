package com.example.gson;

import com.google.gson.Gson;


public class NewGson {
	
	private Class<?> name = null;
	private Gson gson = new Gson();

	public String toJson(Object obj){
		
		return gson.toJson(obj);
	}
	
	public Object fromJson(String json,String className){
		
		try {
			name = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gson.fromJson(json, name);
	}
}
