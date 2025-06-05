// Phase 3: Two Peers on Same Machine Chatting.
//For this we have to to run both Peer A and Peer B class of phase 3 at same time

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Phase3_PeerB {
    public static void main(String[] args) throws IOException {
        int listenPort = 6001;
        String targetIP = "localhost";
        int targetPort = 6000;

        ServerSocket serverSocket = new ServerSocket(listenPort);
        System.out.println("PeerB listening on port " + listenPort);

        new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("PeerA: " + in.readLine());
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
