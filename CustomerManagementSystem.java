import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class CustomerManagementSystem {
    private static ArrayList<Customer> customerList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a Customer");
            System.out.println("2. Remove a Customer");
            System.out.println("3. Search for a Customer");
            System.out.println("4. List All Customers");
            System.out.println("5. Sort Customers by Name");
            System.out.println("6. Sort Customers by ID");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    removeCustomer(scanner);
                    break;
                case 3:
                    searchCustomer(scanner);
                    break;
                case 4:
                    listAllCustomers();
                    break;
                case 5:
                    sortCustomersByName();
                    break;
                case 6:
                    sortCustomersById();
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();

        // Simple email validation
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid email format. Customer not added.");
            return;
        }

        customerList.add(new Customer(id, name, email));
        System.out.println("Customer added successfully!");
    }

    private static void removeCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID to remove: ");
        int idToRemove = scanner.nextInt();

        boolean removed = customerList.removeIf(customer -> customer.getId() == idToRemove);
        if (removed) {
            System.out.println("Customer removed successfully!");
        } else {
            System.out.println("Customer ID not found.");
        }
    }

    private static void searchCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID to search: ");
        int idToSearch = scanner.nextInt();

        for (Customer customer : customerList) {
            if (customer.getId() == idToSearch) {
                System.out.println("Customer found: " + customer);
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private static void listAllCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    private static void sortCustomersByName() {
        Collections.sort(customerList, Comparator.comparing(Customer::getName));
        System.out.println("Customers sorted by name:");
        listAllCustomers();
    }

    private static void sortCustomersById() {
        Collections.sort(customerList, Comparator.comparingInt(Customer::getId));
        System.out.println("Customers sorted by ID:");
        listAllCustomers();
    }
}
