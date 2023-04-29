package lab2.veterinarian;

import java.util.ArrayList;

/**
 * A room containing a max number of Objects (Threads, Animals)
 */
public class WaitingRoom {

    //private int maxNum;
   // private int threadsAlreadyEntered;

    private int catsIn;
    private int dogsIn;

    private ArrayList<AnimalThread> patientsList;


    public WaitingRoom(ArrayList<AnimalThread> p) { //int numOfThreads,, ArrayList<AnimalThread> p

        //AnimalThread at = new AnimalThread();

        //this.maxNum = numOfThreads;

        //this.threadsAlreadyEntered = 0;

        this.catsIn = 0;
        this.dogsIn =0 ;
        this.patientsList = p;
    }


    public synchronized void enterRoom(int id, String an) throws InterruptedException {

        System.out.println("Check if the animal " + id +" can enter in the waiting room");

        while (true){
            if(dogsIn > 5){
                System.out.println("No one can enter, there are already 4 dogs");
                System.out.println("Cannot enter animal " + id + " " + an);
                wait();
            }else if((catsIn==1)&&(an.equals("DOG"))){
                System.out.println("A dog cannot enter. There is already a cat");
                System.out.println("Cannot enter animal " + id + " " + an);
                wait();
            }else if((catsIn>0)||(dogsIn>0) && (an.equals("CAT"))){
                System.out.println("A cat cannot enter. There are already cat(s)/dog(s) ");
                System.out.println("Cannot enter animal " + id + " " + an);
                wait();
            }else {
                System.out.println("The animal "+ id +" "+ an +" is officially inside the waiting room");
                //threadsAlreadyEntered ++;
                if(an.equals("DOG"))
                    dogsIn++;
                else
                    catsIn++;
                break;
            }

        }

    }

    public synchronized void exitRoom(int id, String an){

        //threadsAlreadyEntered --;
        if(an.equals("CAT"))
            catsIn--;
        else
            dogsIn--;
        System.out.println("The animal "+ id + " "+ an +" exited a room");
        this.notifyAll();
    }


}
