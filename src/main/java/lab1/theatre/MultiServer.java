package lab1.theatre;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket welcomeSocket = new ServerSocket(888);
        Reservations reservations = new Reservations(10);

        while (true){
            Socket connectionSocket = welcomeSocket.accept();

            // thread creation passing the established socket as arg
            ServerThread theThread = new ServerThread(connectionSocket, reservations);

            // the start of the thread
            theThread.start();
            System.out.println("SERVER READY");

            //Thread.sleep(2000);
        }





    }
}
