import java.io.*;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Main {
    public static void main(String[] args) {
        ObjectToCompress object = new ObjectToCompress("COMPRESS", "ME!");
        byte[] compressedBytes = compressObject(object);

        Inflater inflater = new Inflater();
        inflater.setInput(compressedBytes);
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                baos.write(buffer, 0, count);
            }
            byte[] decompressedBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(decompressedBytes);
                 ObjectInputStream ois = new ObjectInputStream(bais)) {
                ObjectToCompress restoredObject = (ObjectToCompress) ois.readObject();
                System.out.println(restoredObject.toString());
                System.out.println(object.equals(restoredObject));
            } catch (IOException | ClassNotFoundException ignore) {}
        } catch (IOException | DataFormatException ignore) {
        } finally {
            inflater.end();
        }
    }

    private static byte[] compressObject(ObjectToCompress object) {
        byte[] objectBytes = getBytes(object);

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(objectBytes);
        deflater.finish();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(objectBytes.length)) {
            byte[] buffer = new byte[1024];
            while (!deflater.finished()) {
                int count = deflater.deflate(buffer);
                baos.write(buffer, 0, count);
            }
            return baos.toByteArray();
        } catch (IOException ignore) {
        } finally {
            deflater.end();
        }

        return new byte[]{};
    }

    private static byte[] getBytes(Serializable object) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (IOException ignore) {
        }

        return new byte[]{};
    }
}
