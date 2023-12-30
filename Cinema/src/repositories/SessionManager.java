package repositories;
import entities.movie.Movie;
import entities.session.Room;
import entities.session.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static repositories.GenerateID.idGenerate;
import static repositories.ManagerProgram.managerMenu;
import static repositories.MoviesManager.moviesList;
import static repositories.RoomManager.roomList;

public class SessionManager
{
    private static final Scanner scanner = new Scanner(System.in);
    public static final List<Session> sessionList = new ArrayList<>();

    public static void sessionManagerMenu()
    {
        System.out.println("\n\t############## APLICAÇÃO 3 - GERENCIAR SESSÕES ##############\n");
        System.out.println("""
                O que desejas?
                1 - Adicionar sessão
                2 - Ver lista de sessões
                3 - Procurar sessão
                R - Retornar""");
        switch (scanner.nextLine().toUpperCase())
        {
            case "1" ->
            {
                if (roomList.isEmpty())
                    System.out.println("Nenhuma sala disponível para sessão!\n");
                else
                    addSession();
                sessionManagerMenu();
            }
            case "2" -> {displaySessions(); sessionManagerMenu();}
            case "3" -> {searchSection(); sessionManagerMenu();}
            case "R" -> {System.out.println("Retornando ao menu do administrador..."); managerMenu();}
            default -> {System.out.println("Opção inválida!\n"); sessionManagerMenu();}
        }
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
    static void displaySessions()
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
            session.getSession();
            contSession++;
        }
    }

    private static void addSession()
    {
        LocalDate sessionDate = null;
        LocalTime sessionTime = null;
        String stringSessionTime;
        String stringSessionDate;
        String ticketPrice;
        String movieAdd;
        Movie movieSession = null;
        boolean invalidFormat;
        boolean finMovie;
        Room newRoom = null;
        String numRoomSearch;
        boolean findRoom = false;
        String formattedDate = null;
        String formattedTime = null;

        do
        {
            invalidFormat = false;
            System.out.println("\nInforme a data da sessão (no formato DD/MM/YYYY):");
            stringSessionDate = scanner.nextLine();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try
            {
                sessionDate = LocalDate.parse(stringSessionDate, dateFormatter);
                formattedDate = sessionDate.format(dateFormatter);
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Formato de data inválido. Utilize o formato DD/MM/YYYY.");
                invalidFormat = true;
            }
        }
        while (stringSessionDate.trim().isEmpty()|| invalidFormat);

        do
        {
            invalidFormat = false;
            System.out.println("Informe o horário da sessão (no formato HH:mm):");
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
        
        do 
        {
            finMovie = false;
            System.out.println("Informe o nome ou ID do filme que será apresentado na sessão:");
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
            {
                System.out.println("Filme não econtrado!\n");
            }
        }
        while (movieAdd.trim().isEmpty() || !finMovie);

        do
        {
            invalidFormat = false;
            System.out.println("Qual número da sala em que o sessão será apresentada:");
            numRoomSearch = scanner.nextLine();

            try
            {
                if (Integer.parseInt(numRoomSearch) < 0)
                {
                    System.out.println("Informe um número válido!\n");
                }
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
                    {
                        System.out.println("Sala não econttrada!\n");
                    }
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