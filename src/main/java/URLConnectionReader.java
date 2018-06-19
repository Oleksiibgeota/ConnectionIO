import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLConnectionReader {
    String regexp = "(<img class=\"card-img img-fluid\" src=)";
    Pattern pattern = Pattern.compile(regexp);


    public URLConnectionReader() throws IOException {
        URL pro100juice = new URL("http://pro100juice.com/");
        URLConnection yc = pro100juice.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));

        String inputLine;
        int num = 0;
        while ((inputLine = in.readLine()) != null) {
            if (pattern.matcher(inputLine).find()) {
                Matcher matcher = pattern.matcher(inputLine);
                num++;
                System.out.println("Photo number"  + inputLine.replaceAll(regexp, String.valueOf(num) + " "));
//                System.out.println(inputLine);
            }
        }
        in.close();
    }
}