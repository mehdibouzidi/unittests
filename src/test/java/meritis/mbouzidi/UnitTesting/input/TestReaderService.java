package meritis.mbouzidi.UnitTesting.input;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class TestReaderService {

    @Autowired
    private IReaderService readerService;

    @Test
    public void testRead(){
        //Given
        String fileName = "testfile.txt";
        ClassLoader classLoader = TestReaderService.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        //When
        String fileContent = readerService.read(file.getAbsolutePath());

        //Then
        Assert.assertEquals("Hello Meritis Tests",fileContent);
    }
}
