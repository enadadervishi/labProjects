package lab2.studentsStats;

import lab2.chatService.QueueOfMessages;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{


    private Socket connectionSocket;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    private QueueOfJSONs queue;

    private ArrayList<ServerThread> serverThreads = new ArrayList<>();

    public ServerThread(Socket s, QueueOfJSONs q){

        this.connectionSocket = s;
        serverThreads.add(this);
        this.queue = q;

        try{
            inFromClient = new BufferedReader( new InputStreamReader(connectionSocket.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){

        System.out.println("RUNNING THREAD");



    }


}
