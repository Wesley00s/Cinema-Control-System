package repositories;

import entities.session.Seat;
import entities.user.User;
import entities.session.Session;

import java.time.LocalDateTime;
import java.util.Scanner;

import static repositories.ClientProgram.clientMenu;
import static repositories.GenerateID.idGenerate;

public class Transaction
{
    private static final Scanner scanner = new Scanner(System.in);
    private static String id;
    private static LocalDateTime dateTimeIssue;
    private static User client;
    private static Session session;
    private static double totalPay;

    public Transaction(User client, Session session)
    {
        id = "T-" + idGenerate();
        this.dateTimeIssue = LocalDateTime.now();
        this.session = session;
        this.client = client;
    }

    public static LocalDateTime getDateTimeIssue() {
        return dateTimeIssue;
    }

    public static String getId()
    {
        return id;
    }

    public void generateTransaction ()
    {
        if (session.isSessionClose())
        {
            String seatCod;
            boolean findSeat;
            boolean invalidOption;


                if (client.getAge() <= session.getMovie().getIndicativeRating())
                {
                    System.out.println("Querido " + client.getName() + ", infelizmente a classificação " +
                            "indicaticativa do filme '" + session.getMovie().getMovieName() + "' não é recomendável para sua idade.");

                    clientMenu();
                }
                System.out.println("\n-------------------------------------------------");
                System.out.println("\tCompra de ingresso para: " + session.getMovie().getMovieName());
                System.out.println("\tData e hora da sessão: " + session.getSessionDate() + " - " + session.getSessionTime() + "h");
                System.out.println("\tClassificação indicativa: " + session.getMovie().getIndicativeRating());

                do
                {
                    invalidOption = false;
                    System.out.println("\nO que você escolhe?");
                    System.out.println("1 - ENTRADA: " + String.format("R$ %.2f", session.getTicketPrice()));
                    System.out.println("2 - MEIA ENTRADA: " + String.format("R$ %.2f", session.getHalfTicketPrice()));
                    switch (scanner.nextLine())
                    {
                        case "1" -> totalPay = session.getTicketPrice();
                        case "2" -> totalPay = session.getHalfTicketPrice();
                        default -> {System.out.println("Opção inválida!\n"); invalidOption = true;}
                    }
                }
                while (invalidOption);

            do
            {
                findSeat = false;
                System.out.println("Escolha um assento. Assentos disponíveis!\n");
                session.getRoom().displaySeatList();
                seatCod = scanner.nextLine();

                try
                {
                    if (Integer.parseInt(seatCod) > session.getRoom().getRoomCapacity() || Integer.parseInt(seatCod) <= 0)
                    {
                        System.out.println("Informe um valor válido!\n");
                    }
                    else
                    {
                        for (Seat seat : session.getRoom().seatList)
                        {
                            if (seat.getSeatCod() == Integer.parseInt(seatCod))
                            {
                                seat.setOccupied(true);
                            }
                        }

                        generateTicket();
                        findSeat = true;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("ERROR: Tipo de dado inválido!\n");
                }
            }
            while (seatCod.trim().isEmpty() || !findSeat);

        }
        else
        {
            System.out.println("A sessão está fechada!\n");
        }
    }

    public static void generateTicket ()
    {
        System.out.println("\n\t=================== INGRESSO ====================");
        System.out.println("\tID da transação: " + getId());
        System.out.println("\tData e hora da transação " + getDateTimeIssue());
        System.out.println("\tID da sessão: " + session.getId());
        System.out.println("\tFilme: " + session.getMovie().getMovieName());
        System.out.println("\tSala: " + session.getRoom().getRoomNum());
        System.out.println("\tTotal a pagar: " + String.format("%.2f", totalPay));
        System.out.println("\tCliente: " + client.getName());
    }
}
