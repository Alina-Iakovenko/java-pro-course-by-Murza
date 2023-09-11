import java.io.Serial;
import java.io.Serializable;

public class GameSave implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int health;
    private int balance;
    private transient int fatigue;
    private PlayerInventory inventory;

    public GameSave(int health, int balance, PlayerInventory inventory) {
        this.health = health;
        this.balance = balance;
        this.inventory = inventory;
    }

    // getters, setter, toString

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public PlayerInventory getInventory() {
        return inventory;
    }

    public void setInventory(PlayerInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "GameSave{" +
                "health=" + health +
                ", balance=" + balance +
                ", fatigue=" + fatigue +
                ", inventory=" + inventory +
                '}';
    }
}
