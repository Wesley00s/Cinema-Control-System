package entities.session;
import java.util.ArrayList;

public class Room
{
    public ArrayList<Seat> seatList = new ArrayList<>();
    private int roomNum;
    private int roomCapacity;

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
        Seat newSeat = new Seat();
        newSeat.setSeatCod(seatCod);
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
