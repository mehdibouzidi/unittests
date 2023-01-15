package meritis.mbouzidi.UnitTesting.library;

import meritis.mbouzidi.UnitTesting.library.entity.Book;
import meritis.mbouzidi.UnitTesting.library.repository.LibraryRepository;
import meritis.mbouzidi.UnitTesting.library.service.IBookService;
import meritis.mbouzidi.UnitTesting.library.service.ILibraryService;
import meritis.mbouzidi.UnitTesting.library.service.LibraryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestLibraryService {

    @Mock
    private LibraryRepository repository;
    @Mock
    private IBookService bookService;

    private ILibraryService libraryService;

    @Before
    public void setup(){
        libraryService = new LibraryService(bookService, repository);
    }


    @Test
    public void testCountBooks(){
        //Given
        Integer libraryId = 1;
        List<Book> books = List.of(new Book(1,"Book_1",2005,libraryId),
                new Book(2,"Book_2",1905,libraryId),
                new Book(3,"Book_3",1993,2));

        //When
        Mockito.when(bookService.getAllBooks()).thenReturn(books);
        long result =  libraryService.countBooks(libraryId);

        //Then
        Assert.assertEquals(2l,result);

    }
}
