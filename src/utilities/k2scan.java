package utilities;


import com.blueseer.utl.OVData;
import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;


public class k2scan {
public static Scanner in = new Scanner(System.in);
public static ArrayList<String> mylist = new ArrayList<String>();
public static String user = "";
public static void main (String[] args) throws InterruptedException, ParseException { 
bsmf.MainFrame.setConfig();



if (args.length == 1) {
    user = args[0].toString();
} else {
    user = "k2";
}

clearscreen();
printscreen();
System.out.print("Choose option:");
String choice = in.nextLine();


System.out.println(choice);
Thread.sleep(2000);
}

public static void printscreen() throws InterruptedException, ParseException {

mylist.clear();
Scanner in = new Scanner(System.in);
System.out.println("*************************");
System.out.println("*  1) Scan To K2        *");
System.out.println("*  0) Quit              *");
System.out.println("*************************");
System.out.print("Choose option:");
String choice = in.nextLine();
    if (choice.equals("1")) {
    clearscreen();
    choice1();
    Thread.sleep(1000);
    clearscreen();
    printscreen();
    } else if (choice.equals("0")) {
    System.out.println("Exiting...");
    Thread.sleep(1000);
    System.exit(0);
    } else {
    System.out.println("Bad Choice");
    Thread.sleep(1000);
    clearscreen();
    printscreen();
    }


}

public static void clearscreen() throws InterruptedException {
/* System.out.println("\f"); */
final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
}


public static boolean isParsableToInt(String i) {
        try {
            Integer.parseInt(i);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }



public static void choice1() throws InterruptedException, ParseException {
String myscan = "";
String sqty = "";
int myqty = 0;
int i = 0;
boolean isbad = false;

while ( ! myscan.equals("d") ) {
clearscreen();

System.out.println("Scan Label:");
myscan = in.nextLine();

if (! myscan.equals("d") && (! OVData.isValidItem(myscan) || myscan.isEmpty())) {
    System.out.println("Bad Part");
          Thread.sleep(1000);
          continue;
}

System.out.println("Enter Qty:");
sqty = in.nextLine();
if (! isParsableToInt(sqty)) {
    System.out.println("Bad Qty");
          Thread.sleep(1000);
          continue;
} else {
   myqty = Integer.valueOf(sqty); 
}



   if (! myscan.equals("d")) {
       OVData.kanban2k2tfr(myscan.toString(), myqty, user);
       System.out.println("scan complete.");
       Thread.sleep(1000);
       continue;
   } 

   // end program by pressing 'd'
   if (myscan.equals("d")) {
       OVData.kanban2k2tfr(myscan.toString(),myqty, user);
       System.out.println("End Program");
       Thread.sleep(1000);
       return;
   } 
  

} // while loop

}
 
public static void example() throws InterruptedException, ParseException {
String myscan = "";
int i = 0;
boolean isbad = false;

while ( ! myscan.equals("d") ) {
clearscreen();
System.out.println("Scan Label:");
myscan = in.nextLine();
   if (myscan.equals("d")) {
       // lets insert tran_mstr record for each serial number
       for (String element : mylist) {
           if (OVData.isLabel(element) &&  OVData.getLabelStatus(element) == 1 ) {
               OVData.nitrideTransferAVM2TT(element);
           } 
       }
       System.out.println("program complete.");
   Thread.sleep(1000);
   return;
   } 

  
   
   if (! myscan.equals("d") && ! myscan.isEmpty()) {
      
      if (! OVData.isLabel(myscan)) {
          System.out.println("Bad Label");
          Thread.sleep(1000);
          continue;
      } 
      
       if ( OVData.isLabel(myscan) && OVData.getLabelStatus(myscan) == 0) {
          System.out.println("Missing CR scan");
          Thread.sleep(1000);
          continue;
      }
       if ( OVData.isLabel(myscan) && OVData.getLabelStatus(myscan) > 2) {
          System.out.println("Closed Label");
          Thread.sleep(1000);
          continue;
      }
      if ( OVData.isLabel(myscan) && OVData.getLabelStatus(myscan) == 2) {
          System.out.println("Previously Scanned");
          Thread.sleep(1000);
          continue;
      } 
      if (! mylist.contains(myscan)) {
          i++;
          mylist.add(myscan);
          System.out.println("Scanned " + String.valueOf(i));
          Thread.sleep(1000);
      } else {
          System.out.println("Already Scanned");
          Thread.sleep(1000);
      }
   }

} // while loop

}

}
