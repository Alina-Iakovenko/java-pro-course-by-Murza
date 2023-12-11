import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ObjectToCompress implements Serializable {
    @Serial
    private final static long serialVersionUID = 1;
    String val1;
    String val2;

    public ObjectToCompress(String val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectToCompress object = (ObjectToCompress) o;

        if (!Objects.equals(val1, object.val1)) return false;
        return Objects.equals(val2, object.val2);
    }

    @Override
    public int hashCode() {
        int result = val1 != null ? val1.hashCode() : 0;
        result = 31 * result + (val2 != null ? val2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ObjectToCompress{" +
                "val1='" + val1 + '\'' +
                ", val2='" + val2 + '\'' +
                '}';
    }
}
