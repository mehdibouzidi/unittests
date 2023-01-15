package meritis.mbouzidi.UnitTesting.library.repository;

import meritis.mbouzidi.UnitTesting.library.entity.Book;
import meritis.mbouzidi.UnitTesting.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
