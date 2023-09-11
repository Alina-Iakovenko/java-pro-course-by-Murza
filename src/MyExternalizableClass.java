import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MyExternalizableClass implements Externalizable {
    public static int SERVER_VERSION = 2023;
    private String name;

    public MyExternalizableClass() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(SERVER_VERSION);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        SERVER_VERSION = in.readInt();
        name = (String) in.readObject();
    }

    // getter, setter, toString

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyExternalizableClass{" +
                "version='" + SERVER_VERSION + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
