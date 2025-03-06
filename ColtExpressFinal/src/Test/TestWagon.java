package Test;

import ColtExp.Modele.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WagonTest {
    private Train train;
    private Wagon wagon;

    @BeforeEach
    void setUp() {
        train = new Train(5); // Créez un train avec 5 wagons
        wagon = train.getWagon(0); // Obtenez le premier wagon du train pour les tests
    }

    @Test
    void testAddBandit() {
        // Vérifiez que le wagon est initialement vide
        assertTrue(wagon.getBandits().isEmpty());

        // Ajoutez un bandit au wagon
        Bandit bandit = new Bandit("Bandit Test");
        wagon.addBandit(bandit);

        // Vérifiez que le bandit a été ajouté avec succès au wagon
        assertEquals(1, wagon.getBandits().size());
        assertTrue(wagon.getBandits().contains(bandit));
        assertEquals(wagon, bandit.getCurrentWagon()); // Vérifiez que le wagon du bandit est correctement mis à jour
    }

    @Test
    void testAddMarshall() {
        // Vérifiez que le wagon est initialement vide de marshall
        assertTrue(wagon.getMarshall().isEmpty());

        // Ajoutez un marshall au wagon
        Marshall marshall = new Marshall();
        wagon.addMarshall(marshall);

        // Vérifiez que le marshall a été ajouté avec succès au wagon
        assertEquals(1, wagon.getMarshall().size());
        assertTrue(wagon.getMarshall().contains(marshall));
        assertEquals(wagon, marshall.getCurrentWagon()); // Vérifiez que le wagon du marshall est correctement mis à jour
    }

    @Test
    void testAddButin() {
        // Vérifiez que le wagon est initialement vide de butin
        assertTrue(wagon.getButin().isEmpty());

        // Ajoutez un butin au wagon
        wagon.addButin(new Bourse()); // Ajoutez le type approprié de butin que vous avez

        // Vérifiez que le butin a été ajouté avec succès au wagon
        assertEquals(1, wagon.getButin().size());
    }

    @Test
    void testEmptyButin() {
        // Vérifiez que le wagon est initialement vide de butin
        assertTrue(wagon.emptyButin());

        // Ajoutez un butin au wagon
        wagon.addButin(new Bijou()); // Ajoutez le type approprié de butin que vous avez

        // Vérifiez que le wagon n'est plus vide de butin
        assertFalse(wagon.emptyButin());
    }

    @Test
    void testEmptyBandit() {
        // Vérifiez que le wagon est initialement vide de bandit
        assertTrue(wagon.emptyBandit());

        // Ajoutez un bandit au wagon
        wagon.addBandit(new Bandit("Bandit Test"));

        // Vérifiez que le wagon n'est plus vide de bandit
        assertFalse(wagon.emptyBandit());
    }

    @Test
    void testRandomBandit() {

        // Ajoutez quelques bandits au wagon
        Bandit bandit1 = new Bandit("Bandit 1");
        Bandit bandit2 = new Bandit("Bandit 2");
        wagon.addBandit(bandit1);
        wagon.addBandit(bandit2);

        // Vérifiez que le bandit renvoyé est bien l'un des bandits ajoutés
        assertTrue(wagon.getBandits().contains(wagon.randomBandit()));
    }

    @Test
    void testIsLocomotive() {
        // Testez le cas où le wagon est une locomotive
        Wagon locomotive = train.getWagon(train.Size() - 1); // Obtenez la dernière locomotive du train
        assertTrue(locomotive.isLocomotive());

        // Testez le cas où le wagon n'est pas une locomotive
        assertFalse(wagon.isLocomotive());
    }
}
