package ir.ahuratus.task3.q1;

public class Q1Main {
    public static void main(String[] args) {
        QuestionOne q1;
        q1 = new QuestionOne();
        /* q1.A = 12;     */     // WRONG! :>>  field A is a constant value @Class "QuestionOne" so it can not be reassigned
        q1.b = 12;          // CORRECT!
        /* q1.c = 12;     */ // WRONG! :>> field C is a private field @class "QuestionOne" thus it cant be reassigned!
        /* q1.methodOne(12); */// WRONG! :>> "MethodOne"@Class "QuestionOne" has a private modifier so it can't be used @Class "Q1Main"
        /* q1.methodOne(); */   // WRONG! :>> "MethodOne"@Class "QuestionOne" has a private modifier so it can't be used @Class "Q1Main"
        /* System.out.println(q1.methodTwo(12));*/// Wrong! :>>"methodTwo" @class "QuestionOne" Does not receive an argument!
        /*q1.c = q1.methodTwo();*/// WRONG! :  >>  field C is a private field @class "QuestionOne" thus it cant be reassigned!
    }
}