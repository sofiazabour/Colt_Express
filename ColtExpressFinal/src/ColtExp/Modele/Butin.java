package ColtExp.Modele;
import java.util.Random;

public abstract class  Butin {
    private String Type;
    public Butin(String s){
        this.Type=s;
    }
    @Override
    public  abstract String toString();
}



