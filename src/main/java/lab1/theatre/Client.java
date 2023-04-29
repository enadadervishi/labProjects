package lab1.theatre;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        int ticketsFromUser;
        String result;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 888);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("How many tickets do you want to buy? ");
        ticketsFromUser = Integer.parseInt(inFromUser.readLine());

        outToServer.writeBytes(ticketsFromUser + "\n");

        result = inFromServer.readLine();
        System.out.println("FROM SERVER: " + result);
        clientSocket.close();

    }
}
