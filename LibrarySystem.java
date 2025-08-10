import java.util.*;

class Book {
    String id, title, author;
    boolean issued = false;
    
    Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    
    @Override
    public String toString() {
        return id + " - " + title + " by " + author + (issued ? " [ISSUED]" : " [AVAILABLE]");
    }
}

public class LibrarySystem {
    static List<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Sample books
        books.add(new Book("B1", "Java Basics", "John"));
        books.add(new Book("B2", "Python Guide", "Alice"));
        books.add(new Book("B3", "Web Development", "Bob"));
        
        while (true) {
            System.out.println("\n=== LIBRARY SYSTEM ===");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            switch (choice) {
                case 1 -> viewBooks();
                case 2 -> addBook();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> { 
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
    
    static void viewBooks() {
        System.out.println("\n--- ALL BOOKS ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    static void addBook() {
        System.out.print("Book ID: ");
        String id = sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }
    
    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        String id = sc.nextLine();
        
        for (Book book : books) {
            if (book.id.equals(id)) {
                if (!book.issued) {
                    book.issued = true;
                    System.out.println("Book issued: " + book.title);
                    return;
                } else {
                    System.out.println("Book already issued!");
                    return;
                }
            }
        }
        System.out.println("Book not found!");
    }
    
    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        String id = sc.nextLine();
        
        for (Book book : books) {
            if (book.id.equals(id)) {
                if (book.issued) {
                    book.issued = false;
                    System.out.println("Book returned: " + book.title);
                    return;
                } else {
                    System.out.println("Book was not issued!");
                    return;
                }
            }
        }
        System.out.println("Book not found!");
    }
}