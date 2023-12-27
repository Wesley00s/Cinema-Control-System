package entities.session;

public class Seat
{
    private int seatCod;
    private boolean occupied;

    public void setSeatCod (int seatCod)
    {
        this.seatCod = seatCod;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getSeatCod ()
    {
        return seatCod;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
