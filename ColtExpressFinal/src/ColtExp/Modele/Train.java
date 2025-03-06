package ColtExp.Modele;

import ColtExp.Observer.*;
import java.util.ArrayList;
import java.util.Random;

public class Train extends Observable {

    private final Wagon[][] listWagons ;
    private final ArrayList<Wagon> wagonTrain = new ArrayList<>();
    private final ArrayList<Wagon> toitTrain = new ArrayList<>();
    private  ArrayList<Bandit> bandits = new ArrayList<>();
    private  ArrayList<Marshall> marshall = new ArrayList<>();
    private int banditCourant = 0;
    private int marshallcourant = 0;


    public Train(int nb_w){
        listWagons = new Wagon[2][nb_w];

        for (int i =0 ;i<nb_w-1; i ++) {
            this.wagonTrain.add(new Wagon(this, Wagon.TypeWagon.WagonSimple));

        }
        this.wagonTrain.add(new Wagon(this, Wagon.TypeWagon.Locomotive));
        for (int i = 0;i<nb_w;i++){
            this.listWagons[0][i] = this.wagonTrain.get(i);
        }


        for (int i =0 ;i<nb_w-1; i ++) {
            this.toitTrain.add(new Wagon(this, Wagon.TypeWagon.Toit));

        }
        this.toitTrain.add(new Wagon(this, Wagon.TypeWagon.Locomotive));
        for (int i = 0;i<nb_w;i++){
            this.listWagons[1][i] = this.toitTrain.get(i);
        }

    }

    public Wagon getWagon(int i) {
        return this.listWagons[0][i];
    }
    public Wagon getToit(int i){
        return this.listWagons[1][i];
    }


    public ArrayList<Wagon> getWagonList(){return this.wagonTrain;}
    public ArrayList<Wagon> getToitList(){return this.toitTrain;}

    public void addBandit(Bandit b){
        this.bandits.add(b);
    }
    public void addMarshall(Marshall m){
        this.marshall.add(m);
    }


    public void passe_bandit(){
        if (this.banditCourant == this.bandits.size()-1){
            System.out.println("fin du tour, Appuyer sur action");
        }
        else{
            this.banditCourant++;
        }
    }

    public boolean LastBandit(){
        return this.banditCourant == this.bandits.size()-1;
    }

    public Bandit getBanditCourant(){
        return this.bandits.size() > 0 ? this.bandits.get(this.banditCourant) : null;
    }
    public Marshall getMarshallcourant(){
        return this.marshall.size() > 0 ? this.marshall.get(this.marshallcourant) : null;
    }

    public void setBanditCourant(int x){
        this.banditCourant = x;
    }

    public int Size(){return this.wagonTrain.size();}

    public ArrayList<Bandit> getBandit(){return this.bandits;}

    //fonction Depart qui initialise le train,les bandits(joueurs),le marshall et les differents butins:
    public void Depart() {

        Marshall m = new Marshall();
        this.marshall.add(m);
        this.getWagon(this.Size() - 1).addMarshall(m);

        for(Bandit b : this.bandits){
            this.getToit(0).addBandit(b);
        }

        Random random = new Random();
        for (Wagon w : wagonTrain){
            for(int i =0;i<random.nextInt(3);i++){
                w.addButin(random.nextBoolean()?new Bijou():new Bourse());
            }
            if(w == this.wagonTrain.get(this.Size()-1)){
                w.addButin(new Magot());
            }
        }
        /*for (Wagon t : toitTrain){
            for(int i =0;i<random.nextInt(3);i++){
                t.addButin(random.nextBoolean()?new Bijou():new Bourse());
                if(t == this.wagonTrain.get(this.Size()-1)){
                    t.addButin(new Magot());
                }
            }
        }*/
        this.notifyObservers();
    }
}

