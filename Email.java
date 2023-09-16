import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "xycompany.org";

    // Constructor to recieve the first name and last name.
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Calling the method asking for department and returning the department.
        this.department = setDepartmant();
        // System.out.println("Department: " + this.department);

        // Calling get method that returns random password.
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Creating email.
        if (this.department == "") {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        }
        else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        }
        // System.out.println("New Email: " + email);
    }


    // Ask for department.
    private String setDepartmant() {
        System.out.print("Enter the department code\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if (deptChoice == 1) { return "Sal"; }
        else if (deptChoice == 2) { return "Dev"; }
        else if (deptChoice == 3) { return "Acc"; }
        else { return ""; }
    }

    // Generate a random password.
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);  
        }
        return new String(password);
    }

    // Set mailbox capacity.
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set alternate email.
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // set Change the password.
    public void setChangePassword(String password) {
        this.password = password;
    }

    // Getting methods.
    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getChangedPassword() { return password; }
    
    // Displaying all the info.
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
                "COMPANY EMAIL: " + email + "\n" +
                "MAILBOX CAPACITY: " + mailboxCapacity;
    }
}
