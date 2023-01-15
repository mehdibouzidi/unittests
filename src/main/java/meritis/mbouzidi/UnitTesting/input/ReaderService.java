package meritis.mbouzidi.UnitTesting.input;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ReaderService implements IReaderService {

    @Override
    public String read(String fileName) {
        File file =  new File(fileName);
        try (InputStream inputStream = new FileInputStream(file)) {
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
               builder.append(line);
            }
            return builder.toString();
        }  catch (IOException e) {
            return "Empty File";
        }
    }
}
