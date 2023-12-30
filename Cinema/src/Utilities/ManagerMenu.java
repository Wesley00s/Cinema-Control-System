//package Utilities;
//
//import repositories.MoviesManager;
//import repositories.RoomManager;
//import repositories.SessionManager;
//
//import java.util.Scanner;
//
//import static Utilities.MainMenu.mainMenu;
//import static repositories.ManagerProgram.userManagerMenu;
//
//public class ManagerMenu
//{
//    private static final Scanner scanner = new Scanner(System.in);
//    public static void managerMenu ()
//    {
//        System.out.println("\n\t############## MENU DO ADMINISTRADOR ##############\n");
//        System.out.println("""
//                Olá, caro administrador! O que deseja?
//                1 - Gerenciar Filmes
//                2 - Gerenciar Salas
//                3 - Gerenciar Sessões
//                4 - Gerenciar Usuários
//                5 - Retornar ao menu inicial
//                """);
//        switch (scanner.nextLine())
//        {
//            case "1" -> MoviesManager.moviesMenu();
//            case "2" -> RoomManager.roomMenu();
//            case "3" -> SessionManager.sessionManagerMenu();
//            case "4" -> userManagerMenu();
//            case "5" -> {System.out.println("Retornando ao menu inicial..."); mainMenu();}
//            default -> {System.out.println("Opção inválida!\n"); managerMenu();}
//        }
//    }
//}
