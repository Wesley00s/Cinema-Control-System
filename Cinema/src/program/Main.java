package program;
import repositories.MoviesManager;
import repositories.SectionManager;
import java.util.Scanner;

public class Main
{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Olá, caro adminitrador! O que deseja?\n1 - Gerenciar Filmes\n2 - Gerenciar Salas");
        switch (scanner.nextLine())
        {
            case "1" ->
            {
                System.out.println("\n\t############## APLICAÇÃO 1 - ADICIONAR FILMES ##############\n");
                MoviesManager.addMovies();
            }
            case "2" ->
            {
                System.out.println("\n\t############## APLICAÇÃO 2 - GERENCIAR SALAS ##############\n");
                SectionManager.sectionOpc();
            }
            default -> System.out.println("Opção inválida. Encerrando programa...\n");
        }
    }
}