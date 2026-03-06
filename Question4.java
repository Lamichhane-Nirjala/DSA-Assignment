import java.util.*;

class EnergySource {

    String name;
    int capacity;
    double cost;

    EnergySource(String name, int capacity, double cost) {
        this.name = name;
        this.capacity = capacity;
        this.cost = cost;
    }
}

public class Question4 {

    public static void allocateEnergy(int demand) {

        List<EnergySource> sources = new ArrayList<>();

        sources.add(new EnergySource("Solar", 50, 1.0));
        sources.add(new EnergySource("Hydro", 40, 1.5));
        sources.add(new EnergySource("Diesel", 60, 3.0));

        sources.sort(Comparator.comparingDouble(s -> s.cost));

        double totalCost = 0;

        for (EnergySource s : sources) {

            if (demand <= 0)
                break;

            int used = Math.min(demand, s.capacity);

            demand -= used;

            totalCost += used * s.cost;

            System.out.println(s.name + " used: " + used + " kWh");
        }

        System.out.println("Total Cost: Rs " + totalCost);
    }

    public static void main(String[] args) {

        int demand = 60;

        allocateEnergy(demand);
    }
}