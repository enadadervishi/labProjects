package lab1.sum.multithreadServer;

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
        int firstNumFromClient;
        int secondNumFromClient;
        int sum;
        String resultFromServer;

        try{
            firstNumFromClient = Integer.parseInt(inFromClient.readLine());
            secondNumFromClient = Integer.parseInt(inFromClient.readLine());

            sum = firstNumFromClient + secondNumFromClient;
            resultFromServer = "The sum between "+ firstNumFromClient + " and "
                    + secondNumFromClient + " is " + sum + "\n";

            outToClient.writeBytes(resultFromServer);
            connectionSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
