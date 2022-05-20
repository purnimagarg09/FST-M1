package Activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomScannerActivity {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();

        System.out.println("Enter Integers");
        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        Integer nums[] = list.toArray(new Integer[0]);
        System.out.println("Array length: " + nums.length);
        int max = indexGen.nextInt(nums.length);
        System.out.println("Index value generated: " + max);
        System.out.println("Value in array at index value: " + nums[max]);

        scan.close();
    }
}
