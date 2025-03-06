package ColtExp.Controler;

import javax.swing.*;
import java.awt.*;

public class JouerButton extends JButton {
    private final JPanel root;

    public JouerButton(JPanel root) {
        this.root = root;
        this.setText("Jouer");
        this.addActionListener((e) -> {
            CardLayout cards = (CardLayout)this.root.getLayout();
            cards.show(root, "menu_creation_joueur");
        });
    }
}
