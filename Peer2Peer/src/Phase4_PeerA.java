// Phase 4: Chatting Between Different Machines
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Phase4_PeerA {
    public static void main(String[] args) throws IOException {
        int listenPort = 6000;          // Port PeerA listens on
        String targetIP = "192.168.70.110";  // PeerB's IP
        int targetPort = 6001;          // Port PeerB listens on

        ServerSocket serverSocket = new ServerSocket(listenPort);
        System.out.println("PeerA listening on port " + listenPort);

        // Thread to listen for incoming messages from PeerB
        new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("PeerB: " + in.readLine());
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Sending messages to PeerB
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("You: ");
            String msg = scanner.nextLine();
            if (msg.equalsIgnoreCase("exit")) break;

            try (Socket socket = new Socket(targetIP, targetPort)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(msg);
            } catch (IOException e) {
                System.out.println("Could not send message to PeerB.");
            }
        }

        serverSocket.close();
        scanner.close();
    }
}
