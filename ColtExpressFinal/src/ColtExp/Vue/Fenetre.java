package ColtExp.Vue;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    private final JPanel elements;

    public Fenetre(String nom, Dimension Min) {
        super(nom);
        this.setMinimumSize(Min);
        this.elements = new JPanel();
        this.add(elements);
    }

    public void ajouterElement(JComponent element) {
        this.elements.add(element);
    }

    public void dessinerFenetre() {
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}