package uni;

import java.util.ArrayList;

public class Professor {
    public int id;
    private static int idCounter = 0;
    public static ArrayList<Professor> professorList = new ArrayList<>();
    public int personalID;
    public int majorID;

    public Professor(int personalID, int majorID){
        this.id = idCounter++;
        this.personalID = personalID;
        this.majorID = majorID;
        professorList.add(this);
    }

    public static Professor findById(int id){
        for(Professor professor : professorList)
            if(professor.id == id)
                return professor;
        return null;
    }

}