import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();
        String username =
                console.readLine("Enter username: ");
        char[] password =
                console.readPassword("Hello, %s! Enter password: ", username);

        System.out.printf("%s : %s", username, new String(password));
    }
}
