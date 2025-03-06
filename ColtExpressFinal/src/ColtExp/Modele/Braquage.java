package ColtExp.Modele;

import java.util.Random;

public class Braquage extends Action {

    private Train train;
    private Bandit bandit;
    public Braquage( Bandit b ,Train t){
        super(t,b);
        this.train=t;
        this.bandit = b;
    }
    @Override
    public void appliquer() {
        if(this.bandit.getCurrentWagon().emptyButin()){
            System.out.println("le vagon est vide rien a braquer");
            for (Butin b : bandit.getButins()){
                System.out.println(b.toString());
            }
        } else {
            Random random = new Random();
            int r = random.nextInt(this.bandit.getCurrentWagon().getButin().size());
            bandit.getCurrentWagon().rmBandit(bandit);
            this.bandit.addButin(this.bandit.getCurrentWagon().getButin().get(r));
            this.bandit.getCurrentWagon().rmButin(this.bandit .getCurrentWagon().getButin().get(r));
            bandit.getCurrentWagon().addBandit(bandit);
            System.out.println(this.bandit.getNom()+" a fait un braquage");
            for (Butin b : bandit.getButins()){
                System.out.println(b.toString());
            }

        }
    }
    public String getNom(){
        return "Braquage";
    }
}

