package meritis.mbouzidi.UnitTesting.library.service;

import meritis.mbouzidi.UnitTesting.library.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Integer bookAge(Integer id) throws RuntimeException;
}
