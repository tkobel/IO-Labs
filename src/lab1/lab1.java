package lab1;

import java.io.*;


/**
 *
 * @author Tracy Kobel
 */
public class lab1 {
    public static void main(String[] args) {
        File data = new File(File.separatorChar + 
                "temp" + File.separatorChar + 
                "contactList.txt");
        System.out.println("task 1: print all records");
        outputToConsole(data);
        System.out.println("task 2: print just the second record");
        outputSecondRecordToConsole(data);
        System.out.println("task 3: add a record and print all records");
        addRecordToFile(data, "Dave,Thomas,79 Wendy Rd.,Dublin,OH,55555,dave@wendys.com,(444)444-4444");
        outputToConsole(data);
    }
    
    public static void outputToConsole(File data) {
        BufferedReader in = null;
       //task 1: print all records
        try {
	   in = new BufferedReader(new FileReader(data));
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
    }
    
    public static void outputSecondRecordToConsole(File data) {
        BufferedReader in = null;
        int recordToRead = 2;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   for(int i = 1; line != null; i++){
               if(i == recordToRead) {
		  System.out.println(line);
               }
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
    }
    
    public static void addRecordToFile(File data, String record) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(data, true));
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
    }
}

