import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Main dummyObj = new Main();
        Method[] methods = Main.class.getDeclaredMethods();
        List<Method> sortedMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(CallSequence.class))
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(CallSequence.class).position()))
                .toList();

        for (Method method : sortedMethods) {
            if (Modifier.isStatic(method.getModifiers())) { // Якщо метод статичний - викликаємо без об'єкта.
                method.invoke(null);
            } else { // Якщо метод не статичний - передаємо потрібний об'єкт
                method.invoke(dummyObj);
            }
        }
    }

    @CallSequence(position = Integer.MIN_VALUE)
    public static void start() {
        System.out.println("Start");
    }

    @CallSequence(position = 1)
    public static void doWork() {
        System.out.println("Do something...");
    }

    //... КУПА МЕТОДІВ!

    @CallSequence(position = Integer.MAX_VALUE)
    public static void finish() {
        System.out.println("Finish");
    }
}

