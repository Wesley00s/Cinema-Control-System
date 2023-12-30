//package Utilities;
//
//import java.util.Scanner;
//
//import static Utilities.ManagerMenu.managerMenu;
//import static repositories.ManagerProgram.*;
//
//public class UserManagerMenu
//{
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void userManagerMenu() {
//        System.out.println("""
//                O que desejas?
//                1 - Adicionar usuário
//                2 - Ver lista de usuários
//                3 - Procurar usuário
//                4 - Remover usuário
//                5 - Retornar ao menu de admnistrador""");
//
//        switch (scanner.nextLine()) {
//            case "1" -> {
//                addUser();
//                userManagerMenu();
//            }
//            case "2" -> {
//                displayUsers();
//                userManagerMenu();
//            }
//            case "3" -> {
//                searchUser();
//                userManagerMenu();
//            }
//            case "4" -> {
//                removeUser();
//                userManagerMenu();
//            }
//            case "5" -> {
//                System.out.println("Retornando ao menu de admnistrador...\n");
//                managerMenu();
//            }
//            default -> {
//                System.out.println("Opção inválida!");
//                userManagerMenu();
//            }
//        }
//    }
//}
