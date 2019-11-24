package driver;

import java.io.*;
import java.util.Scanner;

/**
 * Reads in the employee, firefile.txt and hirefile.txt information and performs the necessary operations.
 * Outputs information in tabular format to console and write file.
 * @author Noe Cebreros
 */
public class Payroll {
    
    //file paths
    private final String PAYFILE = "payfile.txt";
    private final String FIREFILE = "firefile.txt";
    private final String HIREFILE = "hirefile.txt";
    
    private ObjectList list = new ObjectList();
    private final PrintWriter pw;
    
    /**
     * Payroll constructor.
     * @param pw Takes in the PrintWriter to write to file.
     */
    public Payroll(PrintWriter pw){
        this.pw = pw;
    }
    
    /**
     * Reads in from payfile.txt.
     * Parses each line and creates an employee object which is added to list of employees.
     * @throws FileNotFoundException 
     */
    public void readEmployees() throws FileNotFoundException{
        Scanner file = new Scanner(new File(PAYFILE));
        while(file.hasNextLine()){
            String buf = file.nextLine();
            String[] employeeInfo = buf.split("[ ]+");
            
            Employee employee = new Employee(
                    employeeInfo[0],
                    employeeInfo[1],
                    employeeInfo[2],
                    Integer.parseInt(employeeInfo[3]),
                    employeeInfo[4],
                    Double.parseDouble(employeeInfo[5]));
            
            list.addLast(employee);
        }
    }
    
    /**
     * Prints each employee's information from the employee list in tabular format.
     */
    public void printEmployees(){
        
        //Print Header
        System.out.println("PAYFILE.TXT CONTENTS\n");
        System.out.printf("%-11s %-12s %-8s %-8s %-6s %s \n","First Name", "Last Name","Gender","Tenure","Rate","Salary");
        System.out.println("----------------------------------------------------------");
        pw.println("PAYFILE CONTENTS\n");
        pw.printf("%-11s %-12s %-8s %-8s %-6s %s \n","First Name", "Last Name","Gender","Tenure","Rate","Salary");
        pw.println("----------------------------------------------------------");
        
        ObjectListNode n = list.getFirstNode();
        Employee employee;
        while(n != null){
            employee = (Employee)n.getInfo();
            System.out.printf("%-11s %-12s %-8s %-8s %-6s%7.2f \n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getGender(),
                    employee.getTenure(),
                    employee.getRate(),
                    employee.getSalary());
           pw.printf( "%-11s %-12s %-8s %-8s %-6s%7.2f \n",
                   employee.getFirstName(),
                    employee.getLastName(),
                    employee.getGender(),
                    employee.getTenure(),
                    employee.getRate(),
                    employee.getSalary());
           n = n.getNext();
        }
        
        System.out.println();
        pw.println();
    }
    
    /**
     * Prints the number of employees.
     */
    public void printNumEmployees(){
        System.out.println("Number of Employees: " + list.size() + "\n");
        pw.println("Number of Employees: " + list.size() + "\n");
    }
    
    /**
     * Prints the female employees in tabular format.
     */
    public void printFemaleEmployees(){
        ObjectListNode n = list.getFirstNode();
        Employee employee;
        
        System.out.println("FEMALE EMPLOYEES\n");
        System.out.printf("%-11s %-12s\n","First Name","Last Name");
        System.out.println("-----------------------");
        
        pw.println("FEMALE EMPLOYEES\n");
        pw.printf("%-11s %-12s\n","First Name","Last Name");
        pw.println("-----------------------");
        
        while(n != null){
            employee = (Employee)n.getInfo();
            if(employee.getGender().equals("F")){
                System.out.printf("%-11s %-12s\n",employee.getFirstName(),employee.getLastName());
                pw.printf("%-11s %-12s\n",employee.getFirstName(),employee.getLastName());
            }
            n = n.getNext();
        }
        
        System.out.println();
        pw.println();
    }
    
    /**
     * Prints the salary for weekly employees with 5+ years seniority and a salary over 35k yearly in tabular format.
     */
    public void printSalary(){
        ObjectListNode n = list.getFirstNode();
        Employee employee;
        
        System.out.println("SALARY\n*Weekly employees with 5+ years seniority and salary over 35k yearly\n");
        System.out.printf("%-11s %-12s %s \n", "First Name", "Last Name", "Salary");
        System.out.println("---------------------------------");
        
        pw.println("SALARY\n*Weekly employees with 5+ years seniority and salary over 35k yearly\n");
        pw.printf("%-11s %-12s %s \n", "First Name", "Last Name", "Salary");
        pw.println("---------------------------------");
        
        while(n != null){
            employee = (Employee)n.getInfo();
            if(employee.getRate().equals("W") &&
               employee.getSalary() > (35000/52) &&
               employee.getTenure() >= 5){
                System.out.printf("%-11s %-12s%7.2f\n",employee.getFirstName(),employee.getLastName(),employee.getSalary());
                pw.printf("%-11s %-12s%7.2f\n",employee.getFirstName(),employee.getLastName(),employee.getSalary());
            }
            n = n.getNext();
        }
        
        System.out.println();
        pw.println();
    }
    
    /**
     * Gives a raise of $0.75 hourly to hourly employees making less than $10.00 hourly.
     * Gives a rise of $50.00 weekly to weekly employees making less than $350.00 weekly.
     * Prints the updated employee information in tabular format.
     */
    public void giveRaise(){
        ObjectListNode n = list.getFirstNode();
        Employee employee;
        
        System.out.println("EMPLOYEE RAISES");
        System.out.println("+$0.75 hourly to hourly employees making less than $10.00 hourly.");
        System.out.println("+$50.00 weekly to weekly employees making less than $350.00 weekly.\n");
        
        pw.println("EMPLOYEE RAISES");
        pw.println("+$0.75 hourly to hourly employees making less than $10.00 hourly.");
        pw.println("+$50.00 weekly to weekly employees making less than $350.00 weekly.\n");
        
        System.out.printf("%-11s %-12s%s\n","First Name", "Last Name"," Salary");
        System.out.println("---------------------------------");
        
        pw.printf("%-11s %-12s%s\n","First Name", "Last Name"," Salary");
        pw.println("---------------------------------");
        
        while(n != null){
            employee = (Employee)n.getInfo();
            if(employee.getRate().equals("H") && employee.getSalary() < 10.00){
                double newSalary = employee.getSalary() + 0.75;
                employee.setSalary((double)Math.round(newSalary * 100) / 100);
                System.out.printf("%-11s %-12s%7.2f\n",employee.getFirstName(), employee.getLastName(),employee.getSalary());
                pw.printf("%-11s %-12s%7.2f\n",employee.getFirstName(), employee.getLastName(),employee.getSalary());
            }
            else if(employee.getRate().equals("W") && employee.getSalary() < 350.00){
                double newSalary = employee.getSalary()+50.00;
                    employee.setSalary((double)Math.round(newSalary * 100) / 100);
                    System.out.printf("%-11s %-12s%7.2f\n",employee.getFirstName(), employee.getLastName(),employee.getSalary());
                    pw.printf("%-11s %-12s%7.2f\n",employee.getFirstName(), employee.getLastName(),employee.getSalary());
            }
            
            n = n.getNext();
        }
        
        System.out.println();
        pw.println();
    }
    
    /**
     * Sorts the employees alphabetically by last name.
     * Prints resulting sorted list in tabular format.
     */
    public void sortEmployeesAlphabetically(){
        ObjectList newList = new ObjectList();
        Employee employee;
         
        ObjectListNode n = list.getFirstNode();
        while(n != null){
            employee = (Employee)n.getInfo();
            newList.insert(employee);
            n = n.getNext();
        }
        list = newList;
        
        n = list.getFirstNode();
        
        System.out.println("SORTED EMPLOYEES\n*Alphabetically\n");
        pw.println("SORTED EMPLOYEES\n*Alphabetically\n");
        
        System.out.printf("%-11s %-12s %s\n","First Name", "Last Name", "Salary");
        System.out.println("---------------------------------");
        
        pw.printf("%-11s %-12s %s\n","First Name", "Last Name", "Salary");
        pw.println("---------------------------------");
        
        while(n != null){
            employee = (Employee)n.getInfo();
            System.out.printf("%-11s %-12s%7.2f\n",employee.getFirstName(), employee.getLastName(),employee.getSalary());
            pw.printf("%-11s %-12s%7.2f\n",employee.getFirstName(), employee.getLastName(),employee.getSalary());
            n = n.getNext();
        }
        
        System.out.println();
        pw.println();
    }
    
    /**
     * Reads in the employees to be hired from hirefile.txt.
     * Adds these employees to the employees list and sorts.
     * Prints in tabular format.
     * @throws FileNotFoundException 
     */
    public void hire() throws FileNotFoundException{
        Scanner file = new Scanner(new File(HIREFILE));
        
        while(file.hasNextLine()){
            String buf = file.nextLine();
            String[] employeeInfo = buf.split("[ ]+");
            Employee employee = new Employee(
                    employeeInfo[0],
                    employeeInfo[1],
                    employeeInfo[2],
                    Integer.parseInt(employeeInfo[3]),
                    employeeInfo[4],
                    Double.parseDouble(employeeInfo[5]));
            list.insert(employee);
        }
        
        ObjectList newList = new ObjectList();
        
        Employee employee;
        
        ObjectListNode n = list.getFirstNode();
        while(n != null){
            employee = (Employee)n.getInfo();
            newList.insert(employee);
            n = n.getNext();
        }
        list = newList;
        
        System.out.println("UPDATED EMPLOYEE LIST - NEW EMPLOYEES HIRED FROM HIREFILE.TXT\n");
        pw.println("UPDATED EMPLOYEE LIST - NEW EMPLOYEES HIRED FROM HIREFILE.TXT\n");
        
        System.out.printf("%-11s %-12s\n","First Name", "Last Name");
        System.out.println("-----------------------");
        pw.printf("%-11s %-12s\n","First Name", "Last Name");
        pw.println("-----------------------");
        
        n = list.getFirstNode();
        while(n != null){
            employee = (Employee)n.getInfo();    
            System.out.printf("%-11s %-12s\n",employee.getFirstName(), employee.getLastName());
            pw.printf("%-11s %-12s\n",employee.getFirstName(), employee.getLastName());
            n = n.getNext();
            }
        System.out.println();
        pw.println();
        }
    
    /**
     * Reads in the employees to be fired from firefile.txt.
     * Removes these employees to the employees list.
     * Prints in tabular format.
     * @throws FileNotFoundException 
     */
    public void fire() throws FileNotFoundException{
        Scanner file = new Scanner(new File(FIREFILE));
        
        ObjectList fireList = new ObjectList();
        
        while(file.hasNextLine()){
            String buf = file.nextLine();
            String[] employeeInfo = buf.split("[ ]+");
            Employee employee = new Employee(employeeInfo[0],employeeInfo[1]);
            fireList.insert(employee);
        }

        ObjectListNode n = fireList.getFirstNode();
        while(n != null){
            Employee employee = (Employee)n.getInfo();
            list.remove(employee);
            n = n.getNext();
        }
        
        System.out.println("UPDATED EMPLOYEE LIST - EMPLOYEES FIRED FROM FIREFILE.TXT\n");
        pw.println("UPDATED EMPLOYEE LIST - EMPLOYEES FIRED FROM FIREFILE.TXT\n");
        
        System.out.printf("%-11s %-12s\n","First Name", "Last Name");
        System.out.println("-----------------------");
        pw.printf("%-11s %-12s\n","First Name", "Last Name");
        pw.println("-----------------------");
        
        Employee employee;
        
        n = list.getFirstNode();
        while(n != null){
            employee = (Employee)n.getInfo();    
            System.out.printf("%-11s %-12s\n",employee.getFirstName(), employee.getLastName());
            pw.printf("%-11s %-12s\n",employee.getFirstName(), employee.getLastName());
            n = n.getNext();
            }
        System.out.println();
        pw.println();
        }
}
