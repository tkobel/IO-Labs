package lab4;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Tracy Kobel
 */
public class TextFileWriter implements FileWriter {
    @Override
    public void write(String path, String record) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new java.io.FileWriter(path, true));
            out.newLine();
            out.append(record);
        } catch(IOException ioe) {
            System.out.println("file write failed");
        } finally {
            try {
                out.close();
            } catch(Exception e) {
                
            }
        }
    };
}
