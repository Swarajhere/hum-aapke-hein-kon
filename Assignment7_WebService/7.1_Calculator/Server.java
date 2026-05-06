import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class Server{
    public static void main(String[] args) throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/add", exchange->handle(exchange, "add"));
        server.createContext("/sub", exchange->handle(exchange, "sub"));
        server.createContext("/div", exchange->handle(exchange, "div"));
        server.createContext("/mul", exchange->handle(exchange, "mul"));
        server.start();
        System.out.println("Server Running");
    }

    static void handle(HttpExchange exchange, String op) throws IOException{
        String query = exchange.getRequestURI().getQuery();
        Map<String, String>param = parseQuery(query);
        double a = Double.parseDouble(param.get("a"));
        double b = Double.parseDouble(param.get("b"));
        double result = 0;

        switch (op) {
            case "add":
                result = a+b;
                break;
            case "sub":
                result = a-b;
                break;
            case "mul":
                result = a*b;
                break;
            case "div":
                result = a/b;
                break;
            default:
                break;
        }
        String response = String.valueOf(result);
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
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