package com.example.lab5t2.DB;



import com.mysql.cj.jdbc.MysqlDataSource;

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
        public static List<Employees> SelectOnNameQuery(String name){
                String query = "SELECT * FROM employees WHERE name LIKE \"%" + name + "%\"";
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
                String query = "INSERT INTO employees (name, manager, pay, num_razdel, name_razdel, city, razryad) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = null;
                try {
                        Connection connection = getConnection();
                        preparedStatement = connection.prepareStatement(query);//заполняем values, это сделано для большей надёжности
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, manager);
                        preparedStatement.setInt(3, pay);
                        preparedStatement.setInt(4, numRazd);
                        preparedStatement.setString(5, nameRazd);
                        preparedStatement.setString(6, city);
                        preparedStatement.setInt(7, razryad);
                        preparedStatement.executeUpdate();

                        preparedStatement.close();
                        connection.close();

                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
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
                Connection connection = getConnection();
                Statement statement = null;
                List<Employees> employeesList = new ArrayList<>();
                try {
                        if (connection != null) {
                                statement = connection.createStatement();
                        }
                        ResultSet resultSet = null;
                        if (statement != null) {
                                resultSet = statement.executeQuery(query);
                        }
                        if (resultSet != null) {
                                while (resultSet.next()) {
                                        Employees employee = new Employees();
                                        employee.setNum(resultSet.getInt("id"));
                                        employee.setNameE(resultSet.getString("name"));
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
                PreparedStatement preparedStatement = null;
                try {
                        Connection connection = getConnection();
                        preparedStatement = connection.prepareStatement(query);//заполняем values, это сделано для большей надёжности

                        preparedStatement.executeUpdate();

                        preparedStatement.close();
                        connection.close();

                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
        public static Connection getConnection() {
                try {
                        MysqlDataSource dataSource = new MysqlDataSource();

                        dataSource.setServerName("localhost");
                        dataSource.setPortNumber(3306);
                        dataSource.setDatabaseName("dblab4");
                        dataSource.setUser("root");
                        dataSource.setPassword("646464");
                        dataSource.setAutoReconnect(true);
                        dataSource.setUseSSL(false);

                        return dataSource.getConnection();
                } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                }
        }
}
