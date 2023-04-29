package lab2.veterinarian;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<AnimalThread> animalThreads = new ArrayList<>();
        WaitingRoom room = new WaitingRoom(animalThreads); //3 , animalThreads

        /** entrambe le classi si dipendono a vicenda, è normale?*/

        for (int i = 0; i < 10; i++) {
            AnimalThread animalT = new AnimalThread(room, i);
            animalThreads.add(animalT);
            animalThreads.get(i).start();
        }

        /**
        for (AnimalThread t : animalThreads) {
            //Thread.sleep(4000); cause they happen to enter randomly
            t.start();
        }
        */

    }
}
