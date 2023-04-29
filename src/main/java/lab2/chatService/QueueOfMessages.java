package lab2.chatService;

import java.util.ArrayList;

public class QueueOfMessages {

    public ArrayList<String> buffer;

    public QueueOfMessages() {
        this.buffer = new ArrayList<>();
    }

    public synchronized void put(String message){
        buffer.add(message);
        notify();
    }

    public synchronized String getMessage() throws InterruptedException {

        String mex = null;

        while (buffer.size()==0)
            wait();

        if(buffer.size()>0){
            mex = buffer.get(0);
            buffer.remove(0);
        }

        return mex;
    }







}
