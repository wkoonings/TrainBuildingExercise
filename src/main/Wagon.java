package main;

public class Wagon extends TrainUnit {

    private Train train;
    private WagonType wagonType;

    public Wagon() {
        super();
    }

    public Wagon(int weightEmpty,
                 int length,
                 int maximumPassengers,
                 int maximumLuggageWeight,
                 String model,
                 String brand,
                 int buildYear,
                 String serialNumber,
                 WagonType wagonType) {
        super(weightEmpty,
                length,
                maximumPassengers,
                maximumLuggageWeight,
                model,
                brand,
                buildYear,
                serialNumber);
        this.wagonType = wagonType;
    }

    public void setTrain(Train train) {
        if (this.train != null) {
            this.train.removeWagon(this);
        }
        this.train = train;
    }

    public Train getTrain() {
        return this.train;
    }

    public void setWagonType(WagonType wagonType) {
        this.wagonType = wagonType;
    }

    public WagonType getWagonType() {
        return this.wagonType;
    }
}
