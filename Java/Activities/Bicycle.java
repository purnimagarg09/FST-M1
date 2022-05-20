package Activities;

interface BicycleParts{
    public int gears=0;
    public int speed=0;
}

interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}
public class Bicycle implements BicycleParts,BicycleOperations{
    public int gears;
    public int speed;
    public Bicycle(int gears, int speed){
        this.gears=gears;
        this.speed=speed;
    }

    public void applyBrake(int decrement){
        speed-=decrement;
        System.out.println("Speed after brakes: " + speed);
    }

    public void speedUp(int increment){
        speed+=increment;
        System.out.println("Speed after accelertation: " + speed);
    }

    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
    }
}

