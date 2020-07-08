package main;

public abstract class TrainUnit {

    private int weightEmpty;
    private int length;

    private int maximumPassengers;
    private int maximumLuggageWeight;

    private String model;
    private String brand;
    private int buildYear;
    private String serialNumber;

    public TrainUnit() {

    }

    public TrainUnit(int weightEmpty,
                     int length,
                     int maximumPassengers,
                     int maximumLuggageWeight,
                     String model,
                     String brand,
                     int buildYear,
                     String serialNumber) {
        this.weightEmpty = weightEmpty;
        this.length = length;
        this.maximumPassengers = maximumPassengers;
        this.maximumLuggageWeight = maximumLuggageWeight;
        this.model = model;
        this.brand = brand;
        this.buildYear = buildYear;
        this.serialNumber = serialNumber;
    }

    public void setWeightEmpty(int weightEmpty) {
        this.weightEmpty = weightEmpty;
    }

    public int getWeightEmpty() {
        return this.weightEmpty;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public int getMaximumPassengers() { return this.maximumPassengers; }

    public int getMaximumLuggageWeight() { return this.maximumLuggageWeight; }
}
