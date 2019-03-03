import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiMsgMultiClientServer {

    private ServerSocket serverSocket;

    public MultiMsgMultiClientServer(int serverPort) throws IOException {
        serverSocket = new ServerSocket(serverPort);
    }

    public void start() throws IOException {
        System.out.println("start listening for clients... ");
        while (true) {
            new MultiClientHandler(serverSocket.accept()).start();
            System.out.println("Client connected");
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class MultiClientHandler extends Thread {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public MultiClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }

        public void run() {
            try {

                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    if (".".equals(inputLine)) {
                        System.out.println("bye");
                        out.println("bye");
                        break;
                    }
                    System.out.println(inputLine);
                    out.println(inputLine);
                }

                in.close();
                out.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        /**
         * MultiMsgSingleClientServer
         */
        MultiMsgMultiClientServer server = new MultiMsgMultiClientServer(6666);
        server.start();
    }

}
