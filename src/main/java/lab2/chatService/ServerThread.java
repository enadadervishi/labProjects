package lab2.chatService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{

    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    public ServerThread(Socket s){

        connectionSocket = s;
        try{
            inFromClient = new BufferedReader( new InputStreamReader(connectionSocket.getInputStream()));
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){

        String messageFromClient = "\0";
        String resultFromServer;

        try {

            //synchronized (this){

                while (!messageFromClient.equals("QUIT")) {

                    messageFromClient = inFromClient.readLine();
                    resultFromServer = "What you said to me was " + messageFromClient + "\n";

                    outToClient.writeBytes(resultFromServer);
                }
                connectionSocket.close();
            //}


        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
