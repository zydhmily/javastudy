import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ApacheIOStudy {

    public static void main(String[] args) {

        File file = new File("/Users/zydhmily/Desktop/javaStudy/ApacheIOStudy.txt");

        try {
            String content = FileUtils.readFileToString(file);
            System.out.println("Contents of file: " + content);
        } catch (IOException e) {
            new RuntimeException(e);
        }
    }
}