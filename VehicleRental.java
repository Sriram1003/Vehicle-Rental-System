import java.util.Scanner;
class Vehicle {
    private String type;
    private double pricePerDay;
    public Vehicle(String type, double pricePerDay) {
        this.type = type;
        this.pricePerDay = pricePerDay;
    }
    public String getType() {
        return type;
    }
    public double getPricePerDay() {
        return pricePerDay;
    }
}
class Car extends Vehicle {
    public Car() {
        super("Car", 2000);
    }
}
class Bike extends Vehicle {
    public Bike() {
        super("Bike", 500);
    }
}
class Reservation {
    private Vehicle vehicle;
    private int days;
    public Reservation(Vehicle vehicle, int days) {
        this.vehicle = vehicle;
        this.days = days;
    }
    public double calculateTotalPrice() {
        return vehicle.getPricePerDay() * days;
    }
    public String getDetails() {
        return "Vehicle: " + vehicle.getType() + "\nDays: " + days + "\nTotal Price: " + calculateTotalPrice()+"Rs";
    }
}
public class VehicleRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vehicle Rental System");
        System.out.println("---------------------");
        System.out.println("Available vehicles:");
        System.out.println("1. Car - 2000 rs/day");
        System.out.println("2. Bike - 500 rs/day");
        System.out.print("Enter the vehicle type (  [1] for Car , [2] for Bike): ");
        int vehicleChoice = scanner.nextInt();
        Vehicle vehicle;
        if (vehicleChoice == 1) {
            vehicle = new Car();
        } else if (vehicleChoice == 2) {
            vehicle = new Bike();
        } else {
            System.out.println("Invalid choice. Exiting...");
            scanner.close();
            return;
        }
        System.out.print("Enter the number of days: ");
        int days = scanner.nextInt();
        if (days <= 0) {
            System.out.println("Invalid number of days. Exiting...");
            scanner.close();
            return;
        }

        Reservation reservation = new Reservation(vehicle, days);
        System.out.println("Reservation Details:");
        System.out.println(reservation.getDetails());

        scanner.close();
    }
}
