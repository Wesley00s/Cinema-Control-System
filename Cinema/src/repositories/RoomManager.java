package repositories;
import entities.session.Room;
import java.util.ArrayList;
import java.util.Scanner;

import static utilities.Attempts.TOTAL_ATTEMPTS;
import static utilities.Attempts.attempts;
import static utilities.PrintSeats.printSeats;
import static repositories.ManagerProgram.managerMenu;

public class RoomManager
{
    public static ArrayList<Room> roomList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean invalidData;

    public static void roomMenu ()
    {
        while (true)
        {
            System.out.println("\n\t############## GERENCIAR SALAS ##############\n");
            System.out.println("""
                O que deseja?
                1 - Cadastrar sala
                2 - Listar salas
                3 - Procurar sala
                4 - Remover cadastro
                R - Retornar""");
            switch (scanner.nextLine().toUpperCase())
            {
                case "1" -> addRoom();
                case "2" -> showRooms();
                case "3" -> searchRoom();
                case "4" -> removeRoom();
                case "R" -> {System.out.println("Retornado ao menu do administrador..."); managerMenu();}
                default -> System.out.println("Opção inválida!\n");
            }
        }
    }

    public static void addNewRoom ()
    {
        Room room1 = new Room(3, 15);
        roomList.add(room1);
        generateSeatCode();
        Room room2 = new Room(9, 35);
        roomList.add(room2);
        generateSeatCode();
    }

    public static void showRooms()
    {
        System.out.println("\n\tSALAS =================================");
        for (Room room : roomList)
            printSeats(room);
    }
    public static void searchRoom()
    {
        String roomNum;
        boolean findRoom;
        do
        {
            findRoom = false;
            invalidData = false;
            System.out.println("Informe o número da sala que deseja encontrar:");
            roomNum = scanner.nextLine();

            try
            {
                if (Integer.parseInt(roomNum) < 0)
                    System.out.println("Informe um valor válido!\n");
                else
                {
                    for (Room room : roomList)
                    {
                        if (room.getRoomNum() == Integer.parseInt(roomNum))
                        {
                            System.out.println("\n\tSALA ENCONTRADA\n");
                            room.getRoom();
                            findRoom = true;
                        }
                    }
                }
                if (!findRoom)
                    System.out.println("Sala não encontrada!\n");
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado não permitido!\n");
                invalidData = true;
            }
        }
        while (roomNum.trim().isEmpty() || invalidData || Integer.parseInt(roomNum) < 0);
    }

     public static void removeRoom()
    {
        String roomNum;
        Room roomRemoved = null;
        boolean roomFind = false;

        System.out.println("Informe o número da sala que deseja remover:");
        roomNum = scanner.nextLine();

        try
        {
            if (Integer.parseInt(roomNum) < 0)
                System.out.println("Informe um valor válido!\n");
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
                    roomList.remove(roomRemoved);
                else
                    System.out.println("Sala número '" + roomNum + "' não encontrada!\n");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("ERROR: Tipo de dado não permitido!\n");
            invalidData = true;
        }
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
                    roomSeat.addSeat(seatCode);
                    seatCode++;
                }
            }
        }
    }

    public static void addRoom()
    {
        String  roomNum;
        String roomCapacity;
        int availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            invalidData = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe o número da sala: ");
            roomNum = scanner.nextLine();

            try
            {
                if (Integer.parseInt(roomNum) < 0)
                    System.out.println("Informe um valor válido!\n");
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

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempt--))
                managerMenu();

            invalidData = false;
            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe a capacidade da sala:");
            roomCapacity = scanner.nextLine();

            try
            {
                if (Integer.parseInt(roomCapacity) < 0)
                    System.out.println("Informe um valor válido!\n");
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado não permitido!\n");
                invalidData = true;
            }
        }
        while (roomCapacity.trim().isEmpty() || invalidData || Integer.parseInt(roomCapacity) < 0);

        Room room = new Room(Integer.parseInt(roomNum), Integer.parseInt(roomCapacity));
        System.out.println("Sala número '" + roomNum + "' cadastrada com sucesso!\n");

        roomList.add(room);
        generateSeatCode();
        roomMenu();
    }
}