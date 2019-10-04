package ir.ahuratus.task3.q2;

import ir.ahuratus.task2.Tutor;

import java.util.ArrayList;

public class Course {
    public String title;
    public ArrayList <Integer> students = new ArrayList<Integer>();
    public ArrayList<Integer>   professorsID = new ArrayList<Integer>();
    public ArrayList<Integer>   TAsID     = new ArrayList<Integer>();
    public ArrayList<Integer>   LMsID        = new ArrayList<Integer>();
    public Course() {};
    public Course(String Title,ArrayList<Student> students,ArrayList<Professor> professors,ArrayList<LabMentor> lms,ArrayList<TeacherAssistant> TAs)
    {
        this.title = Title;
        for (TeacherAssistant ta        : TAs)        this.TAsID.add(ta.personId);
        for (LabMentor lm     :lms)     this.LMsID.add(lm.personId);
        for (Professor professor : professors) this.professorsID.add(professor.personId);
        for (Student   student   : students)   this.students.add(student.personId);

    }
    /*****************************************************/
    public void addStudent (Student st){
        if (students.indexOf(st.personId)== -1)
            students.add(st.personId);

    }
    public boolean removeStudent (Student st){
        return students.remove(st.personId);

    }
    public int getNumStudents (Student st){
        return students.size();

    }
    /****************************************************/
    public void addProfessor (Professor st){
        if (professorsID.indexOf(st.personId)== -1)
            professorsID.add(st.personId);

    }
    public boolean removeStudent (Professor st){
        return professorsID.remove(st.personId);

    }
    public int getNumStudents (){
        return students.size();
    }
    /******************************************************/
    public void addLabMentor (LabMentor st){
        if (LMsID.indexOf(st.personId)== -1)
            LMsID.add(st.personId);

    }
    public boolean removeLabMentor (LabMentor st){
       return LMsID.remove(st.personId);

    }
    public int getNumLabMentors (LabMentor st){
        return LMsID.size();

    }
    /*******************************************************/
    public void addTeacherAssistant (TeacherAssistant st){
        if (TAsID.indexOf(st.personId)== -1)
            TAsID.add(st.personId);

    }
    public void removeTeacherAssistant (TeacherAssistant st){
       TAsID.remove(st.personId);

    }
    public int getNumTeacherAssistant (TeacherAssistant st){
        return TAsID.size();

    }


}
