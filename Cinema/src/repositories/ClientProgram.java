package repositories;

import entities.session.Session;
import entities.user.User;
import entities.user.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Utilities.MainMenu.mainMenu;
import static repositories.ActorManager.displayActorsList;
import static repositories.GenerateID.idGenerate;
import static repositories.ManagerProgram.*;
import static repositories.MoviesManager.actorList;
import static repositories.MoviesManager.displayMoviesList;
import static repositories.SessionManager.displaySessions;
import static repositories.SessionManager.sessionList;

public class ClientProgram
{
    private static final Scanner scanner = new Scanner(System.in);
    public static List<User> clientInSession = new ArrayList<>();
    public static List<Session> sessionCilentList = new ArrayList<>();
    private static Session session;
    private static User newClient;
    private static String clientName;
    public static void loginClient ()
    {
        System.out.println("\n\tPor favor, preencha seus dados.");
        clientName = addName();
        newClient = new User(idGenerate(), clientName, addAge(), UserType.C, addContact(), addAddress());
        clientMenu();
    }
    public static void clientMenu ()
    {
        System.out.println("\n\n\t############ MENU DO CLIENTE - LOGADO COMO: '" + clientName.toUpperCase() + "' #############");


        while (true)
        {
            System.out.println("""
            \n\tOlá, queridissimo cliente, o que desejas?
            1 - Fazer reserva
            2 - Ver sessões disponíveis
            3 - Ver filmes
            4 - Ver atores
            5 - Ver meus dados
            R - Retornar ao menu inicial""");
            switch (scanner.nextLine().toUpperCase())
            {
                case "1" -> buyTicket();
                case "2" -> displaySessions();
                case "3" -> displayMoviesList();
                case "4" -> displayActorsList(actorList);
                case "5" -> newClient.displayPerson();
                case "R" -> {System.out.println("Retonando ao menu inicial..."); mainMenu();}
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void buyTicket ()
    {
        boolean findSession;
        Session addedSession = null;
        String idSession;
        do
        {
            findSession = false;
            System.out.println("Informe o ID da sessão que deseja:");
            idSession = scanner.nextLine();

            for (Session session : sessionList)
            {
                if (session.getId().equals(idSession))
                {
                    addedSession = session;
                    findSession = true;
                }
            }

            if (!findSession)
            {
                System.out.println("Sessão não encontrada!\n");
            }
        }
        while (idSession.trim().isEmpty() || !findSession);

        Transaction transaction = new Transaction(newClient, addedSession);
        transaction.generateTransaction();
    }
}
