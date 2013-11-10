package lab3;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Tracy Kobel
 */
public class lab3 {
    public static void main(String[] args) {
        File data = new File(File.separatorChar + 
                "temp" + File.separatorChar + 
                "contactList.txt");
        System.out.print("Enter the record number you would like to view: ");
        Scanner keyboard = new Scanner(System.in);
        outputCityInSpecificRecordToConsole(data, keyboard.nextInt());
        
    }
    
    public static void outputCityInSpecificRecordToConsole(File data, int record) {
        BufferedReader in = null;
        int recordToRead = record;
        int numberOfRecords = 0;
        boolean recordPrinted = false;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   for(int i = 1; line != null; i++){
               if(i == recordToRead) {
                  //splits the record into an array of fields
                  String[] fields = line.split(",");
                  //prints array index 3, which is the city
		  System.out.println(fields[3]);
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
