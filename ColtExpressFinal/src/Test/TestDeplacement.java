package Test;


import ColtExp.Modele.Bandit;
import ColtExp.Modele.Deplacement;
import ColtExp.Modele.Direction;
import ColtExp.Modele.Train;
import ColtExp.Modele.Wagon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeplacementTest {
    private Train train;
    private Bandit bandit;

    @BeforeEach
    void setUp() {
        train = new Train(5); // Créez un train avec 5 wagons
        bandit = new Bandit("Bandit Test"); // Créez un bandit pour les tests
        train.getWagon(0).addBandit(bandit); // Ajoutez le bandit au premier wagon du train
    }

    @Test
    void testMonter() {
        // Testez le cas où le bandit monte sur le toit
        Deplacement deplacement = new Deplacement(bandit, Direction.HAUT, train);
        deplacement.appliquer();
        assertEquals(train.getToitList().get(0), bandit.getCurrentWagon()); // Vérifiez que le bandit est dans le premier wagon du toit
    }


    @Test
    void testDevant() {
        // Testez le cas où le bandit se déplace vers l'avant du train
        Deplacement deplacement = new Deplacement(bandit, Direction.DEVANT, train);
        deplacement.appliquer();
        assertEquals(train.getWagonList().get(1), bandit.getCurrentWagon()); // Vérifiez que le bandit est dans le deuxième wagon du train
    }

    @Test
    void testArriere() {
        // Testez le cas où le bandit se déplace vers l'arrière du train
        bandit.setCurrentWagon(train.getWagonList().get(1)); // Placez le bandit dans le deuxième wagon du train
        Deplacement deplacement = new Deplacement(bandit, Direction.ARRIERE, train);
        deplacement.appliquer();
        assertEquals(train.getWagonList().get(0), bandit.getCurrentWagon()); // Vérifiez que le bandit est dans le premier wagon du train
    }
}
