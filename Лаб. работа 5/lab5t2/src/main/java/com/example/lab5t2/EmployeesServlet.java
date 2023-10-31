package com.example.lab5t2;

import com.example.lab5t2.DB.DBconnection;
import com.example.lab5t2.DB.Employees;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/getEmployees")
public class EmployeesServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(EmployeesServlet.class.getName());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, UnsupportedEncodingException {
        String operation = request.getParameter("operation");

        request.setCharacterEncoding("UTF-8");
        List<Employees> employees = new ArrayList<>();
        String num;
        switch (operation){
            case "SelectAll":
                employees = DBconnection.SelectAllQuery();
                break;
            case "DeleteOnNumQuery":
                num = request.getParameter("num");
                DBconnection.DeleteOnNumQuery(Integer.parseInt(num));
                employees = DBconnection.SelectAllQuery();
                break;
            case "SelectOnNum":
                num = request.getParameter("num");
                employees = DBconnection.SelectOnNumQuery(Integer.parseInt(num));
                break;
            case "AddEmployee":
                String nameEmpl = getUTFString(request.getParameter("name"));
                String manager = getUTFString(request.getParameter("manager"));
                int pay = Integer.parseInt(request.getParameter("pay"));
                int numrazd = Integer.parseInt(request.getParameter("numrazd"));
                String namerazd = getUTFString(request.getParameter("namerazd"));
                String city = getUTFString(request.getParameter("city"));
                int razryad = Integer.parseInt(request.getParameter("razryad"));
                DBconnection.InsertQuery(nameEmpl,manager, pay, numrazd, namerazd, city, razryad);

                break;
            case "SelectOnName":
                String name = getUTFString(request.getParameter("name"));
                employees = DBconnection.SelectOnNameQuery(name);
                //Сделать запрос по имени
            default:
                logger.info("------------------------------------------------------------------------UNCORRECT QUERY");
                break;
        }
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Преобразуем список в JSON и отправляем его клиенту
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employees);

        try {
            PrintWriter out = response.getWriter();
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    String getUTFString(String str){
        return new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
