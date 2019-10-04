package ir.ahuratus.task2;

public class Person {

	String name;
	String surname;
	Date   birthday = new Date();
		public Person(String firstName,String lastName, Date birthday)
		{
			this.name     = firstName;
			this.surname  = lastName;
			this.birthday = birthday;
		}

}
