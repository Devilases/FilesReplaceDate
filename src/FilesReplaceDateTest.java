import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FilesReplaceDateTest {
    String path = "/Users/aleksand/Desktop/Testex";
    FilesReplaceDate filesReplaceDate;
    @BeforeEach
    void createObjeckt(){
        filesReplaceDate = new FilesReplaceDate();
    }

    @Test
     void shouldFindAllFiles() {

        assertArrayEquals(new File[]{new File("/Users/aleksand/Desktop/Testex/.DS_Store"), new File("/Users/aleksand/Desktop/Testex/test.txt"), new File("/Users/aleksand/Desktop/Testex/test — копия.txt")},filesReplaceDate.findAllFiles(path) );

    }

    @Test
    void shouldReplaceDateInFile() {
        /*
        1 выполнить метод
        2 прочитать строку из него
        3 сравнить
         */
        File[] files = {new File("/Users/aleksand/Desktop/Testex/test.txt"), new File("/Users/aleksand/Desktop/Testex/test — копия.txt")};
        filesReplaceDate.replaceString(files);
        for (File file : files){
            String line, lineFromFile = "";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while ((line = bufferedReader.readLine()) != null){
                    lineFromFile += line;
                }
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(lineFromFile);
            assertEquals(" 23-12-2003", lineFromFile);

        }

    }
}