package ir.ahuratus.task2;

import java.util.ArrayList;

public class University {
	
	String name;
	int worldRank;
	ArrayList<eduLevel>     allowedLevels = new ArrayList<eduLevel>();
	
	ArrayList<TeachingTeam> teachingTeams = new ArrayList<TeachingTeam>();
	ArrayList<Integer>      studentsID      = new ArrayList<Integer>();
	ArrayList<Course>       courses       = new ArrayList<Course>();
	public University(String Name,int worldRank,ArrayList<eduLevel> allowedLevels,ArrayList<Student> students,ArrayList<Professor> professors,ArrayList<Tutor> tutors,ArrayList<TA> TAs) 
	{
		this.name          = Name;
		this.worldRank     = worldRank;
		this.allowedLevels = allowedLevels;
		for (Student   student   : students)   this.studentsID.add(student.ID);
		
	}

}

 
 