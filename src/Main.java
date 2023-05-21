import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> userClass = Class.forName("models.User");
        Constructor<?> constructor = userClass.getConstructor(String.class, int.class, String.class);

        System.out.println(constructor.getName());
        System.out.println(constructor.getDeclaringClass());
        System.out.println(constructor.getAnnotatedReturnType().getType().getTypeName());
        System.out.println(constructor.getParameterCount());
    }
}
