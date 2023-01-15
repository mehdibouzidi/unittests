package meritis.mbouzidi.UnitTesting.library.service;

import meritis.mbouzidi.UnitTesting.library.entity.Library;

public interface ILibraryService {
    Library findById(Integer libraryId);
    long countBooks(Integer libraryId);
}
