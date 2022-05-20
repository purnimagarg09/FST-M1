package Activities;

public class Activity2 {

    public static void main (String[] args) {
        int[] a = {10, 77, 10, 54, -11, 10} ;

        System.out.println("Result = "+checkSum(a));
    }
    public static boolean checkSum ( int[] arr){
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 10)
                    sum += arr[i];
            }

            if(sum==30)
                return true;
            else
                return false;

    }
}
