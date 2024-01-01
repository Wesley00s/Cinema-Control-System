package repositories;
import entities.movie.Movie;
import entities.session.Room;
import entities.session.Session;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static utilities.Attempts.TOTAL_ATTEMPTS;
import static utilities.Attempts.attempts;
import static utilities.GenerateID.idGenerate;
import static utilities.HistorySession.history;
import static repositories.ManagerProgram.managerMenu;
import static repositories.MoviesManager.moviesList;
import static repositories.RoomManager.roomList;

public class SessionManager
{
    private static final Scanner scanner = new Scanner(System.in);
    public static List<Session> sessionList = new ArrayList<>();
    public static List<Session> finishSessionList = new ArrayList<>();

    public static void sessionManagerMenu()
    {
        while (true)
        {
            System.out.println("\n\t############## GERENCIAR SESSÕES ##############\n");
            System.out.println("""
                O que desejas?
                1 - Adicionar sessão
                2 - Ver lista de sessões
                3 - Procurar sessão
                4 - Finalizar sessão
                5 - Ver sessões finalizadas
                R - Retornar""");
            switch (scanner.nextLine().toUpperCase())
            {
                case "1" ->
                {
                    if (roomList.isEmpty())
                        System.out.println("Nenhuma sala disponível para sessão!\n");
                    else
                        addSession();
                }
                case "2" -> displaySessions();
                case "3" -> searchSection();
                case "4" -> finishSession();
                case "5" ->  history();
                case "R" -> {System.out.println("Retornando ao menu do administrador..."); managerMenu();}
                default -> System.out.println("Opção inválida!\n");
            }
        }
    }

    public static void finishSession()
    {
        Session sessionFinish = searchSection();
        try
        {
            for (Session session : sessionList)
            {
                if (sessionFinish.equals(session))
                {
                    session.finishSession();
                    finishSessionList.add(session);
                }
            }
        }
        catch (NullPointerException ignored){}
    }

    public static void addNewSession ()
    {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate newDate = LocalDate.now();
        LocalTime newTime = LocalTime.now();

        String formattedDate = newDate.format(dateFormatter);
        String formattedTime = newTime.format(timeFormatter);

        Session session1 = new Session(idGenerate(), formattedDate, formattedTime, 53.31, moviesList.getFirst(), roomList.getFirst());
        Session session2 = new Session(idGenerate(), formattedDate, formattedTime, 21.59, moviesList.get(1), roomList.get(1));
        sessionList.add(session1);
        sessionList.add(session2);

    }
    public static Session searchSection()
    {
        String sessionId;
        Session sessionSearch = null;
        boolean findSession = false;

        System.out.println("Informe o ID da sessão:");
        sessionId = scanner.nextLine();

        for (Session session : sessionList)
        {
            if (session.getId().equals(sessionId))
            {
                sessionSearch = session;
                System.out.println("\n\tSESSÃO ENCONTRADA");
                session.displaySession();
                findSession = true;
            }
        }
        if (!findSession)
        {
            System.out.println("Sessão não encontrada!\n");
        }
        return sessionSearch;
    }

    public static void displaySessions()
    {
        if (sessionList.isEmpty())
        {
            System.out.println("Nenhuma sessão disponível no momento!\n");
            return;
        }
        int contSession = 1;
        for (Session session : sessionList)
        {
            System.out.println("\n\n* SESSÃO " + contSession + " =========================\n");
            session.displaySession();
            contSession++;
        }
    }

    public static void addSession()
    {
        LocalDate sessionDate;
        LocalTime sessionTime;
        String stringSessionTime;
        Movie movieSession = null;
        Room newRoom = null;
        String formattedTime = null;
        String formattedDate = null;
        String stringSessionDate;
        String ticketPrice;
        String movieAdd;
        String numRoomSearch;
        boolean findRoom = false;
        boolean finMovie;
        boolean invalidFormat;
        int availableAttempt = TOTAL_ATTEMPTS;

        do
        {
            invalidFormat = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe a data da sessão (no formato DD/MM/YYYY):");
            stringSessionDate = scanner.nextLine();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try
            {
                sessionDate = LocalDate.parse(stringSessionDate, dateFormatter);
                formattedDate = sessionDate.format(dateFormatter);
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Formato de data inválido. Utilize o formato DD/MM/YYYY.\n");
                invalidFormat = true;
            }
        }
        while (stringSessionDate.trim().isEmpty()|| invalidFormat);

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            invalidFormat = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe o horário da sessão (no formato HH:mm):");
            stringSessionTime = scanner.nextLine();

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            try
            {
                sessionTime = LocalTime.parse(stringSessionTime, timeFormatter);
                formattedTime = sessionTime.format(timeFormatter);
                
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Formato de horário inválido. Utilize o formato HH:mm.\n");
                invalidFormat = true;
            }
        }
        while (stringSessionTime.trim().isEmpty() || invalidFormat);

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            invalidFormat = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe o preço do ingresso:");
            ticketPrice = scanner.nextLine();

            try
            {
                if (Float.parseFloat(ticketPrice) < 0)
                    System.out.println("Informe um valor válido!");
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado não permitido!\n");
                invalidFormat = true;
            }
        }
        while (ticketPrice.trim().isEmpty() || invalidFormat || Float.parseFloat(ticketPrice) < 0);

        availableAttempt = TOTAL_ATTEMPTS;
        do 
        {
            finMovie = false;

            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe o nome ou ID do filme que será apresentado na sessão:");
            movieAdd = scanner.nextLine();
            
            for (Movie movie : moviesList)
            {
                if (movie.getMovieName().equals(movieAdd) || movie.getId().equals(movieAdd))
                {
                    movieSession = movie;
                    finMovie = true;
                }
            }
            if (!finMovie)
                System.out.println("Filme não econtrado!\n");

        }
        while (movieAdd.trim().isEmpty() || !finMovie);

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            invalidFormat = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Qual número da sala em que o sessão será apresentada:");
            numRoomSearch = scanner.nextLine();

            try
            {
                if (Integer.parseInt(numRoomSearch) < 0)
                    System.out.println("Informe um número válido!\n");
                else
                {
                    for (Room room : roomList)
                    {
                        if (room.getRoomNum() == Integer.parseInt(numRoomSearch))
                        {
                            newRoom = room;
                            findRoom = true;
                        }
                    }

                    if (!findRoom)
                        System.out.println("Sala não econttrada!\n");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado inválido!\n");
                invalidFormat = true;
            }
        }
        while (numRoomSearch.trim().isEmpty() || invalidFormat || !findRoom);

        Session session = new Session(idGenerate(), formattedDate, formattedTime, Float.parseFloat(ticketPrice), movieSession, newRoom);
        sessionList.add(session);
        System.out.println("Sessão criada com sucesso!\n");
    }
}