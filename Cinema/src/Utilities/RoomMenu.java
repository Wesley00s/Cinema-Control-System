//package Utilities;
//
//import java.util.Scanner;
//
//import static Utilities.ManagerMenu.managerMenu;
//import static repositories.RoomManager.*;
//
//public class RoomMenu
//{
//    private static final Scanner scanner = new Scanner(System.in);
//    public static void roomMenu ()
//    {
//        System.out.println("\n\t############## APLICAÇÃO 2 - GERENCIAR SALAS ##############\n");
//        System.out.println("O que deseja?\n1 - Cadastrar sala\n2 - Listar salas\n3 - Procurar sala\n4 - Remover cadastro\n5 - Retornar");
//
//        switch (scanner.nextLine())
//        {
//            case "1" -> roomOpc();
//            case "2" -> {showRooms(); roomMenu();}
//            case "3" -> {searchRoom(); roomMenu();}
//            case "4" -> {removeRoom(); roomMenu();}
//            case "5" -> {System.out.println("Retornado ao menu do administrador..."); managerMenu();}
//            default -> {System.out.println("Opção inválida!\n"); roomMenu();}
//        }
//    }
//}
