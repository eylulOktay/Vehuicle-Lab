package vehicle;
import java.util.List;

public abstract class  Car {
    private String c_make;
    private String c_model;
    private double c_mileage;
    public Car(String make, String model, double startingMileage){
        c_make = make;
        c_model = model;
        c_mileage = startingMileage;
    }

    public Car(String make, String model){
        this(make,model,0);
    }

    public boolean canDrive(double miles){
        if (miles<0 ){
            throw new IllegalArgumentException("Can't have negative amount");
        }
        
        return miles <= getRemainingRange();

    }
    public abstract void drive(double miles);
    
    public String toString(){
        return getMake() + " " +getModel() + " ("+String.format("%.1f",getMileage())+")";
    }
    public double getMileage(){
        return c_mileage;
    }
    public String getMake(){
        return c_make;
    }
    public String getModel(){
        return c_model;
    }
    public abstract double getRemainingRange();
    protected void addMileage(double miles){
        if (miles<0){
            throw new IllegalArgumentException("Can't have negative amount");
        }
        c_mileage += miles;
    }
    public int roadTrip(List<Double> milesEachDay){
        for (Double miles : milesEachDay){
            if (miles<0){
                throw new IllegalArgumentException("Can't have negative amount");
            }
        }
        int numdays =0;
        for (;canDrive(milesEachDay.get(numdays));numdays++){
            drive(milesEachDay.get(numdays));
        }
        return numdays;
    }
}
