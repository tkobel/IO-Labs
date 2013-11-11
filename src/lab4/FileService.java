package lab4;

import java.io.File;

/**
 *
 * @author Tracy Kobel
 */
public class FileService {
    private FileReader reader;
    private FileWriter writer;
    private String path = "";
    
    public FileService(String path) {
        setPath(path);
    }

    public FileReader getReader() {
        return reader;
    }

    public void setReader(FileReader reader) {
        this.reader = reader;
    }

    public FileWriter getWriter() {
        return writer;
    }

    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }

    public String getPath() {
        return path;
    }

    public final void setPath(String path) {
        if(path.startsWith("/") || path.startsWith("\\")) {
            path += File.separatorChar;
        }
        String[] dirs = path.split("[/'\']");
        for(int i = 0; i < dirs.length; i++) {
            this.path += dirs[i];
            if(i != dirs.length - 1) {
                this.path += File.separatorChar;
            }
        }
    }
    
    public static void main(String[] args) {
        FileService service = new FileService("C:/temp/contactList.txt");
        System.out.println(service.path);
        service.setReader(new TextFileReader());
        service.getReader().read(service.getPath());
        
    }
}
