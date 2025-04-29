package contestexample.codingcontest;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Cone> cones = new ArrayList<>();

    public void addCone(Cone cone) {
        cones.add(cone);
    }


    public List<Cone> getCones() {
        return cones;
    }

    public double getTotalPrice() {
        return cones.stream()
                .flatMap(c -> c.getScoops().stream())
                .mapToDouble(Scoop::getPrice)
                .sum();
    }

    public void printReceipt() {
        System.out.println("Order Date: " + (cones.isEmpty() ? "N/A" : cones.get(0).getDate()));
        int coneNumber = 1;
        for (Cone cone : cones) {
            System.out.println("Cone " + coneNumber + ":");
            for (Scoop scoop : cone.getScoops()) {
                System.out.println(" - " + scoop.getFlavor() + ": $" + String.format("%.2f", scoop.getPrice()));
            }
            coneNumber++;
        }
        System.out.println("Total (Gross): $" + String.format("%.2f", getTotalPrice()));
        System.out.println("(VAT 2.5% included)");
    }
}
