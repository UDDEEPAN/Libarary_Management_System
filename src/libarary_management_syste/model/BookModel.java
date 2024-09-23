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


/**
 *
 * @author LENOVO
 */
public class BookModel {

    private final Connection connection;

    public BookModel() throws Exception {
        connection = DbConnection.getInstance().getConnection();
    }

    public String saveBook(BookDto bookdto) throws Exception {
        String sql = "INSERT INTO book VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, bookdto.getBookId());
        statement.setString(2, bookdto.getName());
        statement.setString(3, bookdto.getIsbn());
        statement.setString(4, bookdto.getAuthor());
        statement.setInt(5, bookdto.getItemId());

        if (statement.executeUpdate() > 0) {
            return "Book Save Succesfully";
        } else {
            return "Book Save Error";
        }
    }

    public ArrayList<BookDto> getAllBook() throws Exception {
        String sql = "SELECT*FROM book";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();
        ArrayList<BookDto> bookdtos = new ArrayList();
        while (rst.next()) {
            BookDto bookdto = new BookDto();
            bookdto.setBookId(rst.getInt("bookid"));
            bookdto.setName(rst.getString("book_name"));
            bookdto.setIsbn(rst.getString("Isbn"));
            bookdto.setAuthor(rst.getString("author"));
            bookdto.setItemId(rst.getInt("itemid"));
            bookdtos.add(bookdto);

        }
        return bookdtos;
    }

    public BookDto serchBook(Integer BookId) throws Exception {
        String sql = "SELECT*FROM book WHERE bookid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, BookId);
        ResultSet rst = statement.executeQuery();

        while (rst.next()) {
            BookDto dto = new BookDto();
            dto.setBookId(rst.getInt("bookid"));
            dto.setName(rst.getString("book_name"));
            dto.setIsbn(rst.getString("Isbn"));
            dto.setAuthor(rst.getString("author"));
            dto.setItemId(rst.getInt("itemid"));

            return dto;
        }
        return null;

    }

   public String updateBook(BookDto bookdto) throws Exception {
    String sql = "UPDATE book SET book_name = ?, isbn = ?, author = ?, itemid = ? WHERE bookid = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        
        statement.setString(1, bookdto.getName());
        statement.setString(2, bookdto.getIsbn());
        statement.setString(3, bookdto.getAuthor());
        statement.setInt(4, bookdto.getItemId());
        statement.setInt(5, bookdto.getBookId());

      
        if (statement.executeUpdate() > 0) {
            return "Book Successfully Updated";
        } else {
            return "Book Update Error";
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception("Database error occurred", e);
    }
}


    public String DleteBook(Integer bookId) throws Exception {
        String sql = "DELETE FROM book WHERE bookid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookId);

            if (statement.executeUpdate() > 0) {
                return "Book Successfully Deleted";
            } else {
                return "Book Delete Error";
            }
        } catch (Exception e) {
            throw new Exception("Database error occurred", e.getCause());
        }
    }

}
