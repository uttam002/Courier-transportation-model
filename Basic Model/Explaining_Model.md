# Courier Transportation Model Explanation

This document provides a step-by-step explanation of the Java implementation of a courier transportation model using Object-Oriented Programming (OOP) concepts.

## Classes Overview

### `Package` Class
- Represents a package to be transported.
- Attributes:
  - `packageId`: Unique identifier for the package.
  - `destination`: Destination of the package.
  - `weight`: Weight of the package.

### `Vehicle` Class
- Represents a vehicle used for transportation.
- Attributes:
  - `vehicleId`: Unique identifier for the vehicle.
  - `capacity`: Maximum weight the vehicle can carry.
  - `packages`: List of packages loaded onto the vehicle.
- Methods:
  - `loadPackage`: Loads a package onto the vehicle, if capacity allows.

### `Courier` Class
- Represents a courier responsible for delivering packages.
- Attributes:
  - `courierId`: Unique identifier for the courier.
  - `name`: Name of the courier.
  - `vehicle`: Vehicle assigned to the courier.
- Methods:
  - `assignVehicle`: Assigns a vehicle to the courier.
  - `deliverPackage`: Delivers a package using the assigned vehicle.

### `TransportationCompany` Class
- Represents a transportation company managing vehicles and couriers.
- Attributes:
  - `name`: Name of the transportation company.
  - `vehicles`: List of vehicles owned by the company.
  - `couriers`: List of couriers employed by the company.
- Methods:
  - `addVehicle`: Adds a vehicle to the company's fleet.
  - `addCourier`: Adds a courier to the company's workforce.
  - `assignVehicleToCourier`: Assigns a vehicle to a courier based on IDs.

## Usage Example

1. **Initialization**: Create a transportation company, vehicles, and couriers.
2. **Assign Vehicle to Courier**: Assign a vehicle to a courier.
3. **Package Handling**:
   - Create packages.
   - Load packages onto vehicles.
   - Deliver packages using assigned couriers.

## Running the Example

1. Compile the Java files: `javac Main.java`.
2. Run the compiled program: `java Main`.

The output will demonstrate the process of assigning vehicles to couriers, loading packages onto vehicles, and delivering packages.

