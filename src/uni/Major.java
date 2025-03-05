package uni;

import java.util.ArrayList;

public class Major {
    public int id;
    private static int idCounter = 0;
    public static ArrayList<Major> majorList = new ArrayList<>();
    public String name;
    public final int capacity;
    public int numberOfStudents = 0;

    public Major(String name, int capacity){
        this.id = idCounter++;
        this.name = name;
        this.capacity = capacity;
        majorList.add(this);
    }

    public static Major findById(int id){
        for(Major major : majorList)
            if(major.id == id)
                return major;
        return null;
    }

    public void addStudent(){
        if(numberOfStudents >= this.capacity)
            System.out.println("max number of students reached!");
        numberOfStudents++;
    }

}