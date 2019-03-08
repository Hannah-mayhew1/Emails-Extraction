package hannahmayhew.EmptyProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public static String getDataFromFile(String filename) throws IOException {
        Path fileLocation = Paths.get(filename);
        return new String(Files.readAllBytes(fileLocation));
    }
}
