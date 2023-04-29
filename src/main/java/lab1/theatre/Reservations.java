package lab1.theatre;

public class Reservations {

    int totalSeats;
    int availableSeats = 0;
    int requestedSeats;

    public Reservations(int tot) {
        this.totalSeats = tot;
    }

    public void ticketsReservedByClient(int n){
        this.requestedSeats = n;
        this.availableSeats = totalSeats - requestedSeats;
    }

    public int freeSeats(){
        if(availableSeats < 0)
            return 0;
        else {
            totalSeats = totalSeats - requestedSeats;
            return requestedSeats;
        }
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}
