package pl.coderslab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {


    private static final Logger logger
            = LoggerFactory.getLogger(BookController.class);

    @RequestMapping("/helloBook")
    public Book helloBook() {
        logger.info("helloBook");
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
}