package ColtExp.Vue;


import ColtExp.Modele.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class MenuCreationJoueur extends JPanel {
    private JSlider nbJoueurComponent;
    private int joueur_courant;
    private final Train train;

    private JPanel Selection() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(100, 100));
        JLabel nbJoueurText = new JLabel("Nombre de joueur : ");
        JButton next = new JButton("Suivant");
        next.addActionListener((e) -> {
            CardLayout cards = (CardLayout)this.getLayout();
            cards.show(this, "creation_joueur_" + this.joueur_courant);
        });
        this.nbJoueurComponent = new JSlider(0, 1, 4, 1);
        this.nbJoueurComponent.setMajorTickSpacing(1);
        this.nbJoueurComponent.setMinorTickSpacing(1);
        this.nbJoueurComponent.setPaintTicks(true);
        this.nbJoueurComponent.setPaintLabels(true);
        panel.add(nbJoueurText, new GridBagConstraints());
        panel.add(this.nbJoueurComponent, new GridBagConstraints());
        panel.add(next, new GridBagConstraints());
        return panel;


    }

    private JPanel initCreationJoueur(JPanel rootPanel) {
        JPanel creationJoueur = new JPanel();
        creationJoueur.setLayout(new GridBagLayout());
        creationJoueur.setPreferredSize(new Dimension(100, 100));
        JLabel infoNom = new JLabel("Nom Joueur : ");
        final JTextField nomJoueur = new JTextField(20);
        nomJoueur.setDocument(new LengthRestrictedDocument(15));
        final JButton next_player = new JButton("Suivant");
        next_player.setEnabled(false);
        nomJoueur.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent documentEvent) {
                next_player.setEnabled(nomJoueur.getText().length() != 0);

            }

            public void removeUpdate(DocumentEvent documentEvent) {
                this.insertUpdate(documentEvent);
            }

            public void changedUpdate(DocumentEvent documentEvent) {
            }
        });
        next_player.addActionListener((e) -> {
            Bandit new_player = new Bandit(nomJoueur.getText());
            this.train.addBandit(new_player);
            CardLayout cards;
            if (this.joueur_courant < this.nbJoueurComponent.getValue() - 1) {
                nomJoueur.setText("");
                cards = (CardLayout)this.getLayout();
                cards.show(this, "creation_joueur" + this.joueur_courant);
                ++this.joueur_courant;
            } else {
                this.train.Depart();
                cards = (CardLayout)rootPanel.getLayout();
                cards.show(rootPanel, "vue_jeu");
            }

        });
        creationJoueur.add(infoNom, new GridBagConstraints());
        creationJoueur.add(nomJoueur, new GridBagConstraints());
        creationJoueur.add(next_player, new GridBagConstraints());
        return creationJoueur;
    }


    public MenuCreationJoueur(JPanel rootPanel, Train t) {
        this.train = t;
        this.setLayout(new CardLayout());
        this.joueur_courant = 0;
        JPanel panneauSelectionJoueur = this.Selection();
        this.add(panneauSelectionJoueur, "selection_joueur");

        for(int i = 0; i < 6; ++i) {
            this.add(this.initCreationJoueur(rootPanel), "creation_joueur_" + i);
        }

    }


    private static final class LengthRestrictedDocument extends PlainDocument {
        private final int limit;

        public LengthRestrictedDocument(int limit) {
            this.limit = limit;
        }

        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str != null) {
                if (this.getLength() + str.length() <= this.limit) {
                    super.insertString(offs, str, a);
                }

            }
        }
    }
}
