package ir.ahuratus.task2;
import java.util.*;
public class Course
{
	String title;
	TeachingTeam tt = new TeachingTeam();
	ArrayList<Integer>   studentsID   = new ArrayList<Integer>();
	ArrayList<Grade>     grades       = new ArrayList<Grade>();
	public Course() {};
	public Course(String Title,ArrayList<Student> students,ArrayList<Professor> professors,ArrayList<Tutor> tutors,ArrayList<TA> TAs) 
	{
		this.title = Title;
		for (TA        ta        : TAs)        this.tt.tutorsID.add(ta.ID);
		for (Tutor     tutor     : tutors)     this.tt.tutorsID.add(tutor.ID);
		for (Professor professor : professors) this.tt.professorsID.add(professor.ID);
		for (Student   student   : students)   this.studentsID.add(student.ID);
		
	}
	public boolean set_Grade(Grade grade)
	{
		try {
			grades.add(grade);
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}

}
