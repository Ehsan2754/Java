package Spring2020.DSA3;
import java.util.*;

public class DSA3A {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int iteration = user.nextInt();
        user.nextLine();
        String [] raw_data = user.nextLine().split(" ");
        Map<String,Integer>  data = new HashMap<String, Integer>();
        for (int i = 0; i < iteration ; i++) {
            if(data.containsKey(raw_data[i]))
                data.put(raw_data[i],data.get(raw_data[i])+1);
            else data.put(raw_data[i],1);
        }
        ArrayList<Map.Entry<String,Integer>> dataArray = new ArrayList<Map.Entry<String, Integer>>(data.entrySet());
        Collections.sort(dataArray, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                if (!t1.getValue().equals(t2.getValue())) {
                    return t2.getValue() - t1.getValue();
                }
                return t1.getKey().compareTo(t2.getKey());
            }
        });
        for (Map.Entry<String,Integer> arg:
             dataArray) {
            System.out.println(arg.getKey()+" "+arg.getValue());
        };

    }
}
