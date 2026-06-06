import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class Directory {
    private Contact[] contacts;
    private int count;

    public Directory(int size) {
        contacts = new Contact[size];
        count = 0;
    }

    public void addContact(String name, String phone) {
        if (count < contacts.length) {
            contacts[count++] = new Contact(name, phone);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Directory is full.");
        }
    }

    public void searchContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + contacts[i].getName());
                System.out.println("Phone: " + contacts[i].getPhoneNumber());
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }
                contacts[count - 1] = null;
                count--;
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void displayContacts() {
        if (count == 0) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\nContact List:");
        for (int i = 0; i < count; i++) {
            System.out.println("Name: " + contacts[i].getName()
                    + ", Phone: " + contacts[i].getPhoneNumber());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of contacts: ");
        int size = sc.nextInt();
        sc.nextLine();

        Directory directory = new Directory(size);

        while (true) {
            System.out.println("\n--- Contact Directory Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    directory.addContact(name, phone);
                    break;

                case 2:
                    System.out.print("Enter Name to Search: ");
                    name = sc.nextLine();
                    directory.searchContact(name);
                    break;

                case 3:
                    System.out.print("Enter Name to Delete: ");
                    name = sc.nextLine();
                    directory.deleteContact(name);
                    break;

                case 4:
                    directory.displayContacts();
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}