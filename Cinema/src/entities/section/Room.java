package entities.section;

public class Room
{
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

    public int getRoomCapacity()
    {
        return roomCapacity;
    }

    public int getRoomNum()
    {
        return roomNum;
    }

    public void getRoom ()
    {
        System.out.println("Número da sala: " + getRoomNum());
        System.out.println("Capacidade da sala: " + getRoomCapacity());
        System.out.println("===========================\n");
    }
}
