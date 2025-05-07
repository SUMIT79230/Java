import java.io.*;
import java.net.*;

public class Client {

  public void run() throws IOException {
    int port = 8090;
    InetAddress address = InetAddress.getByName("localhost");

    try (
      Socket socket = new Socket(address, port);
      PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader fromServer = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );
      BufferedReader userInput = new BufferedReader(
        new InputStreamReader(System.in)
      )
    ) {
      String inputLine;
      while (true) {
        System.out.print("Client : ");
        inputLine = userInput.readLine();
        toServer.println(inputLine);
        if (inputLine.equalsIgnoreCase("exit")) {
          System.out.println("You ended the chat.");
          break;
        }
        String serverResponse = fromServer.readLine();
        if (serverResponse == null || serverResponse.equalsIgnoreCase("exit")) {
          System.out.println("Server ended the chat.");
          break;
        }
        System.out.println("Server: " + serverResponse);
      }
    }
  }

  public static void main(String[] args) {
    Client client = new Client();
    try {
      client.run();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}