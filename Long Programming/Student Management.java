import java.util.*;

class Student {

    int id;
    String name;
    int age;
    String department;

    Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    void display() {
        System.out.println("--------------------------------");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Department : " + department);
    }
}

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        Student s = new Student(id, name, age, dept);

        students.add(s);

        System.out.println("Student Added Successfully.");
    }

    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Student Records.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {

                s.display();

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public static void updateStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        for (Student s : students) {

            if (s.id == id) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Department: ");
                s.department = sc.nextLine();

                System.out.println("Student Updated Successfully.");

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {

                students.remove(s);

                System.out.println("Student Deleted Successfully.");

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

    }
}