package lab2;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Tracy Kobel
 */
public class lab2 {
    public static void main(String[] args) {
        File data = new File(File.separatorChar + 
                "temp" + File.separatorChar + 
                "contactList.txt");
        
        System.out.print("Enter the record number you would like to view: ");
        Scanner keyboard = new Scanner(System.in);
        outputSpecificRecordToConsole(data, keyboard.nextInt());
        
    }
    
    public static void outputSpecificRecordToConsole(File data, int record) {
        BufferedReader in = null;
        int recordToRead = record;
        int numberOfRecords = 0;
        boolean recordPrinted = false;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   for(int i = 1; line != null; i++){
               if(i == recordToRead) {
		  System.out.println(line);
                  recordPrinted = true;
               }
               //in.read();
               line = in.readLine();  // strips out any carriage return chars
               numberOfRecords = i;
	   }
           if(!recordPrinted) {
               throw new IOException();
           }
        } catch(IOException ioe) {
            System.out.println("Sorry, there are only " + numberOfRecords + " records.");                    
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
    }
}
