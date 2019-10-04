/***************************************************************************************************************
 * *************************************************************************************************************
 *
 * Introduction to Programming 1
 *          >> Assignment 3
 *              Author :
 *                          Ehsan Shaghaei
 *              Bachelor 2019 - Group 03
 *              Innopolis University
 *              http://github.com/EhsanShaghaei
 *              http://Ahuratus.ir
 *              http://EhsanShaghaei.Ahuratus.ir
 *              e.shaghaei@innopolis.university
 *
 * *************************************************************************************************************
 * *************************************************************************************************************
 */
package ir.ahuratus.task4;

import java.io.*;

import java.util.*;

/************************************************* QUESTION 1 *************************************************/
 public class CauseProblem {
    public static String m1() {
        String result = null;


        try{
                throw new Exception("question 1");
        }
        catch(Exception c){
                result = c.getMessage();
        }
        finally {
            result+="; with finally";
        }

    return result;  
        
    }

 /************************************************* QUESTION 2 *************************************************/
 /////------------->   ProblemException Custom Exception
 public static class ProblemException extends Exception {
     public ProblemException (String arg){
         super(arg);
     }

 }
/////-------------->   Method 2
    public static String m2() {
        String result = null;


        try{
            throw new ProblemException("question 2");
        }
        catch(ProblemException c){
            result = c.getMessage();
        }
        catch(Exception c){
            result = c.getMessage();
        }
        finally {
            result+="; with finally";
        }

        return result;

    }
 /************************************************* QUESTION 3 *************************************************/
 public static void m3() throws ProblemException {
    throw new ProblemException("question 3"); // As we didn't handle this Exception with any type of
     //                                              Exception Handling Equipments such as try,catch;
     //                                                 we must declare that it throws Exception objects!
 }
 /************************************************* QUESTION 4 *************************************************/
 public static void m4()  {
   try {
       Object object = null;
       object.hashCode();
       // as Object object from class "Object" is assigned to null, it doesn't point to any address in the memory;
       // meanwhile method .hashCode() returns the object memory address it points to address null (pointer value
       // of the object "object" thus it causes exception : java.lang.NullPointerException. Consequently, we should
       // handle it.
   } catch (NullPointerException c){
       System.out.println("Exception Handled! : "+ c.toString());
   }
 }
 /************************************************* QUESTION 5 *************************************************/
 //------> f()
 public static void f() throws ProblemException {
     throw new ProblemException("ProblemException from f();");
 }
 //------> g()
 public static void g() throws RuntimeException{
     try {
         f();
     }catch (ProblemException ex){
         throw new RuntimeException("RuntimeException from g();");
     }
 }
 /************************************************* QUESTION 6 *************************************************/
public static void m6(){
    try {
        int a = 10/0;                                                      //>>ArithmeticException
        char [] array = new char [1];
        array[2]  = 'a';                                                   //>>ArrayIndexOutOfBoundsException
        Integer c = null;
        c.hashCode();                                                     //>>NullPointerException
        int b = Integer.parseInt("Hello World!");                      //>>NumberFormatException
        Scanner scan = new Scanner(new File("WrongPath:)"));    //>>FileNotFoundException

    }catch (ArithmeticException ex)
    {
        System.out.println(ex.toString()+" --> "+ex.getMessage());
    }catch (ArrayIndexOutOfBoundsException ex)
    {
        System.out.println(ex.toString()+" --> "+ex.getMessage());
    }catch (NullPointerException ex)
    {
        System.out.println(ex.toString()+" --> "+ex.getMessage());
    }catch (NumberFormatException ex)
    {
        System.out.println(ex.toString()+" --> "+ex.getMessage());
    }catch (FileNotFoundException ex) {
        System.out.println(ex.toString()+" --> "+ex.getMessage());
    }catch (Exception ex){
        System.out.println(ex.toString()+" --> "+ex.getMessage());
    }
}
 /************************************************* Main *******************************************************/
    public static void main(String[] args) {

        System.out.println(CauseProblem.m1());
        System.out.println(CauseProblem.m2());
        try {
            m3();
        }
        catch (ProblemException ex){
            System.out.println(ex.getMessage());
        }
        CauseProblem.m4();
        try {
            CauseProblem.f();
        }
        catch (ProblemException ex){
            System.out.println(ex.getMessage());
        }
        try {
            CauseProblem.g();
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }
        m6();


    }


}
