import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal (p): ");
        double p = sc.nextDouble();

        System.out.print("Enter Rate (r): ");
        double r = sc.nextDouble();

        System.out.print("Enter Time (t): ");
        double t = sc.nextDouble();

        String urlStr = "http://localhost:8080/si?p=" + p + "&r=" + r + "&n=" + t;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.readLine();
        System.out.println("Simple Interest: " + response);
    }
}
