package meritis.mbouzidi.UnitTesting.library.service;

import meritis.mbouzidi.UnitTesting.library.entity.Book;
import meritis.mbouzidi.UnitTesting.library.entity.Library;
import meritis.mbouzidi.UnitTesting.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements ILibraryService{
    private LibraryRepository repository;
    private IBookService bookService;

    @Autowired
    public LibraryService(IBookService bookService, LibraryRepository repository) {
        this.bookService = bookService;
        this.repository = repository;
    }

    @Override
    public Library findById(Integer libraryId) {
        return repository.findById(libraryId).orElse(new Library(0, "Default Library"));
    }

    @Override
    public long countBooks(Integer libraryId) {
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks.stream().filter(book -> book.getLibraryId()==libraryId).count();
    }
}
