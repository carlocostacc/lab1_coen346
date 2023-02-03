import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class OpenBrowser {
    public static void main(String[] args) {
        String url = "http://www.google.com";
        String os = System.getProperty("os.name").toLowerCase();

        List<String> commands = new ArrayList<>();

        try {
            if (os.contains("windows")) {
                commands.add("rundll32");
                commands.add("url.dll,FileProtocolHandler");
                commands.add(url);
            } else if (os.contains("mac")) {
                commands.add("open");
                commands.add(url);
            } else {
                // this assumes a linux or unix system
                commands.add("xdg-open");
                commands.add(url);
            }

            new ProcessBuilder(commands).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
