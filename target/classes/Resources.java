package files;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class Resources {
	
	public Properties prop;
	
	
	public String InitializeHost() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\de01\\TASK1_APP\\src\\main\\java\\files\\environment.properties");
		prop.load(fis);				
		
		String hostname = prop.getProperty("HOST");
		
		return hostname;				
		
	}
	
	
}
