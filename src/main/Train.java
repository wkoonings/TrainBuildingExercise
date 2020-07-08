package main;

import java.util.ArrayList;
import java.util.List;

public class Train {

    private TrainCompany trainCompany;

    private List<Locomotive> locomotives = new ArrayList<>();
    private List<Wagon> wagons = new ArrayList<>();

    public Train() {

    }

    public Train(TrainCompany trainCompany) {
        this.trainCompany = trainCompany;
    }

    public TrainCompany getTrainCompany() {
        return this.trainCompany;
    }

    public void setTrainCompany(TrainCompany trainCompany) {
        this.trainCompany = trainCompany;
    }

    public List<Locomotive> addLocomotive(Locomotive locomotive) {
        if (!this.locomotives.contains(locomotive)) {
            this.locomotives.add(locomotive);
            locomotive.setTrain(this);
        }

        return this.locomotives;
    }

    public List<Locomotive> removeLocomotive(Locomotive locomotive) {
        if (this.locomotives.contains(locomotive)) {
            this.locomotives.remove(locomotive);
            locomotive.setTrain(null);
        }

        return this.locomotives;
    }

    public List<Wagon> addWagon(Wagon wagon) {
        if (!this.wagons.contains(wagon)) {
            this.wagons.add(wagon);
            wagon.setTrain(this);
        }

        return this.wagons;
    }

    public List<Wagon> removeWagon(Wagon wagon) {
        if (this.wagons.contains(wagon)) {
            this.wagons.remove(wagon);
            wagon.setTrain(null);
        }

        return this.wagons;
    }

    public int getEmptyWeight() {
        int totalWeight = 0;
        for (Locomotive l : this.locomotives) {
            totalWeight += l.getWeightEmpty();
        }
        for (Wagon w : this.wagons) {
            totalWeight += w.getWeightEmpty();
        }

        return totalWeight;
    }

    public int getMaximumPassengers() {
        int totalPassengers = 0;
        for (Locomotive l : this.locomotives) {
            totalPassengers += l.getMaximumPassengers();
        }
        for (Wagon w : this.wagons) {
            totalPassengers += w.getMaximumPassengers();
        }
        return totalPassengers;
    }

    public int getMaximumLuggageWeight() {
        int totalLuggageWeight = 0;
        for (Locomotive l : this.locomotives) {
            totalLuggageWeight += l.getMaximumLuggageWeight();
        }
        for (Wagon w : this.wagons) {
            totalLuggageWeight += w.getMaximumLuggageWeight();
        }
        return totalLuggageWeight;
    }

    public int getMaximumCarryWeight() {
        int maximumCarryWeight = 0;

        maximumCarryWeight += (this.getMaximumPassengers() * 75);
        maximumCarryWeight += this.getMaximumLuggageWeight();

        return maximumCarryWeight;
    }

    public int getMaximumTotalWeight() {
        return getEmptyWeight() + getMaximumCarryWeight();
    }

    public int getLength() {
        int totalLength = 0;
        for (Locomotive l : this.locomotives) {
            totalLength += l.getLength();
        }
        for (Wagon w : this.wagons) {
            totalLength += w.getLength();
        }
        return totalLength;
    }

    public boolean isTrainReady() {
        int totalTraction = 0;
        for (Locomotive l : this.locomotives) {
            totalTraction += l.getTraction();
        }

        return (totalTraction >= getMaximumTotalWeight());
    }

    public int getNeededConductors() {
        return (getMaximumPassengers() + 50 - 1) / 50;
    }
}
