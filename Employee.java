package driver;

/**
 * Employee object which stores and allows access to the first name, last name, gender, tenure, rate and salary.\
 * Implements the comparable interface allowing for the last name to be compared.
 * @author Noe Cebreros
 */

public class Employee implements Comparable{
    
    private final String firstName;
    private final String lastName;
    private String gender;
    private int tenure;
    private String rate;
    private double salary;
    
    /**
     * 6 arg constructor.
     * @param firstName Takes a string for the first name.
     * @param lastName Takes a string for the last name.
     * @param gender Takes a string for the gender.
     * @param tenure Takes an integer for the tenure (years).
     * @param rate Takes a string for the rate (W or H).
     * @param salary Take a double for the salary.
     */
    public Employee(String firstName, String lastName, String gender, int tenure, String rate, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.tenure = tenure;
        this.rate = rate;
        this.salary = salary;
    }
    
    /**
     * 2 arg constructor.
     * @param firstName Takes a string for the first name.
     * @param lastName Takes a string for the last name.
     */
    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Compares this Employee object's last name to another.
     * @param o the Employee object to be compared.
     * @return -1, 0 or 1
     */
    @Override
    public int compareTo(Object o){
        Employee e = (Employee) o;
        return lastName.compareTo(e.getLastName());
    }
    
    /**
     * Returns the Employee object's first name.
     * @return firstName
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Returns the Employee object's last name.
     * @return lastName
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * Returns the Employee object's gender.
     * @return gender
     */
    public String getGender(){
        return gender;
    }
    
    /**
     * Returns the Employee object's tenure.
     * @return tenure
     */
    public int getTenure(){
        return tenure;
    }
    
    /**
     * Returns the Employee object's rate.
     * @return rate
     */
    public String getRate(){
        return rate;
    }
    
    /**
     * Returns the Employee object's salary.
     * @return salary
     */
    public double getSalary(){
        return salary;
    }
    
    /**
     * Sets the salary for the Employee object.
     * @param salary The new salary to set.
     */
    public void setSalary(double salary){
        this.salary = salary;
    }
}
