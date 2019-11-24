package driver;

import java.io.*;

/**
 * Driver to run the Payroll Processing lab.
 * @author Noe Cebreros
 * ID: 011176643
 * Date: 4/27/18 
 * CSCI 210 Data Structures
 * Lab 4 - Linked List Lab
 * @version 8.1 - NetBeans - 4/24/18
 */
public class Driver {
    
    //address of the file to write to
    private static final String WRITEFILE = "csis.txt";
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[]args) throws IOException{
        try (PrintWriter pw = new PrintWriter(new FileWriter(WRITEFILE))) {
            Payroll payroll = new Payroll(pw);
            payroll.readEmployees();
            payroll.printEmployees();
            payroll.printNumEmployees();
            payroll.printFemaleEmployees();
            payroll.printSalary();
            payroll.giveRaise();
            payroll.sortEmployeesAlphabetically();
            payroll.hire();
            payroll.fire();
        }
    }
}