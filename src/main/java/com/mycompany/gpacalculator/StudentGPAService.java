/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gpacalculator;

import java.util.Scanner;

/**
 *
 * @author Paul Afolabi
 */
public class StudentGPAService {

    private final double[] studentScores;
    private final String[] studentGrades;
    private final int[] studentGradeUnits;
    private final int[] studentCreditUnits;
    private final int[] studentQualityPoints;
    private final Scanner studentInput;
    
    
    public StudentGPAService(){
        studentScores = new double[5];
        studentGrades = new String[5];
        studentGradeUnits = new int[5];
        studentCreditUnits = new int[5];
        studentQualityPoints = new int[5];
        studentInput = new Scanner(System.in);
    }
    
    public void getStudentRecordInput(StudentCourseRecord newStudent, 
            StudentScoreRecord newStudentScore, 
            CourseCreditUnit studentCreditUnit){
        try{
            int count = 1;

            System.out.printf("Enter course %d: ", count);
            newStudent.course1 = studentInput.nextLine();
            System.out.printf("Enter score for course %d: ", count);
            newStudentScore.score1 = studentInput.nextDouble();
            System.out.printf("Enter credit unit for course %d: ", count++);
            studentCreditUnit.creditUnit1 = studentInput.nextInt();

            System.out.printf("Enter course %d: ", count);
            newStudent.course2 = studentInput.next();
            System.out.printf("Enter score for course %d: ", count);
            newStudentScore.score2 = studentInput.nextDouble();
            System.out.printf("Enter credit unit for course %d: ", count++);
            studentCreditUnit.creditUnit2 = studentInput.nextInt();

            System.out.printf("Enter course %d: ", count);
            newStudent.course3 = studentInput.next();
            System.out.printf("Enter score for course %d: ", count);
            newStudentScore.score3 = studentInput.nextDouble();
            System.out.printf("Enter credit unit for course %d: ", count++);
            studentCreditUnit.creditUnit3 = studentInput.nextInt();

            System.out.printf("Enter course %d: ", count);
            newStudent.course4 = studentInput.next();
            System.out.printf("Enter score for course %d: ", count);
            newStudentScore.score4 = studentInput.nextDouble();
            System.out.printf("Enter credit unit for course %d: ", count++);
            studentCreditUnit.creditUnit4 = studentInput.nextInt();

            System.out.printf("Enter course %d: ", count);
            newStudent.course5 = studentInput.next();
            System.out.printf("Enter score for course %d: ", count);
            newStudentScore.score5 = studentInput.nextDouble();
            System.out.printf("Enter credit unit for course %d: ", count);
            studentCreditUnit.creditUnit5 = studentInput.nextInt();
            
        } catch(Exception ex){
            System.out.printf("An invalid input error occurred :: %s ", ex.getMessage());
        }
    }
    
    public String[] getStudentGrades(StudentScoreRecord  studentScoreRecord){
        
        studentScores[0] = studentScoreRecord.score1;
        studentScores[1] = studentScoreRecord.score2;
        studentScores[2] = studentScoreRecord.score3;
        studentScores[3] = studentScoreRecord.score4;
        studentScores[4] = studentScoreRecord.score5;
        
        for (int i = 0; i < studentScores.length; i++) {
            if (studentScores[i] >= 70) {
                studentGrades[i] = "A";
            } else if (studentScores[i] >= 60) {
                studentGrades[i] = "B";
            } else if (studentScores[i] >= 50) {
                studentGrades[i] = "C";
            } else if (studentScores[i] >= 45) {
                studentGrades[i] = "D";
            } else if (studentScores[i] >= 40) {
                studentGrades[i] = "E";
            } else{
                studentGrades[i] = "F";
            }
        }
        
        return studentGrades;
    }
    
    public int[] getStudentGradeUnits(String[] studentGrades){
        int i = 0;
        for (String grade : studentGrades ) {
            switch (grade){
                case "A":
                    studentGradeUnits[i] = 5;
                    break;
                case "B":
                    studentGradeUnits[i] = 4;
                    break;
                case "C":
                    studentGradeUnits[i] = 3;
                    break;
                case "D":
                    studentGradeUnits[i] = 2;
                    break;
                case "E":
                    studentGradeUnits[i] = 1;
                    break;
                case "F":
                    studentGradeUnits[i] = 0;
                    break;
                default:
                    studentGradeUnits[i] = 0;
                    break;
            }
            i++;
        }
        
        return studentGradeUnits;
    }
    
    public int[] getStudentQualityPoints(CourseCreditUnit studentUnits, int[] studentGradeUnits){
        studentCreditUnits[0] = studentUnits.creditUnit1;
        studentCreditUnits[1] = studentUnits.creditUnit2;
        studentCreditUnits[2] = studentUnits.creditUnit3;
        studentCreditUnits[3] = studentUnits.creditUnit4;
        studentCreditUnits[4] = studentUnits.creditUnit5;
        
        for (int i = 0; i < 5; i++) {
            studentQualityPoints[i] = studentCreditUnits[i] * studentGradeUnits[i];
        }
        
        return studentQualityPoints;
    }
    
    public double getStudentGPA(int[] studentGradeUnits, int[] studentQualityPoints){
        double studentGPA;
        int studentTotalUnits = 0;
        int studentTotalQualityPoints = 0;
        
        for(int unit : studentGradeUnits){
            studentTotalUnits += unit;
        }
        
        for(int point : studentQualityPoints){
            studentTotalQualityPoints += point;
        }
        
        studentGPA = ((double)studentTotalQualityPoints/(double)studentTotalUnits);
        
        return studentGPA;
    }
}
