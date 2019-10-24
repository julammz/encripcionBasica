import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesOperation {

    public String readFile(String filePath){

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = java.nio.file.Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public void  writeFile(String content, String path){

        try (FileWriter writer = new FileWriter(path);
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
