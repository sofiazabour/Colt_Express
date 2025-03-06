package ColtExp;

import ColtExp.Modele.*;
import ColtExp.Vue.*;

import javax.swing.*;
import java.awt.*;

public class ColtExpress {
    public ColtExpress(){}

    private static Train PanneauJeu(Fenetre f, JPanel rootPanel, int nb_w){
        Train t = new Train(nb_w);
        return t;
    }

    private static void PanneauJeu2(Fenetre f,JPanel rootpanel, Train t){
        VueJeu jeu = new VueJeu(f,t);
        rootpanel.add(jeu,"vue_jeu");
    }

    public static void main(String[] args) {
        int nb_w = 7;
        Fenetre ColtExpress = new Fenetre("Colt Epress", new Dimension(900, 800));
        JPanel rootPanel = new JPanel(new CardLayout());
        MenuPrincipale mn = new MenuPrincipale(rootPanel);
        rootPanel.add(mn, "menu_principal");
        Train t = PanneauJeu(ColtExpress, rootPanel,nb_w);
        MenuCreationJoueur mcj = new MenuCreationJoueur(rootPanel, t);
        PanneauJeu2(ColtExpress, rootPanel,t);
        rootPanel.add(mcj, "menu_creation_joueur");
        CardLayout cards = (CardLayout)rootPanel.getLayout();
        cards.show(rootPanel, "menu_principal");
        ColtExpress.ajouterElement(rootPanel);
        ColtExpress.dessinerFenetre();
    }

}
