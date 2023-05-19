import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesReplaceDate {
    ///Users/aleksand/Desktop/Testex

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pathToFoulder = scanner.nextLine();
        replaceString(findAllFiles(pathToFoulder));
    }

    public static File[] findAllFiles(String path){
        File folder = new File(path);
        File[] files = folder.listFiles();

        return files;
    }

    public static void replaceString(File[] files){

        for ( File file: files) {
            Pattern pattern = Pattern.compile("\s(0?[1-9]|[12][0-9]|3[01])[/|-](0?[1-9]|1[0-2])[/|-][0-9]{4}\s([01]?[0-9]|2[0-3]):[0-5][0-9]");

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = "", oldText = "", replaceText = "",rep1 = "";
                while ((line = reader.readLine()) != null) {
                    oldText += line;
                }
                reader.close();

                Matcher matchPattern = pattern.matcher(oldText);
                if(matchPattern.find()){
                    rep1 = matchPattern.group().substring(0,11);
                    oldText = matchPattern.replaceAll(rep1);
                }

                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(oldText);

                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

