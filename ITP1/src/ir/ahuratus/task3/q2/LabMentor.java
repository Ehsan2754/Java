package ir.ahuratus.task3.q2;



public class LabMentor extends Person{

    public String Degree ;
    private boolean CoolFlag;
    public LabMentor (){};
    public LabMentor (String name,String family,Integer pId,Integer ID,String degree,boolean cool){
        super(name, family, pId, ID);
        this.Degree = degree;
        this.CoolFlag = cool;

    }


    public boolean isCool(){
        return CoolFlag;
    }

}
