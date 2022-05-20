package Activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args){
        HashMap<Integer,String> colours=new HashMap<Integer, String>();
        colours.put(1,"Red");
        colours.put(2,"Pink");
        colours.put(3,"Orange");
        colours.put(4,"Green");
        colours.put(5,"Yellow");

        System.out.println("Original Colours map : "+colours);
        colours.remove(2);
        System.out.println("Verifying colour Green in map : "+colours.containsValue("Green"));
        System.out.println("Verifying colour Blue in map : "+colours.containsValue("Blue"));

        System.out.println("Updated size of map : "+colours.size());
        System.out.println("Updated Colours map : "+colours);
    }
}
