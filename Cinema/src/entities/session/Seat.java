package entities.session;

public class Seat
{
    private final int seatCod;
    private boolean occupied;

    public Seat (int seatCod, boolean occupied)
    {
        this.seatCod = seatCod;
        this.occupied = occupied;
    }

    public void setOccupied(boolean occupied)
    {
        this.occupied = occupied;
    }

    public int getSeatCod ()
    {
        return seatCod;
    }

    public boolean isOccupied()
    {
        return occupied;
    }
}