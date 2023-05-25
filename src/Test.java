import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ///Users/aleksand/Desktop/Testex
        FilesReplaceDate filesReplaceDate = new FilesReplaceDate();
        Scanner scanner = new Scanner(System.in);
        String pathToFoulder = scanner.nextLine();
        System.out.println(Arrays.toString(filesReplaceDate.findAllFiles(pathToFoulder)));

        filesReplaceDate.replaceString(filesReplaceDate.findAllFiles(pathToFoulder));
    }
}
