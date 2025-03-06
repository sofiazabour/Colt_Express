package Test;

import ColtExp.Modele.Bandit;
import ColtExp.Modele.Marshall;
import ColtExp.Modele.Train;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

    class TestTrain {
        private Train train;
        private ArrayList<Bandit> bandits;
        private ArrayList<Marshall> marshalls;

        @BeforeEach
        void setUp() {
            train = new Train(5); // Créez un train avec 5 wagons
            bandits = new ArrayList<>();
            marshalls = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Bandit bandit = new Bandit("Bandit " + i);
                train.addBandit(bandit);
                bandits.add(bandit);
            }
            for (int i = 0; i < 2; i++) {
                Marshall marshall = new Marshall();
                train.addMarshall(marshall);
                marshalls.add(marshall);
            }
        }

        @Test
        void testLastBandit() {
            assertFalse(train.LastBandit());

            train.setBanditCourant(bandits.size() - 1);
            assertTrue(train.LastBandit());
        }

        @Test
        void testGetBanditCourant() {
            assertEquals(bandits.get(0), train.getBanditCourant());

            train.passe_bandit();

            assertEquals(bandits.get(1), train.getBanditCourant());
        }

        @Test
        void testGetMarshallcourant() {
            assertEquals(marshalls.get(0), train.getMarshallcourant());

            Train trainWithoutMarshall = new Train(5);
            assertNull(trainWithoutMarshall.getMarshallcourant());
        }
}
