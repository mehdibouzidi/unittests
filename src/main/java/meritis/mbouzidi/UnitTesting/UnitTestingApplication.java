package meritis.mbouzidi.UnitTesting;

import meritis.mbouzidi.UnitTesting.library.entity.Library;
import meritis.mbouzidi.UnitTesting.library.service.IBookService;
import meritis.mbouzidi.UnitTesting.library.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestingApplication implements ApplicationRunner {

	@Autowired
	private IBookService bookService;
	@Autowired
	private ILibraryService libraryService;

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Hello Tests");
		Library librarySoleil = libraryService.findById(1);
		long nbBooks = libraryService.countBooks(librarySoleil.getId());
		System.out.println(String.format("Il y a %h dans la librairie: %s",nbBooks, librarySoleil.getName()));
	}
}
