package lab1.upperCase.multithreadServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{

    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    // the constructor argument is an established socket
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
        String clientSentence;
        String capitalizedSentence;
        try{
            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase()+"\n";
            outToClient.writeBytes(capitalizedSentence);
            connectionSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
