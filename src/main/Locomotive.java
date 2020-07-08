package main;

public class Locomotive extends TrainUnit {

    private Train train;

    private int traction;
    private PowerSource powerSource;

    public Locomotive() {
        super();
    }

    public Locomotive(int weightEmpty,
                      int length,
                      int maximumPassengers,
                      int maximumLuggageWeight,
                      String model,
                      String brand,
                      int buildYear,
                      String serialNumber,
                      int traction,
                      PowerSource powerSource) {
        super(weightEmpty,
                length,
                maximumPassengers,
                maximumLuggageWeight,
                model,
                brand,
                buildYear,
                serialNumber);
        this.traction = traction;
        this.powerSource = powerSource;
    }

    public int getTraction() {
        return this.traction;
    }

    public void setTraction(int traction) {
        this.traction = traction;
    }

    public PowerSource getPowerSource() {
        return this.powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public void setTrain(Train train) {
        if (this.train != null) {
            this.train.removeLocomotive(this);
        }
        this.train = train;
    }

    public Train getTrain() {
        return this.train;
    }
}
