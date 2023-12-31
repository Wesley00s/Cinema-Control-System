package repositories;

import entities.user.Contact;
import entities.user.User;
import entities.user.UserType;
import entities.user.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utilities.Attempts.TOTAL_ATTEMPTS;
import static utilities.Attempts.attempts;
import static utilities.MainMenu.mainMenu;
import static repositories.MoviesManager.moviesMenu;
import static repositories.RoomManager.roomMenu;
import static repositories.SessionManager.sessionManagerMenu;

public class ManagerProgram
{
    private static final List<User> managerList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int availableAttempts;

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
                4 - Gerenciar Administradores
                R - Retornar ao menu inicial
                """);
            switch (scanner.nextLine().toUpperCase())
            {
                case "1" -> moviesMenu();
                case "2" -> roomMenu();
                case "3" -> sessionManagerMenu();
                case "4" -> manageManagerMenu();
                case "R" -> {System.out.println("Retornando ao menu inicial..."); mainMenu();}
                default -> System.out.println("Opção inválida!\n");
            }
        }
    }

    public static void manageManagerMenu()
    {
        while (true)
        {
            System.out.println("\n\t############## GERENCIAR ADMINISTRADORES ##############\n");
            System.out.println("""
                O que desejas?
                1 - Adicionar administrador
                2 - Ver lista de administradores
                3 - Procurar administrador
                4 - Remover administrador
                R - Retornar ao menu de admnistrador""");

            switch (scanner.nextLine().toUpperCase())
            {
                case "1" -> addUser();
                case "2" -> displayManager();
                case "3" -> searchManager();
                case "4" -> removeManager();
                case "R" -> {System.out.println("Retornando ao menu de admnistrador...\n"); managerMenu();}
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public static void addMainManager ()
    {
        Contact contact = new Contact("(88)99999-9999", "popscornharry@gmail.com");
        Address address = new Address("Flavor State", "Flavorville", "Popcorn Heights", "Butter Lane", 78);
        User mainManager = new User("Harry Pops'corn", 87, UserType.A, contact, address, false);
        mainManager.setPassword("CineMagic");
        managerList.add(mainManager);
    }

    public static void managerLogin ()
    {
        String managerName;
        String managerPassword;
        boolean findManager = false;
        System.out.println("\n\t############## LOGIN DO ADMINISTRADOR ##############\n");
        System.out.println("Informe seu nome e senha de administrador.");
        System.out.print("Nome: ");
        managerName = scanner.nextLine();
        System.out.print("Senha: ");
        managerPassword = scanner.nextLine();

        for (User manager : managerList)
        {
            if (managerName.equals(manager.getName())
                    && managerPassword.equals(manager.getPassword())
                    && manager.getUser().equals(UserType.A))
            {
                findManager = true;
                managerMenu();
            }
        }

        if (!findManager)
        {
            System.out.println("Nome ou senha de administrador inválidos!\n");
            mainMenu();
        }
    }

    public static String addName ()
    {
        String name;
        availableAttempts = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe o nome:");
            name = scanner.nextLine();

        }
        while (name.trim().isEmpty());
        return name;
    }

    public static int addAge ()
    {
        availableAttempts = TOTAL_ATTEMPTS;
        String userAge;
        boolean invalidInput;

        do
        {
            invalidInput = false;

            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe a idade:");
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

        availableAttempts = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe o número de telefone:");
            phone = scanner.nextLine();
        }
        while (phone.trim().isEmpty());

        availableAttempts = 4;
        do
        {
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe o email:");
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

        availableAttempts = TOTAL_ATTEMPTS;
        System.out.println("\n\tDADOS DE ENDEREÇO");
        do
        {
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe o estado: ");
            state = scanner.nextLine();
        }
        while (state.trim().isEmpty());

        availableAttempts = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe a cidade: ");
            city = scanner.nextLine();
        }
        while (city.trim().isEmpty());

        availableAttempts = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe o bairro:");
            neighborhood = scanner.nextLine();
        }
        while (neighborhood.trim().isEmpty());

        availableAttempts = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe a rua:");
            street = scanner.nextLine();
        }
        while (street.trim().isEmpty());

        availableAttempts = TOTAL_ATTEMPTS;
        do
        {
            invalidData = false;
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe o número:");
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
        String managerPassword;
        availableAttempts = TOTAL_ATTEMPTS;
        System.out.println("\tADICIONAR NOVO ADMINISTRADOR.\n");
        do
        {
            if (attempts(availableAttempts--))
                managerMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Crie a senha do novo administrador: ");
            managerPassword = scanner.nextLine();
        }
        while (managerPassword.trim().isEmpty());

        User newManager = new User(addName(), addAge(), UserType.A, addContact(), addAddress(), false);
        newManager.setPassword(managerPassword);
        managerList.add(newManager);
        System.out.println("Administrador adicionado(a) com sucesso!\n");
    }

    public static void displayManager()
    {
        if (managerList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }
        System.out.println("\n\t ============== ADMINISTRADORES ==============");
        for (User user : managerList)
            user.displayUser();
    }

    public static void searchManager()
    {
        if (managerList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        String idUserSearch;
        boolean findUser = false;

        availableAttempts = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe o ID do administrador que deseja procurar:");
            idUserSearch = scanner.nextLine();

            for (User user : managerList)
            {
                if (user.getId().equals(idUserSearch))
                {
                    System.out.println("\n\tADMINISTRADOR ENCONTRADO");
                    user.displayUser();
                    findUser = true;
                }
            }
            if (!findUser)
                System.out.println("Usuário(a) com ID '" + idUserSearch + "' não encontrado!\n");
        }
        while (idUserSearch.trim().isEmpty() || !findUser);
    }

    public static void removeManager()
    {
        if (managerList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }
        else if (managerList.size() == 1)
        {
            System.out.println("Um administrador não pode se auto-remover!");
            return;
        }

        String idManagerSearch;
        User removedManager = null;
        boolean findManager;

        availableAttempts = TOTAL_ATTEMPTS;
        do
        {
            findManager = false;
            if (attempts(availableAttempts--))
                mainMenu();

            System.out.println("(" + (availableAttempts + 1) + " tentativas) Informe o ID do(a) usuário(a) que deseja remover:");
            idManagerSearch = scanner.nextLine();

            for (User user : managerList)
            {
                if (user.getId().equals(idManagerSearch))
                {
                    System.out.println("\n\tADMINISTRADOR ENCONTRADO");
                    user.displayUser();
                    removedManager = user;
                    findManager = true;
                }
            }

            if (findManager)
            {
                System.out.println("Deseja mesmo remover o(a) " + removedManager.getUser().getUser() + " " + removedManager.getName() + "?\nS - Sim\nN - Não");
                switch (scanner.nextLine().toUpperCase())
                {
                    case "S" -> {managerList.remove(removedManager); System.out.println("Usuário removido!\n");}
                    case "N" -> System.out.println("Operação cancelada! Nenhum usuário foi removido!\n");
                    default -> System.out.println("Opção inválida!\n");
                }
            }
            else
                System.out.println("Usuário(a) com ID '" + idManagerSearch + "' não encontrado!\n");
        }
        while (idManagerSearch.trim().isEmpty() || !findManager);
    }
}