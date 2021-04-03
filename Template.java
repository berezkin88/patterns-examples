import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Template {

    public abstract class FileEditor {

        public void editFile(String filePath) {

            byte[] file = null;

            try {
                file = read(filePath);
                edit(file);
                write(filePath, file);
            } catch (Exception ex) {
                System.out.println("Failed to edit file. " + ex);
            }

            System.out.println("Edition completed successfully");
        }

        byte[] read(String filePath) throws IOException {
            return Files.readAllBytes(Paths.get(filePath));
        }
    
        abstract void edit(byte[] file);

        void write(String filePath, byte[] file) throws IOException {
            Files.write(Paths.get(filePath), file);
        }
    }
    
    public class CsvFileEditor extends FileEditor {

        @Override
        void edit(byte[] file) {
            // Do some stuff with CSV
        }
        
    }

    public class ExcelFileEditor extends FileEditor {

        @Override
        void edit(byte[] file) {
            // Do some stuff with Excel
        }
        
    }
}
