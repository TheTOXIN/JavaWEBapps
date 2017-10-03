package com.toxin.hello;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class FormServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String page;

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        if (code == null || name == null || price == null)
            page = "/form.html";
        else
            page = "/form.jsp";

        RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
        rd.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }
}