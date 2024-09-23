/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.controller;

import java.util.ArrayList;
import libarary_management_syste.dto.BookDto;
import libarary_management_syste.model.BookModel;

/**
 *
 * @author LENOVO
 */
public class BookController {

    private final BookModel bookModel;

    public BookController() throws Exception {
        this.bookModel = new BookModel();
    }

    public String saveBook(BookDto bookdto) throws Exception {
        return bookModel.saveBook(bookdto);
    }

    public ArrayList<BookDto> getAllBook() throws Exception {
        return bookModel.getAllBook();
    }

    public BookDto serchBook(Integer BookId) throws Exception {
        return bookModel.serchBook(BookId);
    }

    public String UpdateBook(BookDto bookdto) throws Exception {
        return bookModel.updateBook(bookdto);
    }

    public String DeleteBook(Integer Id) throws Exception {
        return bookModel.DleteBook(Id);
    }
}
