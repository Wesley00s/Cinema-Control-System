package repositories;

import entities.session.Seat;
import entities.user.User;
import entities.session.Session;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//import static Utilities.HistorySession.total;
import static utilities.PrintSeats.printSeats;
import static utilities.PrintSeats.redText;
import static repositories.ClientProgram.clientMenu;
import static utilities.GenerateID.idGenerate;

public class Transaction
{
    private static final Scanner scanner = new Scanner(System.in);
    private static String id;
    private static User client;
    private static Session session;
    private static double totalPay;
    private static String seatCod;

    public Transaction(User client, Session session)
    {
        id = "T-" + idGenerate();
        Transaction.session = session;
        Transaction.client = client;
    }

    public static String getDateTimeIssue()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime newDateTime = LocalDateTime.now();
        return newDateTime.format(formatter);
    }

    public static String getId()
    {
        return id;
    }

    public void generateTransaction ()
    {
        if (!session.isSessionClose())
        {
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

                System.out.println("\nConfirme o pagamento:");
                if (client.isStudent())
                {
                    System.out.println("1 - ENTRADA: " + String.format("R$ %.2f", session.getTicketPrice()));
                    System.out.println("2 - MEIA ENTRADA: " + String.format("R$ %.2f", session.getHalfTicketPrice()));
                }
                else
                    System.out.println("1 - ENTRADA: " + String.format("R$ %.2f", session.getTicketPrice()));

                System.out.println("C - CANCELAR");
                switch (scanner.nextLine().toUpperCase())
                {
                    case "1" -> totalPay = session.getTicketPrice();
                    case "2" -> totalPay = session.getHalfTicketPrice();
                    case "C" -> {System.out.println("Compra de ingresso cancelada!"); clientMenu();}
                    default -> {System.out.println("Opção inválida!\n"); invalidOption = true;}
                }
            }
            while (invalidOption);
            session.setTotalPay(totalPay);
            do
            {
                findSeat = false;
                System.out.println("\nEscolha um dos assentos disponíveis!");
                printSeats(session.getRoom());
                seatCod = scanner.nextLine();

                try
                {
                    if (Integer.parseInt(seatCod) < 0)
                    {
                        System.out.println("Informe um valor válido!\n");
                    }
                    else
                    {
                        for (Seat seat : session.getRoom().seatList)
                        {

                            if (seat.getSeatCod() == Integer.parseInt(seatCod))
                            {
                                if (seat.isOccupied())
                                {
                                    System.out.println("\n\tO assento escolhido está ocupado, como podes ver, a cor " + redText("VERMELHA") + " significa que já estar ocupado.\n" +
                                            "\tSe você sofre de DISCROMATOPSIA, por favor, entre em contato com o suporte: (88)9888-0000\n");
                                }
                                else
                                {
                                    seat.setOccupied(true);
                                    generateTicket();
                                    findSeat = true;
                                }
                            }
                        }
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

    public User getClient ()
    {
        return client;
    }

    public Session getSession ()
    {
        return session;
    }

    public String returnSessionClient ()
    {
        return client.getId() + "-" + session.getId();
    }

    public static void generateTicket ()
    {
        System.out.println("\n\t=================== INGRESSO ====================\n");
        System.out.println("\t* INFORMAÇÕES DA TRANSAÇÃO ----------------------");
        System.out.println("\tID da transação: " + getId());
        System.out.println("\tData e hora da transação " + getDateTimeIssue() + "h");
        System.out.println("\n\t* INFORMAÇÕES DA SESSÃO ------------------------");
        System.out.println("\tID da sessão: " + session.getId());
        System.out.println("\tFilme: " + session.getMovie().getMovieName());
        System.out.println("\tSala: " + session.getRoom().getRoomNum());
        System.out.println("\tAssento: " + seatCod);
        System.out.println("\n\t* INFORMAÇÕES DO CLIENTE ------------------------");
        System.out.println("\tID do cliente: " + client.getId());
        System.out.println("\tNome do cliente: " + client.getName());
        System.out.println("\n\t-------------------------------------------------");
        System.out.println("\t\t\t\tTOTAL A PAGAR: " + String.format("R$ %.2f", totalPay));
        System.out.println("\t=================================================\n");
    }
}