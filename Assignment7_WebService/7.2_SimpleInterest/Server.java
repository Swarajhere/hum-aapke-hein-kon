import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;

public class Server {
    public static void main(String[] args) throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/si", exchange->{
            String query = exchange.getRequestURI().getQuery();
            Map<String, String>param = parseQuery(query);
            double p = Double.parseDouble(param.get("p"));
            double r = Double.parseDouble(param.get("r"));
            double n = Double.parseDouble(param.get("n"));
            double result = p*r*n/100.0;

            String response = String.valueOf(result);
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
        System.out.println("Server started");
    }     
    
    static Map<String, String>parseQuery(String query){
        Map<String, String>map = new HashMap<>();
        for(String param: query.split("&")){
            String[] pair = param.split("=");
            map.put(pair[0], pair[1]);
        }
        return map;
    }
}
