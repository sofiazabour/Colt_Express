package ColtExp.Vue;
import ColtExp.Controler.JouerButton;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipale extends JPanel {
    public MenuPrincipale(JPanel rootPanel) {
        JouerButton jouer = new JouerButton(rootPanel);
        JButton quitter = new JButton("Quitter");
        this.setLayout(new BorderLayout());
        JPanel j = new JPanel();
        j.setLayout(new FlowLayout());
        j.add(jouer);
        j.add(quitter);
        this.add(j, BorderLayout.CENTER);
    }
}