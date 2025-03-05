package uni;

import java.util.ArrayList;

public class Student {
    public int id;
    private static int idCounter = 1;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentID;
    public int studentCode;

    public Student(int personID, int entranceYear, int majorID){
        this.id = idCounter++;
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        setStudentCode();
        studentList.add(this);
    }

    public static Student findById(int id){
        for(Student student : studentList)
            if(student.id == id)
                return student;
        return null;
    }

    public void  setStudentCode(){
        this.studentCode = (entranceYear * 10000) + (majorID * 100) + (this.id);
    }

}