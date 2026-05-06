import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client{
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://localhost:8080/mul?a=10&b=5");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.readLine();
        System.out.println("Response: " + response);
        in.close();
    }
}