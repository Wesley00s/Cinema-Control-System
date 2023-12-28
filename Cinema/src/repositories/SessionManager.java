package repositories;
import entities.session.Session;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static repositories.GenerateID.idGenerate;
import static repositories.ManagerProgram.managerMenu;

public class SessionManager
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Session> sessionList = new ArrayList<>();

    private static void searchSection ()
    {
        String sessionId;
        boolean findSession = false;
        do
        {
            System.out.println("Informe o ID da sessão que deseja encontrar:");
            sessionId = scanner.nextLine();

            for (Session session : sessionList)
            {
                if (session.getId().equals(sessionId))
                {
                    System.out.println("\n\tSESSÃO ENCONTRADA");
                    session.getSession();
                    findSession = true;
                }
            }
            if (!findSession)
            {
                System.out.println("Sessão não encontrada!\n");
            }
        }
        while (sessionId.trim().isEmpty());
    }
    static void listSession ()
    {
        System.out.println("\n\tSESSÕES");
        for (Session session : sessionList)
        {
            session.getSession();
        }
    }
    public static void sessionManagerMenu()
    {
        System.out.println("\n\t############## APLICAÇÃO 3 - GERENCIAR SESSÕES ##############\n");
        System.out.println("O que desejas?\n1 - Adicionar sessão\n2 - Listar sessões\n3 - Procurar sessão\n4 - Retornar");
        switch (scanner.nextLine())
        {
            case "1" -> addSession();
            case "2" -> {listSession(); sessionManagerMenu();}
            case "3" -> {searchSection(); sessionManagerMenu();}
            case "4" -> {System.out.println("Retornando ao menu do administrador..."); managerMenu();}
            default -> {System.out.println("Opção inválida!\n"); sessionManagerMenu();}
        }
    }
    private static void addSession()
    {
        Session session = new Session();
        LocalDate sessionDate = null;
        LocalTime sessionTime = null;
        String stringSessionTime;
        String stringSessionDate;
        String ticketPrice;
        boolean invalidFormat;

        System.out.println("===========================");
        do
        {
            invalidFormat = false;
            System.out.println("Informe a data da sessão (no formato YYYY-MM-DD):");
            stringSessionDate = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            try
            {
                sessionDate = LocalDate.parse(stringSessionDate, formatter);
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Formato de data inválido. Utilize o formato YYYY-MM-DD.");
                invalidFormat = true;
            }
        }
        while (stringSessionDate.trim().isEmpty()|| invalidFormat);

        do
        {
            invalidFormat = false;
            System.out.println("Informe o horário da sessão (no formato HH:mm):");
            stringSessionTime = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            try
            {
                sessionTime = LocalTime.parse(stringSessionTime, formatter);
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Formato de horário inválido. Utilize o formato HH:mm.\n");
                invalidFormat = true;
            }
        }
        while (stringSessionTime.trim().isEmpty() || invalidFormat);

        do
        {
            invalidFormat = false;
            System.out.println("Informe o preço do ingresso:");
            ticketPrice = scanner.nextLine();

            try
            {
                if (Float.parseFloat(ticketPrice) < 0)
                {
                    System.out.println("Informe um valor válido!");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado não permitido!\n");
                invalidFormat = true;
            }
        }
        while (ticketPrice.trim().isEmpty() || invalidFormat || Float.parseFloat(ticketPrice) < 0);

        session.setSessionDate(sessionDate);
        session.setSessionTime(sessionTime);
        session.setTicketPrice(Float.parseFloat(ticketPrice));
        session.setHalfTicketPrice(Float.parseFloat(ticketPrice));
        session.setSessionClose(true);
        session.setId(idGenerate());
        sessionList.add(session);
        sessionManagerMenu();
    }
}