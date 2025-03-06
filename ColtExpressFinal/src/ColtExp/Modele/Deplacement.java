package ColtExp.Modele;

public class Deplacement extends Action {
    Direction d;
    Train train;
    Personnage pers;


    public Deplacement(Personnage p ,Direction d, Train t) {
        super(t,p);
        this.d = d;
        this.train = t;
        if (p instanceof Bandit){
            this.pers = p;
        }else this.pers = p;

    }

    @Override
    public void appliquer() {
        if (this.d == Direction.DEVANT) {
            this.devant();
        } else if(this.d == Direction.HAUT){
            this.monter();
        }else if(this.d == Direction.BAS){
            this.descend();
        }else if(this.d == Direction.ARRIERE){
            this.arriere();
        }
    }

    public void monter(){

        if(pers.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.Toit || pers.getCurrentWagon()==train.getToitList().get(train.getToitList().size()-1)) {
            System.out.println("Le bandit est déjà sur le toit, il ne peut pas monter plus haut.");
        }else{
            pers.getCurrentWagon().rmBandit((Bandit) pers);
            pers.setCurrentWagon(train.getToitList().get(train.getWagonList().indexOf(pers.getCurrentWagon())));
            pers.getCurrentWagon().addBandit((Bandit) pers);
            System.out.println(pers.getNom() +" est Monter sur le toit");
        }
    }

    public void descend(){
        if(pers.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.WagonSimple|| pers.getCurrentWagon()==train.getWagonList().get(train.getWagonList().size()-1)) {
            System.out.println("Le bandit est déjà a l'interieur ");
        }else{
            System.out.println(pers.getNom() +" est descendu a l'interieur");
            pers.getCurrentWagon().rmBandit((Bandit) pers);
            pers.setCurrentWagon(train.getWagonList().get(train.getToitList().indexOf(pers.getCurrentWagon())));
            pers.getCurrentWagon().addBandit((Bandit) pers);
        }

    }
    public void devant() {
        if (pers.locomotive()) {
            System.out.println(pers.getNom() + " est dans la locomotive deplacement impossible");
        } else {
            if(pers.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.WagonSimple ||pers.getCurrentWagon()==train.getWagonList().get(train.getWagonList().size()-1)) {
                if (pers instanceof Bandit) {
                    pers.getCurrentWagon().rmBandit((Bandit) pers);
                    pers.setCurrentWagon(train.getWagonList().get(train.getWagonList().indexOf(pers.getCurrentWagon()) + 1));
                    pers.getCurrentWagon().addBandit((Bandit) pers);
                }
                else {
                    pers.getCurrentWagon().rmMarshall((Marshall) pers);
                    pers.setCurrentWagon(train.getWagonList().get(train.getWagonList().indexOf(pers.getCurrentWagon()) + 1));
                    pers.getCurrentWagon().addMarshall((Marshall) pers);
                }
                System.out.println(pers.getNom() + " s'est deplcaer au vagon n°" + (this.train.getWagonList().indexOf(pers.getCurrentWagon())+1));

            }else if (pers.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.Toit ||pers.getCurrentWagon()==train.getToitList().get(train.getToitList().size()-1)) {
                if (pers instanceof Bandit) {
                    pers.getCurrentWagon().rmBandit((Bandit) pers);
                    pers.setCurrentWagon(train.getToitList().get(train.getToitList().indexOf(pers.getCurrentWagon()) + 1));
                    pers.getCurrentWagon().addBandit((Bandit) pers);
                }else {
                    pers.getCurrentWagon().rmMarshall((Marshall) pers);
                    pers.setCurrentWagon(train.getToitList().get(train.getToitList().indexOf(pers.getCurrentWagon()) + 1));
                    pers.getCurrentWagon().addMarshall((Marshall) pers);
                }
                System.out.println(pers.getNom() + " s'est deplcaer au vagon n°" + (this.train.getToitList().indexOf(pers.getCurrentWagon())+1));
            }
        }
    }
    public void arriere(){
        if (pers.getCurrentWagon()==train.getWagonList().get(0) ||pers.getCurrentWagon()==train.getToitList().get(0)){
            System.out.println(pers.getNom() + "est dans le dernier wagon deplacement impossible");

        } else {
            if(pers.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.WagonSimple ||pers.getCurrentWagon()==train.getWagonList().get(train.getWagonList().size()-1)) {

                if (pers instanceof Bandit) {
                    pers.getCurrentWagon().rmBandit((Bandit) pers);
                    pers.setCurrentWagon(train.getWagonList().get(train.getWagonList().indexOf(pers.getCurrentWagon()) - 1));
                    pers.getCurrentWagon().addBandit((Bandit) pers);
                }
                else {
                    pers.getCurrentWagon().rmMarshall((Marshall) pers);
                    pers.setCurrentWagon(train.getWagonList().get(train.getWagonList().indexOf(pers.getCurrentWagon()) - 1));
                    pers.getCurrentWagon().addMarshall((Marshall) pers);
                }

                System.out.println(pers.getNom() + " s'est deplcaer au vagon n°" + (this.train.getWagonList().indexOf(pers.getCurrentWagon())+1));
            }else
                if (pers.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.Toit ||pers.getCurrentWagon()==train.getToitList().get(train.getToitList().size()-1)) {

                    if (pers instanceof Bandit) {
                        pers.getCurrentWagon().rmBandit((Bandit) pers);
                        pers.setCurrentWagon(train.getToitList().get(train.getToitList().indexOf(pers.getCurrentWagon()) - 1));
                        pers.getCurrentWagon().addBandit((Bandit) pers);
                    }else {
                        pers.getCurrentWagon().rmMarshall((Marshall) pers);
                        pers.setCurrentWagon(train.getToitList().get(train.getToitList().indexOf(pers.getCurrentWagon()) - 1));
                        pers.getCurrentWagon().addMarshall((Marshall) pers);
                    }

                System.out.println(pers.getNom() + " s'est deplcaer au vagon n°" + (this.train.getToitList().indexOf(pers.getCurrentWagon())+1));
            }
        }
    }

    @Override
    public String getNom() {
        return "Deplacement "+ this.d.toString();
    }
}


