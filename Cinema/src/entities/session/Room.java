package entities.session;
import java.util.ArrayList;
import java.util.List;

public class Room
{
    public List<Seat> seatList = new ArrayList<>();
    private int roomNum;
    private int roomCapacity;

    public Room (int roomNum, int roomCapacity)
    {
        this.roomNum = roomNum;
        this.roomCapacity = roomCapacity;
    }

    public void setRoomNum (int roomNum)
    {
        this.roomNum = roomNum;
    }

    public void setRoomCapacity (int roomCapacity)
    {
        this.roomCapacity = roomCapacity;
    }

    public void setSeatList(int seatCod)
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

    public void getSeatList()
    {
        for (Seat seat : seatList)
        {
            System.out.println(seat.getSeatCod());
        }
    }

    public void getRoom()
    {
        System.out.println("Número da sala: " + getRoomNum());
        System.out.println("Capacidade da sala: " + getRoomCapacity());
        System.out.println("Acentos disponíveis: ");
        getSeatList();
        System.out.println("===========================\n");
    }
}