package ColtExp.Vue;

import ColtExp.Controler.*;
import ColtExp.Modele.*;
import javax.swing.*;
import java.awt.*;
public class VueInfoJeu extends JPanel{


    private final Train train;


    public VueInfoJeu(Train t){
        this.train = t;
        this.setLayout(new GridLayout( 0, 3));
        JPanel PanneauGauche = new JPanel();
        JPanel Panneaucentre = new JPanel();
        Panneaucentre.setLayout(new BorderLayout());
        JLabel objectif = new JLabel("Amassez le plus grand butin !!!");
        JPanel PanneauDroite = new JPanel();
        Panneaucentre.add(objectif,BorderLayout.NORTH);
        this.add(Panneaucentre);
    }

}
