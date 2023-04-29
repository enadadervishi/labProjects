package lab2.chatService;

import jdk.net.Sockets;

import javax.sound.sampled.SourceDataLine;
import javax.xml.crypto.Data;
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

    private QueueOfMessages queue;

    private ArrayList<Socket> sockets = new ArrayList<>(); //Socket

    //private ArrayList<DataOutputStream> dataOut = new ArrayList<>();

    public ServerThread(Socket s, QueueOfMessages q){

        this.connectionSocket = s;

        this.sockets.add(this.connectionSocket);

        this.queue = q;

        try{
            inFromClient = new BufferedReader( new InputStreamReader(connectionSocket.getInputStream()));

            //for (Socket soc: sockets){

                //outToClient = new DataOutputStream(connectionSocket.getOutputStream()); //soc
           // }



           // this.dataOut.add(this.outToClient);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){

        String message = "\0";
        String resultFromServer;


        try {

            //need to synchronize each client one by one
            //synchronized (this){

                while (!message.equals("QUIT")) {


                    for (Socket s : sockets) { // dataOut

                        System.out.println("Client: " + s.toString());
                    }

                    //message = inFromClient.readLine();
                    //resultFromServer = "What you said to me was " + message + "\n";
                    //System.out.println(resultFromServer);


                    //queue.put(resultFromServer);

                    synchronized (this.sockets) {
                        for (Socket s : sockets) // dataOut
                        {

                            message = inFromClient.readLine();
                            resultFromServer = "What you said to me was " + message + "\n";
                            System.out.println(resultFromServer);

                            queue.put(resultFromServer);


                            new DataOutputStream(s.getOutputStream()).writeBytes("Client: "+ s);
                            new DataOutputStream(s.getOutputStream()).writeBytes(queue.getMessage());

                            //outToClient.writeBytes("Client: " + s.toString());
                            //s.writeBytes("Client: "+ s);

                            // s.writeBytes(queue.getMessage());
                            //outToClient.writeBytes(queue.getMessage());
                        }
                    }


                }
                connectionSocket.close();
            //}


        }catch(IOException | InterruptedException e ){
            e.printStackTrace();
        }
    }

}
