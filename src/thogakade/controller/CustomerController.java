/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import thogakade.db.DBConnection;
import thogakade.model.Customer;

/**
 *
 * @author pc
 */
public class CustomerController {

    public static boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
      
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Insert into Customer Values(?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getSalary());
        return stm.executeUpdate() > 0;
    }

    public static boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
      
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Update Customer set name=?, address=?, salary=? where id=?";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getSalary());
        stm.setObject(4, customer.getId());
        return stm.executeUpdate() > 0;
    }

    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {
       
        Connection connection = DBConnection.getInstance().getConnection();
         String SQL = "Select * From Customer where id='" + id + "'";
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
        }
        return null;
    }
    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException{
      

        String SQL = "Delete From Customer where id='"+id+"'";  //?
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL)>0;
    }
    public static ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
      
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Select * From Customer";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList <Customer>customerList=new ArrayList<>();
        while(rst.next()) {
            customerList.add(new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary")));
        }
        return customerList;
    }    
}
