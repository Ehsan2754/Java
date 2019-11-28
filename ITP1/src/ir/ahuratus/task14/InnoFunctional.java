/************************************************
 *
 *    Introduction to Programming |  Week 14
 *
 *    Author : Ehsan Shaghaei
 *
 *    EhsanShaghaei.Ahuratus.ir
 *
 *    Ahuratus.ir
 *
 *    Group : B19-03
 */


package ir.ahuratus.task14;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

public class InnoFunctional {

    public static void main (String [] arg) {

        /**********************************************
         * takes the String input arguments as program input
         */
        ArrayList<String> argList = new ArrayList<String>();

        for (String element: arg)
             argList.add(element);            
        
        System.out.println(getEvenList(argList));


    }

    /*********************************************
     *
     * @param input is an ArrayList of arbitrary type
     * @return   this Methode returns the even Numbers available in the arguments
     */
    public static <T> List<Integer> getEvenList (ArrayList<T> input){



               return functionalFilter(
                       functionalMap(input ,
                               s -> Integer.parseInt((String) s) ),
                       number-> number%2 == 0 )
                       .stream().collect(Collectors.toList());
    }

    /************************************
     *
     * @param list   input list
     * @param f      input function
     * @param <T>    generic type T
     * @param <V>    generic type V
     * @return       returning an Array list of type T
     * returns a list of type T by an Injected function @param f which takes T type to V type
     */
    public static <T,V> ArrayList<T> functionalMap(ArrayList<V> list, Function<V, T> f){
        ArrayList<T> ans = new ArrayList<T>();
        for(V v: list){
            T value = f.apply(v);
            ans.add(value);
        }
        return ans;
    }

    /*********************************
     *
     * @param l     input List
     * @param p     predicate of type p
     * @param <T>   generic type T
     * @return      returning the list @param L that the items which predicate @param p couldn't be applied was removed.
     */
    public static <T> ArrayList<T> functionalFilter(ArrayList<T> l, Predicate<T> p){
        ArrayList<T> ans = l;
        ans.removeIf(t -> !p.test(t));
        return ans;
    }


}
