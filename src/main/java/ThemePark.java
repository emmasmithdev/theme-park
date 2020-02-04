import attractions.*;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.TobaccoStall;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;
    private HashMap<String, Integer> allReviews;

    public ThemePark(Dodgems dodgems, Park park, Playground playground, RollerCoaster rollerCoaster, CandyflossStall candyflossStall, IceCreamStall iceCreamStall, TobaccoStall tobaccoStall) {
        this.dodgems = dodgems;
        this.park = park;
        this.playground = playground;
        this.rollerCoaster = rollerCoaster;
        this.candyflossStall = candyflossStall;
        this.iceCreamStall = iceCreamStall;
        this.tobaccoStall = tobaccoStall;
        this.allReviews = new HashMap<>();
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

    public void generateAllReviews(){
        ArrayList<IReviewed> allPlaces = getAllReviewed();
        for (IReviewed place : allPlaces){
            String name = place.getName();
            Integer rating = place.getRating();
            this.allReviews.put(name, rating);
        }
    }

    public int getRating(String name){
        if(this.allReviews.containsKey(name)){
            return this.allReviews.get(name);
        }
        return 0;
    }

    public ArrayList<IReviewed> findAllAllowed(Visitor visitor){
        ArrayList<IReviewed> allowedPlaces = new ArrayList<>();
        allowedPlaces.add(this.dodgems);
        allowedPlaces.add(this.park);
        allowedPlaces.add(this.candyflossStall);
        allowedPlaces.add(this.iceCreamStall);
        ArrayList<ISecurity> securityPlaces = new ArrayList<>();
        securityPlaces.add(this.playground);
        securityPlaces.add(this.rollerCoaster);
        securityPlaces.add(this.tobaccoStall);
        for (ISecurity place : securityPlaces){
            if( place.isAllowedTo(visitor)){
                allowedPlaces.add((IReviewed) place);
            }
        }
        return allowedPlaces;
    }
}
