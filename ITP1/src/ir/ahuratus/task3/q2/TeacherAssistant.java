package ir.ahuratus.task3.q2;



public class TeacherAssistant extends Person{

    public String Degree ;
    private boolean ProfessionalFlag;
    public TeacherAssistant (){};
    public TeacherAssistant (String name,String family,Integer pId,Integer ID,String degree,boolean pro){
        super(name, family, pId, ID);
        this.Degree = degree;
        this.ProfessionalFlag = pro;

    }


    public boolean isCool(){
        return ProfessionalFlag;
    }

}
