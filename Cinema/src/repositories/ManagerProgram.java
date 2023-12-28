package repositories;

import entities.person.Person;
import entities.person.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static repositories.GenerateID.idGenerate;

public class ManagerProgram
{
    private static final List<Person> personList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static void addUser ()
    {
        boolean invalidInput;
        String managerName = null;
        String userType;
        UserType user;

        do {
            invalidInput = false;

            System.out.println("""
                    Qual tipo de usuário desejas adicionar?
                    G - Gerente
                    A - Atendente""");

            userType = scanner.nextLine().toUpperCase();

            user = null;

            try {
                user = UserType.valueOf(userType);

                do {
                    System.out.println("Informe o nome do(a) " + user.getUser());
                    managerName = scanner.nextLine();

                }
                while (managerName.trim().isEmpty());

            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de usuário inválido. Use G ou A.\n");
                invalidInput = true;
            }

        }
        while (userType.trim().isEmpty() || invalidInput);

        Person newUser = new Person(idGenerate(), managerName, user);
        personList.add(newUser);
        System.out.println(user.getUser() + " adicionado(a) com sucesso!\n");
    }

    private  static void displayUsers()
    {
        if (personList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }
        System.out.println("\n\tUSUÁRIOS");
        for (Person user : personList)
        {
            user.getPerson();
        }
    }

    private static void searchUser ()
    {
        if (personList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        String idUserSearch;
        boolean findUser = false;

        System.out.println("Informe o ID do usuário(a) que deseja procurar:");
        idUserSearch = scanner.nextLine();

        for (Person user : personList)
        {
            if (user.getId().equals(idUserSearch))
            {
                System.out.println("\n\tUSUÁRIO ENCONTRADO");
                user.getPerson();
                findUser = true;
            }
        }
        if (!findUser)
        {
            System.out.println("Usuário(a) com ID '" + idUserSearch + "' não encontrado!\n");
        }
    }

    private static void removeUser ()
    {
        if (personList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        String idUserSearch;
        Person removedUser = new Person(null, null, null);
        boolean findUser = false;

        System.out.println("Informe o ID do(a) usuário(a) que deseja remover:");
        idUserSearch = scanner.nextLine();

        for (Person user : personList)
        {
            if (user.getId().equals(idUserSearch))
            {
                System.out.println("\n\tUSUÁRIO ENCONTRADO");
                user.getPerson();
                removedUser = user;
                findUser = true;
            }
        }

        if (findUser)
        {
            System.out.println("Deseja mesmo remover o(a) " + removedUser.getUser().getUser() + " " + removedUser.getName() + "?\nS - Sim\nN - Não");
            switch (scanner.nextLine().toUpperCase())
            {
                case "S" -> {personList.remove(removedUser); System.out.println("Usuário removido!\n");}
                case "N" -> System.out.println("Operação cancelada! Nenhum usuário foi removido!\n");
                default -> System.out.println("Opção inválida!\n");
            }
        }
        else
        {
            System.out.println("Usuário(a) com ID '" + idUserSearch + "' não encontrado!\n");
        }

    }
    private static void userManager()
    {
        System.out.println("""
                O que desejas?
                1 - Adicionar usuário
                2 - Ver lista de usuários
                3 - Procurar usuário
                4 - Remover usuário
                5 - Retornar ao menu de admnistrador""");

        switch (scanner.nextLine())
        {
            case "1" -> {addUser(); userManager();}
            case "2" -> {displayUsers(); userManager();}
            case "3" -> {searchUser(); userManager();}
            case "4" -> {removeUser(); userManager();}
            case "5" -> {System.out.println("Retornando ao menu de admnistrador...\n"); managerMenu();}
            default -> {System.out.println("Opção inválida!"); userManager();}
        }
    }
    public static void managerMenu ()
    {
        System.out.println("\n\t############## MENU DO ADMINISTRADOR ##############\n");
        System.out.println("""
                Olá, caro administrador! O que deseja?
                1 - Gerenciar Filmes
                2 - Gerenciar Salas
                3 - Gerenciar Sessões
                4 - Gerenciar Usuários
                5 - Encerrar programa
                """);
        switch (scanner.nextLine())
        {
            case "1" -> MoviesManager.moviesMenu();
            case "2" -> RoomManager.roomMenu();
            case "3" -> SessionManager.sessionManagerMenu();
            case "4" -> userManager();
            case "5" -> {System.exit(0); System.out.println("Hasta la vista, baby...\n");}
            default -> {System.out.println("Opção inválida!\n"); managerMenu();}
        }
    }
}