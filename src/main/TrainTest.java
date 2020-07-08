package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrainTest {

    static Train t1;

    @BeforeAll
    static void setup() {
        Locomotive l1 = new Locomotive(60000, 20, 20, 5000, "DB Class 10", "Krupp", 1957, "DB 10 001", 200000, PowerSource.STEAM);

        WagonType wt1 = new WagonType("Passenger wagon");
        Wagon w1 = new Wagon(20000, 30, 50, 10000, "wagon type 1", "Krupp", 1989, "W 34 001", wt1);
        Wagon w2 = new Wagon(20000, 30, 50, 10000, "wagon type 1", "Krupp", 1989, "W 34 002", wt1);
        Wagon w3 = new Wagon(20000, 30, 50, 10000, "wagon type 1", "Krupp", 1989, "W 34 003", wt1);

        TrainCompany tc1 = new TrainCompany("Cool company");

        t1 = new Train(tc1);
        t1.addLocomotive(l1);
        t1.addWagon(w1);
        t1.addWagon(w2);
        t1.addWagon(w3);
    }

    @Test
    void getEmptyWeight() {
        // t1 has one locomotive weighing 60000 and three wagons weighing 20000 each so the total empty weight should be 120000.
        assertEquals(120000, t1.getEmptyWeight());
    }

    @Test
    void getMaximumPassengers() {
        // t1 has one locomotive with 20 passengers capacity and 3 wagons with 50 passengers capacity each, so the total capacity is 170.
        assertEquals(170, t1.getMaximumPassengers());
    }

    @Test
    void getMaximumLuggageWeight() {
        // t1's combined luggage capacity is 35000, 10000 for each wagon and 5000 for the locomotive
        assertEquals(35000, t1.getMaximumLuggageWeight());
    }

    @Test
    void getMaximumCarryWeight() {
        // t1's maximum carry weight is 35000 luggage + 170 passengers * 75 kg is in total 47750
        assertEquals(47750, t1.getMaximumCarryWeight());
    }

    @Test
    void getMaximumTotalWeight() {
        // t1's maximum total weight is 120000 empty weight + 47750 maximum carry weight is in total 167750
        assertEquals(167750, t1.getMaximumTotalWeight());
    }

    @Test
    void getLength() {
        // t1's total length is one 20 meter locomotive + three times a 30 meter wagon makes 110
        assertEquals(110, t1.getLength());
    }

    @Test
    void isTrainReady() {
        // t1 with a total weight of 167750 and a traction of 200000 should be ready to drive
        assertTrue(t1.isTrainReady());
    }

    @Test
    void getNeededConductors() {
        // t1 has a capacity of 170 passengers so 4 conductors are needed
        assertEquals(4, t1.getNeededConductors());
    }
}