package pl.coderslab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    private static final Logger logger
            = LoggerFactory.getLogger(BookController.class);

    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        logger.info("helloBook");
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping
    public List<Book> getAllBooks(){
        logger.info("getAllBooks");
        return mockBookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        mockBookService.addBook(book);
    }




}