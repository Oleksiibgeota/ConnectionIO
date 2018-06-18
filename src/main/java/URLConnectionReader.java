import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLConnectionReader {
    String regexp = "^<head>.*";
    Pattern pattern = Pattern.compile(regexp);
    Matcher matcher;

    public URLConnectionReader() throws IOException {
        URL pro100juice = new URL("http://pro100juice.com/");
        URLConnection yc = pro100juice.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));

        String inputLine;
        String stringExemple = "<head>";
        System.out.println("matches" + " " + pattern.matcher(stringExemple).matches());
        System.out.println("find" + " " + pattern.matcher(stringExemple).find());
        while ((inputLine = in.readLine()) != null) {
            if (pattern.matcher(in.readLine()).find()) {

                System.out.println(inputLine);
            }
        }
        in.close();
    }
}