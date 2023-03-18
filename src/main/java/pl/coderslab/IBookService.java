package pl.coderslab;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    void editBook(Book newBookData, Long id);
    void deleteBook(Long id);
    void addBook(Book book);
}
