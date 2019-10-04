package ir.ahuratus.task3.q2;

import java.util.ArrayList;

public class Group  {
    public  Group (){};
    private String name;
    public ArrayList<Student> Students = new ArrayList<Student>();
    public Group(ArrayList<Student> Students,String Name) {
        this.Students = Students;
        this.name =Name;
    }
    public void addStudent (Student st){
        if (Students.indexOf(st)== -1)
                            Students.add(st);

    }
    public boolean removeStudent (Student st){
       return Students.remove(st);

    }
    public int getNumStudents (){
       return Students.size();

    }
}
