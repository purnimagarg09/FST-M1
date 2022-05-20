package Activities;

public class MountainBike extends Bicycle{
    int seatHeight;

    MountainBike(int gears, int speed, int seatHeight){
        super(gears,speed);
        this.seatHeight=seatHeight;
    }

    public void setHeight(int height) {
        seatHeight = height;
    }

    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed + "\nSeat Height of bicycle is " + seatHeight);
    }
}
