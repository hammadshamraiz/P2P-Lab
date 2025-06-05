//Phase 2: Continuous Messaging Until "exit" in runable condition
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Phase2 {
    private static final int PORT = 5001;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Peer is listening on port " + PORT);

        // Thread to handle receiving messages
        new Thread(() -> {
            try {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message = in.readLine();
                    System.out.println("Received: " + message);
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Sending messages in loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter message (type 'exit' to quit): ");
            String msg = scanner.nextLine();
            if (msg.equalsIgnoreCase("exit")) break;

            try (Socket socket = new Socket("localhost", PORT)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(msg);
            } catch (IOException e) {
                System.out.println("Could not send message.");
            }
        }
        serverSocket.close();
    }
}
