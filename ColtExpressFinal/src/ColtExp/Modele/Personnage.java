package ColtExp.Modele;

import ColtExp.Observer.Observable;

import java.util.ArrayList;

public abstract class Personnage extends Observable {
    protected String nom;
    protected Wagon currentWagon;
    protected ArrayList<Action> actions;
    public Personnage(String nom){
        this.nom=nom;
        this.currentWagon = null;
        this.actions = new ArrayList<>();
    }

    public abstract Wagon getCurrentWagon();
    public abstract void setCurrentWagon(Wagon w);

    public abstract boolean locomotive();

    public abstract String getNom();
}
