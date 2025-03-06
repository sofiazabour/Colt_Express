package ColtExp.Vue;

import ColtExp.Observer.Observer;
import ColtExp.Controler.*;
import ColtExp.Modele.*;

import javax.swing.*;
import java.awt.*;



public class VueJeu extends JPanel implements Observer{
    private final Train t;
    private final JLabel textJoueurCourant;
    public VueJeu(Fenetre f, Train t){

        GridLayout jeuLayout = new GridLayout(4,0,0,0);
        this.setLayout(jeuLayout);
        this.setPreferredSize(new Dimension(800,800));
        this.t=t;


        // VUE DES BOUTON
        JPanel PanneauBAS = new JPanel();
        JPanel tmpPanneauBAS1 = new JPanel();
        tmpPanneauBAS1.setLayout(new BorderLayout());
        JPanel tmpPanneauBAS2 = new JPanel();
        tmpPanneauBAS2.setLayout(new BorderLayout());
        DeplacementBouton monter = new DeplacementBouton(t, Direction.HAUT);
        DeplacementBouton Descendre = new DeplacementBouton(t, Direction.BAS);
        DeplacementBouton Avance = new DeplacementBouton(t, Direction.DEVANT);
        DeplacementBouton recule = new DeplacementBouton(t, Direction.ARRIERE);
        ActionBouton action = new ActionBouton(t);
        BraquerBouton braquer = new BraquerBouton(t);
        TirerBouton T_avant = new TirerBouton(t,Direction.DEVANT);
        TirerBouton T_arriere = new TirerBouton(t,Direction.ARRIERE);
        tmpPanneauBAS1.add(monter,BorderLayout.NORTH);
        tmpPanneauBAS1.add(Descendre,BorderLayout.SOUTH);
        tmpPanneauBAS1.add(Avance,BorderLayout.EAST);
        tmpPanneauBAS1.add(recule,BorderLayout.WEST);
        tmpPanneauBAS2.add(action,BorderLayout.SOUTH);
        tmpPanneauBAS2.add(braquer,BorderLayout.NORTH);
        tmpPanneauBAS2.add(T_avant,BorderLayout.EAST);
        tmpPanneauBAS2.add(T_arriere,BorderLayout.WEST);
        PanneauBAS.add(tmpPanneauBAS1);
        PanneauBAS.add(tmpPanneauBAS2);


        // VUE INFOJOUEUR
        JPanel infoJoueur = new JPanel();
        infoJoueur.setLayout(new BoxLayout(infoJoueur,BoxLayout.X_AXIS));
        VueBandit vb = new VueBandit(f,this.t);
        infoJoueur.add(vb);
        JPanel PanneauINFO = new JPanel();
        PanneauINFO.setLayout(new GridLayout(1,4,5,5));
        PanneauINFO.add(vb);


        // VUE SUPERIEUR
        JPanel vueJoueurCourant = new JPanel();
        vueJoueurCourant.setLayout(new BoxLayout(vueJoueurCourant, BoxLayout.X_AXIS));
        this.textJoueurCourant = new JLabel("Tour du joueur ");
        vueJoueurCourant.add(this.textJoueurCourant);
        JPanel PanneauHAUT = new JPanel();
        PanneauHAUT.setLayout(new GridLayout(0,2,0,0));
        PanneauHAUT.add(vueJoueurCourant);



        // VUE TRAIN
        VueTrain vueTrain = new VueTrain(f, t, this.t.Size());


        // VUE FINAL
        this.add(PanneauHAUT);
        this.add(vueTrain);
        this.add(PanneauBAS);
        this.add(PanneauINFO);
        t.addObserver(this);

    }

    public void update() {
        Bandit courant = this.t.getBanditCourant();
        if (courant != null) {
            this.textJoueurCourant.setText("Tour du joueur : " + courant.getNom());
        }
        this.repaint();
        this.revalidate();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
