import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[100];
        int count = 0;

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    books[count] = new Book(id, title, author);
                    count++;

                    System.out.println("Book Added Successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("\nBook List:");
                        for (int i = 0; i < count; i++) {
                            System.out.println("--------------------------------");
                            System.out.println("ID      : " + books[i].id);
                            System.out.println("Title   : " + books[i].title);
                            System.out.println("Author  : " + books[i].author);
                            System.out.println("Status  : " + (books[i].issued ? "Issued" : "Available"));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].id == searchId) {
                            System.out.println("Book Found");
                            System.out.println("Title : " + books[i].title);
                            System.out.println("Author: " + books[i].author);
                            System.out.println("Status: " + (books[i].issued ? "Issued" : "Available"));
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Book Not Found!");
                    break;

                case 4:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();

                    found = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].id == issueId) {
                            found = true;

                            if (!books[i].issued) {
                                books[i].issued = true;
                                System.out.println("Book Issued Successfully!");
                            } else {
                                System.out.println("Book is Already Issued.");
                            }
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Book Not Found!");
                    break;

                case 5:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();

                    found = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].id == returnId) {
                            found = true;

                            if (books[i].issued) {
                                books[i].issued = false;
                                System.out.println("Book Returned Successfully!");
                            } else {
                                System.out.println("Book was not Issued.");
                            }
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Book Not Found!");
                    break;

                case 6:
                    System.out.println("Thank You for Using Library Management System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}