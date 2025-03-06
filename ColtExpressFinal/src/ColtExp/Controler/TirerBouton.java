package ColtExp.Controler;


import javax.swing.*;

import ColtExp.Modele.Action;
import ColtExp.Observer.*;
import ColtExp.Modele.*;

import java.util.ArrayList;

public class TirerBouton extends JButton implements Observer{

    //private Bandit bandit;
    private Train train;

    public TirerBouton(Train t, Direction d) {
        this.train = t;
        switch(d){
            case DEVANT:
                this.setText("Tirer ►");
                this.addActionListener((e) -> {
                    this.train.getBanditCourant().addAction(new Tirer(this.train.getBanditCourant(),d,this.train));
                    this.train.notifyObservers();
                });
                this.train.addObserver(this);
                break;
            case ARRIERE:
                this.setText("Tirer ◄");
                this.addActionListener((e) -> {
                    this.train.getBanditCourant().addAction(new Tirer(this.train.getBanditCourant(),d,this.train));
                    this.train.notifyObservers();
                });
                this.train.addObserver(this);
                break;
        }
    }

    public void update() {
        if (this.train.getBanditCourant().getActions().size() == 4 && !this.train.LastBandit()){
            System.out.println("next bandit ");
            this.train.passe_bandit();
        }
    }
}
