package ir.ahuratus.task2;

public class UniStaff extends Person {
	eduLevel x;

	public UniStaff(String firstName, String lastName, Date birthday,eduLevel degree) {
		super(firstName, lastName, birthday);
		x = degree;
	}
	
	

}
