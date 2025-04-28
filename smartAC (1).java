public class SmartAirConditionerControlSystem {

    // Base class for all electronic appliances
    public static class ElectronicAppliance {
        private String brand;
        private boolean isOn;

        // Constructor
        public ElectronicAppliance(String brand) {
            this.brand = brand;
            this.isOn = false;
        }

        // Method to turn the appliance ON
        public void turnOn() {
            isOn = true;
            System.out.println(brand + " is turned ON.");
        }

        // Method to turn the appliance OFF
        public void turnOff() {
            isOn = false;
            System.out.println(brand + " is turned OFF.");
        }
    }

    // Subclass for AirConditioner
    public static class AirConditioner extends ElectronicAppliance {
        private int temperature;
        private int fanSpeed;
        private Compressor compressor;
        private Fan fan;

        // Constructor for AirConditioner
        public AirConditioner(String brand) {
            super(brand);
            this.compressor = new Compressor();
            this.fan = new Fan();
        }

        // Method to operate the air conditioner
        public void operate() {
            compressor.start();
            fan.start();
            System.out.println("Air conditioner is cooling the room.");
        }

        // Method to set the temperature
        public void setTemperature(int temperature) {
            this.temperature = temperature;
            System.out.println("Set temperature to: " + temperature + "°C");
        }
    }

    // Compressor class (used inside AirConditioner)
    public static class Compressor {
        public void start() {
            System.out.println("Compressor started, cooling in progress.");
        }
    }

    // Fan class (used inside AirConditioner)
    public static class Fan {
        public void start() {
            System.out.println("Fan started.");
        }
    }

    // SmartHome class to manage multiple appliances
    public static class SmartHome {
        private java.util.List<ElectronicAppliance> appliances;

        // Constructor for SmartHome
        public SmartHome() {
            appliances = new java.util.ArrayList<>();
        }

        // Method to add appliances
        public void addAppliance(ElectronicAppliance appliance) {
            appliances.add(appliance);
        }

        // Method to turn ON all appliances
        public void turnOnAll() {
            for (ElectronicAppliance appliance : appliances) {
                appliance.turnOn();
            }
        }

        // Method to turn OFF all appliances
        public void turnOffAll() {
            for (ElectronicAppliance appliance : appliances) {
                appliance.turnOff();
            }
        }
    }

    // Main method to simulate the system
    public static void main(String[] args) {
        // Create the SmartHome system and appliances
        SmartHome home = new SmartHome();
        AirConditioner ac = new AirConditioner("Samsung AC");

        // Add appliances to the SmartHome
        home.addAppliance(ac);

        // Turn on all appliances in the SmartHome
        home.turnOnAll();
        ac.setTemperature(22); // Set temperature for the AC
        ac.operate(); // Start operating the air conditioner

        // Simulate the AC running for 10 seconds (without threading)
        try {
            Thread.sleep(10000); // Simulate 10 seconds of AC cooling
            System.out.println("Cooling completed.");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}