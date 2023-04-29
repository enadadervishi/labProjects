package lab1.upperCase;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Connection Client-Server
 *  input from the user
 *  a socket which has to be initialized
 *  output to the server
 *  incoming message from the server
 */
public class Client {

    public static void main(String[] args) throws IOException {

        String sentence;
        String modifiedSentence;

        // input stream from the user
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        /*
            client socket initialization
            localhost: sever address
            6789: server service port number
         */
        Socket clientSocket = new Socket("localhost", 6789);

        // output stream to the server
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        // input stream from the server
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Say something: ");
        // read a line from the user
        sentence = inFromUser.readLine();

        // send the line to the server
        outToServer.writeBytes(sentence + "\n");

        // read the response from the server
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: "+ modifiedSentence);
        clientSocket.close();

    }



}
