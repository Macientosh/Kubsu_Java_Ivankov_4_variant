class Vehicle {
    protected int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public void move() {
        System.out.println("The vehicle is moving at speed: " + speed + " km/h");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getInfo() {
        return "Speed: " + speed + " km/h";
    }
}

class Car extends Vehicle {
    public Car(int speed) {
        super(speed);
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println("Car accelerated to: " + speed + " km/h");
    }

    @Override
    public String getInfo() {
        return "Car | " + super.getInfo();
    }
}

class Bike extends Vehicle {
    public Bike(int speed) {
        super(speed);
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println("Bike accelerated to: " + speed + " km/h");
    }

    @Override
    public String getInfo() {
        return "Bike | " + super.getInfo();
    }
}

class Truck extends Vehicle {
    public Truck(int speed) {
        super(speed);
    }

    public void loadCargo(int weight) {
        System.out.println("Truck loaded with " + weight + " kg of cargo. Speed adjusted.");
        speed -= weight / 100; // Assume each 100 kg reduces speed by 1 km/h
        if (speed < 0) speed = 0;
        System.out.println("Truck speed after loading: " + speed + " km/h");
    }

    @Override
    public String getInfo() {
        return "Truck | " + super.getInfo();
    }
}

class Garage {
    private Vehicle[] vehicles;

    public Garage(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public void updateSpeed(int index, int newSpeed) {
        if (index >= 0 && index < vehicles.length) {
            vehicles[index].setSpeed(newSpeed);
            System.out.println("Vehicle at index " + index + " updated to speed: " + newSpeed + " km/h");
        } else {
            System.out.println("Invalid index");
        }
    }

    public void showAllVehicles() {
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println("Vehicle " + (i + 1) + ": " + vehicles[i].getInfo());
        }
    }

    public void addVehicle(Vehicle vehicle) {
        Vehicle[] newVehicles = new Vehicle[vehicles.length + 1];
        System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
        newVehicles[vehicles.length] = vehicle;
        vehicles = newVehicles;
        System.out.println(vehicle.getClass().getSimpleName() + " added to the garage.");
    }

    public void removeVehicle(int index) {
        if (index >= 0 && index < vehicles.length) {
            Vehicle[] newVehicles = new Vehicle[vehicles.length - 1];
            System.arraycopy(vehicles, 0, newVehicles, 0, index);
            System.arraycopy(vehicles, index + 1, newVehicles, index, vehicles.length - index - 1);
            vehicles = newVehicles;
            System.out.println("Vehicle at index " + index + " removed from the garage.");
        } else {
            System.out.println("Invalid index");
        }
    }

    public void countVehicles() {
        int cars = 0, bikes = 0, trucks = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                cars++;
            } else if (vehicle instanceof Bike) {
                bikes++;
            } else if (vehicle instanceof Truck) {
                trucks++;
            }
        }
        System.out.println("Cars: " + cars + ", Bikes: " + bikes + ", Trucks: " + trucks);
    }
}

public class inheritance {
    public static void main(String[] args) {
        Car car = new Car(60);
        Bike bike = new Bike(20);
        Truck truck = new Truck(50);

        Vehicle[] vehicles = {car, bike, truck};
        Garage garage = new Garage(vehicles);

        garage.showAllVehicles();

        car.accelerate(20);
        bike.accelerate(10);
        truck.loadCargo(300);

        garage.updateSpeed(0, 100);
        garage.updateSpeed(1, 40);

        garage.showAllVehicles();

        garage.addVehicle(new Car(80));
        garage.addVehicle(new Bike(30));

        garage.showAllVehicles();

        garage.removeVehicle(1);

        garage.showAllVehicles();

        garage.countVehicles();
    }
}
