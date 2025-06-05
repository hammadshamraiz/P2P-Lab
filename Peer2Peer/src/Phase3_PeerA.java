// Phase 3: Two Peers on Same Machine Chatting

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Phase3_PeerA {
    public static void main(String[] args) throws IOException {
        int listenPort = 6000;
        String targetIP = "localhost";
        int targetPort = 6001;

        ServerSocket serverSocket = new ServerSocket(listenPort);
        System.out.println("PeerA listening on port " + listenPort);

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

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("You: ");
            String msg = scanner.nextLine();
            if (msg.equalsIgnoreCase("exit")) break;

            try (Socket socket = new Socket(targetIP, targetPort)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(msg);
            }
        }
        serverSocket.close();
    }
}
