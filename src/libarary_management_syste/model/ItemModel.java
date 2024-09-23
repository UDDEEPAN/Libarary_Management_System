/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.model;

import java.sql.Connection;
import libarary_management_syste.db.DbConnection;
import libarary_management_syste.dto.ItemDto;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class ItemModel {

    private final Connection connection;

    public ItemModel() throws Exception {
        connection = DbConnection.getInstance().getConnection();
    }

    public String saveItem(ItemDto itemdto) throws SQLException {
        String sql = "INSERT INTO item VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, itemdto.getItemId());
        statement.setString(2, itemdto.getItemName());
        statement.setString(3, itemdto.getAvilibilty());

        if (statement.executeUpdate() > 0) {
            return "Item Save Succesfully";
        } else {
            return "Item Save Error";
        }

    }

    public ArrayList<ItemDto> getAllItem() throws Exception {
        String sql = "SELECT*FROM item";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();
        ArrayList<ItemDto> itemdtos = new ArrayList();
        while (rst.next()) {
            ItemDto itemdto = new ItemDto();
            itemdto.setItemId(rst.getInt("itemid"));
            itemdto.setItemName(rst.getString("name"));
            itemdto.setAvilibilty(rst.getString("avilability"));
            itemdtos.add(itemdto);
        }
        return itemdtos;

    }

    public ItemDto serchItem(Integer ItemId) throws Exception {
        String sql = "SELECT*FROM item WHERE itemid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ItemId);
        ResultSet rst = statement.executeQuery();

        while (rst.next()) {
            ItemDto dto = new ItemDto();
            dto.setItemId(rst.getInt("itemid"));
            dto.setItemName(rst.getString("name"));
            dto.setAvilibilty(rst.getString("avilability"));

            return dto;
        }
        return null;
    }

   public String updateItem(ItemDto itemdto) throws Exception {
    String sql = "UPDATE item SET name = ?, avilability = ? WHERE itemid = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        // Bind parameters in the correct order
        statement.setString(1, itemdto.getItemName());
        statement.setString(2, itemdto.getAvilibilty());
        statement.setInt(3, itemdto.getItemId());

        // Execute update and check the result
        if (statement.executeUpdate() > 0) {
            return "Item Successfully Updated";
        } else {
            return "Item Update Error";
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new Exception("Database error occurred", e);
    }
}


    public String deleteItem(Integer itemId) throws Exception {
        String sql = "DELETE FROM item WHERE itemid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, itemId);

            if (statement.executeUpdate() > 0) {
                return "Item Successfully Deleted";
            } else {
                return "Item Delete Error";
            }
        } catch (Exception e) {
            throw new Exception("Database error occurred", e.getCause());
        }
    }

}
