import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Student ID
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        // Input: Number of courses
        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();

        int totalCredits = 0;
        int earnedCredits = 0;
        double totalGradePoints = 0;

        System.out.println("\nEnter details for each course:");

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("\nCourse " + i + ":");

            // Input: Course credits
            System.out.print("Credit (Max 3): ");
            int credit = scanner.nextInt();
            totalCredits += credit;

            // Input: Continuous Assessment Marks
            System.out.print("CT (Max 30): ");
            int ctMarks = scanner.nextInt();

            // Input: Assignment Marks
            System.out.print("AT (Max 10): ");
            int atMarks = scanner.nextInt();

            // Input: Final Exam Marks
            System.out.print("FE (Max 60): ");
            int feMarks = scanner.nextInt();

            // Calculate total marks for the course
            int totalMarks = ctMarks + atMarks + feMarks;

            // Calculate GPA for the course
            double gpa;
            if (totalMarks >= 80) {
                gpa = 4.00;
            } else if (totalMarks >= 75) {
                gpa = 3.75;
            } else if (totalMarks >= 70) {
                gpa = 3.50;
            } else if (totalMarks >= 65) {
                gpa = 3.25;
            } else if (totalMarks >= 60) {
                gpa = 3.00;
            } else if (totalMarks >= 55) {
                gpa = 2.75;
            } else if (totalMarks >= 50) {
                gpa = 2.50;
            } else if (totalMarks >= 45) {
                gpa = 2.25;
            } else if (totalMarks >= 40) {
                gpa = 2.00;
            } else {
                gpa = 0.00; // Fail
            }

            // Calculate grade points for the course
            double gradePoints = gpa * credit;
            totalGradePoints += gradePoints;

            // Credits earned
            if (gpa > 0) {
                earnedCredits += credit;
            }

            // Display GPA for the course
            System.out.println("GPA for Course " + i + ": " + gpa);
        }

        // Calculate overall CGPA
        double cgpa = totalGradePoints / totalCredits;
        cgpa = Math.round(cgpa * 100.0) / 100.0; // Round to 2 decimal places

        // Determine overall grade
        String overallGrade;
        if (cgpa == 4.00) {
            overallGrade = "A+";
        } else if (cgpa >= 3.75) {
            overallGrade = "A";
        } else if (cgpa >= 3.50) {
            overallGrade = "A-";
        } else if (cgpa >= 3.25) {
            overallGrade = "B+";
        } else if (cgpa >= 3.00) {
            overallGrade = "B";
        } else if (cgpa >= 2.75) {
            overallGrade = "B-";
        } else if (cgpa >= 2.50) {
            overallGrade = "C+";
        } else if (cgpa >= 2.25) {
            overallGrade = "C";
        } else if (cgpa >= 2.00) {
            overallGrade = "D";
        } else {
            overallGrade = "F";
        }

        // Display final results
        System.out.println("\n--- Final Result ---");
        System.out.println("Student ID: " + studentID);
        System.out.println("Credit Taken: " + totalCredits);
        System.out.println("Credit Earned: " + earnedCredits);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Grade: " + overallGrade);

        scanner.close();
    }
}
