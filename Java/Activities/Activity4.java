package Activities;

public class Activity4 {
    public static void main (String[] args){
        int[] arr= {8,4,6,9,2,5};

        System.out.println("Array elements before sorting: ");
        printArray(arr);
        sortArray(arr);
        System.out.println("Array elements after sorting: ");
        printArray(arr);
    }

    public static void sortArray(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array [j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] a){

        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");

        System.out.println();
    }
}
