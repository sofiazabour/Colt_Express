package ColtExp.Controler;

import javax.swing.*;

import ColtExp.Modele.Action;
import ColtExp.Observer.*;
import ColtExp.Modele.*;

import java.util.ArrayList;
import java.util.Random;

public class DeplacementBouton extends JButton implements Observer{

    private final Train train;
    public DeplacementBouton(Train train,Direction d) {
        this.train = train;
        //Random random = new Random();
        double NERVOSITE = 0.3;
        Random random = new Random();
        switch(d){
            case HAUT:
                this.setText("Monter ▲");
                this.addActionListener((e) -> {
                    this.train.getBanditCourant().addAction(new Deplacement(this.train.getBanditCourant(),d,this.train));
                    if(random.nextDouble()<=NERVOSITE){
                        Direction d2 = (random.nextBoolean()?Direction.DEVANT:Direction.ARRIERE);
                        this.train.getMarshallcourant().addAction(new Deplacement(this.train.getMarshallcourant(),d2,this.train));
                    }
                    this.train.notifyObservers();

                });
                this.train.addObserver(this);
                break;
            case BAS:
                this.setText("Descendre ▼ ");
                this.addActionListener((e) -> {
                    this.train.getBanditCourant().addAction(new Deplacement(this.train.getBanditCourant(),d,this.train));
                    if(random.nextDouble()<=NERVOSITE){
                        Direction d2 = (random.nextBoolean()?Direction.DEVANT:Direction.ARRIERE);
                        this.train.getMarshallcourant().addAction(new Deplacement(this.train.getMarshallcourant(),d2,this.train));
                    }
                    this.train.notifyObservers();
                });
                this.train.addObserver(this);
                break;
            case DEVANT:
                this.setText("Avance ►");
                this.addActionListener((e) -> {
                    this.train.getBanditCourant().addAction(new Deplacement(this.train.getBanditCourant(),d,this.train));
                    if(random.nextDouble()<=NERVOSITE){
                        Direction d2 = (random.nextBoolean()?Direction.DEVANT:Direction.ARRIERE);
                        this.train.getMarshallcourant().addAction(new Deplacement(this.train.getMarshallcourant(),d2,this.train));
                    }
                    this.train.notifyObservers();
                });
                this.train.addObserver(this);
                break;
            case ARRIERE:
                this.setText("recule ◄");
                this.addActionListener((e) -> {
                    this.train.getBanditCourant().addAction(new Deplacement(this.train.getBanditCourant(),d,this.train));
                    if(random.nextDouble()<=NERVOSITE){
                        Direction d2 = (random.nextBoolean()?Direction.DEVANT:Direction.ARRIERE);
                        this.train.getMarshallcourant().addAction(new Deplacement(this.train.getMarshallcourant(),d2,this.train));
                    }
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
