import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveDirectory {
    private static final String SOURCE_DIR_PATH = "dir_to_arch";
    private static final String ARCHIVE_DIR_PATH = "dir.zip";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long originalFileSize = calculateDirectorySize(new File(SOURCE_DIR_PATH));
        System.out.println("Розмір теки з файлами: " + originalFileSize + " байт");

        try (FileOutputStream fos = new FileOutputStream(ARCHIVE_DIR_PATH);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            zos.setLevel(Deflater.BEST_SPEED);
            File dir = new File(SOURCE_DIR_PATH);
            zipInnerDirectoriesAndFiles(dir, "", zos);
        } catch (IOException ignore) {
        }

        long compressedFileSize = new File(ARCHIVE_DIR_PATH).length();
        System.out.println("Розмір архіву: " + compressedFileSize + " байт");
        System.out.println("Витрачений час: " + (System.currentTimeMillis() - startTime));
    }

    private static void zipInnerDirectoriesAndFiles(File folder, String parentFolderPath,
                                                    ZipOutputStream zos) throws IOException {
        String folderPath = createInnerDirInArchive(folder, parentFolderPath, zos);

        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                zipInnerDirectoriesAndFiles(file, folderPath, zos);
            } else {
                zipFile(zos, file, folderPath);
            }
        }
    }

    private static String createInnerDirInArchive(File folder, String parentFolderPath,
                                                  ZipOutputStream zos) throws IOException {
        String folderPath = parentFolderPath + folder.getName() + "/";
        if (!folder.getPath().equals(folder.getName())) {
            zos.putNextEntry(new ZipEntry(folderPath));
            zos.closeEntry();
        }

        return folderPath;
    }

    private static void zipFile(ZipOutputStream zos, File file,
                                String folderPath) throws IOException {
        ZipEntry zipEntry = new ZipEntry(folderPath + file.getName());
        zos.putNextEntry(zipEntry);

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
        }

        zos.closeEntry();
    }

    // Utils
    private static long calculateDirectorySize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else if (file.isDirectory()) {
                    length += calculateDirectorySize(file);
                }
            }
        }

        return length;
    }
}
