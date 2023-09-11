import java.io.*;

public class Main {
    public static void main(String[] args) {
        String pathToSave = "D:\\IdeaProjects\\java-pro-course\\src\\MEC.ser";
        try (InputStream fis = new FileInputStream(pathToSave);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            MyExternalizableClass savedGame = (MyExternalizableClass) ois.readObject();
            System.out.println(savedGame);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void serialize() {
        PlayerInventory inventory = new PlayerInventory();
        inventory.getItems()[0] = "Меч";
        inventory.getItems()[1] = "2 яблука";
        GameSave save = new GameSave(100, 1000, inventory);

        String pathToSave = "D:\\IdeaProjects\\java-pro-course\\src\\game_save.ser";
        try (OutputStream fos = new FileOutputStream(pathToSave);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(save);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deserialize() {
        String pathToSave = "D:\\IdeaProjects\\java-pro-course\\src\\game_save.ser";
        try (InputStream fis = new FileInputStream(pathToSave);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            GameSave savedGame = (GameSave) ois.readObject();
            System.out.println(savedGame);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
