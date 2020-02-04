import attractions.*;
import behaviours.IReviewed;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.TobaccoStall;

import java.util.ArrayList;

public class ThemePark {

    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;

    public ThemePark(Dodgems dodgems, Park park, Playground playground, RollerCoaster rollerCoaster, CandyflossStall candyflossStall, IceCreamStall iceCreamStall, TobaccoStall tobaccoStall) {
        this.dodgems = dodgems;
        this.park = park;
        this.playground = playground;
        this.rollerCoaster = rollerCoaster;
        this.candyflossStall = candyflossStall;
        this.iceCreamStall = iceCreamStall;
        this.tobaccoStall = tobaccoStall;
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> places = new ArrayList<>();
        places.add(this.dodgems);
        places.add(this.park);
        places.add(this.playground);
        places.add(this.rollerCoaster);
        places.add(this.candyflossStall);
        places.add(this.iceCreamStall);
        places.add(this.tobaccoStall);

        return places;
    }

    public void visit(Visitor visitor, Attraction attraction){
        int visitCount = attraction.getVisitCount();
        visitor.addVisitedAttraction(attraction);
        attraction.setVisitCount(visitCount +=1);
    }
}
