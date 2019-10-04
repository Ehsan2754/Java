package ir.ahuratus.task3.q2;

import ir.ahuratus.task2.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student extends Person{

private Date dateofBirth;
    public Student (){};
    public Student (String name,String family,Integer pId,Integer ID,Date BirthDate){
        super(name, family, pId, ID);
        this.dateofBirth = BirthDate;

    }
    @Override
    public String toString() {
        return super.toString();
    }
    public Integer getAge(){
       return dateofBirth.yy - LocalDateTime.now().getYear();
    }

}
