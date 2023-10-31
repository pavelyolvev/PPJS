package com.example.lab4.DB;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DBconnection {
        static String dbIP = "localhost";
        static String dbPort = "3306";
        static String dbName = "dblab4";
        static String dbUsername = "root";
        static String dbPassword = "646464";

        static public String getDbIP() {
                return dbIP;
        }

        static public String getDbName() {
                return dbName;
        }

        static public String getDbPassword() {
                return dbPassword;
        }

        static public String getDbPort() {
                return dbPort;
        }

        static public String getDbUsername() {
                return dbUsername;
        }

        public static List<Employees> SelectOnNumQuery(int num){
                String query = "SELECT * FROM employees WHERE id = " + num;
                try {
                        return executeQuery(query);
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
        public static void DeleteOnNumQuery(int num){ //удаляет и выполняет select all
                String query = "DELETE FROM employees WHERE id="+num;
                prepQuery(query);
        }
        public static void InsertQuery(String name, String manager, int pay, int numRazd, String nameRazd, String city, int razryad){
                //добавить проверку на пустые значения тут или в InsertController
                String query = "INSERT INTO employees (name, manager, pay, num_razdel, name_razdel, city, razryad) " +
                        "VALUES ('" + name +
                        "', '" + manager +
                        "', '" + pay +
                        "', '" + numRazd +
                        "', '" + nameRazd +
                        "', '" + city +
                        "', '" + razryad +
                        "')";
                prepQuery(query);
        }
        public static List<Employees> SelectAllQuery(){
                String query = "SELECT * FROM employees";
                try {
                        return executeQuery(query);
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }


        static List<Employees> executeQuery(String query) throws SQLException {
                String connectQuery = "jdbc:mysql://" + dbIP + ":" + dbPort + "/" + dbName + "?autoReconnect=true&useSSL=false";
                Connection connection = null;
                Statement statement = null;
                List<Employees> employeesList = new ArrayList<>();
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                        System.out.println("ошибка при загрузке драйвера");
                        throw new RuntimeException(e);
                }
                try {
                        connection = DriverManager.getConnection(connectQuery, dbUsername, dbPassword);
                } catch (SQLException e) {
                        return null;
                        //throw new RuntimeException(e);
                }
                try {
                        statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);
                        if (resultSet != null) {
                                while (resultSet.next()) {
                                        Employees employee = new Employees();
                                        employee.setNum(resultSet.getInt("id"));
                                        employee.setName(resultSet.getString("name"));
                                        employee.setManager(resultSet.getString("manager"));
                                        employee.setPay(resultSet.getInt("pay"));
                                        employee.setNumrazd(resultSet.getInt("num_razdel"));
                                        employee.setNamerazd(resultSet.getString("name_razdel"));
                                        employee.setCity(resultSet.getString("city"));
                                        employee.setRazryad(resultSet.getInt("razryad"));
                                        employeesList.add(employee);
                                }
                        }
                } catch (SQLException e) {
                        return null;
                } finally {
                        if (statement != null){
                                statement.close();
                        }
                        if (connection !=null){
                                connection.close();
                        }
                }
                return employeesList;
        }
        static void prepQuery(String query){
                String connectQuery = "jdbc:mysql://" + dbIP + ":" + dbPort + "/" + dbName + "?autoReconnect=true&useSSL=false";
                Connection connection = null;
                PreparedStatement preparedStatement = null;

                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                }

                try {
                        connection = DriverManager.getConnection(connectQuery, dbUsername, dbPassword);
                        preparedStatement = connection.prepareStatement(query);//заполняем values, это сделано для большей надёжности

                        preparedStatement.executeUpdate();

                        preparedStatement.close();
                        connection.close();

                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
}
