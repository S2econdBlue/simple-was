import com.sun.net.httpserver.HttpServer;
import handler.EchoGetHandler;
import handler.EchoHeaderHandler;
import handler.EchoPostHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {


    public static void main(String[] args) throws IOException {
        int port = 9000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);

        server.createContext("/", new RootHandler());
        server.createContext("/echoHeader", new EchoHeaderHandler());
        server.createContext("/echoGet", new EchoGetHandler());
        server.createContext("/echoPost", new EchoPostHandler());

        server.setExecutor(null);
        server.start();
    }
}

