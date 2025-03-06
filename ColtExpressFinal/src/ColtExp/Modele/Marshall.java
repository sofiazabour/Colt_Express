package ColtExp.Modele;

import java.util.ArrayList;

public class Marshall extends Personnage{

    private String nom;
    private Wagon currentWagon;
    private ArrayList<Action> actions;

    public Marshall() {
        super("Marshall");
        this.nom = "Marshall";
        this.currentWagon = null;
        this.actions = new ArrayList<>();
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
