package uni;

import java.util.ArrayList;

public class Course {
    private static int idCounter = 0;
    public int id;
    public static ArrayList<Course> courseList = new ArrayList<>();
    public String title;
    public int units;

    public Course(String title, int units){
        this.id = idCounter++;
        this.title = title;
        this.units = units;
        courseList.add(this);
    }

    public static Course findById(int id){
        for(Course course : courseList)
            if(course.id == id)
                return course;
        return null;
    }

    public int getCredits() {
        return this.units;
    }

    public String getTitle() {
        return title;
    }

}