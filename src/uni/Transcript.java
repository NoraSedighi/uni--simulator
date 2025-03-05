package uni;

import java.util.HashMap;
import base.Person;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int studentID){
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }

    public void setGrade(int presentedCourseID, double grade){
        PresentedCourse presentedCourse = PresentedCourse.findById(presentedCourseID);
        if (presentedCourse == null) {
            System.out.println("Course not found for ID: " + presentedCourseID);
            return;
        }
        if (!presentedCourse.studentIds.contains(studentID)) {
            System.out.println("Student not found in the course!");
            return;
        }
        transcript.put(presentedCourseID, grade);
    }

    public void printTranscript(){
        Student student = Student.findById(studentID);
        if(student == null) {
            System.out.println("Student not found!");
            return;
        }

        Person person = Person.findByID(student.personID);
        if(person == null){
            System.out.println("Person's details not found!");
            return;
        }

        System.out.println("Student Name: " + person.name);
        System.out.println("Student Code: " + student.studentCode);

        if(transcript.isEmpty())
            System.out.println("No grades available for studentID: " + studentID);
        else{
            for(int presentedCourseID : transcript.keySet()) {
                Course course = Course.findById(presentedCourseID);
                if(course != null)
                    System.out.println(course.getTitle() + " : " + transcript.get(presentedCourseID));
                else
                    System.out.println("Course not found for ID: " + presentedCourseID);
            }
        }
    }

    public double getGPA(){
        if (transcript.isEmpty()) {
            System.out.println("No grades available to calculate GPA.");
            return 0.0;
        }

        double totalGrade = 0.0;
        int totalCredit = 0;

        for(int presentedCourseID : transcript.keySet()){
            Course course = Course.findById(presentedCourseID);
            if(course == null){
                System.out.println("Course not found for ID: " + presentedCourseID);
                continue;
            }

            int credits = course.getCredits();
            double grade = transcript.get(presentedCourseID);
            totalGrade += grade * credits;
            totalCredit += credits;

        }

        if (totalCredit == 0) {
            System.out.println("No credits available to calculate GPA.");
            return 0.0;
        }

        return totalGrade / totalCredit;
    }

}