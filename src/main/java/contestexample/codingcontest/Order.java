package contestexample.codingcontest;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Cone> cones = new ArrayList<>();

    public void addCone(Cone cone) {
        cones.add(cone);
    }

}
