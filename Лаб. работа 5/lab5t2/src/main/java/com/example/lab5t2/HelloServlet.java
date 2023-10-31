package com.example.lab5t2;

import java.io.*;
import java.util.List;

import com.example.lab5t2.DB.DBconnection;
import com.example.lab5t2.DB.Employees;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Here");
        List<Employees> employees = DBconnection.SelectAllQuery();

        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("table.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}