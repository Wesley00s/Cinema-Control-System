package utilities;

import entities.session.Room;
import entities.session.Seat;

public class PrintSeats
{
    public static String redText (String text)
    {
        return "\u001B[31m" + text + "\u001B[0m";
    }

    public static String greenText (String text)
    {
        return "\u001B[32m" + text + "\u001B[0m";
    }

    public static void printSeats (Room room)
    {
        int cont = 1;
        System.out.println("\n\t* SALA NÚMERO: " + room.getRoomNum() + " ---------------------------");
        System.out.println("\tAssentos: " + greenText("(DISPONÍVEL)") + redText(" (OCUPADO)"));
        for (Seat seat : room.seatList)
        {
            if (seat.isOccupied())
                System.out.print(redText(String.format("\t(%-3d", seat.getSeatCod()) + "\uD83E\uDE91" + ")   "));
            else
                System.out.print(greenText(String.format("\t(%-3d", seat.getSeatCod()) + "\uD83E\uDE91" + ")   "));

            if (cont % 5 == 0)
                System.out.println();

            cont++;
        }
        System.out.println();
    }
}