package meritis.mbouzidi.UnitTesting.library;

import lombok.SneakyThrows;
import meritis.mbouzidi.UnitTesting.library.entity.Book;
import meritis.mbouzidi.UnitTesting.library.repository.BookRepository;
import meritis.mbouzidi.UnitTesting.library.service.BookService;
import meritis.mbouzidi.UnitTesting.library.service.IBookService;
import org.checkerframework.checker.nullness.Opt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TestBookService {

    @Mock
    private BookRepository repository;

    private IBookService bookService;

    @Before
    public void setup(){
        bookService = new BookService(repository);
    }

    @Test
    public void testBookAge() throws RuntimeException {
        //Given
        Integer bookId = 1;
        Book book = new Book(bookId, "Book", 2005,1);

        //When
        Mockito.when(repository.findById(bookId)).thenReturn(Optional.of(book));
        Integer resultAge = bookService.bookAge(bookId);

        //Then
        Assert.assertEquals(18, resultAge.intValue());
    }

    @Test
    public void testException() throws Exception {
        //Given
        Integer bookId = 1;

        //When
        Mockito.when(repository.findById(bookId)).thenReturn(Optional.empty());
        RuntimeException resultException = Assert.assertThrows(RuntimeException.class, ()-> bookService.bookAge(bookId));

        //Then
        Assert.assertEquals(resultException.getMessage(), "Book Not Found");
    }

}
