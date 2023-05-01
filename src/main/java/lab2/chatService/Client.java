package lab2.chatService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Client{ //extends Thread


    public static void main(String[] args) throws IOException {

        String messageToServer = "\0";
        String result;

        ArrayList<BufferedReader> allResponses = new ArrayList<>();


        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost",8888);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //allResponses.add(inFromServer);

        try {

            while (!messageToServer.equals("QUIT")) {
                System.out.println("Write something: ");
                messageToServer = inFromUser.readLine();

                outToServer.writeBytes(messageToServer + "\n");

                result = inFromServer.readLine();
                System.out.println("FROM SERVER: " + result);
            }
            clientSocket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    /**
    private String messageToServer = "\0";
    private String result;

    ArrayList<BufferedReader> allResponses = new ArrayList<>();


    BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));
    Socket clientSocket = new Socket("localhost", 8888);
    DataOutputStream outToServer;
    BufferedReader inFromServer;
     */



    /**
    public Client(Socket c) throws IOException {

        this.messageToServer = "/0";
        this.result = "/0";
        this.allResponses = new ArrayList<>();
        this.inFromUser = new BufferedReader(new InputStreamReader(System.in));
        this.clientSocket = c;
        this.outToServer = new DataOutputStream(clientSocket.getOutputStream());
        this.inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }
     */


    /**
    public static void main(String[] args) throws IOException {

        Socket sss= new Socket("localhost",8888);

        Client clientHoping = new Client(sss);
        clientHoping.letsTry();




    }
     */

    /**
    public void letsTry(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    while (!messageToServer.equals("QUIT")) {
                        System.out.println("Write something: ");
                        messageToServer = inFromUser.readLine();

                        outToServer.writeBytes(messageToServer + "\n");

                        result = inFromServer.readLine();
                        System.out.println("FROM SERVER: " + result);
                    }
                    clientSocket.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }



            }
        }).start();



    }
     */

/**
    public static void main(String[] args) throws IOException {

        String messageToServer = "\0";
        String result;

        ArrayList<BufferedReader> allResponses = new ArrayList<>();


        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 8888);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //allResponses.add(inFromServer);

        try {

            while (!messageToServer.equals("QUIT")) {
                System.out.println("Write something: ");
                messageToServer = inFromUser.readLine();

                outToServer.writeBytes(messageToServer + "\n");

                result = inFromServer.readLine();
                System.out.println("FROM SERVER: " + result);
            }
            clientSocket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

 */

    /**
     * ADDED NEW
    BufferedReader inFromUser;
    Socket clientSocket;
    DataOutputStream outToServer;
    BufferedReader inFromServer;

    Thread t;



    public Client() throws IOException {

        this.inFromUser = new BufferedReader(new InputStreamReader(System.in));
        this.clientSocket = new Socket("localhost", 8888);
        this.outToServer = new DataOutputStream(clientSocket.getOutputStream());
        this.inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        t= new Thread(this);
        t.start();

    }
     */
    /** ADDED JUST THE PUBLIC VOID RUN METHOD
    public void run(){

        try {

            while (!messageToServer.equals("QUIT")) {
                System.out.println("Write something: ");
                messageToServer = inFromUser.readLine();

                outToServer.writeBytes(messageToServer + "\n");

                result = inFromServer.readLine();
                System.out.println("FROM SERVER: " + result);
            }
            clientSocket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    }
     */

    /**
     * NEW PSVM ADDED
     *
    public static void main(String[] args) throws IOException {
        new Client();
        //clientTry.start();
    }*/

    }
}