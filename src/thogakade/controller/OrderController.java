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
import thogakade.model.Orders;
import thogakade.model.OrderDetail;

/**
 *
 * @author pc
 */
public class OrderController {

    public static boolean addorderDetail(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
      
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Insert into orderdetail Values(?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, orderDetail.getOrderId());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getQty());
        stm.setObject(4, orderDetail.getUnitPrice());
        return stm.executeUpdate() > 0;
    }
     public static boolean addorder(Orders order) throws SQLException, ClassNotFoundException {
       
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Insert into orders Values(?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, order.getOrdeId());
        stm.setObject(2, order.getDate());
        stm.setObject(3, order.getCustomerId());
       
        return stm.executeUpdate() > 0;
    }

    public static ArrayList<Orders> getAllOrders() throws ClassNotFoundException, SQLException {
      
        Connection connection = DBConnection.getInstance().getConnection();
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
