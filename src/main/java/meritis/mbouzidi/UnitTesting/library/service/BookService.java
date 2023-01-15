package meritis.mbouzidi.UnitTesting.library.service;

import meritis.mbouzidi.UnitTesting.library.entity.Book;
import meritis.mbouzidi.UnitTesting.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService implements IBookService{

    private final  BookRepository repository;

    @Autowired
    public BookService(BookRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Integer bookAge(Integer id) throws Exception {
        Book book = repository.findById(id).orElse(null);
        if(book==null){
            throw new Exception("Book Not Found");
        }
        return LocalDate.now().getYear() - book.getYearOfPublication();
    }
}
