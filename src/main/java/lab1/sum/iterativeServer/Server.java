package lab1.sum.iterativeServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int firstFromClient;
        int secondFromClient;
        int sumToSendToClient;

        ServerSocket welcomeSocket = new ServerSocket(888);

        while (true){

            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            System.out.println("SERVER READY");

            firstFromClient = Integer.parseInt(inFromClient.readLine());
            secondFromClient = Integer.parseInt(inFromClient.readLine());

            sumToSendToClient = firstFromClient + secondFromClient;

            outToClient.writeBytes("The sum between "+ firstFromClient + " and "
                    + secondFromClient + " is " + sumToSendToClient + "\n");

        }

    }




}
