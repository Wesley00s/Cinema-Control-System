package repositories;

import static repositories.RoomManager.scanner;

public class ManagerProgram
{
    public static void managerMenu ()
    {
        System.out.println("\n\t############## MENU DO ADMINISTRADOR ##############\n");
        System.out.println("Olá, caro adminitrador! O que deseja?\n1 - Gerenciar Filmes\n2 - Gerenciar Salas\n3 - Gerenciar Sessões\n4 - Encerrar programa");
        switch (scanner.nextLine())
        {
            case "1" -> MoviesManager.moviesMenu();
            case "2" -> RoomManager.roomMenu();
            case "3" -> SessionManager.sessionManagerMenu();
            case "4" -> System.out.println("Encerrando...\n");
            default -> {System.out.println("Opção inválida!\n"); managerMenu();}
        }
    }
}
