package Activities;

public class Activity7 {
    public static void main (String[] args){
        MountainBike bike = new MountainBike(2,40,10);
        System.out.println(bike.bicycleDesc());
        bike.speedUp(15);
        bike.applyBrake(10);
       // System.out.println("After Acceleration and brakes :"+bike.bicycleDesc());
    }
}
