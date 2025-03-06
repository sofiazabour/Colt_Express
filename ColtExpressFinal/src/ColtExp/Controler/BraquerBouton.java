package ColtExp.Controler;

import ColtExp.Modele.Braquage;
import ColtExp.Modele.Deplacement;
import ColtExp.Modele.Train;
import ColtExp.Observer.Observer;

import javax.swing.*;

public class BraquerBouton extends JButton implements Observer {
    private final Train train;
    public BraquerBouton(Train t){
        this.train =t;
        this.setText("$ Braquage $");
        this.addActionListener((e) -> {

            this.train.getBanditCourant().addAction(new Braquage(this.train.getBanditCourant(), this.train));
            this.train.notifyObservers();
        });
        this.train.addObserver(this);
    }

    public void update() {
        if (this.train.getBanditCourant().getActions().size() == 4 && !this.train.LastBandit()){
            System.out.println("next bandit ");
            this.train.passe_bandit();
        }
    }
}
