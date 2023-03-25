
package grade12culminatingwriting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Grade12CulminatingWriting 
{
    
    public static void main(String[] args) 
    {
        //creates an ArrayList that stores integer objects
        ArrayList<Integer>pinList =  new ArrayList<>();
        
        //creates handles for the files by passing the file names to a file object
        File nf = new File("PIN.txt");
        File nf1 = new File("chequingBalance.txt");
        File nf2 = new File("savingsBalance.txt");
        File nf3 = new File("creditCardBalance.txt");
        File nf4 = new File("totalBalance.txt");
        File nf5 = new File("ID.txt");
        
        //establishes the streams that the PrintWriters will use
        PrintWriter pw;
        PrintWriter pw1;
        PrintWriter pw2;
        PrintWriter pw3;
        PrintWriter pw4;
        PrintWriter pw5;
        
        //exception handler
        try
        {
            //attaches the printwriter to the file, adds a new pin to the ArrayList, and prints the pin to the file
            pw = new PrintWriter(nf);
            pinList.add(1234);
            pw.println(pinList);
            
            //attaches the printwriters to the files and prints the starting balances to the files
            pw1 = new PrintWriter(nf1);
            pw1.println(10000.00);
            pw2 = new PrintWriter(nf2);
            pw2.println(20000.00);
            pw3 = new PrintWriter(nf3);
            pw3.println(2000.00);
            pw4 = new PrintWriter(nf4);
            pw4.println(32000.00);
            
            //attaches the printwriter to the file and prints the ID's to the file
            pw5 = new PrintWriter(nf5);
            pw5.println(1234);
            pw5.println(5678);
            pw5.println(9810);
            
            //closes the file streams
            pw.close();
            pw1.close();
            pw2.close();
            pw3.close();
            pw4.close();
            pw5.close();
        }
        catch(IOException e)
        {
            //prints an error message
            System.out.println("File error: " + e.getMessage());
        }
        
    }
    
}
