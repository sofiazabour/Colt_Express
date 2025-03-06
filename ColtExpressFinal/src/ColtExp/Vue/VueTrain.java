package ColtExp.Vue;

import ColtExp.Observer.Observer;
import ColtExp.Modele.Train;
import javax.swing.*;
import java.awt.*;

public class VueTrain extends JPanel implements Observer{
    private final Train t;
    private final VueWagon[] vueWagonTrain;
    private final VueWagon[] vueToitTrain;
    public VueTrain(Fenetre f, Train t, int largeur){
        this.t=t;
        this.vueToitTrain= new VueWagon[t.Size()];
        this.vueWagonTrain = new VueWagon[t.Size()];
        this.setLayout(new BorderLayout());
        t.addObserver(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,0,2,2));


        for (int i = 0; i < t.Size(); i++) {
            VueWagon vw = new VueWagon(t.getWagon(i));
            VueWagon vt = new VueWagon(t.getToit(i));
            this.vueWagonTrain[i] = vw;
            this.vueToitTrain[i]=vt;
            panel.add(vt);

        }
        for (int i = 0; i < t.Size(); i++) {
            VueWagon vw = new VueWagon(t.getWagon(i));
            VueWagon vt = new VueWagon(t.getToit(i));
            this.vueWagonTrain[i] = vw;
            this.vueToitTrain[i]=vt;

            panel.add(vw);
        }

        JScrollPane scrollpane = new JScrollPane(panel);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollpane);
        this.setPreferredSize(new Dimension(800,400));
        this.setVisible(true);

    }

    @Override
    public void update(){
        for(int i = 0; i < 4; ++i) {

            this.vueWagonTrain[i].setWagon(this.t.getWagon(i));

        }
        this.revalidate();
        this.repaint();
    }

}
