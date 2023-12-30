package repositories;

import entities.user.Contact;
import entities.user.User;
import entities.user.UserType;
import entities.user.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Utilities.MainMenu.mainMenu;
import static repositories.GenerateID.idGenerate;

public class ManagerProgram
{
    private static final List<User> USER_LIST = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void managerMenu ()
    {
        System.out.println("\n\t############## MENU DO ADMINISTRADOR ##############\n");
        System.out.println("""
                Olá, caro administrador! O que deseja?
                1 - Gerenciar Filmes
                2 - Gerenciar Salas
                3 - Gerenciar Sessões
                4 - Gerenciar Usuários
                R - Retornar ao menu inicial
                """);
        switch (scanner.nextLine().toUpperCase())
        {
            case "1" -> MoviesManager.moviesMenu();
            case "2" -> RoomManager.roomMenu();
            case "3" -> SessionManager.sessionManagerMenu();
            case "4" -> userManagerMenu();
            case "R" -> {System.out.println("Retornando ao menu inicial..."); mainMenu();}
            default -> {System.out.println("Opção inválida!\n"); managerMenu();}
        }
    }

    public static String addName ()
    {
        String name;
        do {
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
                {
                    System.out.println("Informe uma idade válida!\n");
                }
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
                {
                    System.out.println("Informe um número válido\n");
                }
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
        boolean invalidInput;
//        String userName = null;
//        String userAge;
        String userType;
        UserType user;

        do
        {
            invalidInput = false;
            System.out.println("""
                    Qual tipo de usuário desejas adicionar?
                    G - Gerente
                    A - Atendente""");

            userType = scanner.nextLine().toUpperCase();
            user = null;


            try
            {
                user = UserType.valueOf(userType);

//                void addName ()
//                {
//                    do {
//                        System.out.println("Informe o nome :");
//                        userName = scanner.nextLine();
//                    }
//                    while (userName.trim().isEmpty());
//                }

//                userName = addName();

            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de usuário inválido. Use G ou A.\n");
                invalidInput = true;
            }
        }
        while (userType.trim().isEmpty() || invalidInput);

//        void addAge ()
//        {
//            do
//            {
//                invalidInput = false;
//                System.out.println("Informe a idade do " + user.getUser() + ":");
//                userAge = scanner.nextLine();
//
//                try
//                {
//                    if (Integer.parseInt(userAge) < 0 || Integer.parseInt(userAge) > 150)
//                    {
//                        System.out.println("Informe uma idade válida!\n");
//                    }
//                }
//                catch (NumberFormatException e)
//                {
//                    System.out.println("ERROR: Tipo de dado inválido!\n");
//                    invalidInput = true;
//                }
//            }
//            while (userAge.trim().isEmpty() || invalidInput || Integer.parseInt(userAge) < 0 || Integer.parseInt(userAge) > 150);
//        }
//        addAge();

        User newUser = new User(idGenerate(), addName(), addAge(), user, addContact(), addAddress());
        USER_LIST.add(newUser);
        System.out.println(user.getUser() + " adicionado(a) com sucesso!\n");
    }

    public static void displayUsers()
    {
        if (USER_LIST.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }
        System.out.println("\n\t ============== USUÁRIOS ==============");
        for (User user : USER_LIST)
        {
            user.displayPerson();
        }
    }

    public static void searchUser()
    {
        if (USER_LIST.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        String idUserSearch;
        boolean findUser = false;

        System.out.println("Informe o ID do usuário(a) que deseja procurar:");
        idUserSearch = scanner.nextLine();

        for (User user : USER_LIST)
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
        if (USER_LIST.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        String idUserSearch;
        User removedUser = null;
        boolean findUser = false;

        System.out.println("Informe o ID do(a) usuário(a) que deseja remover:");
        idUserSearch = scanner.nextLine();

        for (User user : USER_LIST)
        {
            if (user.getId().equals(idUserSearch))
            {
                System.out.println("\n\tUSUÁRIO ENCONTRADO");
                user.displayPerson();
                removedUser = user;
                findUser = true;
            }
        }

        if (findUser)
        {
            System.out.println("Deseja mesmo remover o(a) " + removedUser.getUser().getUser() + " " + removedUser.getName() + "?\nS - Sim\nN - Não");
            switch (scanner.nextLine().toUpperCase())
            {
                case "S" -> {
                    USER_LIST.remove(removedUser); System.out.println("Usuário removido!\n");}
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
        System.out.println("""
                O que desejas?
                1 - Adicionar usuário
                2 - Ver lista de usuários
                3 - Procurar usuário
                4 - Remover usuário
                R - Retornar ao menu de admnistrador""");

        switch (scanner.nextLine().toUpperCase())
        {
            case "1" -> {addUser(); userManagerMenu();}
            case "2" -> {displayUsers(); userManagerMenu();}
            case "3" -> {searchUser(); userManagerMenu();}
            case "4" -> {removeUser(); userManagerMenu();}
            case "R" -> {System.out.println("Retornando ao menu de admnistrador...\n"); managerMenu();}
            default -> {System.out.println("Opção inválida!"); userManagerMenu();}
        }
    }

}