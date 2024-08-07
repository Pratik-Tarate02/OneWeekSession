package AnudipPracticals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<String> bookTitles;

    public LibrarySystem() {
        bookTitles = new ArrayList<>();
    }

    // Add a book title
    public void addBookTitle(String title) {
        bookTitles.add(title);
        System.out.println("Book titled '" + title + "' added.");
    }

    // Remove a book title
    public void removeBookTitle(String title) {
        if (bookTitles.remove(title)) {
            System.out.println("Book titled '" + title + "' removed.");
        } else {
            System.out.println("Book titled '" + title + "' not found.");
        }
    }

    // Search for a book title
    public void searchBookTitle(String title) {
        if (bookTitles.contains(title)) {
            System.out.println("Book titled '" + title + "' is available in the library.");
        } else {
            System.out.println("Book titled '" + title + "' is not available in the library.");
        }
    }

    // List all book titles
    public void listBookTitles() {
        if (bookTitles.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("List of books in the library:");
            for (String title : bookTitles) {
                System.out.println(title);
            }
        }
    }

    // Sort book titles alphabetically
    public void sortBookTitles() {
        Collections.sort(bookTitles);
        System.out.println("Books have been sorted alphabetically.");
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book Title");
            System.out.println("2. Remove Book Title");
            System.out.println("3. Search Book Title");
            System.out.println("4. List All Book Titles");
            System.out.println("5. Sort Book Titles");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String addTitle = scanner.nextLine();
                    library.addBookTitle(addTitle);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBookTitle(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBookTitle(searchTitle);
                    break;
                case 4:
                    library.listBookTitles();
                    break;
                case 5:
                    library.sortBookTitles();
                    break;
                case 6:
                    System.out.println("Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}
