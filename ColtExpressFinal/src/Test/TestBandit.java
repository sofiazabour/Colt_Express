package Test;


import ColtExp.Modele.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BanditTest {
    private Bandit bandit;
    private Wagon wagon;

    @BeforeEach
    void setUp() {
        Train t = new Train(4);
        bandit = new Bandit("Test Bandit");
        wagon = new Wagon(t,Wagon.TypeWagon.Locomotive);
    }

    @Test
    void testGetNom() {
        assertEquals("Test Bandit", bandit.getNom());
    }

    @Test
    void testGetCurrentWagon() {
        assertNull(bandit.getCurrentWagon());
    }

    @Test
    void testSetCurrentWagon() {
        bandit.setCurrentWagon(wagon);
        assertEquals(wagon, bandit.getCurrentWagon());
    }

    @Test
    void testAddButin() {
        Butin b = new Bijou();
        bandit.addButin(b);
        assertEquals(1, bandit.getButins().size());

    }
}

