package Test;

import ColtExp.Modele.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMarshall {
    private Marshall marshall;

    @BeforeEach
    void setUp() {
        marshall = new Marshall();
    }

    @Test
    void testGetNom() {
        assertEquals("Marshall", marshall.getNom());
    }

    @Test
    void testGetCurrentWagon() {
        assertNull(marshall.getCurrentWagon());
    }

    @Test
    void testSetCurrentWagon() {
        Train t = new Train(5);
        Wagon wagon = new Wagon(t,Wagon.TypeWagon.Locomotive);
        marshall.setCurrentWagon(wagon);
        assertEquals(wagon, marshall.getCurrentWagon());
    }
    @Test
    void testAddAction() {
        Bandit b = new Bandit("sofia");
        Direction d = Direction.HAUT;
        Train t = new Train(5);
        Action action = new Tirer(b,d,t);
        marshall.addAction(action);
        assertTrue(marshall.getActions().contains(action));
    }
    @Test
    void testLocomotive() {
        Train t = new Train(5);
        Wagon wagonLocomotive = new Wagon(t,Wagon.TypeWagon.Locomotive);
        marshall.setCurrentWagon(wagonLocomotive);
        assertTrue(marshall.locomotive());

        // Testez la méthode locomotive lorsque le wagon actuel n'est pas une locomotive
        Wagon wagonSimple = new Wagon(t,Wagon.TypeWagon.WagonSimple);
        marshall.setCurrentWagon(wagonSimple);
        assertFalse(marshall.locomotive());
    }

    @Test
    void testResetAction() {
        Bandit b = new Bandit("sofia");
        Direction d = Direction.HAUT;
        Train t = new Train(5);
        Action action1 = new Braquage(b,t);
        Action action2 = new Tirer(b,d,t);
        marshall.addAction(action1);
        marshall.addAction(action2);

        // Vérifiez que la liste des actions n'est pas vide
        assertFalse(marshall.getActions().isEmpty());

        // Appelez resetAction pour effacer les actions
        marshall.resetAction();

        // Vérifiez que la liste des actions est vide après l'appel à resetAction
        assertTrue(marshall.getActions().isEmpty());
    }

}
