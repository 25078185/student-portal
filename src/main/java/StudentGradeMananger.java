/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//package com.mycompany.studentgrademananger;

/**
 *
 * @author Lwando
 */
import java.util.*;

class Student {
    
private String name;
    private int[] marks;

    // Constructor
     Student (String name, int[] marks) {
        this.name = name;
        this.marks = marks;

    }


    // Calculate average
    public double getAverage() {
        int sum = 0;
        for (int marks : marks) {
            sum += marks;
        }
        return sum /marks.length;
    }

    // Get grade
    public String getGrade() {
        double avg = getAverage();

        if (avg >= 75) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 50) return "C";
        else return "F";
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }

}


public class StudentGradeMananger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter mark " + (j+1) + ": ");
                marks[j] = sc.nextInt();
            }
            sc.nextLine();

            students[i] = new Student(name, marks);
        }

        // Display results
        System.out.println("\n--- Results ---");

        Student topStudent = students[0];

        for (Student s : students) {
            System.out.print("\nName: " + s.getName());
            System.out.print("\nMarks: ");

            for (int m : s.getMarks()) {
                System.out.print(m + " ");
            }

            System.out.println("\nAverage: " + s.getAverage());
            System.out.println("Grade: " + s.getGrade());

            // Find top student
            if (s.getAverage() > topStudent.getAverage()) {
                topStudent = s;
            }
        }

        // Display top student
        System.out.println("\n--- Top Student ---");
        System.out.println(topStudent.getName() + " with " + topStudent.getAverage());
    }
}
