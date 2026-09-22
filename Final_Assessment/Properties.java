package FinalUtilities;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {
	public static String getData(String key) throws IOException {

        FileInputStream fis = new FileInputStream("./src/test/resources/DDT/loginProperties");

        java.util.Properties prop = new java.utilProperties();

        prop.load(fis);

        String value = prop.getProperty(key);

        fis.close();

        return value;
    }

}
