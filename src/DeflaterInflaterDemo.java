import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DeflaterInflaterDemo {
    private static final String INPUT_VALUE = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac tincidunt felis. Suspendisse in ligula tristique, lobortis elit id, aliquam elit. Donec leo enim, aliquet quis rhoncus eget, venenatis non justo. Nunc at diam vitae sem sagittis faucibus non in risus. Nunc condimentum vestibulum fringilla. Suspendisse mauris lectus, interdum ac venenatis quis, tempor id neque. Sed vitae magna quis nulla lacinia dignissim. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus ligula enim, dapibus non neque at, placerat cursus ex. Suspendisse tristique venenatis risus eu tempus. Suspendisse in suscipit sapien, quis finibus sapien.

            Pellentesque eget sapien vitae ex vulputate elementum. Cras at magna laoreet, bibendum urna sagittis, aliquam odio. In cursus est venenatis nisi mattis faucibus. In hac habitasse platea dictumst. Phasellus egestas libero massa, quis venenatis eros maximus et. Quisque at dolor ac sem hendrerit eleifend quis id massa. Fusce interdum, tortor quis tristique consectetur, sem purus mattis sem, a lacinia eros lacus a tortor. Aliquam urna enim, consectetur pretium placerat sed, sagittis eu metus. Donec ultrices dignissim risus nec hendrerit.

            Aenean aliquet urna in dui vehicula facilisis non in erat. Integer cursus eros eu ex ornare, aliquet pharetra nunc vehicula. In quis odio lorem. Pellentesque pulvinar placerat velit, et tincidunt sem faucibus eu. Nulla a varius mi. Morbi vel erat ex. Curabitur elementum eu risus in convallis. Praesent aliquam dolor a ipsum suscipit, sollicitudin ullamcorper leo facilisis. Suspendisse sodales sollicitudin viverra. Vestibulum a lacinia tortor, ac viverra enim. Cras imperdiet hendrerit nibh, non efficitur turpis mattis vitae. Integer iaculis dui leo, at volutpat metus lacinia consectetur. Interdum et malesuada fames ac ante ipsum primis in faucibus.

            Vivamus vulputate auctor lobortis. Pellentesque blandit mi quis porta ultrices. Donec vulputate tincidunt erat ac posuere. Ut sit amet est ultricies, tincidunt massa vitae, vulputate dolor. Sed id viverra.""";


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        byte[] compressedString = compressString();
        System.out.println("Розмір після стискання: " + compressedString.length + " байт");
        Inflater inflater = new Inflater();
        inflater.setInput(compressedString);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(compressedString.length)) {
            byte[] buffer = new byte[1024];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                baos.write(buffer, 0, count);
            }

            byte[] decompressedBytes = baos.toByteArray();
            String decompressedString = new String(decompressedBytes, StandardCharsets.UTF_8);
            System.out.println("Розмір тексту: " + decompressedBytes.length + " байт");
            System.out.println("INPUT_VALUE.equals(decompressedString): "
                    + INPUT_VALUE.equals(decompressedString));
        } catch (IOException | DataFormatException ignore) {
        } finally {
            inflater.end();
        }

        System.out.println("Витрачений час: " + (System.currentTimeMillis() - startTime));
    }


    private static byte[] compressString() {
        long startTime = System.currentTimeMillis();
        byte[] inputStringBytes = INPUT_VALUE.getBytes(StandardCharsets.UTF_8);
        System.out.println("Розмір тексту: " + inputStringBytes.length + " байт");
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);

        deflater.setInput(inputStringBytes);
        deflater.finish();

        byte[] result = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(inputStringBytes.length)) {
            byte[] buffer = new byte[1024];
            while (!deflater.finished()) {
                int count = deflater.deflate(buffer);
                baos.write(buffer, 0, count);
            }
            result = baos.toByteArray();
            System.out.println("Розмір після стискання: " + result.length + " байт");
        } catch (IOException ignore) {
        } finally {
            deflater.end();
        }

        System.out.println("Витрачений час: " + (System.currentTimeMillis() - startTime));
        return result;
    }
}
