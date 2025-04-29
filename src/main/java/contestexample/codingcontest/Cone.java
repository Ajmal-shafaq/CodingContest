package contestexample.codingcontest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cone {
    private List<Scoop> scoops = new ArrayList<>();
    private Date orderDate = new Date();

    public boolean addScoop(Scoop scoop) {
        if (scoops.size() < 3) {
            scoops.add(scoop);
            return true;
        }
        return false;
    }

    public List<Scoop> getScoops() {
        return scoops;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}

