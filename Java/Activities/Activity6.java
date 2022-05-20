package Activities;

public class Activity6 {
    public static void main (String[] args){
        Plane plane = new Plane(10);
        plane.onboard("Priya");
        plane.onboard("Raj");
        plane.onboard("John");
        plane.onboard("Mike");

        System.out.println("Plane take-off time is: "+plane.takeOff());
        System.out.println("Passengers onboarded the plane: "+plane.getPassengers());
        //Thread.sleep(5000);
        try
        {
            Thread.sleep(5000);            //this thread sleeps for 1 second
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        plane.land();
        System.out.println("Plane landing time is: "+plane.getLastTimeLanded());
    }
}
