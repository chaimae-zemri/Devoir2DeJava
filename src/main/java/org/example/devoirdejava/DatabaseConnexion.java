package org.example.devoirdejava;


import java.sql.*;



public class DatabaseConnexion {
    private Connection connection;


    public DatabaseConnexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:8888/ordersdatabase", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean selectfromdb(int id) {
        String query = "select * from customer where id = " + id;
        try {
            ResultSet result = connection.createStatement().executeQuery(query);
            if(result.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void insert2order(int id ,Date date, double amount, int custid, String status) {
        String query = "insert into orders(id,date,amount,customer_id,status) values (?, ?, ?, ?, ?)";

        try(PreparedStatement statement= connection.prepareStatement(query)){
            statement.setInt(1, id);
            statement.setDate(2, date);
            statement.setDouble(3, amount);
            statement.setInt(4, custid);
            statement.setString(5, status);
            int result =statement.executeUpdate();
            if(result >0){
                System.out.println("Insertion has been successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }







}
