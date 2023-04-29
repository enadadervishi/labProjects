package lab2.chatService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

    public static void main(String[] args) throws IOException {

            ServerSocket welcomeSocket = new ServerSocket(8888);

            QueueOfMessages queue = new QueueOfMessages();

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                // thread creation passing the established socket as arg
                ServerThread theThread = new ServerThread(connectionSocket, queue);

                // the start of the thread
                theThread.start();
                System.out.println("SERVER READY");
            }
    }
}
