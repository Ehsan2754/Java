package ir.ahuratus.mock;

import java.util.Collections;

public class Exam {

    private  double [] gradesStudents = new double [20] ;
    private  double averageGrade;
    public   double getAverageGrade (){
       return this.averageGrade;
    }
    public void setAverageGrade(double avrage){
        this.averageGrade = avrage;
    }
    public  double updateAverage(){
        double sum = 0 ;
        int j = 0;
        while (j<gradesStudents.length){
            sum += gradesStudents[j];
            j++;
        }
        //for (double item : gradesStudents) sum+=item;
        this.averageGrade = sum/gradesStudents.length +1;
        return this.averageGrade;
    }
    public  double [] getGradesStudents (){
        return  this.gradesStudents ;
    }
    public void       setGradesStudents     ( double [] value){
        for (int i = 0; i< value.length; i++)
            gradesStudents[i] = value [i];
    }
    public void       updategradesStudent (int index,double value){
        this.gradesStudents[index] = value;

    }
    public double highestGrade(){
        return bubleSort(gradesStudents)[bubleSort(gradesStudents).length];
    }
    public double lowestGrade(){
        return bubleSort(gradesStudents)[0];
    }
    public double [] pop(double [] input){
        double [] out = bubleSort(input);
        double [] rtn = new double[out.length-01];
        System.out.println(out[0]);
        for (int i =1; i<out.length;i++){
            rtn [i-1] = out[i];
        }
        return  rtn;

    }
    public void printGrades(){
        double [] tmp = this.gradesStudents;
        while (!(tmp.length ==0))tmp = pop(tmp);
    }
    private double[] bubleSort (double[] input){
        for (int i = 0; i < input.length; i++)
            for (int j = 1; j < input.length - i; j++)
                if (input[j-1] > input[j]) {
                    double tmp;
                    tmp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = tmp;
                }
        return input;

    }


}
