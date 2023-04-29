package lab1.upperCase.multithreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

    public static void main(String[] args) throws IOException {

        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true){
            Socket connectionSocket = welcomeSocket.accept();

            // thread creation passing the established socket as arg
            ServerThread theThread = new ServerThread(connectionSocket);

            // the start of the thread
            theThread.start();

        }

    }
}
