/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.dto;

/**
 *
 * @author LENOVO
 */
public class BookDto {

    private Integer ItemId;
    private Integer BookId;
    private String name;
    private String Isbn;
    private String author;

    public BookDto() {

    }

    public Integer getItemId() {
        return ItemId;
    }

    public void setItemId(Integer ItemId) {
        this.ItemId = ItemId;
    }

    public Integer getBookId() {
        return BookId;
    }

    public void setBookId(Integer BookId) {
        this.BookId = BookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDto{" + "ItemId=" + ItemId + ", BookId=" + BookId + ", name=" + name + ", Isbn=" + Isbn + ", author=" + author + '}';
    }
}
