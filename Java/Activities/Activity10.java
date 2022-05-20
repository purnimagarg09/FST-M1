package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main (String[] args){
        HashSet<String> hash = new HashSet<>();
        hash.add("Item1");
        hash.add("Item2");
        hash.add("Item3");
        hash.add("Item4");
        hash.add("Item5");
        hash.add("Item6");

        System.out.println("Initial HashSet: " + hash);
        System.out.println("Initial HashSet Size: "+hash.size());
        System.out.println("Removing Item4 from set : "+hash.remove("Item4"));
        System.out.println("Removing Item8 from set : "+hash.remove("Item8"));

        System.out.println("Verifying Item3 in set : "+hash.contains("Item3"));
        System.out.println("Verifying Item4 in set : "+hash.contains("Item4"));

        System.out.println("Final HashSet: " + hash);

    }
}
