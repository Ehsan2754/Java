package ir.ahuratus.task3.q2;



public class Professor extends Person{

    private Integer yearsExperience ;
    public Professor (){};
    public Professor (String name,String family,Integer pId,Integer ID,Integer YearsOfExperience){
        super(name, family, pId, ID);
        this.yearsExperience = YearsOfExperience;

    }

    public boolean isExperienced(){
        if (yearsExperience>5)return true;
        else return false;
    }

}
