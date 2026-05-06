import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.*;

public class Server {
    public static void main(String[] args) throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.start();

        server.createContext("/convert", exchange->{
            String query = exchange.getRequestURI().getQuery();
            Map<String, String>param = parseQuery(query);
            double miles = Double.parseDouble(param.get("miles"));
            double result = miles*1.6031;
            String response = String.valueOf(result);
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        System.out.println("Server Started");
    }

    static Map<String, String>parseQuery(String query){
        Map<String, String>map = new HashMap<>();
        for(String param:query.split("&")){
            String path[] = param.split("=");
            map.put(path[0], path[1]);
        }
        return map;
    }
}
