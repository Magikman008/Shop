package com.company;

import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //String name = scan.nextLine();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int resultInt;
        String url = "jdbc:mysql://195.19.44.146:3306/user21?serverTimezone=UTC";
        Date date = new Date();
        SimpleDateFormat DateNow = new SimpleDateFormat("yyyy-MM-dd");
        Random random = new Random();
        int employee = random.nextInt(5 - 3) + 3;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,"user21","user21");
            //System.out.println("Connected...");
            statement = connection.createStatement();


            resultSet = statement.executeQuery("SELECT * FROM Good");
            System.out.println("В магазине доступно:");
            System.out.println();
            int i = 1;
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " (" + i + ")");
                i++;
            }
            System.out.println();
            System.out.println("Выберите товар");
            int good = scan.nextInt();
            System.out.println();

            resultSet = statement.executeQuery("SELECT * FROM Payment");
            i = 1;
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " (" + i + ")");
                i++;
            }
            System.out.println();
            System.out.println("Выберите способ оплаты:");
            int payment = scan.nextInt();
            System.out.println();

            resultSet = statement.executeQuery("SELECT * FROM Getting");
            i = 1;
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " (" + i + ")");
                i++;
            }
            System.out.println();
            System.out.println("Выберите способ доставки:");
            int getting = scan.nextInt();
            System.out.println();

            resultSet = statement.executeQuery("SELECT * FROM Point");
            i = 1;
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " (" + resultSet.getString("city") + " " + resultSet.getString("street") + ") " + "(" + i + ")");
                i++;
            }
            System.out.println();
            System.out.println("Выберите место доставки:");
            int point = scan.nextInt();
            System.out.println();
            resultInt = statement.executeUpdate("INSERT INTO Orders (dute, status, payment, getting, good, employee, point) VALUES ('"+ DateNow.format(date) + "'," + "1," + payment + "," + getting + "," + good + "," + employee + "," + point + ");");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
