import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;

public class Server {
    public static void main(String[] args) throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/name", exchange->{
            String query = exchange.getRequestURI().getQuery();
            Map<String, String>param = parseQuery(query);
            String name = param.get("name");

            String response = "hello" + name;
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
            String pair[] = param.split("=");
            map.put(pair[0], pair[1]);
        }
        return map;
    }
}
