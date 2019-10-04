package ir.ahuratus.task2;





public class Student extends UniStaff
{

	int ID;
	GPA gpa;
	
	public Student(int ID,String firstName, String lastName, Date birthday,eduLevel x,GPA gpa)
	{
		super(firstName, lastName, birthday, x);
		this.ID  = ID;
		this.gpa = gpa;
		
	}


}


