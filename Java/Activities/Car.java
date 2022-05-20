package Activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car(){
        tyres=4;
        doors=4;
    }

    public void displayCharacteristics(){
        System.out.println("Car is of "+color+" color");
        System.out.println("Car's transmission is "+transmission);
        System.out.println("Car's make is "+make);
        System.out.println("Car has "+tyres+" tyres");
        System.out.println("Car has "+doors+" doors");
    }

    public void accelerate(){
        System.out.println("Car is moving forward.");
    }

    public void brake(){
        System.out.println("Car has stopped.");
    }
}
