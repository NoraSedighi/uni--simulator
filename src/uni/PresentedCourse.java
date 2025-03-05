package uni;

import java.util.ArrayList;

public class PresentedCourse {
    private static int idCounter = 0;
    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int capacity;
    public static ArrayList<Integer> studentIds;

    public PresentedCourse(int courseID, int professorID, int maxCapacity){
        this.id = idCounter++;
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = maxCapacity;
        studentIds = new ArrayList<>();
        presentedCourseList.add(this);
    }

    public static PresentedCourse findById(int id){
        for(PresentedCourse presentedCourse : presentedCourseList)
            if(presentedCourse.courseID == id)
                return presentedCourse;
        return null;
    }

    public void addStudent(int studentID){
        if(studentIds.size() < this.capacity)
            studentIds.add(studentID);
        else
            System.out.println("Course is full!");
    }

    public ArrayList<Integer> getStudentIds() {
        return studentIds;
    }

}