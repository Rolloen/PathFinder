package mapObjects;

public class Or extends MainObject{

    private int valeur;

    // constructeur
    public Or(int x, int y) {
        super(x, y, 'O');
        valeur = 1;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

}
