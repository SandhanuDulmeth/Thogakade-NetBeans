/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import thogakade.model.Customer;
import thogakade.model.Orders;
import thogakade.model.OrderDetail;

/**
 *
 * @author pc
 */
public class OrderController {

    public static boolean addorderDetail(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/thogakade2", "root", "1234");
        String SQL = "Insert into orderdetail Values(?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, orderDetail.getOrderId());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getQty());
        stm.setObject(4, orderDetail.getUnitPrice());
        return stm.executeUpdate() > 0;
    }
//
//    public static boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/thogakade2", "root", "1234");
//
//        String SQL = "Update Customer set name=?, address=?, salary=? where id=?";
//        PreparedStatement stm = connection.prepareStatement(SQL);
//        stm.setObject(1, customer.getName());
//        stm.setObject(2, customer.getAddress());
//        stm.setObject(3, customer.getSalary());
//        stm.setObject(4, customer.getId());
//        return stm.executeUpdate() > 0;
//    }
//
//    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {
//        String SQL = "Select * From Customer where id='" + id + "'";
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/thogakade2", "root", "1234");
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery(SQL);
//        if (rst.next()) {
//            return new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
//        }
//        return null;
//    }
//    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException{
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/thogakade2", "root", "1234");
//
//        String SQL = "Delete From Customer where id='"+id+"'";  //?
//        Statement stm = connection.createStatement();
//        return stm.executeUpdate(SQL)>0;
//    }
    public static ArrayList<Orders> getAllOrders() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/thogakade2", "root", "1234");
        
        String SQL = "Select * From orders";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList <Orders>OrdersList=new ArrayList<>();
        while(rst.next()) {
            OrdersList.add(new Orders(rst.getString("id"), rst.getString("date"), rst.getString("CustomerId")));
        }
        return OrdersList;
    }    
}
