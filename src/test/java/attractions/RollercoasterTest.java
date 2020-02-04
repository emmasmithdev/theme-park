package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() {

        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(10, 230, 10);
        visitor2 = new Visitor(13, 164, 10);
        visitor3 = new Visitor(10, 140, 10);
        visitor4 = new Visitor(13, 140, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void hasHeightAndAgeRestrictions(){
        assertTrue(rollerCoaster.isAllowedTo(visitor2));
        assertFalse(rollerCoaster.isAllowedTo(visitor1));
        assertFalse(rollerCoaster.isAllowedTo(visitor3));
        assertFalse(rollerCoaster.isAllowedTo(visitor4));
    }

    @Test
    public void hasDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void tallPeoplePayDouble(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor1), 0.01);
        assertEquals(8.40, rollerCoaster.priceFor(visitor2), 0.01);
    }
}
