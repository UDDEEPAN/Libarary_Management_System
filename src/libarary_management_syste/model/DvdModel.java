/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import libarary_management_syste.db.DbConnection;
import libarary_management_syste.dto.BookDto;
import libarary_management_syste.dto.DvdDto;

/**
 *
 * @author LENOVO
 */
public class DvdModel {

    private final Connection connection;

    public DvdModel() throws Exception {
        connection = DbConnection.getInstance().getConnection();
    }

    public String saveDvD(DvdDto dvddto) throws Exception {
        String sql = "INSERT INTO dvd VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, dvddto.getDvdId());
        statement.setString(2, dvddto.getDvdname());
        statement.setString(3, dvddto.getDirector());
        statement.setString(4, dvddto.getDuration());
        statement.setInt(5, dvddto.getItemId());

        if (statement.executeUpdate() > 0) {
            return "DVD Save Succesfully";
        } else {
            return "DVD Save Error";
        }
    }

    public ArrayList<DvdDto> getAllDvd() throws Exception {
        String sql = "SELECT*FROM dvd";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();
        ArrayList<DvdDto> dvddtos = new ArrayList();
        while (rst.next()) {
            DvdDto dvddto = new DvdDto();
            dvddto.setDvdId(rst.getInt("dvdid"));
            dvddto.setDvdname(rst.getString("dvd_name"));
            dvddto.setDirector(rst.getString("director"));
            dvddto.setDuration(rst.getString("duration"));
            dvddto.setItemId(rst.getInt("itemid"));
            dvddtos.add(dvddto);

        }
        return dvddtos;
    }

    public DvdDto serchDvd(Integer DvdId) throws Exception {
        String sql = "SELECT*FROM dvd WHERE DvdId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, DvdId);
        ResultSet rst = statement.executeQuery();

        while (rst.next()) {
            DvdDto dto = new DvdDto();
            dto.setDvdId(rst.getInt("dvdid"));
            dto.setDvdname(rst.getString("dvd_name"));
            dto.setDirector(rst.getString("director"));
            dto.setDuration(rst.getString("duration"));
            dto.setItemId(rst.getInt("itemid"));

            return dto;
        }
        return null;

    }

 public String UpdateDvd(DvdDto dvddto) throws Exception {
    String sql = "UPDATE dvd SET dvd_name=?, director=?, duration=?, itemid=? WHERE dvdid=?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        
        statement.setString(1, dvddto.getDvdname());
        statement.setString(2, dvddto.getDirector()); 
        statement.setString(3, dvddto.getDuration());
        statement.setInt(4, dvddto.getItemId());     
        statement.setInt(5, dvddto.getDvdId());      

        
        if (statement.executeUpdate() > 0) {
            return "DVD Successfully Updated";
        } else {
            return "DVD Update Error";
        }
    } catch (Exception e) {
       
        e.printStackTrace();
        throw new Exception("Database error occurred", e);
    }
}


    
      public String DELETEDvd(Integer DvdId) throws Exception {
        String sql = "DELETE FROM dvd WHERE dvdid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DvdId);

            if (statement.executeUpdate() > 0) {
                return "DVD Successfully Deleted";
            } else {
                return "DVD Delete Error";
            }
        } catch (Exception e) {
            throw new Exception("Database error occurred", e.getCause());
        }
    }
}
