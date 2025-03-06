package ColtExp.Vue;

import ColtExp.Observer.*;
import ColtExp.Modele.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class VueBandit extends JPanel implements Observer {

    private final ArrayList<VueBanditAux> allVueBandit;
    private final Train train;
    private boolean initBandit;
    private final Fenetre f;

    public VueBandit(Fenetre f , Train t ){
        this.train = t;
        this.f=f;
        this.initBandit = false;
        this.allVueBandit = new ArrayList<>();
        this.setLayout(new GridLayout(0,4,2,2));
        this.train.addObserver(this);
    }

    public VueBanditAux getVueBandit(Bandit b){
        Iterator<VueBanditAux> auxIterator = this.allVueBandit.iterator();
        VueBanditAux aux;
        do {
            if (!auxIterator.hasNext()) {
                return null;
            }

            aux = auxIterator.next();
        } while(aux.bandit != b);

        return aux;
    }

    public void update(){
        Iterator<Bandit> joueurIterator;
        Bandit srcButin;
        VueBanditAux tmpVjx;
        if (!this.initBandit) {
            joueurIterator = this.train.getBandit().iterator();

            while(joueurIterator.hasNext()) {
                srcButin = joueurIterator.next();
                tmpVjx = new VueBanditAux(srcButin, this);
                this.allVueBandit.add(tmpVjx);
                this.add(tmpVjx);
            }

            this.initBandit = true;
        }
    }

    public class VueBanditAux extends JPanel implements Observer {
        //private final VueBandit vueBandit;
        private final Bandit bandit;
        private final JLabel actions;
        private final JLabel bourse;
        private final JLabel bijoux;
        private final JLabel magot;
        private final JLabel score;

        public VueBanditAux(Bandit b, VueBandit vb) {
            this.bandit = b;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            JLabel nomJoueur = new JLabel("Bandit : " + b.getNom());
            //JPanel vueClass = new JPanel();
            this.actions = new JLabel("Actions : " + b.getNom());
            this.bourse = new JLabel("Bourse : ");
            this.bijoux = new JLabel();
            this.magot = new JLabel();
            this.score = new JLabel();
            this.add(nomJoueur);
            //this.add(vueClass);
            this.add(this.actions);
            this.add(this.bourse);
            this.add(this.bijoux);
            this.add(this.magot);
            this.add(this.score);
            b.addObserver(this);
        }



        public void update() {
            this.revalidate();
            this.repaint();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ArrayList<Bourse> bourse = new ArrayList<>();
            ArrayList<Bijou> bijou= new ArrayList<>();;
            ArrayList<Magot> magots= new ArrayList<>();;
            for(Butin b : this.bandit.getButins()){
                if (b instanceof Bourse){bourse.add((Bourse) b);}
                else if (b instanceof Bijou){bijou.add((Bijou)b);}
                else if (b instanceof Magot){magots.add((Magot)b);}
            }
            this.actions.setText("Actions = " + (4-(this.bandit.getActions().size())));
            this.bourse.setText("Bourse "+bourse.size());
            this.bijoux.setText("Bijoux "+bijou.size());
            this.magot.setText("Magots "+magots.size());
            this.score.setText("Score "+this.bandit.getButins().size());
        }
    }
}
