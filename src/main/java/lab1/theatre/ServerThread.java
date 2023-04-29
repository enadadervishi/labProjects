package lab1.theatre;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{

    private Socket connectionSocket = null;
    private Reservations r;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    public ServerThread(Socket s, Reservations res){
        connectionSocket = s;
        r = res;
        try{
            inFromClient = new BufferedReader( new InputStreamReader(connectionSocket.getInputStream()));
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        int ticketsFromClient;
        int resultFromServer;

        try{
            ticketsFromClient = Integer.parseInt(inFromClient.readLine());
            r.ticketsReservedByClient(ticketsFromClient);
            resultFromServer = r.freeSeats();
            outToClient.writeBytes("Tickets bought: "+ resultFromServer + "\n");
            System.out.println("Still " + r.getTotalSeats() + " seats");
            connectionSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }



}
