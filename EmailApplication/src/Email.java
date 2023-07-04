import java.util.Scanner;

public class Email {

    // ATTRIBUTES
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity = 500;
    private String email;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // CONSTRUCTOR TO RECEIVE THE FIRST NAME AND LAST NAME
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName + ".");

        // CALL A METHOD ASKING FOR THE DEPARTAMENT
        this.department = setDepartment();

        // CALL A METHOD THAT RETURNS A RANDOM PASSWORD
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password + ".");

        // COMBINE ELEMENTS TO GENERATE EMAIL
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // ASK FOR THE DEPARTAMENT
    private String setDepartment() {
        System.out.println(
                "DEPARTMENTS CODES:\nter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    // GENERATE A RANDOM PASSWORD
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIKJLMNOPQRSTUVWXYZ0123456789!@#$%";

        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // SET THE MAILBOX CAPACITY

    // SET THE MAILBOX CAPACITY
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // SET THE ALTERNATE EMAIL
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // CHANGE THE PASSWORD
    public void changePassword(String password) {
        this.password = password;
    }

    //GETTERS
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    //METHOD SHOW INFO
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
