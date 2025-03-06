package ColtExp.Modele;

import java.util.ArrayList;
import java.util.Random;


public class Wagon {
    private ArrayList<Bandit> Bandit;
    private ArrayList<Marshall> marshall;
    private ArrayList<Butin> butins;
    private final Train train;
    private final TypeWagon typeWagon;

    public Wagon(Train t,TypeWagon tw){
        this.marshall=new ArrayList<>();
        this.Bandit= new ArrayList<>();
        this.butins = new ArrayList<>();
        this.train=t;
        this.typeWagon = tw;
    }

    public ArrayList<Bandit> getBandits(){return this.Bandit;}
    public ArrayList<Marshall> getMarshall(){return this.marshall;}




    public void addBandit(Bandit b){
        this.Bandit.add(b);
        b.setCurrentWagon(this);
    }
    public void addMarshall(Marshall m){
        this.marshall.add(m);
        m.setCurrentWagon(this);
    }
    public void rmBandit(Bandit b){
        this.Bandit.remove(b);
    }
    public void rmMarshall(Marshall m){
        this.marshall.remove(m);
    }

    public ArrayList<Butin> getButin(){return this.butins;}

    public void addButin(Butin b){
        this.butins.add(b);
    }

    public void rmButin(Butin b){
        this.butins.remove(b);
    }

    public boolean emptyButin(){
        return butins.isEmpty();
    }

    public boolean emptyBandit(){
        return Bandit.isEmpty();
    }

    public Bandit randomBandit(){
        Random r = new Random();
        int rand = r.nextInt(Bandit.size());
        return Bandit.get(rand);
    }

    public TypeWagon getTypeWagon(){
        return this.typeWagon;
    }

    public Train getTrain(){
        return this.train;
    }

    public boolean isLocomotive(){
        return switch (this.typeWagon) {
            case Locomotive -> true;
            case WagonSimple -> false;
            case Toit -> false;
        };
    }

    public enum TypeWagon{
        WagonSimple("Wagon Simple"),
        Locomotive("Locomotive"),
        Toit("Toit");

        private final String nom;
        TypeWagon(String s){
            this.nom = this.name();
        }
        public String toString(){
            return this.nom;
        }
    }

}
