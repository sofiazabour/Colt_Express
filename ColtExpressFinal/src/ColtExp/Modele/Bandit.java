package ColtExp.Modele;

import java.util.ArrayList;
import java.util.Random;

public class Bandit extends Personnage {
    private String nom;
    private Wagon currentWagon;
    private ArrayList<Butin> butins;
    private ArrayList<Action> actions;

    public Bandit(String nom) {
        super(nom);
        this.nom = nom;
        this.currentWagon = null;
        this.butins = new ArrayList<>();
        this.actions = new ArrayList<>();
    }


    public ArrayList<Butin> getButins(){
        return this.butins;
    }

    public void addButin(Butin b) {
        this.butins.add(b);
    }

    public void looseButin(){
        if(!this.butins.isEmpty()) {
            Random random = new Random();
            Butin b = this.butins.get(random.nextInt(0, this.butins.size()));
            rmButin(b);
            this.currentWagon.addButin(b);
        }
    }

    public void rmButin(Butin b) {
        this.butins.remove(b);
    }

    public String getNom() {
        return this.nom;
    }

    public Wagon getCurrentWagon() {
        return this.currentWagon;
    }

    public void setCurrentWagon(Wagon w) {this.currentWagon = w;}

    public void addAction(Action a) {
        this.actions.add(a);
    }

    public ArrayList<Action> getActions(){
        return this.actions;
    }

    public void resetAction(){
        this.actions.clear();
    }

    public boolean locomotive() {
        return this.currentWagon.getTypeWagon() == Wagon.TypeWagon.Locomotive;
    }

    public void executer() {
        if (!actions.isEmpty()) {
            actions.get(0).appliquer();
            actions.remove(actions.get(0));
        }
    }
}

