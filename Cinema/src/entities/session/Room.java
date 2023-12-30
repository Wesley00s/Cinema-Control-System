package entities.session;
import java.util.ArrayList;
import java.util.List;

public class Room
{
    public List<Seat> seatList;
    private int roomNum;
    private int roomCapacity;
    private boolean available;

    public Room (int roomNum, int roomCapacity)
    {
        this.roomNum = roomNum;
        this.roomCapacity = roomCapacity;
        this.seatList = new ArrayList<>();
        this.available = false;
    }

    public void setRoomNum (int roomNum)
    {
        this.roomNum = roomNum;
    }

    public void setRoomCapacity (int roomCapacity)
    {
        this.roomCapacity = roomCapacity;
    }

    public void addSeat(int seatCod)
    {
        Seat newSeat = new Seat(seatCod, false);
        this.seatList.add(newSeat);
    }

    public int getRoomCapacity()
    {
        return roomCapacity;
    }

    public int getRoomNum()
    {
        return roomNum;
    }

    public void displaySeatList()
    {
        for (Seat seat : seatList)
        {
            System.out.println(seat.getSeatCod());
        }
    }

    public List<Seat> getSeatList()
    {
        return seatList;
    }
    public void getRoom()
    {
        System.out.println("Número da sala: " + getRoomNum());
        System.out.println("Capacidade da sala: " + getRoomCapacity());
        System.out.println("Acentos disponíveis: ");
        displaySeatList();
        System.out.println("===========================\n");
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}