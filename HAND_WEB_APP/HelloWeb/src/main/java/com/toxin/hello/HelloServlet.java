package com.toxin.hello;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class HelloServlet extends GenericServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response) 
	throws IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("I'AM HELLO SERVLET");
		pw.close();
	}
}