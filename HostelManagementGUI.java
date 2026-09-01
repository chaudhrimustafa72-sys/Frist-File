import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HostelManagementGUI {

    static ArrayList<Student> students = new ArrayList<>();

    static class Student {
        String name;
        int age;
        String course;
        int roomNo;

        Student(String name, int age, String course, int roomNo) {
            this.name = name;
            this.age = age;
            this.course = course;
            this.roomNo = roomNo;
        }

        @Override
        public String toString() {
            return "Name : " + name +
                    "\nAge : " + age +
                    "\nCourse : " + course +
                    "\nRoom No : " + roomNo +
                    "\n----------------------";
        }
    }

    public static void main(String[] args) {
        loginScreen();
    }

    // Login Screen
    static void loginScreen() {

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();

        Object[] message = {
                "Username:", user,
                "Password:", pass
        };

        int option = JOptionPane.showConfirmDialog(null, message,
                "Hostel Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            if (user.getText().equals("Admin") &&
                    new String(pass.getPassword()).equals("1234")) {

                menu();

            } else {

                JOptionPane.showMessageDialog(null,
                        "Invalid Username or Password");
            }
        }
    }

    // Main Menu
    static void menu() {

        while (true) {

            String choice = JOptionPane.showInputDialog(
                    "HOSTEL MANAGEMENT\n\n" +
                            "1. Add Student\n" +
                            "2. View Students\n" +
                            "3. Allocate Room\n" +
                            "4. Search Student\n" +
                            "5. Delete Student\n" +
                            "6. Exit\n\n" +
                            "Enter Choice:");

            if (choice == null) break;

            switch (choice) {

                case "1":
                    addStudent();
                    break;

                case "2":
                    viewStudents();
                    break;

                case "3":
                    allocateRoom();
                    break;

                case "4":
                    searchStudent();
                    break;

                case "5":
                    deleteStudent();
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, "Thank You!");
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "Invalid Choice!");
            }
        }
    }

    // Add Student
    static void addStudent() {

        String name = JOptionPane.showInputDialog("Enter Student Name:");
        int age = Integer.parseInt(
                JOptionPane.showInputDialog("Enter Age:"));
        String course = JOptionPane.showInputDialog("Enter Course:");
        int room = Integer.parseInt(
                JOptionPane.showInputDialog("Enter Room Number:"));

        students.add(new Student(name, age, course, room));

        JOptionPane.showMessageDialog(null,
                "Student Added Successfully!");
    }

    // View Students
    static void viewStudents() {

        if (students.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "No Students Found!");

            return;
        }

        JTextArea area = new JTextArea(15, 30);

        for (Student s : students) {
            area.append(s + "\n");
        }

        area.setEditable(false);

        JOptionPane.showMessageDialog(null,
                new JScrollPane(area),
                "Student List",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Search Student
    static void searchStudent() {

        String name = JOptionPane.showInputDialog("Enter Student Name:");

        for (Student s : students) {

            if (s.name.equalsIgnoreCase(name)) {

                JOptionPane.showMessageDialog(null, s);

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Student Not Found!");
    }

    // Allocate Room
    static void allocateRoom() {

        String name = JOptionPane.showInputDialog("Enter Student Name:");

        for (Student s : students) {

            if (s.name.equalsIgnoreCase(name)) {

                int room = Integer.parseInt(
                        JOptionPane.showInputDialog("Enter New Room Number:"));

                s.roomNo = room;

                JOptionPane.showMessageDialog(null,
                        "Room Allocated Successfully!");

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Student Not Found!");
    }

    // Delete Student
    static void deleteStudent() {

        String name = JOptionPane.showInputDialog("Enter Student Name:");

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).name.equalsIgnoreCase(name)) {

                students.remove(i);

                JOptionPane.showMessageDialog(null,
                        "Student Deleted Successfully!");

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Student Not Found!");
    }
}