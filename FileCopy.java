import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream(args[0]);
        FileOutputStream output = new FileOutputStream(args[1]);
        byte[] connect = new byte[1024];
        while (input.read(connect) != -1) {
            output.write(connect);
        }
        input.close();
        output.close();
    }
}