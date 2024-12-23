/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import thogakade.db.DBConnection;
import thogakade.model.Item;

/**
 *
 * @author pc
 */
public class ItemController {


    public static ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException {
      
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Select * From item";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList <Item>ItemsList=new ArrayList<>();
        while(rst.next()) {
            ItemsList.add(new Item(rst.getString("code"), rst.getString("description"),rst.getDouble("unitPrice"),rst.getInt("qtyOnHand")));
        }
        return ItemsList;
    }    
}
