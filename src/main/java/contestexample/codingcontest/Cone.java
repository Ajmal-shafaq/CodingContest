package contestexample.codingcontest;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Cone {

    private List<Scoop> scoops = new ArrayList<>();
    private Date date = new Date();


    public boolean addScoop(Scoop scoop) {
        if (scoops.size() < 3)
            scoops.add(scoop);
        return true;
    }
}
