package ColtExp.Modele;


public class Tirer extends Action {

    Direction d;
    Train train;
    Bandit bandit;

    public Tirer(Bandit b, Direction d, Train t) {
        super(t,b);
        this.d = d;
        this.train = t;
        this.bandit = b;
    }


    @Override
    public void appliquer () {
        if (this.d == Direction.DEVANT) {
            this.devant();
        } else if (this.d == Direction.ARRIERE) {
            this.arriere();
        }
    }

    public void devant() {
        if (bandit.locomotive()) {
            System.out.println(bandit.getNom()+" est dans la locomotive il ne peut pas tirer vers l'avant");
        } else {
            if(bandit.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.WagonSimple ||bandit.getCurrentWagon()==train.getWagonList().get(train.getWagonList().size()-1)) {
                if(!(train.getWagonList().get(train.getWagonList().indexOf(bandit.getCurrentWagon()) + 1).emptyBandit())){
                    System.out.println(bandit.getNom()+" tire vers l'avant ");
                    Bandit b = train.getWagonList().get(train.getWagonList().indexOf(bandit.getCurrentWagon()) + 1).randomBandit();
                    if (!b.getButins().isEmpty()){
                        train.getWagonList().get(train.getWagonList().indexOf(bandit.getCurrentWagon()) + 1).rmBandit(b);
                        b.looseButin();
                        train.getWagonList().get(train.getWagonList().indexOf(bandit.getCurrentWagon()) + 1).addBandit(b);
                        System.out.println("le bandit " + b.getNom()+ "a fait tomber un butin");

                    }
                }else System.out.println("dommage le vagon etait vide");
            }else if (bandit.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.Toit ||bandit.getCurrentWagon()==train.getToitList().get(train.getToitList().size()-1)) {
                if(!(train.getToitList().get(train.getToitList().indexOf(bandit.getCurrentWagon()) + 1).emptyBandit())){
                    System.out.println(bandit.getNom()+" tire vers l'avant ");
                    Bandit b = train.getToitList().get(train.getToitList().indexOf(bandit.getCurrentWagon()) + 1).randomBandit();
                    if (!b.getButins().isEmpty()){
                        train.getToitList().get(train.getToitList().indexOf(bandit.getCurrentWagon()) + 1).rmBandit(b);
                        b.looseButin();
                        train.getToitList().get(train.getToitList().indexOf(bandit.getCurrentWagon()) + 1).addBandit(b);
                        System.out.println("le bandit " + b.getNom()+ "a fait tomber un butin");
                    }
                }else System.out.println("dommage le vagon etait vide");
            }
        }
    }

    public void arriere() {
        if (bandit.getCurrentWagon()==this.train.getWagonList().get(0)) {
            System.out.println(bandit.getNom()+ " est dans le dernier vagon il ne peut pas tirer vers l'arriere");
        } else {
            if(bandit.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.WagonSimple ||bandit.getCurrentWagon()==train.getWagonList().get(train.getWagonList().size()-1)) {
                if(!(train.getWagonList().get(train.getWagonList().indexOf(bandit.getCurrentWagon()) - 1).emptyBandit())){
                    System.out.println(bandit.getNom()+" tire vers l'arrier ");
                    Bandit b = train.getWagonList().get(train.getWagonList().indexOf(bandit.getCurrentWagon()) - 1).randomBandit();
                    if (!b.getButins().isEmpty()){
                        train.getWagonList().get(train.getWagonList().indexOf(bandit.getCurrentWagon()) - 1).rmBandit(b);
                        b.looseButin();
                        train.getWagonList().get(train.getWagonList().indexOf(bandit.getCurrentWagon()) - 1).addBandit(b);
                        System.out.println("le bandit " + b.getNom()+ "a fait tomber un butin");

                    }
                }else System.out.println("dommage le vagon etait vide");
            }else if (bandit.getCurrentWagon().getTypeWagon()== Wagon.TypeWagon.Toit ||bandit.getCurrentWagon()==train.getToitList().get(train.getToitList().size()-1)) {
                if(!(train.getToitList().get(train.getToitList().indexOf(bandit.getCurrentWagon()) - 1).emptyBandit())){
                    System.out.println(bandit.getNom()+" tire vers l'arriere ");
                    Bandit b = train.getToitList().get(train.getToitList().indexOf(bandit.getCurrentWagon()) - 1).randomBandit();
                    //b.getCurrentWagon().rmBandit(b);
                    if (!b.getButins().isEmpty()){
                        train.getToitList().get(train.getToitList().indexOf(bandit.getCurrentWagon()) - 1).rmBandit(b);
                        b.looseButin();
                        train.getToitList().get(train.getToitList().indexOf(bandit.getCurrentWagon()) - 1).addBandit(b);
                        System.out.println("le bandit " + b.getNom()+ "a fait tomber un butin");
                    }
                }else System.out.println("dommage le vagon etait vide");
            }
        }
    }
    public String getNom(){
        return "Tirer";
    }
}

