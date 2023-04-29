package lab1.sum;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        int firstNum;
        int secondNum;
        String result;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 888);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Enter a first number: ");
        firstNum = Integer.parseInt(inFromUser.readLine());

        System.out.println("Enter a second number: ");
        secondNum = Integer.parseInt(inFromUser.readLine());

        outToServer.writeBytes(firstNum + "\n");
        outToServer.writeBytes(secondNum + "\n");

        result = inFromServer.readLine();
        System.out.println("FROM SERVER: " + result);
        clientSocket.close();

    }
}
