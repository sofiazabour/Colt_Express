package ColtExp.Modele;

public abstract class Action  {
    private final Train t;
    private Personnage pers;


    public Action(Train t, Personnage p) {
        this.t=t;
        this.pers= p;
    }

    public Train getTrain() {
        return this.t;
    }

    public abstract void appliquer();

    public abstract String getNom();

}