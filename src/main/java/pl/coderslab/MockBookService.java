package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements IBookService {

    private final List<Book> list;
    private static Long nextId;


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

        Integer size = list.size() + 1;
        nextId = size.longValue();
    }

    //    Pobieranie listy wszystkich książek
    @Override
    public List<Book> getAllBooks() {
        return list;
    }

    //    Pobieranie obiektu po wskazanym identyfikatorze.
    @Override
    public Optional<Book> getBookById(Long id) {
        return list.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    //    Edycje obiektu.
    @Override
    public void editBook(Book newBookData, Long id) {
        Optional<Book> bookToEdit = getBookById(id);

        int index = list.indexOf(bookToEdit.get());
        list.set(index, newBookData);

    }

    //    Usuwanie obiektu.
    @Override
    public void deleteBook(Long id) {
        Optional<Book> bookToDelete = getBookById(id);
        if (bookToDelete.isPresent()) {
            list.remove(bookToDelete.get());
        }
    }

    //    dodawanie obiektu.
    @Override
    public void addBook(Book book) {
        book.setId(nextId);
        if (list.add(book)) {
            nextId++;
        }
    }


}
