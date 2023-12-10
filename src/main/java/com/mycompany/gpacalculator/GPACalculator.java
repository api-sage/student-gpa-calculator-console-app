/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gpacalculator;

/**
 *
 * @author Paul Afolabi
 */
public class GPACalculator {

    public static void main(String[] args) {
        StudentCourseRecord newStudent = new StudentCourseRecord();
        StudentScoreRecord newStudentScore = new StudentScoreRecord();
        CourseCreditUnit studentCreditUnit = new CourseCreditUnit();
        StudentGPAService newStudentService = new StudentGPAService();
        
        newStudentService.getStudentRecordInput(newStudent, newStudentScore, studentCreditUnit);
        String[] studentGrades = newStudentService.getStudentGrades(newStudentScore);
        int[] studentGradeUnit = newStudentService.getStudentGradeUnits(studentGrades);
        int[] studentQualityPoints = newStudentService.getStudentQualityPoints(studentCreditUnit, studentGradeUnit);
        double studentGPA = newStudentService.getStudentGPA(studentGradeUnit, studentQualityPoints);
        
        System.out.println("|----------------------------|-----------------------|------------|---------------------|---------------------|");
        System.out.println("|----- COURSE & CODE --------|----- COURSE UNIT -----|--- GRADE --|---- GRADE-UNIT -----|--- QUALITY POINTS --|");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|---------------------|");
        System.out.printf("| %s                          |           %d          |     %s     |           %d        |         %d          |\n", newStudent.course1, studentCreditUnit.creditUnit1, studentGrades[0], studentGradeUnit[0], studentQualityPoints[0]);
        System.out.printf("| %s                          |           %d          |     %s     |           %d        |         %d          |\n", newStudent.course2, studentCreditUnit.creditUnit2, studentGrades[1], studentGradeUnit[1], studentQualityPoints[1]);
        System.out.printf("| %s                          |           %d          |     %s     |           %d        |         %d          |\n", newStudent.course3, studentCreditUnit.creditUnit3, studentGrades[2], studentGradeUnit[2], studentQualityPoints[2]);
        System.out.printf("| %s                          |           %d          |     %s     |           %d        |         %d          |\n", newStudent.course4, studentCreditUnit.creditUnit4, studentGrades[3], studentGradeUnit[3], studentQualityPoints[3]);
        System.out.printf("| %s                          |           %d          |     %s     |           %d        |         %d          |\n", newStudent.course5, studentCreditUnit.creditUnit5, studentGrades[4], studentGradeUnit[4], studentQualityPoints[4]);
        
        System.out.printf("Your GPA is = %s to 2 decimal places", studentGPA);
        
    }
}
