package lab4;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Tracy Kobel
 */
public class TextFileReader implements FileReader {
    @Override
    public void read(String path) {
         BufferedReader in = null;
       //task 1: print all records
        try {
	   in = new BufferedReader(new java.io.FileReader(path));
	   String line = in.readLine();
	   while(line != null){
		  System.out.println(line);
                  //in.read();
		  line = in.readLine();  // strips out any carriage return chars
	   }          	 
        } catch(IOException ioe) {
            System.out.println("file read failed");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
    
    };
}
