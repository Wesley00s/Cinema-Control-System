package repositories;
import entities.section.Room;
import java.util.ArrayList;
import java.util.Scanner;

public class SectionManager
{
    static ArrayList<Room> roomList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean invalidData;

    static void showRooms()
    {
        System.out.println("\n\tSALAS");
        for (Room room : roomList)
        {
            room.getRoom();
        }
    }
    static void searchRoom()
    {
        String roomNum;
        do
        {
            invalidData = false;
            System.out.println("Informe o número da sala que deseja encontrar:");
            roomNum = scanner.nextLine();

            try
            {
                if (Integer.parseInt(roomNum) < 0)
                {
                    System.out.println("Informe um valor válido!\n");
                }
                else
                {
                    for (Room room : roomList)
                    {
                        if (room.getRoomNum() == Integer.parseInt(roomNum))
                        {
                            System.out.println("\n\tSALA ENCONTRADA\n");
                            room.getRoom();
                        }
                    }
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado não permitido!\n");
                invalidData = true;
            }
        }
        while (roomNum.trim().isEmpty() || invalidData || Integer.parseInt(roomNum) < 0);
    }

    static void removeRoom ()
    {
        String roomNum;
        Room roomRemoved = null;
        boolean roomFind = false;

        do
        {
            System.out.println("Informe o número da sala que deseja remover:");
            roomNum = scanner.nextLine();

            try
            {
                if (Integer.parseInt(roomNum) < 0)
                {
                    System.out.println("Informe um valor válido!\n");
                }
                else
                {
                    for (Room room : roomList)
                    {
                        if (room.getRoomNum() == Integer.parseInt(roomNum))
                        {
                            System.out.println("\nSala número '" + roomNum + "' removida!\n");
                            roomRemoved = room;
                            roomFind = true;
                        }
                    }
                    if (roomFind)
                    {
                        roomList.remove(roomRemoved);
                    }
                    else
                    {
                        System.out.println("Sala número '" + roomNum + "' não encontrada!\n");
                    }
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado não permitido!\n");
                invalidData = true;
            }

        }
        while (roomNum.trim().isEmpty() || invalidData || Integer.parseInt(roomNum) < 0);
    }

    public static int seatCode = 1;
    public static void generateSeatCode()
    {
        for (Room roomSeat : roomList)
        {
            if (roomSeat.seatList.isEmpty())
            {
                for (int i = 0; i < roomSeat.getRoomCapacity(); i++)
                {
                    roomSeat.setSeatList(seatCode);
                    seatCode++;
                }
            }
        }
    }

    static void roomMenu ()
    {
        System.out.println("O que deseja?\n1 - Cadastrar outra sala\n2 - Listar salas\n3 - Procurar sala\n4 - Remover cadastro\n5 - Encerrar");

        switch (scanner.nextLine())
        {
            case "1" -> sectionOpc();
            case "2" -> {showRooms(); roomMenu();}
            case "3" -> {searchRoom(); roomMenu();}
            case "4" -> {removeRoom(); roomMenu();}
            case "5" -> System.out.println("Encerrando...\n");
            default -> {System.out.println("Opção inválida!\n"); roomMenu();}
        }
    }

    public static void sectionOpc ()
    {
        Room room = new Room();
        String  roomNum;
        String roomCapacity;
        do
        {
            invalidData = false;
            System.out.println("Informe o número da sala: ");
            roomNum = scanner.nextLine();

            try
            {
                if (Integer.parseInt(roomNum) < 0)
                {
                    System.out.println("Informe um valor válido!\n");
                }
                else
                {
                    for (Room num : roomList)
                    {
                        if (num.getRoomNum() == Integer.parseInt(roomNum))
                        {
                            System.out.println("Sala '" + roomNum + "' já cadastrada!\n");
                            invalidData = true;
                        }
                    }
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado não permitido!\n");
                invalidData = true;
            }
        }
        while (roomNum.trim().isEmpty() || invalidData || Integer.parseInt(roomNum) < 0);

        do
        {
            invalidData = false;
            System.out.println("Informe a capacidade da sala:");
            roomCapacity = scanner.nextLine();

            try
            {
                if (Integer.parseInt(roomCapacity) < 0)
                {
                    System.out.println("Informe um valor válido!\n");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado não permitido!\n");
                invalidData = true;
            }
        }
        while (roomCapacity.trim().isEmpty() || invalidData || Integer.parseInt(roomCapacity) < 0);

        room.setRoomNum(Integer.parseInt(roomNum));
        room.setRoomCapacity(Integer.parseInt(roomCapacity));
        System.out.println("Sala número '" + roomNum + "' cadastrada com sucesso!\n");

        roomList.add(room);
        generateSeatCode();
        roomMenu();
    }
}
