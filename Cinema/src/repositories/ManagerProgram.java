package repositories;

import entities.user.Contact;
import entities.user.User;
import entities.user.UserType;
import entities.user.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Utilities.HistorySession.history;
import static Utilities.MainMenu.mainMenu;
import static repositories.ClientProgram.transactionList;
import static repositories.MoviesManager.moviesMenu;
import static repositories.RoomManager.roomMenu;
import static repositories.SessionManager.sessionManagerMenu;
public class ManagerProgram
{
    private static final List<User> managerList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void managerMenu ()
    {
        while (true)
        {
            System.out.println("\n\t############## MENU DO ADMINISTRADOR ##############\n");
            System.out.println("""
                Olá, caro administrador! O que deseja?
                1 - Gerenciar Filmes
                2 - Gerenciar Salas
                3 - Gerenciar Sessões
                4 - Gerenciar Usuários
                5 - Ver histórico de sessões
                R - Retornar ao menu inicial
                """);
            switch (scanner.nextLine().toUpperCase())
            {
                case "1" -> moviesMenu();
                case "2" -> roomMenu();
                case "3" -> sessionManagerMenu();
                case "4" -> userManagerMenu();
                case "5" -> history(transactionList);
                case "R" -> {System.out.println("Retornando ao menu inicial..."); mainMenu();}
                default -> System.out.println("Opção inválida!\n");
            }
        }
    }

    public static String addName ()
    {
        String name;
        do
        {
            System.out.println("Informe o nome:");
            name = scanner.nextLine();
        }
        while (name.trim().isEmpty());

        return name;
    }

    public static int addAge ()
    {
        String userAge;
        boolean invalidInput;
        do
        {
            invalidInput = false;
            System.out.println("Informe a idade:");
            userAge = scanner.nextLine();

            try
            {
                if (Integer.parseInt(userAge) < 0 || Integer.parseInt(userAge) > 150)
                    System.out.println("Informe uma idade válida!\n");

            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado inválido!\n");
                invalidInput = true;
            }
        }
        while (userAge.trim().isEmpty() || invalidInput || Integer.parseInt(userAge) < 0 || Integer.parseInt(userAge) > 150);

        return Integer.parseInt(userAge);
    }

    public static Contact addContact ()
    {
        String phone;
        String email;
        System.out.println("\n\tDADOS DE CONTATO");
        do
        {
            System.out.println("Informe o número de telefone:");
            phone = scanner.nextLine();
        }
        while (phone.trim().isEmpty());

        do
        {
            System.out.println("Informe o email:");
            email = scanner.nextLine();
        }
        while (email.trim().isEmpty());

        return new Contact(phone, email);
    }

    public static Address addAddress()
    {
        String state;
        String city;
        String neighborhood;
        String street;
        String number;
        boolean invalidData;

        System.out.println("\n\tDADOS DE ENDEREÇO");
        do
        {
            System.out.println("Informe o estado: ");
            state = scanner.nextLine();
        }
        while (state.trim().isEmpty());

        do
        {
            System.out.println("Informe a cidade: ");
            city = scanner.nextLine();
        }
        while (city.trim().isEmpty());

        do
        {
            System.out.println("Informe o bairro:");
            neighborhood = scanner.nextLine();
        }
        while (neighborhood.trim().isEmpty());

        do
        {
            System.out.println("Informe a rua:");
            street = scanner.nextLine();
        }
        while (street.trim().isEmpty());

        do
        {
            invalidData = false;

            System.out.println("Informe o número:");
            number = scanner.nextLine();

            try
            {
                if (Integer.parseInt(number) < 0)
                    System.out.println("Informe um número válido\n");
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado inválido!\n");
                invalidData = true;
            }
        }
        while (number.trim().isEmpty() || invalidData || Integer.parseInt(number) < 0);

        return new Address(state, city, neighborhood, street, Integer.parseInt(number));
    }

    public static void addUser()
    {
        System.out.println("\tADICIONAR NOVO GERENTE.\n");
        User newUser = new User(addName(), addAge(), UserType.G, addContact(), addAddress(), false);
        managerList.add(newUser);
        System.out.println("Gerente adicionado(a) com sucesso!\n");
    }

    public static void displayUsers()
    {
        if (managerList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }
        System.out.println("\n\t ============== USUÁRIOS ==============");
        for (User user : managerList)
        {
            user.displayPerson();
        }
    }

    public static void searchUser()
    {
        if (managerList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        String idUserSearch;
        boolean findUser = false;

        System.out.println("Informe o ID do usuário(a) que deseja procurar:");
        idUserSearch = scanner.nextLine();

        for (User user : managerList)
        {
            if (user.getId().equals(idUserSearch))
            {
                System.out.println("\n\tUSUÁRIO ENCONTRADO");
                user.displayPerson();
                findUser = true;
            }
        }
        if (!findUser)
        {
            System.out.println("Usuário(a) com ID '" + idUserSearch + "' não encontrado!\n");
        }
    }

    public static void removeUser()
    {
        if (managerList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        String idUserSearch;
        User removedManager = null;
        boolean findManager = false;

        System.out.println("Informe o ID do(a) usuário(a) que deseja remover:");
        idUserSearch = scanner.nextLine();

        for (User user : managerList)
        {
            if (user.getId().equals(idUserSearch))
            {
                System.out.println("\n\tUSUÁRIO ENCONTRADO");
                user.displayPerson();
                removedManager = user;
                findManager = true;
            }
        }

        if (findManager)
        {
            System.out.println("Deseja mesmo remover o(a) " + removedManager.getUser().getUser() + " " + removedManager.getName() + "?\nS - Sim\nN - Não");
            switch (scanner.nextLine().toUpperCase())
            {
                case "S" -> {
                    managerList.remove(removedManager); System.out.println("Usuário removido!\n");}
                case "N" -> System.out.println("Operação cancelada! Nenhum usuário foi removido!\n");
                default -> System.out.println("Opção inválida!\n");
            }
        }
        else
        {
            System.out.println("Usuário(a) com ID '" + idUserSearch + "' não encontrado!\n");
        }
    }
    public static void userManagerMenu()
    {
        while (true)
        {
            System.out.println("""
                O que desejas?
                1 - Adicionar administrador
                2 - Ver lista de administrador
                3 - Procurar administrador
                4 - Remover administrador
                R - Retornar ao menu de admnistrador""");

            switch (scanner.nextLine().toUpperCase())
            {
                case "1" -> addUser();
                case "2" -> displayUsers();
                case "3" -> searchUser();
                case "4" -> removeUser();
                case "R" -> {System.out.println("Retornando ao menu de admnistrador...\n"); managerMenu();}
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}