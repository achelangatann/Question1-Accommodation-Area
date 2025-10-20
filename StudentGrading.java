

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package vu.studentgrading;
import java.util.Scanner;

public class StudentGrading {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student's score (0–100): ");
        int score = input.nextInt();
        int grade;
        String remark;

        if (score >= 80 && score <= 100) {
            grade = 1; remark = "Distinction";
        } else if (score >= 75) {
            grade = 2; remark = "Distinction";
        } else if (score >= 66) {
            grade = 3; remark = "Credit";
        } else if (score >= 60) {
            grade = 4; remark = "Credit";
        } else if (score >= 50) {
            grade = 5; remark = "Credit";
        } else if (score >= 45) {
            grade = 6; remark = "Credit";
        } else if (score >= 35) {
            grade = 7; remark = "Pass";
        } else if (score >= 30) {
            grade = 8; remark = "Pass";
        } else {
            grade = 9; remark = "Fail";
        }

        System.out.println("\n--- Student Result ---");
        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade);
        System.out.println("Remark: " + remark);
    }
}
