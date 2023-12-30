package Utilities;

import java.util.Scanner;

import static repositories.ClientProgram.clientMenu;
import static repositories.ClientProgram.loginClient;
import static repositories.ManagerProgram.managerMenu;

public class MainMenu
{
    private static final Scanner scanner = new Scanner(System.in);
    public static void mainMenu ()
    {
        System.out.println("\n\t############ MENU INICIAL #############\n");

        System.out.println("""
                \tBem vindo ao nosso sistema, querido usuário, que tipo de usuário você é?
                C - Cliente
                A - Administrador
                E - Encerrar programa""");

        switch (scanner.nextLine().toUpperCase())
        {
            case "C" -> loginClient();
            case "A" -> managerMenu();
            case "E" -> {System.out.println("Hasta la vista, baby...\n"); System.exit(0);}
            default -> {System.out.println("Opção inválida!\n"); mainMenu();}
        }
    }
}
