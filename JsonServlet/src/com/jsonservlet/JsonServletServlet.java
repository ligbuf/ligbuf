package com.jsonservlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gson.NewGson;
import com.gson.Student;

@SuppressWarnings("serial")
public class JsonServletServlet extends HttpServlet {
	

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String jsonString;
		NewGson gson = new NewGson();
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("euc-kr");
		jsonString = gson.toJson(new Student());
		
		resp.getWriter().println(jsonString);
	}
	
}
