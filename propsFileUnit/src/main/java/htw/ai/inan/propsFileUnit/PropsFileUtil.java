package htw.ai.inan.propsFileUnit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropsFileUtil 
{
    private PropsFileUtil() {   }
    
	public static Properties readProperties() {
    	Properties prop = new Properties();
    	InputStream input = null;	
    	try {
    		input = new FileInputStream("props.properties");
    		if (input != null) {
        		prop.load(input);
        		input.close();
    		} 
    	} catch (IOException e) {
    		System.out.println("Class could not be loaded");
    	} 
    	return prop;	
    }
}
