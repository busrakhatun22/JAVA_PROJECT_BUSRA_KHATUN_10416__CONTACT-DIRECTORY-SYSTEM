// Contact Class
class Contact {
    String name;
    String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
    }
}

// Directory Class
class Directory {
    private Contact[] contacts;
    private int count;

    // Constructor
    public Directory(int size) {
        contacts = new Contact[size];
        count = 0;
    }

    // Add Contact
    public void addContact(String name, String phone) {
        if (count < contacts.length) {
            //contacts[count++] = new Contact(name, phone);
            System.out.println("Contact added successfully");
        } else {
            System.out.println("Directory is full");
        }
    }

    // Search Contact
    public void searchContact(String name) {
        for (int i = 0; i < count;) {
            //if (contacts[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found:");
                contacts[i].display();
                return;
            }
        }
       // System.out.println("Contact not found");
    

    // Delete Contact
    public void deleteContact(String name) {
        for (int i = 0; i < count;) {
           // if (contacts[i].getName().equalsIgnoreCase(name)) {

                //Shift elements
                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }

                count--;
                System.out.println("Contact deleted successfully");
                return;
            }
        }
      //  System.out.println("Contact not found");
    

    // Display All Contacts
    public void displayAll() {
        if (count == 0) {
            System.out.println("No contacts available");
            return;
        }

        for (int i = 0; i < count; i++) {
            contacts[i].display();
            System.out.println("---------------");
        }
    }
}

// Main Class (Testing)
public class Main {
    public static void main(String[] args) {
        Directory directory = new Directory(5);

        // Adding contacts
        directory.addContact("Rahul", "9876543210");
        directory.addContact("Aman", "9123456780");

        // Searching
        System.out.println("\nSearching for Rahul:");
        directory.searchContact("rahul");

        // Display all
        System.out.println("\nAll Contacts:");
        directory.displayAll();

        // Deleting
        System.out.println("\nDeleting Rahul...");
        directory.deleteContact("Rahul");

        // Searching again
        System.out.println("\nSearching again:");
        directory.searchContact("Rahul");
    }
}       
