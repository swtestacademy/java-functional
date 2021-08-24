package basics.polymorphism.interfacepolymorphism;

public interface Engine {
    String vehicleType = "I am a car!";

    default String getVehicleType() {
        return vehicleType;
    }

    void startEngine();
}
