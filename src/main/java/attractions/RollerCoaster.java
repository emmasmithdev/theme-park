package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity {

    public RollerCoaster(String name, int rating) {

        super(name, rating);
    }


    public boolean isAllowedTo(Visitor visitor) {
        return (visitor.getHeight() > 145 ) && (visitor.getAge() > 12);
    }
}
