package Test;

import ColtExp.Modele.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestBraquage {
    private Bandit bandit;
    private Train train;

    @BeforeEach
    void setUp() {
        bandit = new Bandit("Test Bandit");
        train = new Train(7);
        Wagon wagon = new Wagon(train,Wagon.TypeWagon.WagonSimple);
        bandit.setCurrentWagon(wagon);
    }

    @Test
    void testAppliquerWithEmptyButin() {
        Braquage braquage = new Braquage(bandit, train);
        braquage.appliquer();
        assertEquals(0, bandit.getButins().size());
    }

    @Test
    void testAppliquerWithButin() {
        Wagon wagon = bandit.getCurrentWagon();
        wagon.addButin(new Bourse());
        Braquage braquage = new Braquage(bandit, train);
        braquage.appliquer();
        assertEquals(1, bandit.getButins().size());
    }

}