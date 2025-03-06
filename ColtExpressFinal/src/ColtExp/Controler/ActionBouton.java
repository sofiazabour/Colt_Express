package ColtExp.Controler;

//import java.util.ArrayList;

import javax.swing.*;

import ColtExp.Modele.Action;
import ColtExp.Observer.*;
import ColtExp.Modele.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ActionBouton extends JButton implements Observer{
    private Train train;

    public ActionBouton(Train t){
        this.train = t;
        this.setText("ACTION!!!");
        this.addActionListener((e) -> {
            ArrayList<Bandit> BanditList = this.train.getBandit();
            Marshall marshall = this.train.getMarshallcourant();

            for (int i = 0 ; i<4;i++){

                for(Bandit b : BanditList){
                    marshall.executer();
                    b.executer();
                    //marshall.getCurrentWagon().getBandits(){}
                    if(marshall.getCurrentWagon()==b.getCurrentWagon()){
                        b.looseButin();
                        b.resetAction();
                        b.addAction(new Deplacement(this.train.getBanditCourant(),Direction.HAUT,this.train));
                        b.executer();
                    }
                }

            }

            this.train.setBanditCourant(0);
            this.train.notifyObservers();
        });
        this.train.addObserver(this);
    }

    public void update(){
        if (this.train.getBanditCourant().getActions().size() == 4 && this.train.LastBandit()){
            this.setEnabled(true);
            System.out.println("PRESS ACTION!");
            ArrayList<Bandit>  b1 = this.train.getBandit();
            for (Bandit b : b1){
                System.out.println(b.getNom());
                ArrayList<Butin> butin = b.getButins();
                for(Butin b3 : butin){
                    b3.toString();
                }
            }
        }else this.setEnabled(false);
    }


}
