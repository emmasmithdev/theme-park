import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;
    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;
    private Visitor visitor;

    @Before
    public void before(){
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 4);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 8);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        dodgems = new Dodgems("Bumper Cars", 5);
        themePark = new ThemePark(dodgems, park, playground, rollerCoaster, candyflossStall, iceCreamStall, tobaccoStall);
        visitor = new Visitor(14, 1.2, 40.0);
    }

    @Test
    public void canGetListOfReviewedObjects(){
        assertEquals(7, themePark.getAllReviewed().size());
    }

    @Test
    public void canRecordAVisit(){
        themePark.visit(visitor, park);
        assertEquals(1, park.getVisitCount());
        assertEquals(1, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canCreateHashMapOfReviews(){
        themePark.generateAllReviews();
        assertEquals(7, themePark.getRating("Fun Zone"));
        assertEquals(4, themePark.getRating("Dream Cones"));
    }

}
