import java.io.*;
import java.net.*;

public class Server {

  public void run() throws IOException {
    int port = 8090;
    try (ServerSocket serverSocket = new ServerSocket(port)) 
    {
      System.out.println("Server started on port :" + port);
      serverSocket.setSoTimeout(30000); 
      Socket clientSocket = serverSocket.accept();
      System.out.println("Client connected having address is : " +clientSocket.getRemoteSocketAddress());
      try (
        BufferedReader fromClient = new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream())
        );
        PrintWriter toClient = new PrintWriter(
          clientSocket.getOutputStream(),
          true
        );
        BufferedReader userInput = new BufferedReader(
          new InputStreamReader(System.in)
        )
      ) {
        String clientMsg;
        while ((clientMsg = fromClient.readLine()) != null) {
          System.out.println("Client: " + clientMsg);
          if (clientMsg.equalsIgnoreCase("exit")) {
            System.out.println("Client ended the chat.");
            break;
          }
          System.out.print("Server : ");
          String reply = userInput.readLine();
          toClient.println(reply);
          if (reply.equalsIgnoreCase("exit")) {
            System.out.println("Chat closed by server.");
            break;
          }
        }
      }

      clientSocket.close();
    }
  }

  public static void main(String[] args) {
    Server server = new Server();
    try {
      server.run();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
