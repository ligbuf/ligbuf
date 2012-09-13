package com.example.androidclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.ParseException;
import android.util.Log;

public class JSONParser { 
	 
	
    public static String doGetWithResponse(String serverUrl, DefaultHttpClient httpClient) {

        String ret = null;

        HttpResponse response = null;

 

        HttpGet getMethod = new HttpGet(serverUrl);

        try {

            response = httpClient.execute(getMethod);

            Log.i(LOG_TAG, "STATUS CODE: " + String.valueOf(response.getStatusLine().getStatusCode()));

            if (null != response) {

                // HELPER METHOD TO CONVERT HTTP RESPONSE TO STRING

                ret = getResponseBody(response);

            }

        } catch (Exception e) {

            Log.e("Exception", e.getMessage());

        } finally {

        }

        return ret;

    }

 
    public static String getResponseBody(HttpResponse response) {
    	
    	        String response_text = null;
    	
    	        HttpEntity entity = null;
    	
    	 
    	
    	        try {
    	
    	            entity = response.getEntity();
    	
    	            response_text = _getResponseBody(entity);
    	
    	        } catch (ParseException e) {
    	
    	            e.printStackTrace();
    	
    	        } catch (IOException e) {
    	
    	            if (entity != null) {
    	
    	                try {
    	
    	                    entity.consumeContent();
    	
    	                } catch (IOException e1) {
    	
    	                     // ERROR
    	
    	                }
    	
    	            }
    	
    	        }
    	
    	        return response_text;
    	
    	    }


	        
}