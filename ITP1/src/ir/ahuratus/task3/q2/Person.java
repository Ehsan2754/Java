package ir.ahuratus.task3.q2;

public class Person {
    protected String firstName;
    protected String secondName;
    protected Integer personId;
    private   Integer ID;
    public Person(){};
    public Person (String name,String family,Integer pId,Integer ID){
        this.firstName = name;
        this.secondName = family;
        this.personId = pId;
        this.ID = ID;
    }
    public  String getFullName() {return firstName+' '+secondName;}
    public  String getFullName(boolean reverse) {
        if(reverse)return secondName+' '+firstName;
        else  return firstName+' '+secondName;
    }
    @Override
    public String toString()     {
        return firstName+' '+secondName;
    }
}
