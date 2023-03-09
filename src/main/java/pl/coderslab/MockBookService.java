package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService {

    private final List<Book> list;
    private static Long nextId = 4L;


    public MockBookService() {
        this.list = new ArrayList<>();

        this.list.add(new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming"));
        this.list.add(new Book(2L, "6546541213211", "Lord of the Rings",
                "B.R.R", "Helion", "fantasy"));
        this.list.add(new Book(3L, "9876543213214", "Wiedźmin",
                "A. Sapkowski", "Helion", "fantasy"));
        this.list.add(new Book(4L, "9876542141646", "Shining",
                "Steven King", "Helion", "Thriller"));
        this.list.add(new Book(5L, "8975421321897", "Sherlock Holmes",
                "Agatha Cristie", "Helion", "Criminal"));
    }

    //    Pobieranie listy wszystkich książek
    protected List<Book> getAllBooks() {
        return list;
    }

    //    Pobieranie obiektu po wskazanym identyfikatorze.
    protected Book getBookById(Long id) {
        return list.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    //    Edycje obiektu.
    protected void editBook(Book book) {
        int bookToEditIndex = list.indexOf(book);
        list.set(bookToEditIndex, book);
    }

    //    Usuwanie obiektu.
    protected void deleteBook(Long id) {
        Book bookToDelete = getBookById(id);
        list.remove(bookToDelete);
    }

    //    dodawanie obiektu.
    protected void addBook(Book book) {
        book.setId(nextId);
        if (list.add(book)) {
            nextId++;
        }

    }
}
