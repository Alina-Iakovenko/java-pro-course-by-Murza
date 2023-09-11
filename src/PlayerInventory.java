import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class PlayerInventory implements Serializable {
    @Serial
    private static final long serialVersionUID = 111L;

    private String[] items;

    public PlayerInventory() {
        this.items = new String[9];
    }

    // getters, setter, toString

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PlayerInventory{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}

