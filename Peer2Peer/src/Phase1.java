//Phase 1: Basic P2P One-Time Message Code Provided SubjectExpert In runable Condition

import java.io.*;
import java.net.*;
public class Phase1 {
 private static final int PORT = 5000;
 public static void main(String[] args) throws IOException {
 // Create server socket to listen for incoming connections
 ServerSocket serverSocket = new ServerSocket(PORT);
 System.out.println("Peer is listening on port " + PORT);
 // Thread to handle incoming connections
 Thread serverThread = new Thread(() -> {
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
 });
 serverThread.start();
 // Connect to another peer and send a message
 try (Socket socket = new Socket("localhost", PORT)) {
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 out.println("Hello from peer!");
 }
 }
}