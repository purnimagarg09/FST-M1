package Activities;

import java.sql.SQLOutput;

public class Activity8 {
    public static void main (String[] args){
        try {
            Activity8.exceptionTest("Non-null message");
            Activity8.exceptionTest(null);
        }
        catch(CustomException e){
            System.out.println("Custom Exception message : "+e.getMessage());
        }
    }

    public static void exceptionTest(String m) throws CustomException{
            if(m == null)
                throw new CustomException("String message is null");
            else
                System.out.println("String message is : "+m);
    }

}
