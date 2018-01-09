package mapObjects;

public class Monstre extends MainObject  {

    private int damage;

    // constructeur
    public Monstre(int x, int y, int dmg) {
        super(x, y, 'X');
        this.damage = dmg;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
