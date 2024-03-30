import java.util.ArrayList;
import java.util.List;

class Package {
    private String packageId;
    private String destination;
    private double weight;

    public Package(String packageId, String destination, double weight) {
        this.packageId = packageId;
        this.destination = destination;
        this.weight = weight;
    }

    // Getters and setters
}

class Vehicle {
    private String vehicleId;
    private double capacity;
    private List<Package> packages;

    public Vehicle(String vehicleId, double capacity) {
        this.vehicleId = vehicleId;
        this.capacity = capacity;
        this.packages = new ArrayList<>();
    }

    public void loadPackage(Package pkg) {
        if (this.capacity >= pkg.getWeight()) {
            packages.add(pkg);
            this.capacity -= pkg.getWeight();
            System.out.println("Package " + pkg.getPackageId() + " loaded onto vehicle " + this.vehicleId);
        } else {
            System.out.println("Package " + pkg.getPackageId() + " cannot be loaded onto vehicle " + this.vehicleId +
                    ". Insufficient capacity.");
        }
    }

    // Getters and setters
}

class Courier {
    private String courierId;
    private String name;
    private Vehicle vehicle;

    public Courier(String courierId, String name) {
        this.courierId = courierId;
        this.name = name;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        System.out.println("Courier " + this.name + " assigned to vehicle " + vehicle.getVehicleId());
    }

    public void deliverPackage(Package pkg) {
        if (this.vehicle != null) {
            System.out.println("Courier " + this.name + " is delivering package " + pkg.getPackageId() +
                    " to " + pkg.getDestination());
            this.vehicle.getPackages().remove(pkg);
        } else {
            System.out.println("Courier " + this.name + " does not have a vehicle to deliver the package.");
        }
    }

    // Getters and setters
}

class TransportationCompany {
    private String name;
    private List<Vehicle> vehicles;
    private List<Courier> couriers;

    public TransportationCompany(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
        this.couriers = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void addCourier(Courier courier) {
        this.couriers.add(courier);
    }

    public void assignVehicleToCourier(String courierId, String vehicleId) {
        Courier courier = getCourierById(courierId);
        Vehicle vehicle = getVehicleById(vehicleId);
        if (courier != null && vehicle != null) {
            courier.assignVehicle(vehicle);
        } else {
            System.out.println("Courier or vehicle not found.");
        }
    }

    private Courier getCourierById(String courierId) {
        for (Courier courier : couriers) {
            if (courier.getCourierId().equals(courierId)) {
                return courier;
            }
        }
        return null;
    }

    private Vehicle getVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        TransportationCompany company = new TransportationCompany("FastCouriers");

        // Create vehicles
        Vehicle vehicle1 = new Vehicle("V1", 100);
        Vehicle vehicle2 = new Vehicle("V2", 200);
        company.addVehicle(vehicle1);
        company.addVehicle(vehicle2);

        // Create couriers
        Courier courier1 = new Courier("C1", "Uttam");
        Courier courier2 = new Courier("C2", "Dhaval");
        company.addCourier(courier1);
        company.addCourier(courier2);

        // Assign vehicle to courier
        company.assignVehicleToCourier("C1", "V1");

        // Create packages
        Package package1 = new Package("P1", "Destination A", 50);
        Package package2 = new Package("P2", "Destination B", 150);

        // Load packages onto vehicle
        vehicle1.loadPackage(package1);
        vehicle1.loadPackage(package2);

        // Deliver package
        courier1.deliverPackage(package1);
    }
}
