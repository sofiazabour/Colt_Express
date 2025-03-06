package ColtExp.Vue;


import ColtExp.Modele.*;
import ColtExp.Modele.Wagon.TypeWagon;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class VueWagon extends JPanel  {

    private Wagon w;
    private final JLabel labelWagon;


    public VueWagon( Wagon w) {

        this.w = w;
        this.setPreferredSize( new Dimension(150, 75));
        this.labelWagon = new JLabel(this.w.toString());
        if (this.w.getTypeWagon() == TypeWagon.Locomotive || this.w.getTypeWagon() == TypeWagon.WagonSimple || this.w.getTypeWagon() == TypeWagon.Toit) {
            this.labelWagon.setText("");
        }
        this.add(this.labelWagon);
    }

    public void setWagon (Wagon w){
        this.w = w;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.w.getTypeWagon() == TypeWagon.Locomotive) {
           ImageIcon image1 = new ImageIcon("src/ColtExp/Vue/locomotive.png");
            g.drawImage(image1.getImage(),0,0,getWidth(),getHeight(),this);
            this.drawBandit(g, this.w.getBandits());
            //this.drawMarshall(g,this.w.getMarshall());
            this.drawButin(g,this.w.getButin());
        } else {
            ImageIcon image2 = new ImageIcon("src/ColtExp/Vue/wagon.jpg");
            g.drawImage(image2.getImage(),0,0,getWidth(),getHeight(),this);            this.drawBandit(g, this.w.getBandits());
            //this.drawMarshall(g,this.w.getMarshall());
            this.drawButin(g,this.w.getButin());

        }

    }

    public void drawBandit(Graphics g, ArrayList<Bandit> bandits) {
        int i = 2;
        for(Iterator<Bandit> var = bandits.iterator(); var.hasNext(); ++i) {
            Bandit b = var.next();
            g.setColor(new Color(250, 250, 250));
            g.drawString(b.getNom(),5,i*12);
        }
        if(!this.w.getMarshall().isEmpty()) {
            Marshall b = this.w.getMarshall().get(0);
            g.setColor(new Color(0, 0, 0));
            g.drawString(b.getNom(), 5, i * 12);
        }
    }

    /*public void drawMarshall(Graphics g, ArrayList<Marshall>marshalls){
        int i = 2;
        for(Iterator<Marshall> var = marshalls.iterator(); var.hasNext(); ++i) {
            Marshall b = var.next();
            g.setColor(new Color(0, 0, 0));
            g.drawString(b.getNom(),5,i*12);
        }
    }*/

    public void drawButin(Graphics g, ArrayList<Butin>butins){
        int i = 2;
        for(Iterator<Butin> var = butins.iterator(); var.hasNext(); ++i) {
            Butin b = var.next();
            g.setColor(new Color(250, 250, 250));
            g.drawString(b.toString(),115,100 - i*12);
        }
    }
}