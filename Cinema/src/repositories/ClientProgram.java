package repositories;

import entities.session.Session;
import entities.user.User;
import entities.user.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Utilities.MainMenu.mainMenu;
import static repositories.ActorManager.displayActorsList;
import static repositories.ManagerProgram.*;
import static repositories.MoviesManager.actorList;
import static repositories.MoviesManager.displayMoviesList;
//import static repositories.SessionManager.displaySessions;
import static repositories.SessionManager.sessionList;

public class ClientProgram
{
    public static final List<Transaction> transactionList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static User newClient;
    private static String clientName;

    public static void loginClient ()
    {
        System.out.println("\n\tPor favor, preencha seus dados.");
        clientName = addName();
        newClient = new User(clientName, addAge(), UserType.C, addContact(), addAddress(), isStudent());
        clientMenu();
    }
    static void displayAcitveSessions()
    {
        if (sessionList.isEmpty())
        {
            System.out.println("Nenhuma sessão disponível no momento!\n");
            return;
        }
        int contSession = 1;
        for (Session session : sessionList)
        {
            if (!session.isSessionFinish())
            {
                System.out.println("\n\n* SESSÃO " + contSession + " =========================\n");
                session.displaySession();
                contSession++;
            }
        }
    }
    public static void verifyClientInSession (Session session)
    {
        for (Transaction transaction : transactionList)
        {
            if (transaction.returnSessionClient().equals(newClient.getId() + "-" + session.getId()))
            {
                System.out.println("Você já está nessa sessão!\n");
                clientMenu();
            }
        }
    }
    private static boolean isStudent ()
    {
        while (true)
        {
            System.out.println("É estudante? (S/N)");
            switch (scanner.nextLine().toUpperCase())
            {
                case "S" ->
                {
                    return true;
                }
                case "N" ->
                {
                    return  false;
                }
            }
        }
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
                    3 - Ver minhas sessões
                    4 - Ver filmes
                    5 - Ver atores
                    6 - Ver meus dados
                    R - Retornar ao menu inicial""");
            switch (scanner.nextLine().toUpperCase()) {
                case "1" -> buyTicket();
                case "2" -> displayAcitveSessions();
                case "3" -> displayMySessions();
                case "4" -> displayMoviesList();
                case "5" -> displayActorsList(actorList);
                case "6" -> newClient.displayPerson();
                case "R" -> {System.out.println("Retonando ao menu inicial..."); mainMenu();}
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void displayMySessions()
    {
        for (Transaction transaction : transactionList)
        {
            if (transaction.getClient().equals(newClient))
            {
                Transaction.generateTicket();
            }
        }
    }

    public List<Transaction> getTransactionList ()
    {
        return transactionList;
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
                    verifyClientInSession(session);
                    addedSession = session;
                    findSession = true;
                }
            }

            if (!findSession)
                System.out.println("Sessão não encontrada!\n");
        }
        while (idSession.trim().isEmpty() || !findSession);

        Transaction transaction = new Transaction(newClient, addedSession);
        transaction.generateTransaction();
        transactionList.add(transaction);
    }
}
