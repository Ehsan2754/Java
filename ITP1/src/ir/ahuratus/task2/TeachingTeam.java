package ir.ahuratus.task2;

import java.util.ArrayList;

public class TeachingTeam {
	
	ArrayList<Integer>   professorsID = new ArrayList<Integer>();
	ArrayList<Integer>   tutorsID     = new ArrayList<Integer>();
	ArrayList<Integer>   TAsID        = new ArrayList<Integer>();
	public TeachingTeam() {};
	public TeachingTeam(ArrayList<Student> students,ArrayList<Professor> professors,ArrayList<Tutor> tutors,ArrayList<TA> TAs) 
	{
		for (TA        ta        : TAs)        tutorsID.add(ta.ID);
		for (Tutor     tutor     : tutors)     tutorsID.add(tutor.ID);
		for (Professor professor : professors) professorsID.add(professor.ID);
		
		
	}

}
