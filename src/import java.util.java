import java.util.ArrayList;
import java.util.Scanner;

class Driver {
    private String name;
    private String vehicle;
    private String licenseNumber;
    private boolean available;

    public Driver(String name, String vehicle, String licenseNumber) {
        this.name = name;
        this.vehicle = vehicle;
        this.licenseNumber = licenseNumber;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Driver: " + name + ", Vehicle: " + vehicle + ", License: " + licenseNumber + ", Available: " + available;
    }
}

class TransportationApp {
    private ArrayList<Driver> drivers;

    public TransportationApp() {
        this.drivers = new ArrayList<>();
    }

    public void registerDriver(String name, String vehicle, String licenseNumber) {
        Driver driver = new Driver(name, vehicle, licenseNumber);
        drivers.add(driver);
        System.out.println("Driver " + name + " has been registered.");
    }

    public void showAvailableDrivers() {
        System.out.println("\nAvailable Drivers:");
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                System.out.println(driver);
            }
        }
    }

    public void bookDriver(String customerName) {
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                driver.setAvailable(false);
                System.out.println("Driver " + driver.getName() + " has been booked for " + customerName + ".");
                return;
            }
        }
        System.out.println("No available drivers at the moment.");
    }

    public void showAllDrivers() {
        System.out.println("\nAll Drivers:");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }
}

public class TransportationAppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransportationApp app = new TransportationApp();

        while (true) {
            System.out.println("\nTransportation App Menu:");
            System.out.println("1. Register Driver");
            System.out.println("2. Show Available Drivers");
            System.out.println("3. Book a Driver");
            System.out.println("4. Show All Drivers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter driver's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter vehicle type: ");
                    String vehicle = scanner.nextLine();
                    System.out.print("Enter license number: ");
                    String license = scanner.nextLine();
                    app.registerDriver(name, vehicle, license);
                    break;
                case 2:
                    app.showAvailableDrivers();
                    break;
                case 3:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    app.bookDriver(customerName);
                    break;
                case 4:
                    app.showAllDrivers();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}