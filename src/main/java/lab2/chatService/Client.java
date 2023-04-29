package lab2.chatService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        String messageToServer = "\0";
        String result;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 8888);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (!messageToServer.equals("QUIT")) {
            System.out.println("Write something: ");
            messageToServer = inFromUser.readLine();

            outToServer.writeBytes(messageToServer + "\n");

            result = inFromServer.readLine();
            System.out.println("FROM SERVER: " + result);
        }
        clientSocket.close();

    }
}
