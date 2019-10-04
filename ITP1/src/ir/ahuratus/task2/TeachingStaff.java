package ir.ahuratus.task2;

public class TeachingStaff extends UniStaff {

	int ID;
	double salary;
	public TeachingStaff(String firstName, String lastName, Date birthday,int ID,eduLevel x,double salary) {
		super(firstName, lastName, birthday,x);
		this.ID = ID;
		this.salary = salary;
		
		
		}

	

}
