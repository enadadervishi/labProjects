package lab2.veterinarian;

import java.util.Random;

public class AnimalThread extends Thread {

    private Random rnd;
    private int timeInWR;
    private int forDetectingWhatAnimal;

    private String nameOfAnimal;

    private int idNum;

    private WaitingRoom waitingRoom;

    public AnimalThread(WaitingRoom wr, int n) {
        this.rnd = new Random();
        this.timeInWR = rnd.nextInt(10,20)*1000; //from 10 to 20 seconds
        this.forDetectingWhatAnimal = rnd.nextInt(2)+1;
        if(forDetectingWhatAnimal==1)
            this.nameOfAnimal = "CAT";
        else
           this.nameOfAnimal = "DOG";
        this.waitingRoom = wr;

        this.idNum = n;
    }

    private void printResultOfThread(){
        System.out.println("Thread number: " + getName() + " "+getIdNum());
        System.out.println("Time in Waiting Room " + timeInWR);
        System.out.println("Number to detect the animal: "+ forDetectingWhatAnimal);
        System.out.println("It's a "+ nameOfAnimal);
        System.out.println("\n");
    }



    public void run(){
        // I did surround with try catch only cause i have two sleep processes,
        // I would have use try catch only for the sleep twice (redundant code)
        try {
            //Thread.sleep(2000);
            System.out.println("Thread n. "+ getName() +" "+ getIdNum()+ " created, now will try to enter to the WR");
            //printResultOfThread();
            waitingRoom.enterRoom(this.idNum, this.nameOfAnimal);
            Thread.sleep(rnd.nextInt(10)*1000);
            waitingRoom.exitRoom(this.idNum, this.nameOfAnimal);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public int getIdNum() {
        return idNum;
    }


}
