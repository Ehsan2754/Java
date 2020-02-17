package Spring2020.DSA3;

import java.util.*;

public class DSA3B {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int n = user.nextInt();
        user.nextLine();
        Map<String, Integer> dictionary = new HashMap<>();
        for (String input :
                user.nextLine().split(" ")) {
            dictionary.putIfAbsent(input, 0);
        }
        int m = user.nextInt();
        int i = 0;
        user.nextLine();

        Map<Integer, String> output = new HashMap<>();
        for (String input :
                user.nextLine().split(" ")) {
            if (output.containsValue(input))
                continue;
            if (!dictionary.containsKey(input)) {
                output.putIfAbsent(i++,input);
            }
        }
        System.out.println(output.size());
        for (int j = 0; j < output.size(); j++) {
            System.out.println(output.get(j));
        }
    }
}
//    public static void main(String[] args) {
//        Scanner user = new Scanner(System.in);
//        user.nextLine();
//        final String [] dict = user.nextLine().split(" ");
//        user.nextLine();
//        String [] rawData = user.nextLine().split(" ");
//        ArrayList<String> output = new ArrayList<>();
//        for(int i = 0; i<rawData.length; i++){
//            boolean existsInDictionary = false;
//            if (output.contains(rawData[i]))continue;
//            for(int j = 0; j<dict.length; j++){
//                if (rawData[i].equals(dict[j])){
//                    existsInDictionary = true;
//                    break;
//                }
//            }
//            if (!existsInDictionary)
//                if(!output.contains(rawData[i]))
//                    output.add(rawData[i]);
//        }
//        System.out.println(output.size());
//        for(int j = 0; j<output.size();j++){
//            System.out.println(output.get(j));
//        }
//
//    }