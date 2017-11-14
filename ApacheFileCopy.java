
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ApacheFileCopy {
	public static void main(String[] args) {
		File input = null;
		File output = null;

		try {
			input = new File(args[0]);
			output = new File(args[1]);
			
            FileUtils.copyFile(input, output);            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}