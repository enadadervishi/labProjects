package lab1.upperCase.iterativeServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        String clientSentence;
        String capitalizedSentence;

        // create a listening socket
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){

            /*
                once a new connection arrived,
                it creates a new established socket
             */
            Socket connectionSocket = welcomeSocket.accept();

            // input from client
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            // output to client
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            // read a line from client
            clientSentence = inFromClient.readLine();

            capitalizedSentence = clientSentence.toUpperCase() + "\n";

            // send the response
            outToClient.writeBytes(capitalizedSentence); 

        }
    }

}
