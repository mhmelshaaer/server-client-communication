import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiMsgSingleClientServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    MultiMsgSingleClientServer(int serverPort) throws IOException {
        serverSocket = new ServerSocket(serverPort);
        System.out.println("Waiting for client connection...");
        clientSocket = serverSocket.accept();
        System.out.println("connected");

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void start() throws IOException {

        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            if (".".equals(inputLine)) {
                System.out.println("good bye");
                out.println("good bye");
                break;
            }
            System.out.println(inputLine);
            out.println(inputLine);
        }
    }

    public void stop() throws IOException {

        clientSocket.close();
        serverSocket.close();

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        /**
         * MultiMsgSingleClientServer
         */
        MultiMsgSingleClientServer server = new MultiMsgSingleClientServer(6666);
        server.start();
    }

}
